package test.designpatten.factory.abstractfactory;

/**
 * 抽象工厂类，由子工厂决定产品的实现
 * 
 */
public abstract class PizzaStore {

	public Pizza orderPizza(String pizzaType){
		
		Pizza pizza = createPizza(pizzaType);
		
		//下面这些细节，实现在具体的Pizza子类中，工厂类不知道细节
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}
	
	/**
	 * 抽象方法，又子类实现
	 */
	protected abstract Pizza createPizza(String pizzaType);
}
