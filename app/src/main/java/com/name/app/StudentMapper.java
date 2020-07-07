package com.name.app;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
/**
   数据访问----- @Repository
 * 
 * @author Bruno
 *
 */
@Mapper
public interface StudentMapper {

	@Insert("insert into students(name, phone) values(#{name},#{phone})")
	void save(Student s);

	@Select("select * from students")
	List<Student> findAll();

	@Delete("delete from students where id = #{id}")
	void remove(int id);
}
