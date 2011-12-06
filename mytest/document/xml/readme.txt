###################################
xml到java pojo的映射工具,api

实现从xml格式的配置数据和pojo对象互转,减少重复开发。

比如 Castor API,java

###################################
关于xml:

	XML Schema描述了XML文档的结构。可以用一个指定的XML Schema来验证某个XML文档，
以检查该XML文档是否符合其要求。文档设计者可以通过XML Schema指定一个XML文档所允许的结构和内容，
并可据此检查一个XML文档是否是有效的。XML Schema本身是一个XML文档，它符合XML语法结构。
可以用通用的XML解析器解析它。

一个xml文档都有一个根元素，根元素里可以定义命名空间及xml文档机构描述，例如：

web.xml的根元素:
	<web-app version="2.5" xmlns="http://java.sun.com/xml/ns/javaee"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
		http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">
		
spring配置文件：
	<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:aop="http://www.springframework.org/schema/aop"
		xmlns:tx="http://www.springframework.org/schema/tx"
		
		xsi:schemaLocation="http://www.springframework.org/schema/beans 
		http://www.springframework.org/schema/beans/spring-beans-2.5.xsd 
		http://www.springframework.org/schema/aop 
		http://www.springframework.org/schema/aop/spring-aop-2.5.xsd 
		http://www.springframework.org/schema/tx 
		http://www.springframework.org/schema/tx/spring-tx-2.5.xsd">
		
xmlns 默认命名空间，这样标签不需要带前缀		
其他标签需要 比如 <tx:xxx 