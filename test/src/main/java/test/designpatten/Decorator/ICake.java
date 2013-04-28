package test.designpatten.Decorator;

/**
 * 装饰器模式，被装饰者接口类(或者是抽象类)
 */
public interface ICake {

	/**
	 * 价格
	 */
	public float getPrice();
	
	/**
	 * 描述
	 */
	public String getDescrption();
	
}
