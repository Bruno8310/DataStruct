## @datetime ：2019.08.12 pm

### 一. Springboot  2.1.7(稳定版)以上介绍

​	1.boot含义:开箱即用

​	2.约定大于配置，在工程搭建的时候，所有的资源一定要放在指定的路径

​	3.maven:规范工程目录结构，自动下载jar包，配置本地仓库存放下载的jar包，去远程服务器下载

​	4.http://start.spring.io 也可以通过这个网址进行创建Spring Start Project

​	5.文件后缀名:

​		.jar:java应用程序

​		.war:java web应用程序

​	6.Spring 工程的创建

​			工程目录结构：

​						1.src/main/java存放.java的源文件

​						2.src/main/resources静态资源 图片，js/css,  html

​						3.src/main/resources还需要存放 springboot 核心配置文件.properties的后缀名  其次也可以用.yml的后缀名						(主要用于Linux系统)，了解两种形式转换

​						4.src/main/resources 中 static文件夹，还可以手动创建public文件，两个文件夹的功能一致，主要存放静						态资源

​						5.src/main/templates存方放thymeleaf(百里香叶模板引擎，其他模板引擎页面均可放)

​						6.springboot里面有内置默认的application.properties文件，删除也能运行启动

​						7.在src/main/resources下配置application.yml文件，如果同时存在application.properties与application.yml						文件，spring默认读取application.properties文件，其次也可以再创建子文件夹存放自定义的.properties						与.yml配置文件，在main方法中有三种对应的启动SpringBoot工程的方法与流程:

​									1.加载SpringBoot启动类，在内存中对IOC容器进行初始化配置和加载

​									2.加载自定义的核心配置文件，对SpringBoot框架与工程中的bean初始化

​									3.启动本地SpringBoot工程

​									4.springboot启动为什么要加载启动类:

​								1.加载启动类，作用在于去解析@SpringBootApplication 注解标签-------->再解析			@CompontScan，将所有注解标签扫描，注册到Ioc容器中，生成spring的bean对象，Ioc容器本身是个存放复杂的Map集合，在内存中，有多个类完成bean的注册添加。					



​						8.src/test/java存放junit单元测试的源代码，----类路径(classpath)需要补充了解

​						9.target输出文件夹，存放.class字节文件，maven编译该工程的相关配置文件，最终打包的 .jar， .war						的文件

​						10.pom.xml文件：maven依赖库的配置文件，最终运行maven程序打包的配置

​						11.对pom.xml文件标签解释：									

```xml
<!--对应的要调用的类库-->
<dependency>
    <!--某一个jar包的坐标位置信息-->
	<groupId></groupId>
    <artifactId></artifactId>
    <!--版本-->
    <version></version>
    <!--指明这个jar用于测试-->
    <score>test</score>
    <!--依赖关系，当前SpringBoot工程依赖的这个jar包，打包之后不存在-->
    <score>provide</score>
    <!--默认的-->
    <score>compile</score>
    <!--将工程打包后才存在--->
    <score>runtime</score>
</dependency>
```



### 二.REST接口设计

​	资源表述性状态转移是一种体系结构，而HTTP是一种包含了REST架构属性的协议

​	SpringBoot通过@RestController注解，每请求一个方法后，返回一个JSON数据

​	@RestController的作用相当于(@Controller+@ResponseBody)，暴露类中的方法，以远程端口实现调用，REST接口设计请求的路径中不能有资源操作的动词出现

​	URI中不能出现类似：/queryAllTeacher，/deleteTeacher等

​	在REST接口中get，put，delete等代表一种操作

```java
@RestController
public class TeacherContrller {
    
    @AutoWired
    private TeacherService teacherService;
    //查询所有
    @GetMapping("/teachers")
    public List<TeacherVO> Teachers() {
        return xxxx.xxx();
    }
    //根据id查询
    @GetMapping("/teacher/{tid}")
    public TeacherVO getTeacherById(@PathVariable("tid") long tid) {
        return yyy.yyy();
    }
    //指定id删除
    @DeleteMapping("/teacher/{tid}")
    public String deleteTeacher(@PathVariable("tid") long tid) {
        
    }
    
    
}
```



### 三.WebService

​	1.springboot 配置jsp(属于扩展知识，用处不大)

​	存放路径：手动创建jsp存放文件的路径，手动在main文件夹下创建webapp文件夹，然后在webapp文件夹中创建WEB-INF文件夹主要用于存放jsp页面

​	下载jsp页面解析功能及标准c标签的jar包

### 四.Thymeleaf   百里香叶模板引擎(sts需要安装插件)

​	1.pom.xml文件中配置相关thymeleaf模板引擎的下载

​	2.application.yml文件中进行相关配置

​	3.创建thymeleaf页面

​	4.模板thymeleaf页面一定放在src/main/resources/templates目录下

​	5.在html页面上要标注thymeleaf标签的命名空间，th标签开头，

```xml
<html xmlns:th="http://www.thymeleaf.org"></html>
```

​	6.优点：页面可以动静两用

​	7.四大标签

​		${}：后台服务数据的绑定  request.getAttribute()

​		@{}：超链接与静态资源引用，对绝对路径的定位，一定要加th:

​		*{}：对象选择表达式，要在th:object所在标签的范围内使用，

​		#{}： 消息机制的内容绑定: SpringBoot默认的消息机制需要在src/main/resource目录下建立一个messages.properties文件，文件中存入key--value类型的键值对，key值对应页面中的key值。使用国际化功能----用得到

​			也可以自定义文件夹存放.properties文件，比如中英文的文件切换		

​		[[]]：内联表达式 ------>${}表达式的简写：独立于html标签之外的，不用在标签<>范围内

​		传参方式：

​						1./login?tid=...&tname=...  传统风格

​						2./login/{tid}/{tname} ： rest风格API接口传参 

​		控制层接收参数：

​					rest风格：

​						/login/{tid}/{tname}

​						方法参数中：@PathVariable("tid") int tid，@PathVariable("") String tname

​				   传统分格:

​						方法参数中：@RequestParam("tid") int tid, @ResquestParam("tname") String tname 

### 五.Redis + Spring缓存

​	Redis:REmote Dictionary Server----是一个由Salvatore Sanfilippo编写的key-value的存储系统

#### 	1.基本数据类型：

​								String 字符串

​								Hash 散列

​								List  列表

​								Set  集合

​								Sorted Set  有序集合

​								Redis中一个汉字占3个位置

#### 	2.事务：

​			watch : 开启多线程，代表的是一个锁的机制，乐观锁起监视的作用（有锁的概念就是存在高并发的数据操作）

​						监视一个key，采用提交一个事务或者使用unwatch解除监视状态。

​			multi : 新启动一个新的事务，队列里面存放所需要执行的命令

​			exec/discard ：事务的提交与回滚

​		Redis事务提交特点 ：即在命令入队列时Redis会进行语法检查，语法有问题报异常回滚，语法正常入队列并执行，当命令正常，但当执行有无效命令时，其他的也可以执行并将结果提交。

#### 	3. Redis到Java代码的整合：

​			1.Java直接连接Redis

​					设置远程访问Redis服务器的IP地址

​					设置远程Redis服务开启的端口(int类型)

​					设置远程Redis服务的密码

​					事务操作分为单线程与多线程									

```java

public Jedis getJedis() {
    //创建Jedis对象代表的是一个客户端连接
    Jedis jedis = new Jedis(address,port);
    //设置连接密码
    jedis.auth(password);
    return jedis;
}

//单线程操作事务
//开启事务
Jedis jedis = this.getJedis();
//生成事务的对象
Transaction transaction = jedis.multi();
//将命令存入队列
tx.set("key1","value1","key2","value2",...);
String value = tx.discard();

//多线程操作事务
jedis.watch("key1","key2","key3",...);
Transaction transaction = jedis.multi();
    
```

​			2.Redis的连接池

​				1.创建Jedis连接池配置				

```java
public class JedisPoolDemo {
    private static JedisPool jedisPool;
    private static JedisPoolConfig jedisPoolConfig;
    static {
        if(jedisPoolConfig == null) {
            jedisPoolConfig = new JedisPoolConfig();
            //有一系列配置
            jedisPoolConfig.setxx();
        }
    }
}
```



### 4.SpringBoot集成Redis模块

​	步骤：完善

​	1.在pom.xml文件中配置Redis的jar包	

​	方式一：通过yml配置文件进行配置

​	方式二：进行编码方式配置

​	RedisTemplate 模板类的作用：

​		统一分配和管理Redis资源

​		对操作方法进行统一规范和精简



​	Redis底层数据传输是字节方式，要对key--value设置序列化器，常用类型String，JSON，JDK序列化器，传输对象要实现Serializable接口。

​	5.SpringBoot调用Redis事务操作

​		实现SessionCallback接口		



#### 5.Redis数据库中缓存

​		1.首先自定义一个缓存管理器  

​			帮我们自动管理Redis的存储功能，RedisCacheWirter对象:主要负责写的操作对象，通过创建带有锁机制的缓存写入器解决一个并发的操作过程

​		2.SpringBoot启动类头部加@EnableCaching注解开启缓存

​		3.写缓存操作，建议放在service层处理

​		数据不是及时更新可以使用注解缓存方式进行编写，数据实时更新不适合用注解缓存方式



​			用于查询的注解

​			@Cacheable(cacheNames="newTeacherVO",key=" 'teacher_'+#p0.tid", unless="#result == null")：cacheNames代表一个命令空间显示在Redis数据库中（数据库中新生成一个）， #代表一个表达式，result代表注解标注的方法返回的结果集，tid指返回结果集中的一个字段，必须要有返回的结果集才能获取key值，unless代表的是对条件表达式取反，是否加入缓存中

​			用于新增和修改的注解

​			@CachePut(cacheNames="newTeacherVO", key=" 'teacher_'+#p0.tid")，不会去缓存中查找，先执行这个新增的方法存入关系数据库中，如果不出异常，将参数传入缓存空间（命令空间）newTeacherVO中去。

​			存入的key在Redis数据库中显示方式：newTeacherVO::teacher_key值			

​			在Service层中对应的业务处理方法，有返回值时，注解中key取"#result.属性名"，若没有返回结果不可以用result，可以取"#p0.属性名"，#p0代表代表这个方法中的参数所在位置

​			用于删除的注解

​			@CacheEvict(cacheNames="newTeacherVO",  key="'teacher_'+#tid", beforeInvocation = false), 指定false是确定先执行Service方法先删除关系数据库中数据行，然后再删除Redis缓存中数据,执行流程是这样。

​		 	用于查询所有注解

​			@Cacheenable(cacheNames="命名空间的名字", key="#root.targetClass" ,condition="#result != null && #result.size() >0")， 

​			所有的命名空间对应Redis数据库中，规范各种数据存放的位置

​			使用了注解缓存标注的方法之间不能嵌套调用，缓存机制会失效。



### 六.Springboot  Security  (单点安全认证机制)

### 七.Springboot 数据库连接池 

### 	性能排序:

### 	hikariCP(spring默认优先支持) > druid(阿里巴巴) > JNDI jdbc > dbcp2 > c3p0  

​		1.springboot配置数据源

​		连接数据库的操作，所有的原理与步骤均是:	new一个对象，加载配置文件，创建数据源

​			创建dbcp2数据源连接: 代码示例

​			创建HikariCP数据源连接：代码示例

​			需要用到@PropertySource(value="类路径的文件名字", "")，  @Value("${driverclasss}")， ·	

​		2.准备工作:热部署(专门用于开发时): 下载相关的.jar文件，在application配置文件中进行相应的配置

​		springboot中用到starter-jdbc的.jar时，会自动加载HikariCP的jar包

​		

​		两个注解的区别

​		@Configuration：经过一次CGLiB动态代理创建bean对象

​		@Component ：写在类的头部时，将整个类注入IOC容器，      Spring不会进行动态代理而直接new出来bean对象



​		4.springboot首先创建一个数据源，然后丢给hikaiCP数据连接池源相关优化，(也可以直接在hikaiCP直接创建数据源，开发不用)

​			注意一个jar包: springboot里面的IOC容器，默认生成dataSource， sqlSessionFactory对象

​			@MapperScan("映射文件的全路径")



### 八. Springboot + Mybatis

### 九.Springboot 打包和部署

​	1.打成jar文件

​	常用maven命令：

​		mvn clean：打包前将target文件夹(输出文件夹)清空

​		mvn compile：将正式运行的工程重新编译

​		mvn  package：将编译好的target文件夹中的内容打包，在target文件夹下生成.war的文件

​		mvn package -Dmaven.test.skip=true：跳过测试部分的代码

​		mvn  install：将编译好的target文件中的内容打包，同时将打包后的jar文件上传到本地的maven仓库中

​		

​	2.放置到外部的web容器中

​	1.要将SprootBoot内置的web容器（Tomcat，jetty)在pom.xml文件中，设置scope标签中值为provide

​	2.将SpringBoot工程转变为一个Servlet

​			1.需要将启动类继承一个SpringBootServletInitializer类,重写实现config()方法

​	3.在pom.xml文件中，设置package标签

​			

​	在工程部署前效验该工程中所用到jar文件是否有冲突，使用命令：mvn dependency:tree

​	在外围启动已打包的springboot工程，使用命令：mvn spring-boot:run,该命令的调用是在该工程所属的pom.xml文件所在路径下执行

​	

### 十.Springboot 日志 (有默认的日志记录)

​	1.log日志，slf4j(本身是连接，无缝连接)+logback(springboot默认)

​		slf4j+log4j2(主要使用这种方式)

​		log4j(支持properties格式) < logback < log4j2(只支持xml格式)

​	2.日志等级 ：OFF > FATAL > ERROR (前三个划分为错误级别)> WARN > INFO > DEBUG (调试级别)> TRACE > ALL(记录流水信息)

​	3.日志切分(自定义日志文件在本地磁盘路径，然后再在.yml文件中加载自定义的日志文件，较为复杂（看公司要求怎么使用）)---分为具体时间有具体日志--了解

​	4.Banner类：在src/main/resource根目录下引入，文本文件，广告幅。



### 十一 . lambda表达式

​	1.SpringBoot webflux（补充）

​		很有可能取代传统的request/response请求响应的servlet方式，而是主要是服务器发送数据，存入缓存中

​	2.lambda定义

​		接口式函数，存在一个接口，在接口中有且只有一个抽象方法（没有方法体）。

​		作用：精简代码，在读写性能上比传统的代码要快，可以并行读取流中数据（异步操作）

```java
public interface Demo {
	public void Test();
}
public static void main(String[] args) {
    //生成一个接口对象，传统的匿名内部类的写法
    Demo a = new Demo() {
        @override
        public void Test() {
            //对这个方法的具体实现
        }
    }
   //用lambda表达式进一步改写
    Demo a = () -> {
        //对这个方法的具体实现
    }
}
```

​	将数组列表中的数据转换流字节流，通过读取流的方式与传统序列化读取字符比较性能

```java
List<String> list = new ArrayList<>();
list.add("A");
list.add("B");
list.add("C");
list.add("D");
//方式一，传统序列化操作数据打印
list.forEach(System.out::println);//lambda表达式进一步改写
输出结果：ABCD (原本的顺序)
//将其转换为流并进行异步的操作
Stream<String> stream = list.stream().parallel();
//方式二，Stream流的方式
stream.forEach(System.out::println);
输出结果：顺序不确定


```



### 十二. Tomcat与Jetty容器的切换

​	1.修改jar包

```xml
<dependency>
    
    <exclusion>
		<groupId>org.springframework.boot</groupId>
  		<artifactId>spring-boot-starter-tomcat</artifactId>
    </exclusion>
</dependency>
```



### 	十三.Apache服务器	

​	



@RequestBody：用于post请求方式，请求头中以application/json格式，在控制器中使用该注解转换成对象

@ResponseBody：和RESTful接口形式类似 ，都是按照响应json格式数据给前端页面