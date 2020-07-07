package edu.csuft.Bruno;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.function.Consumer;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;

import com.zaxxer.hikari.HikariDataSource;

import edu.csuft.Bruno.entity.User;
import edu.csuft.Bruno.mapper.UserMapper;

@SpringBootApplication

//对Mapper注解接口进行扫描
@MapperScan("edu.csuft.Bruno.mapper")
public class SpringbootdemoApplication {

	private static Logger log = LoggerFactory.getLogger(SpringbootdemoApplication.class);

	/*
	 * 加载yml或yaml配置文件
	 */
	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringbootdemoApplication.class);

		ConfigurableApplicationContext context = builder
				// .properties(factoryBean.getObject())
				.bannerMode(Banner.Mode.OFF).run(args);
		// BasicDataSource datasource = context.getBean("dataSource",
		// BasicDataSource.class);
		HikariDataSource datasource = context.getBean("dataSource", HikariDataSource.class);
		SqlSessionTemplate st = context.getBean("sqlSessionTemplate", SqlSessionTemplate.class);
		SqlSessionFactory sf = context.getBean("sqlSessionFactory", SqlSessionFactory.class);
		log.debug("------------------------->" + st.getClass().getCanonicalName());
		log.debug("------------------------->" + sf.getClass().getCanonicalName());
		try {
			log.debug("------------------------->" + datasource.getConnection().getClass().getCanonicalName());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
		List<User> list = userMapper.findAllUsers();
		list.forEach(new Consumer<User>() {

			@Override
			public void accept(User user) {
				log.debug("-------------------------->" + user);
			}
		});

	}

}
