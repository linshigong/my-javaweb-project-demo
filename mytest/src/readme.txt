Step By Step Project

此为案例项目,以练习为主，先加入各个框架并测试通过，最后集成，改进：
	后续，以框架代码为开发目标，对整体做架构设计，开发为一个快速开发框架项目。
--------------------------------------------------------------------
	常用j2ee框架整合(struts2+ibatis+spring2,struts2+hibernate3+spring2)，
	webservice框架cxf，
	缓存框架 oscache，memcache
	数据库连接池 例如 DBCP1.1 ; c3p0
	视图技术 sitemash ，freemaker，jsp
	js库jquery (常用正则及含义)

	环境: java6 ,tomcat6,mysql5,windows xp(sp3),myeclipse6.5
		struts2
		spring2
		ibatis2.3.4
		
	Date:2011-10-24
--------------------------------------------------------------------
step1:
	新建 web project
	
step2:
	* 加入spring2.5支持(作为业务层，并使用其提供的各类功能)，即把spring的core和web部分的jar包拷贝到项目lib目录下;
	* 配置web.xml文件，如下：
	  <!-- 定义spring配置文件位置和文件名 -->
	  <context-param>
	  	<param-name>contextConfigLocation</param-name>
	  	<param-value>WEB-INF/classes/bean.xml</param-value>
	  </context-param>

	  <listener>
	  	<description>spring listener</description>
	  	<display-name>listener</display-name>
	  	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	  </listener>
	这样，spring在项目启动时进行初始化。	
	* 编写测试代码，(测试spring的IOC，测试..待补充)
	* spring自带了log4j日志插件的jar包，在src下建立log4j.properties文件,配置可以从其jar包拷贝，或者拷贝其他项目配置
	  详细配置参考log4j的框架指南。

step3:
	* 加入ibatis框架作为Dao层的O/R映射框架
	* ibatis就一个jar包，把它拷贝到lib目录下；其他的jar根据需要自行添加，在框架的依赖说明文件里有详细列表
	* 参考ibatis自带的一个小例子，修改配置文件和映射文件，并测试

step4:
	* 集成ibatis和spring
	* 加入spring持久层模块的jar包
	* 找到spring支持ibatis集成的类库接口(org.springframework.orm.ibatis.SqlMapClientFactoryBean)
	* 在spring配置文件里配置上面这个工厂类(定义了bean的class属性后，IDE可提示此类有哪些属性可以配置,这是spring配置文件的小技巧)，
	  此类即可提供ibatis与数据库交互的 SqlMapClient 对象
	* 在其他需要用到 SqlMapClient 的类中，得到这个工厂类返回的 SqlMapClient 即可
	* 测试：通过springIOC注入 SqlMapClient 到业务类中，并使用 SqlMapClient 与数据库交互(web容器测试，或者初始化spring上下文来测试getBean)
step5:
	* 加入数据库连接池(这里指JDBC连接池，hibernate自带的不适合生产环境)框架 DBCP(或者c3p0等)，此处以加入apache的数据库
	   连接池框架 DBCP1.4 (JDK1.6，JDBC4)为例,此框架依赖 common-pool包
	* 数据源的配置 (简单jdbc数据源，容器数据源，jndi数据源，从缓冲池取得的数据源)
	
	
step5:
	* 加入spring事务管理 
		测试 5种spring事务配置方式(测试)
		
			
	