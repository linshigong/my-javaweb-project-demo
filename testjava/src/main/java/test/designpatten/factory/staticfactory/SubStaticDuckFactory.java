package test.designpatten.factory.staticfactory;

import test.designpatten.Delegate.AbstractDuck;

/**
 * static duck factory
 */
public class SubStaticDuckFactory extends StaticDuckFactory{

	/**
	 *  本方法不会覆盖父类方法，而是各自独立的
	 */
	public static AbstractDuck createDuck(Class<AbstractDuck> duckClass){
		throw new UnsupportedOperationException();
	}
	
}
