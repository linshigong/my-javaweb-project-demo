package test.designpatten.factory.staticfactory;

import test.designpatten.Decorator.ICake;
import test.designpatten.Decorator.PlainCake;
import test.designpatten.Delegate.AbstractDuck;
import test.designpatten.Delegate.ToyDuck;

public class test {

	public static void main(String[] args) {
		
		
		AbstractDuck duck = StaticDuckFactory.createDuck(ToyDuck.class);
		System.out.println(duck.getDescription());
		
		//继承静态方法的子类工厂，不会覆盖父类的静态方法，各自都是独立的
		try {
			AbstractDuck duck2 = SubStaticDuckFactory.createDuck(ToyDuck.class);
			System.out.println(duck2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//java 泛型的使用 ，抽象类和接口都这样表达继承关系: Class<? extends ICake> cakeClass ,Class<? extends AbstractDuck>
		ICake cake = StaticDuckFactory.createCake(PlainCake.class);
		System.out.println(cake.getDescrption());
		
	}
	
}
