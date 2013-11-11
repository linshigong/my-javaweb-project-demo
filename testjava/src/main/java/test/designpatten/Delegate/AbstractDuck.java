package test.designpatten.Delegate;

/**
 * abstract class of duck
 */
public abstract class AbstractDuck {
	
	//duck fly type
	private Iflyable fly;
	
	//duck quack type
	private IQuackable quack;
	
	//fly ability
	public void fly(){
		this.fly.fly();
	}
	
	//quack ability
	public void quack(){
		this.quack.quack();
	}
	
	/**
	 * description of the duck
	 */
	public abstract String getDescription();

	public void setFly(Iflyable fly) {
		this.fly = fly;
	}
	
	public void setQuack(IQuackable quack) {
		this.quack = quack;
	}
}
