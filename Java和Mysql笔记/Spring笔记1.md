## @datetime: 2019.07.23 am

### 一.  IOC  (控制反转)

把创建对象的权利交给Spring，通过配置文件配置类的全路径，反射创建对象给工厂，通过指定的id，到工厂中拿取对象



### 二.  DI  (依赖注入)

​	通过配置文件反射调用私有属性的set方法和默认的无参构造方法给属性注入值，ref="引用对象的id"  value="常量值"

​	通过配置文件反射调用有参构造方法给私有属性字段赋值(初始化)

```xml
<!--bean的装配方法 (bean的依赖注入方式)-->
<!--Setter injection(设置注入)-->
<!--通过bean标签创建对象-->
<!--scope作用：每次去工厂拿对象时，对象是否是新生成的，表示创建的bean实例的作用域范围-->
<!--scope取：singleton(单例)：每次Spring容器获取bean的实例时都返回同一个实例
			prototype(原型):每次Spring容器获取bean的实例时都会新建一个实例，返回的是不同对象-->
<bean id="对象名" class="所属类的全路径" scope="" init-method="" destory-method="">
    <!--初始化对象中的属性或成员变量-->
    <!--对象中所包含属性为实体类对象-->
	<property name="所含属性中对象名" ref="引用已创建的哪个对象名"></property>
    <!--对象中所包含属性为基本数据类型-->
    <property name="属性名" value="初始值"></property>
    <!--对象中所包含属性为集合类型-->
    <!--List-->
    <property name="对象中的属性名">
    	<list>
        	<value>集合中所需要添加的数据</value>
        </list>
    </property>
    <!--Set-->
    <property name="对象中的属性名">
    	<set>
        	<value>集合中所需要添加的数据</value>
        </set>
    </property>
    
    <!--Map key和value-->
    <property name="对象中的属性名">
    	<map>
        	<entry key="键名" value="键值"/>
        </map>
    </property>
</bean>

<!--Constructor injection(构造注入)-->
<bean id="对象名" class="所属类的全路径" scope="默认是singleton">
	<constructor-arg index="(基本数据类型)参数在构造方法中的位置" value="常量值" />
    <constructor-arg index="(复杂数据类型比如List)参数在构造方法中的位置">
    	<list>
        	<value></value>
        </list>
    </constructor-arg>


</bean>
```



### 三.注解(annotation)

#### 1.实现注解版导包过程

​		在原有的6个jar上导入aop.jar
​		如果需要spring对的junit测试的话还需要导入text.jar
​		而且如果spring版本过高，junit4的版本匹配不了需要junit的版本增高，
​		需要导入junit4.12.jar以及hamcreat.jar

​		

#### 2.以下注解标记所属实体类中对应属性中

​	@Component：用于描述Spring中的bean，创建对象，可以作用在不同层次

​	@Resource：依赖注入给属性赋值----到Spring工厂中拿取匹配的对象赋值给类中指定的属性赋值
​	@Resource(name="对象的id值")
​	@Resource---自动匹配，默认按照bean的实例名称进行匹配
​	@Autowride---用于对bean的属性，setter方法，构造方法进行标注，配合相应的注解处理器完成相应的bean自动配置，默认按照bean的类型进行装配
​	@Value("常量值")-----用于标注进本数据类型的属性字段

​	在这三个分层的对应接口的实现类中使用不同的注解，代表从工厂中创建指定名称的对象

​	@Service(value="")--------service层

​	@Controller(value="")-----controller层

```xml
@Controller
@Controller("id值")
@Controller(value="id值")
```
​	@Repository(value="")----dao层，用于将数据访问层的类标识为Spring中的bean

#### 3.使用junit4写测试方法

在测试的方法的所属类上写入如下注解:

`@RunWith(SpringJunit4ClassRunner.c1lass)`

`@ContextConfiguration("classpath:"核心文件路径")`

`@Autowired`修饰引入所要调用到的对象(值的注入)

在使用注解形式需要在配置文件中，扫描注解

```xml
<context:component-scan base-package="bean所在的包路径(包中所有注解都会扫描，进行注解解析)"/>
```



### 四. AOP(面向切面编程)

#### 	1.概念与思想

​		在不改变源码的情况下增强方法的功能，采取横向抽取机制，将分散在各个方法中的重复代码提取出来，然后在程序编译与运行时，再将这些提取出来的代码应用到需要执行的地方，而OOP只能继承，只能实现父子关系纵向重用。目前流行的AOP框架是AspectJ，AspectJ扩展了java语言，提供一个专门的编译器，在编译时提供横向代码织入。

#### 	2.实现的方式

​			通过动态代理实现		

##### 		1.JDK的动态代理	

​			必须是面向接口的，只有实现具体的接口的类才能生成代理对象

##### 		2.CGLIB的动态代理

​			对于没有实现接口的类，通过产生这个类的子类实现动态代理  (了解)

#### 	3.AOP术语

​		1.AspectJ(切面)：切面通常指封装在用于横向插入系统功能(包含事务管理，日志记录的功能)的类

​		2.Joinpoint(连接点)：在程序执行的某个阶段点，它实际上是对象的一个操作，即方法的调用

​		3.Pointcut(切入点)：是指切面与程序流程的交叉点，即需要处理的连接点

​		4.Advice(通知)：AOP框架在特定的切入点执行的增强处理，即在定义好的切入点执行增强处理，是切面的具体实现

​		5.Target Object(目标对象)：是指所有被通知的对象，也称被增强的对象（被代理的对象）、

​		6.Weaving(织入)：将切面代码插入到目标对象上，从而生成代理对象的过程



### 五.  AspectJ开发

#### 		1.基于XML的声明式的AspectJ

​		在配置文件中的形式：	

```xml
<!--bena的依赖注入使用了注解方式，需要扫描注解-->
<context:component-scan base-package="bean所在的包路径" />
<!--实例一个切面类对象-->
<bean id="切面类对象" class="切面类的全路径"></bean>
<!--根元素-->
<aop:config>
    <!--配置切面-->
	<aop:aspect  ref="引用所实例化的切面类对象，对应bena中的id">
        <!--
<aop:before methdo="conn" pointcut="execution(public void edu.csuft.Bruno.service.UserServiceImpl.sayHello())"></aop:before>
-->
        <!--前置通知-->
        <!--解释：在切入点(所要执行的方法之前,执行method属性中的方法)-->
		<aop:before method="方法名" pointcut="execution(访问修饰符 方法返回类型 方法全路径 方法参数)">
		</aop:before>
		
        <!--最终通知-->
        <!--解释：在切入点(所要执行的方法之后,执行method属性中的方法)-->
		<aop:after method="方法名" pointcut="execution()">
		</aop:after>
		
        <!--环绕通知-->
        <!--解释：在切入点(所要执行的方法前与后,执行method属性中的方法)-->
        <!--method中方法要特殊实现-->
		<aop:around method="方法名" pointcut="execution()">
		</aop:around>
		
	</aop:aspect>
</aop:config>
```



#### 		2.基于注解(annotation)的声明形式

​			@AspectJ : 用于定义一个切面

​			@Before("execution()") : 用于定义前置通知

​			@After("execution()") : 用于定义最终通知

​			@Around("execution()"):用于定义环绕通知



​			



​		



