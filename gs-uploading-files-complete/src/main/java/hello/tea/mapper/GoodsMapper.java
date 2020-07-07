package hello.tea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import hello.tea.pojo.Goods;


@Mapper
public interface GoodsMapper {
	
	@Select("select * from goods where classify = #{classify}")
	List<Goods> findGoods(String classify);

	@Insert("insert into goods(goodsName,others,size,suger,temp,price,category,classify,quantity,picture) values(#{goodsName},#{others},#{size},#{suger},#{temp},#{price},#{category},#{classify},#{quantity},#{picture}) ")
	void insertgoods(Goods goods);

}
