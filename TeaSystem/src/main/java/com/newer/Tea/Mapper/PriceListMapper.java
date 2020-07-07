package com.newer.Tea.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.newer.Tea.pojo.PriceList;

@Mapper
public interface PriceListMapper {
	
	@Select("select * from pricelist")
	List<PriceList> findPriceList();

}
