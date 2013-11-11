package test.designpatten.Delegate;

/**
 * Test delegate patten
 * 
 * fly and quack is delegate to someone else  
 * 
 */
public class test {

	public static void main(String[] args) {
	
		/* need a toy duck ,which can't fly and can't quack either */
		AbstractDuck toyDuck = new ToyDuck();
		
		System.out.println(toyDuck.getDescription());
		toyDuck.fly();
		toyDuck.quack();
		
		System.out.println();
		
		/* need another toy duck ,which can't quack but it can fly with rocket,isn't that awesome */
		AbstractDuck toyDuck2 = new ToyDuck(new FlyWithRocket(),new QuackNoway());
		System.out.println(toyDuck2.getDescription());
		toyDuck2.fly();
		toyDuck2.quack();
		
	}
	
}
