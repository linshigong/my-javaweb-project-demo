package test.designpatten.factory.abstractfactory;

import test.designpatten.factory.abstractfactory.ingredient.Cheese;
import test.designpatten.factory.abstractfactory.ingredient.Clams;
import test.designpatten.factory.abstractfactory.ingredient.Dough;
import test.designpatten.factory.abstractfactory.ingredient.FreshClams;
import test.designpatten.factory.abstractfactory.ingredient.Garlic;
import test.designpatten.factory.abstractfactory.ingredient.MarinaraSauce;
import test.designpatten.factory.abstractfactory.ingredient.Mushroom;
import test.designpatten.factory.abstractfactory.ingredient.Onion;
import test.designpatten.factory.abstractfactory.ingredient.Pepperoni;
import test.designpatten.factory.abstractfactory.ingredient.RedPepper;
import test.designpatten.factory.abstractfactory.ingredient.ReggianoCheese;
import test.designpatten.factory.abstractfactory.ingredient.Sauce;
import test.designpatten.factory.abstractfactory.ingredient.SlicedPepperoni;
import test.designpatten.factory.abstractfactory.ingredient.ThinCrustDough;
import test.designpatten.factory.abstractfactory.ingredient.Veggies;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
	public Dough createDough() {
		return new ThinCrustDough();
	}

	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	public Cheese createCheese() {
		return new ReggianoCheese();
	}

	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(),
				new RedPepper() };
		return veggies;
	}

	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FreshClams();
	}
}
