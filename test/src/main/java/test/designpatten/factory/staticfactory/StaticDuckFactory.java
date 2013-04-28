package test.designpatten.factory.staticfactory;

import test.designpatten.Decorator.ICake;
import test.designpatten.Delegate.AbstractDuck;

/**
 * static duck factory
 * 
 * 注：静态工厂类的方法，不能通过继承来修改创建行为
 * 
 */
public class StaticDuckFactory {

	/**
	 *  
	 * @param duckClass Implemention class of AbstractDuck
	 * @return
	 */
	public static AbstractDuck createDuck(Class<? extends AbstractDuck> duckClass){
		try {
			return duckClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ICake createCake(Class<? extends ICake> cakeClass){
		try {
			return cakeClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
