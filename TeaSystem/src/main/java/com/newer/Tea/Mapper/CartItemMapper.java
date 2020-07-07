package com.newer.Tea.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.newer.Tea.pojo.ShoppingCartItem;

@Mapper
public interface CartItemMapper {

	// 查
	@Select("select * from shoppingcartitem where phone=#{phone}")
	List<ShoppingCartItem> findCartItem(String phone);
	
	// 增
	@Insert("insert into shoppingcartitem(phone,others,goodsId,goodsName,size,suger,temp,number,price) "
			+ "values(#{phone},#{others},#{goodsId},#{goodsName},#{size},#{suger},#{temp},#{number},#{price})")
	void save(ShoppingCartItem shoppingCartItem);

	// 改	
	@Update("update shoppingcartitem set number=#{number}, price=#{price} where cartItemId=#{cartItemId}")
	void update(ShoppingCartItem shoppingCartItem);
	
	// 删
	@Delete("delete from shoppingcartitem where cartItemId=#{cartItemId}")
	void delete(int cartItemId);
	
	// 通过电话号删
	@Delete("delete from shoppingcartitem where phone=#{phone}")
	void deleteByPhone(String phone);

}
