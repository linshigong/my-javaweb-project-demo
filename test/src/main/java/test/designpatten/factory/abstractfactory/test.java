package test.designpatten.factory.abstractfactory;

public class test {
	public static void main(String[] args) {
		PizzaStore nyStore = new NYPizzaStroe();
		PizzaStore chicagoStore = new ChicagoPizzaStroe();
		Pizza pizza = nyStore.orderPizza("cheese");
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");
		pizza = chicagoStore.orderPizza("cheese");
		System.out.println("Joel ordered a " + pizza.getName() + "\n");
	}
}
