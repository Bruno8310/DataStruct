## @datetime: 2019.07.25 pm

### 一 . Spring与Mybatis的基于Mapper 接口(动态代理)整合

#### 			1.首先要导入mybatis-spring-1.3.1.jar的jar包	



#### 			2.基于MapperScannerConfigurer的整合

​			将Mybatis的核心配置文件中的，数据源的配置，数据库连接，对实体类取别名，加载sql映射文件的操作迁移到		Spring的配置文件中。

##### 			1.创建SqlSessionFactory对象

```xml
<bean id="sqlSessionFactory(对象名)" class="org.mybatis.spring.SqlSessionFactoryBean">
	<!--依赖注入数据库连接池的基本信息-->
    <property name="dataSource" ref="dataSource(数据源名)"></property>
    <!--给实体类取别名-->
    <property name="typeAliasesPackage" value="edu.csuft.Bruno.entity(实体类所在全路径)"></property>
    <!--加载SQL映射文件-->
    <!--当映射文件和接口在同一个包下面并且名字一直，可以省略这个配置-->
    <property name="mapperLocations" value="classpath:edu/csuft/Bruno/dao/*.xml"></property>
    <!--加载Mybatis的核心配置文件，当所有的配置迁移到Spring的核心配置文件中，该步配置可以省略-->
    <property name="configLocation" value="classpath:mybatis.xml"></property>
</bean>
```

##### 			2.在创建工厂时，需要依赖注入数据源的配置，配置数据源模块

```xml
<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <property name="driverClassName" value="${jdbc.driver}"></property>
    <property name="url" value="${jdbc.url}"></property>
    <property name="username" value="${jdbc.username}"></property>
    <property name="password" value="${jdbc.password}"></property>
</bean>
```

##### 			3.通过扫描创建动态代理对象，id值为接口名首字母小写

```xml
<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
    <!--依赖注入SqlSessionFactory属性值，创建SqlSession需要工厂-->
    <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"></property>
    <!--为指定路径下的接口，创建代理对象-->
    <property name="basePackage" value="edu.csuft.Bruno.dao"></property>
</bean>
```

##### 			4.通过注解装配Bean，扫描注解

```xml
<!--扫描整个包中的注解-->
<context:component-scan base-package="包路径"></context:component-scan>
```

##### 			5.加载本地的properties文件

```xml
<!--在db.properties文件中设置连接数据库的参数-->

<context:property-placeholder location="classpath:db.properties" />
```



### 二 . 事务(transaction)

#### 	1.定义与概要

​		一个数据库事务包含了一个序列的对数据库的读/写操作，为数据库操作序列提供了一个从失败中恢复正常状态的方法，同时提供了数据库即使是在异常状态下仍能保持一致性的方法。当多个应用程序并发访问数据库时，可以在这些应用程序中提供一个隔离方法，以防止彼此操作互相干扰。





#### 	2.特性

​	原子性(Atomicity)：事务作为一个整体被执行，包含在其中的对数据库的操作，要么全部被执行，要么都不执行，回滚到先前状态。

​	一致性(Consistency) : 事务应确保数据库的状态从一个一致状态转变为另一个状态。

​	隔离性(Isolation) : 多个事务并发执行时，一个事物的执行不应影响其他事物的执行。

​	持久性(Durability) : 已被提交的事务对数据库的修改应该永久的保存在数据库中。

​	事务都是在服务层，表与表之间的关联关系，先删除从表，再删除主表





#### 	3.Spring事务管理

##### 		1.传统的编程式事务管理

​			通过编写代码实现事务管理，包括定义事务的开始，正常执行后的事务提交和异常时的事务回滚

##### 		2.声明式事务管理

​			通过AOP技术实现事务管理，将事务管理作为一个切面代码单独编写，然后通过AOP技术将事务管理的切面代码织入业务目标类中(Service层)，通过在配置文件中或者注解形式进行声明。

##### 		3.基于XML配置文件方式的声明式事务			

```xml
1.在xml配置文件中添加对应的约束

<!--2.配置数据源，依赖注入连接数据库的参数-->
<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <!--数据库驱动-->
    <property name="driverClassName" value="${jdbc.driver}"></property>
    <!--连接数据库的url-->
    <property name="url" value="${jdbc.url}"></property>
    <!--用户名-->
    <property name="username" value="${jdbc.username}"></property>
    <!--密码-->
    <property name="password" value="${jdbc.password}"></property>
</bean>

<!--3.配置JDBC模板(该步骤可省略)-->
<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
	<property name="dataSource" ref="dataSource"></property>
</bean>

<!--4.事务管理器，依赖于数据源-->
<bean id="transaction" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
	<property name="dataSource" ref="dataSource"></property>
</bean>

<!-- 5.编写通知，对事务进行增强，需要编写对切入点和具体执行的事务细节-->
 <tx:advice id="myAdvice" transaction-manage="transactionManageer">
   		<tx:attributes>
   			<tx:method name="testTx" isolation="DEFAULT" propagation="REQUIRED"/>
   		</tx:attributes>
 </tx:advice>

<!--6.编写AOP,让spring自动对目标生成代理，对方法进行增强-->
<aop:config>
		<aop:advisor advice-ref="myAdvice" pointcut="execution(* *..*.UserServiceImpl.*(..))"/>
</aop:config>

<!--使用注解形式，需要注册事务注解驱动-->
<!--
  <tx:annotation-driven transaction-manager="transactionManager />
-->	
```



#### 4.基于注解(annotation)方式的声明式事务

​	1.在Spring容器中注册事务注解驱动	

```xml
<tx:annotation-driven transaction-manager="transactionManager />
```

​	2.在需要使用事务的Spring Bean或者Bean类的方法上添加注解@Transactional，不需要基于xml配置文件中的第5,6步