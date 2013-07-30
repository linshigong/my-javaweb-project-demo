package mytest.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 重写spring提供的配置文件处理类，加上功能方便代码中获取属性，不仅仅是配置文件的注入需要
 */
public class CustomPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    
    private static final Logger logger = Logger.getLogger(CustomPropertyPlaceholderConfigurer.class);
    
    public static Map<String, Object> ctxPropertiesMap = new HashMap<String, Object>();
    
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, 
                                     Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        
        for(Entry<Object, Object> entry: props.entrySet()){
            ctxPropertiesMap.put(String.valueOf(entry.getKey()), entry.getValue());
        }
        if(logger.isDebugEnabled()){
            logger.debug("ctxPropertiesMap initial finished,map=" + StringUtils.join(ctxPropertiesMap.entrySet().iterator(), ","));
        }
    }

    public static Object getContextPropery(String keyName){
        return ctxPropertiesMap.get(keyName);
    }

}
