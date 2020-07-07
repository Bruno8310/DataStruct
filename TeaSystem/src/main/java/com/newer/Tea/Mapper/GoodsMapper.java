package com.newer.Tea.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.newer.Tea.pojo.Goods;

@Mapper
public interface GoodsMapper {
	
	@Select("select * from goods where classify = #{classify}")
	List<Goods> findGoods(String classify);

	@Insert("insert into goods(picture) values(#{picture}) ")
	void updateGoods(Goods goods);

}
