package test.designpatten.factory.abstractfactory;

public class NYStyleCheesePizza extends Pizza {

	PizzaIngredientFactory ingredientFactory;

	public NYStyleCheesePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	void prepare() {
		this.name = "NY Style cheese pizza";
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
	}

}
