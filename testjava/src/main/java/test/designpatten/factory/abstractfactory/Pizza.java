package test.designpatten.factory.abstractfactory;

import test.designpatten.factory.abstractfactory.ingredient.Cheese;
import test.designpatten.factory.abstractfactory.ingredient.Clams;
import test.designpatten.factory.abstractfactory.ingredient.Dough;
import test.designpatten.factory.abstractfactory.ingredient.Pepperoni;
import test.designpatten.factory.abstractfactory.ingredient.Sauce;
import test.designpatten.factory.abstractfactory.ingredient.Veggies;

/**
 * 产品抽象类
 */
public abstract class Pizza {
	
	/* Each Pizza has a name, a type of dough, a type of sauce, and a set of toppings. */
	String name;
	Dough dough;
	Sauce sauce;
	Veggies veggies[];
	Cheese cheese;
	Pepperoni pepperoni;
	Clams clam;

	/**
	 * 材料由子类通过工厂获取
	 */
	abstract void  prepare();
	
	/* The abstract class provides some basic defaults for baking,cutting and boxing. */
	void bake() {
		System.out.println("Bake for 25 minutes at 350");
	}

	void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}

	void box() {
		System.out.println("Place pizza in official PizzaStore box");
	}

	public String getName() {
		return name;
	}

}
