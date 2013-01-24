osgi初探
1. 使用equnix作为osgi的实现框架
	例子场景为，example这个bundle提供了一个nameservice服务，可以根据name来判断是否存在；exampleclient这个bundle是一个client端，它调用example的服务来验证
	输入的name是否存在。
2. client启动，需要手动启动已保证console可接受输入
3. 具体步骤参考例子文档