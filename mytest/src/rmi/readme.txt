Java RMI之HelloWorld篇
 
		Java RMI 指的是远程方法调用 (Remote Method Invocation)。它是一种机制，能够让在某个 Java 虚拟机上的对象调用另一个 Java 虚拟机中的对象上的方法。可以用此方法调用的任何对象必须实现该远程接口。
 
		Java RMI不是什么新技术（在Java1.1的时代都有了），但却是是非常重要的底层技术。
		大名鼎鼎的EJB都是建立在rmi基础之上的，现在还有一些开源的远程调用组件，其底层技术也是rmi。
 
		在大力鼓吹Web Service、SOA的时代，是不是每个应用都应该选用笨拙的Web Service组件来实现，通过对比测试后，RMI是最简单的，在一些小的应用中是最合适的。
 
		下面通过一个简单的例子来说明RMI的原理和应用，下面这个例子是一个简单HelloWorld，但已涵盖RMI的核心应用与开发模式。

		从上面的过程来看，RMI对服务器的IP地址和端口依赖很紧密，但是在开发的时候不知道将来的服务器IP和端口如何，但是客户端程序依赖这个IP和端口。
这也是RMI的局限性之一。这个问题有两种解决途径：一是通过DNS来解决，二是通过封装将IP暴露到程序代码之外。
		RMI的局限性之二是RMI是Java语言的远程调用，两端的程序语言必须是Java实现，对于不同语言间的通讯可以考虑用Web Service或者公用对象请求代理
体系（CORBA）来实现


来自：http://www.cnblogs.com/ninahan0419/archive/2009/06/25/javarmi.html