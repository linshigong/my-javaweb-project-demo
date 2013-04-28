package test.designpatten.Decorator;

/**
 * 装饰者模式: 动态地将责任附加到对象上。若要扩展功能，装饰者提供了比继承更有弹性的替代方案。
 */
public class test {

	public static void main(String[] args) {
		
		/* 需要一个奶油蛋糕 */
		ICake cake = new PlainCake();//先做一个什么都没加的蛋糕
		cake = new CheeseDecorator(cake);//装饰奶油
		System.out.println("说明："+cake.getDescrption()+" 价格:"+cake.getPrice());
		
		/* 需要一个加奶油、加草莓的蛋糕 */
		ICake cake2 = new PlainCake();//先做一个什么都没加的蛋糕
		cake2 = new CheeseDecorator(cake2);//装饰奶油
		cake2 = new StrawberryDecorator(cake2);//装饰草莓
		//装饰更多的口味或水果...,能够动态组合创建新对象
		System.out.println("说明："+cake2.getDescrption()+" 价格:"+cake2.getPrice());
		
	}
	
}
