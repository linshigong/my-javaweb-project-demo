package mytest.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import mytest.base.BaseJtester;

public class CustomPropertyPlaceholderConfigurerTest extends BaseJtester {

    /**
     * 测试从自定义的属性解析类中获取配置属性
     */
    @Test
    public void testGetContextPropery(){
        String expected = "houyi";
        String actual = String.valueOf(CustomPropertyPlaceholderConfigurer.getContextPropery("jdbc.username"));
        
        Assert.assertEquals(actual, expected);
    }
    
}
