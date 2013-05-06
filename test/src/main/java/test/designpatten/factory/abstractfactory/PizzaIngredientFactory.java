package test.designpatten.factory.abstractfactory;

import test.designpatten.factory.abstractfactory.ingredient.Cheese;
import test.designpatten.factory.abstractfactory.ingredient.Clams;
import test.designpatten.factory.abstractfactory.ingredient.Dough;
import test.designpatten.factory.abstractfactory.ingredient.Pepperoni;
import test.designpatten.factory.abstractfactory.ingredient.Sauce;
import test.designpatten.factory.abstractfactory.ingredient.Veggies;

/**
 * pizza原料抽象工厂类
 */
public interface PizzaIngredientFactory {
	public Dough createDough();

	public Sauce createSauce();

	public Cheese createCheese();

	public Veggies[] createVeggies();

	public Pepperoni createPepperoni();

	public Clams createClam();
}
