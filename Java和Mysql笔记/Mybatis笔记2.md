## @datetime: 2019.07.22 pm

### 一. Mybatis  逆向工程

​	Mybatis Generator可以快速根据表生成对应的接口以及pojo类，只限于单表操作，不用于多表连接查询操作

​	

### 二.Mybatis  注解

​	sql语句不再写到映射文件中，直接写在接口中对应方法上，同一种操作只能对一种写法，不同操作之间的映射既可以用配置文件也可以用注解，混用。

```java
public interface UserMapper {
    @Select("select * from userinfo")
    List<User> selectAllUser();
    
    @Select("select * from userinfo where id = #{id}")
    User selectUserById(int id);
    
    @Select("select * from userinfo where username = #{username}, password = #{password}")
    User login(@Param("username")String username, @Param("password")String password);
    
    @Select("select * from userinfo where name like concat('%',#{name},''%)")
    List<User> selectByLike(String name);
    
    @Delete("delete from userinfo where id = #{id}")
    int deleteById(int id);
    @Update("update userinfo set name = #{name}, sex = #{sex}, birthday = #{birthday}")
    int updateUser(User user);
    
    //主键设置为字符串
    @SelectKey(before = true, KeyProperty = "执行后返回结果哪个属性" , KeyColumn="数据表中哪个列字段", resultType=String.class, statement="select replace(uuid(), '-','')")
    //@Options(useGenerate = true) 如果主键使用自动增长，使用这条注解
    @Insert("insert into userinfo(name, sex, birthday) values('#{name}','#{sex}','#{birthday}')")
    int insertUser(User user);    
    
    //属性与字段不匹配,先进行映射匹配
    @Results(id="userMapper", value={ @Result(column="user_id", property="id" id=true),
                          	@Result(column="user_name", property="name"),
                           	@Result(column="user_sex", property="sex"),
                           	@Result(column="user_birthday", property="birthday")
    })
    //然后再在需要的操作上使用
    @ResultMap("userMapper")
    @Select("select * from userinfo where id = #{id}")
    User selectById(int id);
    
    
    
}
```





### 三.Spring  一站式开发

​	IOC(控制反转):把创建对象的权利交给Spring容器

​		通过XML配置文件，在配置文件中配置类的全路径，Spring底层通过获取全路径在运行时反射创建对象，创建对象后放入工厂中，需要对象时就到工厂中获取这个对象-------实现解耦合

​	AOP(面向切面):动态代理，主要操作事务，日志

​	完成一个项目可以只用Spring一个框架，Spring提供了SpringMVC(控制层)，Spring(服务层)，Spring提供自己本身的jdbc(DAO层)，还提供了Junit4测试模块。

SSH: <u>Spring Struts2  Hibernate</u>

SSM: <u>Spring  SpringMVC Mybatis</u>

### 四. DAO层  、Service层、Controller层、View层

#### 	1.DAO层

​		DAO层主要做数据持久层工作，负责与数据库进行交互的功能(CRUD)都封装在此。DAO层设计首先是设计DAO接口，然后在Spring的配置文件中定义此接口的实现类，然后就可在模块中调用此接口来进行数据业务的处理，而不用关心此接口的具体实现类是哪一个类。DAO层的数据源配置，以及有关数据库连接参数等都可在Spring配置文件中进行配置。

#### 	2.Service层

​		Service层主要负责业务模块的逻辑应用设计，首先设计接口，再设计其实现类，接着在Spring的配置文件中配置其实现的关联。Service层业务实现，具体要调用到已定义的DAO层的接口，封装Service层的业务逻辑利于代码的简洁性。既调用DAO层的接口，又要提供接口给Controller层的类来调用，处于一个中间层位置，每个接口封装各自业务处理的方法。

#### 	3.Controller层

​		Controller层负责具体的业务模块流程，在此层里面要调用Service层的接口来控制业务流程，控制的配置也同样是在Spring的配置文件里面进行，针对具体的业务流程，会有不同的控制器。	

#### 	4.View层		

​		View层与控制层结合比较紧密，需要二者结合协同工作，View层主要负责网页前台的jsp页面表示。