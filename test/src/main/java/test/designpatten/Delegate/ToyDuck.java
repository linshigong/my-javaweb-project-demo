package test.designpatten.Delegate;

public class ToyDuck extends AbstractDuck {
	
	/**
	 * construct a duck can fly with rocket
	 */
	public ToyDuck() {
		setFly(new FlyNoway());
		setQuack(new QuackNoway());
	}
	
	public ToyDuck(Iflyable fly,IQuackable quack) {
		setFly(fly);
		setQuack(quack);
	}
	
	@Override
	public String getDescription() {
		return "I'm a toy duck";
	}

}
