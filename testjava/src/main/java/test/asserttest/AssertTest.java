package test.asserttest;

/**
 * J2SE 1.4在语言上提供了一个新特性，就是assertion功能，它是该版本在Java语言方面最大的革新。 
 * 从理论上来说，通过 assertion方式可以证明程序的正确性，但是这是一项相当复杂的工作，目前还没有太多的实践意义。 
 * 在实现中，assertion就是在程序中的一条语句，它对一个boolean表达式进行检查，一个正确程序必须保证这个boolean表达式的值为true；如果该值为false，
 * 说明程序已经处于不正确的状态下，系统将给出警告或退出。一般来说，assertion用于保证程序最基本、关键的正确性。assertion检查通常在开发和测试时开启。
 * 为了提高性能，在软件发布后，assertion检查通常是关闭的。
 * <p>
 * 参数 -esa和 -dsa：<br>
 * 
 * 它们含义为开启(关闭)系统类的assertion功能。由于新版本的Java的系统类中，也使了assertion语句，因此如果用户需要观察它们的运行情况，
 * 就需要打开系统类的assertion功能 ，我们可使用-esa参数打开，使用 -dsa参数关闭。 -esa和-dsa的全名为-enablesystemassertions和
 * -disenablesystemassertions，全名和缩写名有同样的功能。
 * <p>
 * 参数 -ea和 -ea：<br>
 * 
 * 它们含义为开启(关闭)用户类的assertion功能：通过这个参数，用户可以打开某些类或包的assertion功能，同样用户也可以关闭某些类和包的assertion功能。
 * 打开assertion功能参数为-ea;如果不带任何参数，表示打开所有用户类;如果带有包名称或者类名称，表示打开这些类或包;如果包名称后面跟有三个点，代表这个包及其子包;
 * 如果只有三个点，代表无名包。关闭assertion功能参数为-da，使用方法与-ea类似。
 * -ea和-da的全名为-enableassertions和-disenableassertions，全名和缩写名有同样的功能。
 * 下面表格表示了参数及其含义，并有例子说明如何使用。
 * -ea java -ea 打开所有用户类的assertion
 * <p>
 * EG:<br>
 *   java -dsa:MyClass1:pkg1 关闭MyClass1和pkg1包的assertion 
 *   java -esa:MyClass1:pkg1 开启MyClass1和pkg1包的assertion 
 *   
 *   java -da:MyClass1:pkg1 关闭MyClass1和pkg1包的assertion 
 *   java -ea:MyClass1:pkg1 开启MyClass1和pkg1包的assertion 
 * 
 * From: http://zhidao.baidu.com/question/355255108.html
 *<p>
 * Test assert
 *
 */
public class AssertTest {

	public static void main(String[] args) {
		
		assert (1 > 0);
		System.out.println("right");
		assert (1==0);
		System.out.println("right2");
		/**output=
		 right
		 Exception in thread "main" java.lang.AssertionError
				at test.asserttest.AssertTest.main(AssertTest.java:40)
		 */
		
	}
	
}
