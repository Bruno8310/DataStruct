package edu.csuft.Bruno.world;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

	/**
	 * 获得总记录数
	 * 
	 * @return
	 */
	@Select("select count(id) from city")
	int count();
	
	/**
	 * 获得城市的信息
	 * 
	 * @param size 数据数
	 * @param start 起始位置
	 * @return
	 */
	@Select("select * from city limit #{n} offset #{s}")
	List<City> list(@Param("n") int size, @Param("s") int start);

	@Select("select * from city where id = #{id}")
	City load(int id);
}
