package test.memcached_ibatis;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.ibatis.sqlmap.engine.cache.CacheController;
import com.ibatis.sqlmap.engine.cache.CacheModel;

/**
 * ibatis管理memcache 使用LRU算法
 * 
 * @author langke93
 * @date 2011-01-17
 * @usage: <cacheModel id="cache-videoinfo"
 *         type="com.woyo.upload.kernel.util.MemcachedIbatisController">
 *         <flushInterval seconds="3600"/> <flushOnExecute
 *         statement="updateVideoInfo" /> <flushOnExecute
 *         statement="insertVideoInfo" /> <flushOnExecute
 *         statement="deleteVideoInfo" /> <property name="size" value="1000" />
 *         </cacheModel>
 * @modify: cacheSize默认为0 ，表示由memcache管理缓存大小，推荐在集群中使用
 */
public class MemcachedIbatisController implements CacheController {
	protected final Logger log = Logger.getLogger(this.getClass());
	private MemCachedManager cache;
	private List<String> keyList;// keyList 管理key
	private int cacheSize;

	public MemcachedIbatisController() {
		this.cacheSize = 0; // 默认为0表示不限制缓存大小，不使用LRU
		this.cache = MemCachedManager.getInstance();
		this.keyList = getKeyListInstance();
		log.info("       Enable MemcachedIbatisController !");
	}

	public synchronized List<String> getKeyListInstance() {
		if (keyList == null) {
			keyList = Collections.synchronizedList(new LinkedList<String>());
		}
		return keyList;
	}

	public void flush(CacheModel cacheModel) {
		String key = null;
		try {
			if (keyList.isEmpty()) {
				// cache.flush(); 目前清除缓存仅依赖于缓存过期，分表/条件清除缓存还需要做扩展
			} else
				for (int i = 0; i < keyList.size(); i++) {
					key = keyList.get(i);
					cache.delete(key);
					keyList.remove(key);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// keyList.clear();
		log.info("       flush memcache!");
	}

	/**
	 * 实现LRU算法 把最近取过的数据放到栈顶
	 */
	public Object getObject(CacheModel cacheModel, Object key) {
		Object result;
		String ckey = getKey(cacheModel, key);
		try {
			result = cache.get(ckey);
			if (cacheSize > 0) {// 如果缓存大小有限制，则使用LRU算法
				keyList.remove(ckey);
				if (result != null) {
					keyList.add(ckey);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		log.info("       getObject memcache!!");
		return result;
	}

	/**
	 * 如果超过缓存大小限制，移出栈底数据
	 */
	public void putObject(CacheModel cacheModel, Object key, Object object) {
		String ckey = getKey(cacheModel, key);
		keyList.add(ckey);
		try {
			Date expiry = new Date();// 过期时间
			expiry.setTime(expiry.getTime() + cacheModel.getFlushInterval());
			cache.add(ckey, object, expiry);
			log.debug("       putObject memcache!");
			log.info("cacheSize:" + cacheSize + ",keyListSize:"
					+ keyList.size());
			if (cacheSize > 0 && keyList.size() > cacheSize) {
				String oldestKey = keyList.remove(0);
				cache.delete(oldestKey);
				log.debug("       keyList.oldestKey memcache!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Object removeObject(CacheModel cacheModel, Object key) {
		log.info("       removeObject memcache!");
		String ckey = getKey(cacheModel, key);
		try {
			if (keyList.contains(ckey)) {
				keyList.remove(ckey);
				log.info("       removeObject memcache!");
				return cache.delete(ckey);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setProperties(Properties props) {
		String size = props.getProperty("size");
		if (size == null) {
			size = props.getProperty("cache-size");
		}
		if (size != null) {
			cacheSize = Integer.parseInt(size);
		}
		if (cache != null)
			cache = MemCachedManager.getInstance();
	}

	public int getCacheSize() {
		return cacheSize;
	}

	public void setCacheSize(int cacheSize) {
		this.cacheSize = cacheSize;
	}

	private String getKey(CacheModel cacheModel, Object cacheKey) {
		String key = cacheKey.toString();
		int keyhash = key.hashCode();
		String cacheId = cacheModel.getId();
		key = Config.MEMCACHED_PRE + cacheId + "_" + keyhash;
		return key;
	}
}
