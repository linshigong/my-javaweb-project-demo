package test.designpatten.Decorator;

public class StrawberryDecorator extends AbstractCakeDecorator {

	public StrawberryDecorator(ICake cake) {
		super(cake);
	}
	
	@Override
	public String getDescrption() {
		return cake.getDescrption()+",With Strawberry";
	}
	
	@Override
	public float getPrice() {
		return cake.getPrice() + 6.5f;
	}
	
}
