package test.memcache.myclient;

import test.memcache.memchaceclientapi.com.meetup.memcached.MemcachedClient;
import test.memcache.memchaceclientapi.com.meetup.memcached.SockIOPool;

/**
 * test memcache 
 * centos5测试
 * 1)启动memcached
 * 	memcached -d -m 10 -u root -l 192.168.232.162  -p 12000 -c 256 -P /tmp/memcached.pid
 * 2)配置防火墙允许访问
 *  #/sbin/iptables -I INPUT -p tcp --dport 12000 -j ACCEPT
 *  #/sbin/iptables -I INPUT -p udp --dport 12000 -j ACCEPT
 */
public class test {

	public static void main(String[] args) {
		
		MemcachedClient mc = new MemcachedClient();
		
		mc.add("a", 1);
		
		System.out.println(mc.get("a"));
		
	}
	
	
	//inital IOPool
	static {
		String[] serverlist = { "192.168.232.162:12000" };

		SockIOPool pool = SockIOPool.getInstance();
		pool.setServers(serverlist);
		pool.initialize();	
	}

	
}
