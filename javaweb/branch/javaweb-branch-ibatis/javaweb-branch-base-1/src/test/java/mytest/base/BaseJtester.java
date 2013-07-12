package mytest.base;

import org.jtester.testng.JTester;
import org.unitils.spring.annotation.SpringApplicationContext;

@SpringApplicationContext({
	"classpath:spring/application-context.xml",
	})
//@AutoBeanInject(maps = { @BeanMap(intf = "**.*", impl = "**.impl.*Impl") })
public abstract class BaseJtester extends JTester {
}