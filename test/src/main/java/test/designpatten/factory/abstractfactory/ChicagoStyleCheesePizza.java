package test.designpatten.factory.abstractfactory;

public class ChicagoStyleCheesePizza extends Pizza {
	
	PizzaIngredientFactory ingredientFactory;

	public ChicagoStyleCheesePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	void prepare() {
		this.name = "Chicago Style cheese pizza";
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
	}
	
	/**
	 * The Chicago style pizza also overrides the cut() method 
	 * so that the pieces are cut into squares.
	 */
	void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}