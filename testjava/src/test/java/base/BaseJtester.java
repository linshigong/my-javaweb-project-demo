package base;
import org.jtester.junit4.JTester;
import org.jtester.unitils.spring.AutoBeanInject;
import org.jtester.unitils.spring.AutoBeanInject.BeanMap;
import org.unitils.spring.annotation.SpringApplicationContext;

@SpringApplicationContext({ "classpath:houyi-spring-test.xml",
		"classpath:houyi-spring-dao.xml", 
		"classpath:houyi-spring-db.xml",
		"classpath:houyi-openapi.xml", })
@AutoBeanInject(maps = { @BeanMap(intf = "**.*", impl = "**.impl.*Impl") })
public abstract class BaseJtester extends JTester {
}