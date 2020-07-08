## @datetime: 2019.07.21 pm

### 一.   java中的UUID包：随机生成字符串

​	UUID(Universally Unique Identifier)通用唯一标识符
​	目的：让分布式系统中的所有元素，都有唯一的辨别资讯，
​	不需要透过中央控制端来做辨识资讯的指定

```java
public static void main(String[] args) {
	for(int i = 0; i<10; i++) {
		String uuid = UUID.randomUUID().toString().replaceAll('-','');
	}
	
}
```



### 二.  mybatis中的缓存机制

1. 一级缓存(不需要手动设置)：
   			SqlSession对象的缓存，同一个SqlSession对象多次执行同一个查询操作
      			同一个SqlSession对象进行两次查询(输入参数类型映射[parameterType]与输出结果类型映射[resultType])，
      			第二次查询[输入参数和输出映射相同]会调用缓存中的数据
      			clearCache()方法只清除缓存中的数据,不会关闭缓存对象
      			close()方法关闭SqlSession对象，会回收缓存对象，缓存对象存活时间较短需及时关闭
      			对同一个SQLSession对象在查询操作基础上，执行增删改后，缓存对象会销毁

2. 二级缓存(需要进行配置):
   		二级缓存叫SqlSessionFactory级别的缓存
      		设置二级缓存的使用属性,在sql的配置文件中
      					eviction:设置缓存的回收机制FIFO算法
      					flushInterval:设置刷新时间间隔

   ​		在需要进行二级缓存sql语句上加上使用缓存


   在核心配置文件：

   ```xml
   <settings>
   	<setting name="cacheEnabled" value="true"/>
   </settings>
   ```

   在sql文件中配置
   <!--设置缓存的性能 eviction：回收机制 FIFO：先进先出 flushInterval：多长时间刷新一次 -->
   	

   ```xml
   <cache eviction="FIFO" flushInterval="100000" size="100"
   		readOnly="true"></cache>
   ```

   在某一条sql语句上使用缓存

   ```xml
   <select id="selectAllUser" resultType="user" useCache="true">
   	select * from user
   </select>
   ```

   也就是不同的sqlSession可以共用同一个缓存
   2个SqlSession进行查询，第一个执行sql语句的查询，第二个直接拿缓存中数据 

   ​	

   

   ```java
   <!-- 根据主键查询 -->
   <select id="selectUserById" parameterType="string" resultType="user">
   	select * from user where uid = #{uid}
   </select>
   
   <!-- 查询所有，返回的是一个集合  resultType:泛型的类型-->
   <select id="selectAllUser" resultType="user">
   	select * from user
   </select>
   
   <!--查询所有的女生  -->
   <select id="selectUserBySex" parameterType="string" resultType="user">
   	select * from user where sex = #{sex}	
   </select>
   ```

  

```xml
<!-- 根据主键删除 -->
<delete id="deleteUser" parameterType="string">
	delete from user where uid = #{uid}
</delete>

<!--修改  -->
<update id="updateUser" parameterType="user">
   update user set username = #{username},name=#{name},password=#{password},sex=#{sex},telephone=#{telephone},
   birthday = #{birthday} where uid = #{uid}
</update>

<!--添加  -->
<insert id="insertUser" parameterType="user">
	<!-- 生成主键   如果主键是字符串必须先查主键再进行添加语句，但是如果是整型且设置自动增长，
	是先执行添加语句，后查主键
	keyProperty：执行操作(insert或update)返回结果的这个值给哪一个属性
	keyColumn:把表中哪一个字段(哪一列)当做主键		
	Oracle数据库没有uuid这个函数，不能这样子操作，数据库本身不支持主键自动增长		
	select max(uid)+1 from user:查询id最大值然后加1	
	-->
	<selectKey resultType="string" order="BEFORE" keyProperty="uid" >
		select REPLACE(UUID(),'-','')
	</selectKey>
	<!-- 先设置主键，然后进行插入操作，将执行的select REPLACE(UUID(),'-','')结果赋值给数据库uid字段,目的是设置主键唯一标识-->
	insert into user(uid,username,password,name,sex,birthday,telephone) values 
	(#{uid},#{username},#{password},#{name},#{sex},#{birthday},#{telephone})
</insert>

<!-- ${}:用来拼接，只有模糊查询 ，${value} 不进行数据类型转换  单个数据就只能用value-->
<select id="selectUserLike" parameterType="string" resultType="user">
	<!--  select * from user where name like  '%${value}%'  -->
	<!--  select * from user where name like #{value}  -->
	select * from user where name like concat('%',#{name},'%') 
</select>

<!-- 查询user表的总个数-->
<select id="selectUserCount" resultType="int">
	select count(*) from user
</select>
```

### 三.  为什么mybatis替代了jdbc？

​	1.mybatis的优点

​	  	mybatis简化了jdbc的代码。mybatis侧重在sql语句，我们不需要对sql语句
​	  的？进行赋值，也不需要处理结果集，由mybatis底层来进行了输入封装(输入参数映射)和输出封装(输出参数映射)
​	  

​	  为什么由hibernate替代了jdbc，然后又由mybatis替代了hibernate

```java
jdbc----------------hibernate----------------mybatis
```

​	2.jdbc的缺点

​	jdbc：需要手动连接数据库，预编译sql语句，然后进行？赋值，以及处理结果集，代码量多

​	3.Hibernate缺点

​	Hibernate：orm框架:对象关系映射  
​	o：object
​	r:relational
​	m:mapping

​	Hibernate不需要写sql语句，通过操作实体和属性自动生成sql语句，需要进行表和实体的配置，把表和实体进行关联
​	把表的字段和实体的属性进行关联，不再操作表和字段，通过操作对象和属性来操作表和字段。

​	sql:数据库结构查询语句，操作的是表和字段

​	hql:Hibernate的查询语句，操作的是实体与属性

​	SqlSessionFactory：是一个工厂，用于创建sqlSession的，所以我们的Factory要用单例模式设计
​	整个项目中就一个		



mybatis持久层框架引入项目步骤：
1.导入jar
2.导入核心配置文件(mybatis-config.xml)和日志文件(log4j.properties)
3.配置sql映射文件
		dao层接口和sql文件最好在同一个包下
		dao层接口名最好和sql文件同名
		sql文件的namespace是接口的全路径
		sql文件中id名和接口中方法名一致
		sql文件的parameterType和方法的参数一致
		sql文件的resultType和方法的返回值一致
		
4.创建service层
		SqlSession session = MyBatisUtil.getSession();
		//获取接口的动态代理实现类对象  
		UserDao ud = session.getMapper(UserDao.class);
		List<User> list = ud.selectAllUser();
		session.close();
		System.out.println(list);		
		

```java
	文件的路径：   D:/img/a.jpg---------用来找到这个文件
	类的全路径	:   包名+类名   com.newer.entity.User------反射创建对象		
```

### 四.  参数个数与resultMap

​	1.多个参数的情况

​		需要对参数取别名

​		User login(@Param("username")String username,@Param("password")String password);		

```xml
<select id="login" resultType="user">
	select * from user where username = #{username} and password = #{password}
</select
```

​	2.实体属性和表的字段名不一致的情况
​	

```xml
<resultMap type="book" id="bookMap">
		<!-- 主键  column：字段   property:属性-->
		<id column="book_id" property="bid" />
		<!-- 其余字段 -->
		<result column="book_name" property="bname"/>
</resultMap>
```

​	

```xml
<!-- 如果查询的结果使用的是resultMap的配对那么就不适用resultType要使用resultMap -->
<select id="selectAllBook" resultMap="bookMap">
	select * from book
</select>					
		
<!-- 当字段名和属性名不一致的时候，赋值使用的是属性名 -->
<insert id="insertBook" parameterType="book">
	insert into book(book_name) values(#{bname})
</insert>
```

3.foreach使用：

常用于select查询in语句中

```java
//测试类的方法中创建一个集合，添加元素
List<String> usernames = new ArrayList<>()
usernames.add('names1')
usernames.add('names2')
usernames.add('names3')
usernames.add('names4')
```

//接口中定义查询方法
//当查询方法中参数是一个集合时，需要给集合对象取别名，foreach中collection属性使用别名作为属性值
List<String> selectAllUser(@Param('usernames')List<String> usernames);

//从userinfo数据表中遍历查询
select * from userinfo where name in ('name1', 'name2', 'name3', 'name4')

```xml
<select id="selectAllUser" resultType="user">
select * from userinfo
<where>
<foreach collection="usernames" open="name in (" close=")" separator="," item="name">
	#{name}
</foreach>
<where>
</select>
```

collection参数：要进行遍历的集合，用到了传入参数的别名作为循环的集合，在select标签中不需要设置parameterType值
open参数：从sql语句何处开始
close参数：到sql语句何处结束
separator参数：分隔符
item参数：循环取出的数据取名字


​	mybatis.xml核心配置文件中，需要加载接口
​	

```xml
<mappers>
	<mapper package="接口所在的全路径，扫描包中所有"/>
</mappers>
```

​	在CRUD方法声明上使用注解(annonation)	
​		

```java
	@Select("select 语句")

	@Insert("insert 语句")
	
	@Delete("delete 语句")
	
	@Update("update 语句")

	@SelectKey(before=true, keyProperty="", resultType=String.class, statement="select replaceAll(uuid(),'-','')")

	@Results(id="", value={
			@Result(),
			@Result(),
			@Result(),
	})
```

​			



### 五. Mybatis的工作原理

#### 	1.读取Mybatis的核心配置文件

​		核心配置文件作为Mybatis的全局配置文件，配置了运行环境与数据库连接的信息，并且加载映射文件

#### 	2.加载映射文件

​		SQL映射文件配置了操作数据库的的SQL语句，需要在核心配置文件中加载才能运行，每个配置文件对应数据库中的一张数据表

#### 	3.构造会话工厂(SqlSessionFactory)

​		SqlSessionFactory对象的实例可以通过SqlSessionFactoryBuilder对象构建，是线程安全的，一旦创建在整个执行期间都存在，采用单例设计模式。

#### 	4.构造会话对象(SqlSession)

​		SqlSession对象是应用程序与持久层之间执行操作的一个单线程对象，执行持久化操作，由于底层封装JDBC的连接，通过实例直接来执行已映射的SQL语句。每个线程都有一个SqlSession实例，该实例是不能被共享的，线程不安全，其使用范围最好在一次请求或一个方法中，不能放在静态块中，并且及时关闭。

#### 	5.Executor执行器

​		Mybatis底层中定义了一个Executor接口来操作数据库，根据传入的参数动态生成需要执行的SQL语句，同时负责查询缓存的维护。

#### 	6.MappedStatement对象

​		在Executor接口的执行方法中，包含一个MappedStatement类型的参数，该参数是对映射信息的封装，用于存储要映射的SQL语句的id，参数等。

#### 	7.输入参数映射

​		MappedStatement对象在执行SQL前，将输入的java对象映射到SQL语句中，类似于JDBC编程中对preparedStatement对象设置参数的过程。

#### 	8.输出参数映射

​		MappedStatement对象在执行SQL语句后，将输出结果映射到java对象中，类似于JDBC编程中对结果的解析处理过程。