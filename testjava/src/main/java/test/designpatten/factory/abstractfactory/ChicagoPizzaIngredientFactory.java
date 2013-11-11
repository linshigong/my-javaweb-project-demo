package test.designpatten.factory.abstractfactory;

import test.designpatten.factory.abstractfactory.ingredient.Cheese;
import test.designpatten.factory.abstractfactory.ingredient.Clams;
import test.designpatten.factory.abstractfactory.ingredient.Dough;
import test.designpatten.factory.abstractfactory.ingredient.FrozenClams;
import test.designpatten.factory.abstractfactory.ingredient.MozzarellaCheese;
import test.designpatten.factory.abstractfactory.ingredient.Mushroom;
import test.designpatten.factory.abstractfactory.ingredient.Pepperoni;
import test.designpatten.factory.abstractfactory.ingredient.PlumTomatoSauce;
import test.designpatten.factory.abstractfactory.ingredient.RedPepper;
import test.designpatten.factory.abstractfactory.ingredient.Sauce;
import test.designpatten.factory.abstractfactory.ingredient.SlicedPepperoni;
import test.designpatten.factory.abstractfactory.ingredient.ThickCrustDough;
import test.designpatten.factory.abstractfactory.ingredient.Veggies;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
	public Dough createDough() {
		return new ThickCrustDough();
	}

	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	public Veggies[] createVeggies() {
		Veggies veggies[] = {new Mushroom(), new RedPepper() };
		return veggies;
	}

	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FrozenClams();
	}
}
