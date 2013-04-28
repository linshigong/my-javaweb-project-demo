package test.designpatten.Decorator;

/**
 * 什么都没加的普通蛋糕
 */
public class PlainCake implements ICake {

	@Override
	public float getPrice() {
		return 10;
	}

	@Override
	public String getDescrption() {
		return "Plain cake";
	}

}
