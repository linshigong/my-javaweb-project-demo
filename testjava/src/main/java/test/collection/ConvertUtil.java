package test.collection;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

/**
 * 列表转换工具类，从一种列表对象，转换为另外一种对象列表
 * 使用反射
 */
public class ConvertUtil {
        
    private static final Logger logger = Logger.getLogger(ConvertUtil.class);
        
        public static <T1, T2 extends AbstractApiResult<T1>> List<T2> convertList(List<T1> list, Class<T2> ApiResultClass){
            if(CollectionUtils.isEmpty(list)){
                throw new RuntimeException("error ,list is empty");
            }
            List<T2> newList = new ArrayList<T2>(list.size());
            try {
                for(T1 sourceBean: list){
                    T2 targetBean = ApiResultClass.newInstance();
                    targetBean.copy(sourceBean);
                    newList.add(targetBean);
                }
            } catch (InstantiationException e) {
                logger.error("error, Convert bean failed", e);
            } catch (IllegalAccessException e) {
                logger.error("error, Convert bean failed", e);
            }finally{
                list.clear();
            }
            
            return newList;
        }
        
    
}
abstract class AbstractApiResult<T>{
    public abstract void copy(T sourceBean);
}
