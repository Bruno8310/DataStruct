package edu.csuft.Bruno.world.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


import edu.csuft.Bruno.world.pojo.Dept;
import edu.csuft.Bruno.world.pojo.Staff;

@Mapper
public interface DeptMapper {
	
	/**
	 * 插入一条记录，返回状态(而非新的主键值，要获得主键值需要调用对象的getId()方法)
	 * 使用useGeneratedKeys赋值为keyProperty标记为id
	 * @param dept 一条记录对应一个实体对象
	 * @return 返回的是insert操作的状态
	 */
	@Options(useGeneratedKeys = true, keyProperty = "id")
	@Insert("insert into dept(name, loc) values(#{name}, #{city})")
	int save(Dept dept);
	

	@Select("select * from dept where id = #{pk}")
	@Results({
		@Result(column = "loc", property = "city"),
		@Result(column = "id", property = "staffList", javaType = List.class, many = @Many(select = "findStaffByDeptId"))
	})
	Dept load(int pk);
	
	
	
	@Select("select * from staff where dept_id = #{id}")
	@Results({
		@Result(column = "phone", property = "tel"),
//		@Result(column = "dept_id", property = "dept", javaType = Dept.class, one=@One(select = "load"))
	})
	List<Staff> findStaffByDeptId(int id);
}
