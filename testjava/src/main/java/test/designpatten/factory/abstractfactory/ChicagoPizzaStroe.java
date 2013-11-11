package test.designpatten.factory.abstractfactory;

public class ChicagoPizzaStroe extends PizzaStore{

	@Override
	protected Pizza createPizza(String pizzaType) {
		//The NY Store is composed with a NY pizza ingredient factory. This will be used to 
		//produce the ingredients	for all NY style pizzas.
		PizzaIngredientFactory ingredientFactory =new ChicagoPizzaIngredientFactory();
		
		return new ChicagoStyleCheesePizza(ingredientFactory);
	}
	
}
