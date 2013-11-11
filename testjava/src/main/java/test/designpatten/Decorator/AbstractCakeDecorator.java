package test.designpatten.Decorator;

/**
 * 装饰Cake的抽象类
 */
public abstract class AbstractCakeDecorator implements ICake{

	protected ICake cake; 
	
	public AbstractCakeDecorator(ICake cake) {
		this.cake = cake;
	}
	
	/**
	 * 子类实现
	 */
	public abstract String getDescrption();
	
	/**
	 * 子类实现
	 */
	public abstract float getPrice();

	public void setCake(ICake cake) {
		this.cake = cake;
	}
	
}
