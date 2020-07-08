## @datetime 2019.11.6(Nuxt.js)

#### 一、HTML

​	结构

​	<tag>标签、文本、属性</tag>

​	<tag>包含内容</tag>

​	<tag/>自闭合

​	<a href="" alt="" class="">linlk</a>

​	XML：元素（element）、属性（attribute）、文本（text）

​	SGML：定义出了HTML1-4	不区分大小写

​	XML：定义	XHTML1.0	严格区分大小写

​	HTML5：灵活，建议小写



​	区分：	样式---display

​			块级---block		独立的整体，占一行

​			内联---inline		位于块级元素的内部、多个在同一行

#### 二、CSS

​	样式、布局

​		选择器-------优先级排序

​					1.元素选择器（标签名）

​						ol, a, h1, button...

​					2.类选择器（类型、类别、多个元素的统称）

​						.name、.actor

​					3.id选择器 文档中唯一

​						#app

​					4.样式属性

​					5.!important  ----最终的，不可以被覆盖，写在样式后面

````html
<!--引入外部css文件-->
<link rel="stylesheet" href=""/>
````



样式文件链接：额外的网络请求



#### 三、JS/	ECMA Script/	ES  2015/	ES6/  Vue.js

​	1.是一种动态类型的解释型语言，可以用作前端开发在浏览器内部运行，像Node.js可以做桌面、服务端开发，Node.js	是一个RT，是将内嵌在游览器中一个引擎或称为V8虚拟机提取出来。但当项目规模较大时，不适合用动态语言，不够	严谨。

​		出现：		TypeScript----TS---微软公司-----适应大规模的开发

​						兼容所有JS类型，静态类型与编译型，比如存在Any类型

​						通过tc编译器，将ts文件编译成js文件，然后在浏览器中运行

​	2.``反引号可以做为在控制台中格式化的输出，变量可以用 ${变量名} 打印变量值

​	浏览器结构：解码器，渲染，执行JS的引擎

3. undefined是未定义，null是一个值

4. 对服务器资源的操作---REST(资源、呈现、状态、迁移)ful API接口风格设计

   1. ​	HTTP动词		是否幂等(多次执行的结果是否相同)

   /user

   ​	GET	查询		幂等

   ​			/user		返回列表

   ​			/user/1		返回一个

   ​	POST	创建		非幂等

   ​			/user

   ​	PUT	更新		幂等

   ​			/user		满足条件的多个

   ​			/user/1	一个

   ​	DELETE	删除		幂等

   ​			/user		满足条件的多个

   ​			/user/1		一个

   web 1.0	1995年 普通用户阅读/发布者	门户(ALL)

   web 2.0	2002~2004 博客网站/twitter 读写的网络

   ​				1		发布/创造信息

   ​				9 		参与/回复

   ​				90		仅仅阅读

   ​	网站垂直关系

   web 3.0	开放API作为服务提供给第三方，接入和使用第三方的API

   云、容器技术、分布式、微服务		Spring Cloud / jar
   
   
   
5. 分页问题

   
   
6. 观察者模式（发布/订阅模式）

   ​	早期有MVC模式，中期有MVP，现在MVVM(微软在开发图新界面引入这个概念，iOS，Android，前端Angular/Vue/React均有实现)

   1. MVVM----Model----View----ViewModel

      可观测的主题(主题/发布方)

   
   
   
   
   7.单例模式（singleton）
   
   ​	类是模板，可以创建出多个实例（对象），使用单例，类只能创建出唯一的实例
   
   ​			1.构造方法私有化，提供类方法获得唯一实例
   
   ```java
   class Singleton1 {
       static Singleton1 singleton;
       private Singleton1() {}
       public synchronized static Singleton getInstance {
           if() {
               singleton = new Singleton1();
           }
           return singleton;
       }
       
   }
   
   class Singleton2{
       static Singleton2 singleton = new Singleton2();
       private Singleton2() {}
       public static Singleton getInstance() {
           return singleton;
       }
   }
   ```
   
   
   
   8.Sping原理----当中运用到的单例和工厂模式---现代的Java
   
   ​		本身是一个Ioc容器，组件(POJO)作用域：
   
   ​											1.单例---默认的
   
   ​											2.原型---工厂模式
   
   ​											web中有：请求、会话
   
   
   
   9.工厂模式
   
   ​		静态工厂 / 简单工厂
   
   ​			在一个类的静态方法中封装多中产品的构造方法
   
   ​				A a = Factory.newA()
   
   ​				B b = Factory.newB()
   
   ​				C c = Factory.newC()
   
   ​		抽象工厂
   
   ​			JDBC		定义一组接口（抽象的定义）
   
   ​					java.sql
   
   ​							Driver
   
   ​							Connection		interface
   
   ​							Statement		 interface
   
   ​							ResultSet		  interface
   
   ```java
   // 不同数据库驱动各自实现了Driver及相关接口
   Connection 
   ```
   
   
   
   ​					javax.sql
   
   ​			
   
   ​					mysql
   
   ​						要用到驱动程序
   
   ​					oracle
   
   ​						要用到驱动程序
   
   ​		servlet/jsp容器
   
   ​				Servlet/JSP规范
   
   ​					apache tomcat是一个实现
   
   ​					jboss
   
   ​					wildfly
   
   ​					jetty
   
   ​		JPA
   
   
   
   
   
   10. web app stack(web应用栈)----Spring Boot已经整合完毕
   
       1. View 模板引擎 服务端渲染 HTML
   
          JSP、Freemarker、Velocity、JSTL
   
       2. MVC接收 HTTP请求 ，回复View
   
          Servlet
   
          Struts
   
          webwork
   
          xwork
   
          spring MVC
   
       3. 业务逻辑（POJO）
   
          Spring、Guice
   
       4. 数据访问
   
          JDBC、ejb、hibernate、mybatis
       
   11. 会话跟踪和状态管理（记录获得web用户的状态 / 持久化存入数据库）
   
       1.http协议是无状态，一个Request，一个Response
   
       2.Web状态的获取
   
       ​		1.Cookie：浏览器提出支持，服务器通过HTTP响应头发送给用户浏览器，文本格式存储状态信息于本地磁盘，分为临时cookie和有周期的cookie，用户访问网址时，会将cookie信息放置请求头中
   
       ​			最大数量：300，大小：4K，形式是K-V
   
       ​			优点：
   
       ​			用户浏览器关闭或者关机，再次浏览网址时，保留上次的内容
   
       ​			缺点：
   
       ​			文本形式存储数据结构单一，无法存储复杂的数据结构，仅在浏览器中支持，移动端需要使用自定义的cookie，用户也可以禁止使用cookie，数据负载很大，安全性低
   
       ​			场景：
   
       ​			用户鉴权、登陆一次记住、状态追踪(浏览的内容或者进度)
   
       ​		2.Session：基于临时cookie实现的，第一次访问网址请求时，服务端生成JSESSIONID的临时cookie（该唯一标识在响应中后存在于浏览器进程的内存，浏览器关闭就不存在），在响应中发给客户端，在服务器内存空间创建一个HashMap<String, Object>存储用户状态信息，有效期限(Tomcat中默认是30min)，超时空间会释放，如再次请求时，会在请求头中的cookie字段携带jsessionid的值。注销或者退出，让会话失效
   
       ​			优势：
   
       ​			大小和格式都不受限制
   
       ​			缺点：
       
       ​			占用服务器资源
       
       ​		3.Token / OAuth（令牌/开放认证和授权）
       
       ​		
       
       ​		4.URL重编码---令牌(用户在浏览器中禁止cookie，session默认的工作方式失效)
       
       ​			如果用户禁止了cookie，需要使用重编码解决问题
       
       ​			原jsessionid请求头中的值，会追加到url路径中----url;jsession=123456782345
       
       ```java
       href="<%= response.encodeURL("url") %>"
       ```
       
       
       
       ​			
       
       3.springboot启用jsp
       
       ​		1.创建工程以war包的形式打包
       
       ​		2.pom.xml文件中添加jsp依赖的jar包
       
       ​		3.编辑配置文件定义前缀(放置的文件目录：/WEB-INF/jsp/)与后缀(.jsp)
       
       ​		4.在工程文件中建立相应的文件目录，jsp放置在WEB-INF文件夹中的jsp文件夹中
       
       ​		5.写控制器中方法
       
       4.传统java服务端程序与spring mvc的作用域
       
       ​	jsp中有 page、request（请求转发）、session（jsessionid）、application（全局的只有一份，类似单例模型）
       
       ​	spring mvc有 单例（只有一个）、原型（每一次都是全新的）、request、session（在web程序中）
       
       ​	
       
       

#### 四.月考试卷讲评

​		1.HTML文档由元素、属性和文本三个要素构成		

​		2.CSS中的属性，display:none与visibility:hidden，第一个不可见不占空间，第二个会隐藏占空间

​		3.class='container'与class="container-fluid"的区别，第一个是bootstrap4才出现的

​		4.class="form-inline"的作用是文本框的标签、输入栏在同一行显示		

#### 



