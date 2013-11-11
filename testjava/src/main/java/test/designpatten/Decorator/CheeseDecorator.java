package test.designpatten.Decorator;

public class CheeseDecorator extends AbstractCakeDecorator {

	public CheeseDecorator(ICake cake) {
		super(cake);
	}
	
	@Override
	public String getDescrption() {
		return cake.getDescrption()+",With Cheese";
	}
	
	@Override
	public float getPrice() {
		return cake.getPrice() + 2;
	}
	
}
