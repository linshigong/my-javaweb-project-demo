package test.designpatten.Delegate;

/**
 * fly with wings
 */
public class FlyWithWing implements Iflyable {

	@Override
	public void fly() {
		System.out.println("Fly with wings");
	}

}
