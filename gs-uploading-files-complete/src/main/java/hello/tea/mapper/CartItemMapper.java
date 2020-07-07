package hello.tea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import hello.tea.pojo.ShoppingCartItem;



@Mapper
public interface CartItemMapper {

	// 查
	@Select("select * from shoppingCartItem where phone=#{phone}")
	List<ShoppingCartItem> findCartItem(String phone);
	
	// 增
	@Insert("insert into shoppingCartItem(phone,others,goodsId,goodsName,size,suger,temp,number,price) "
			+ "values(#{phone},#{others},#{goodsId},#{goodsName},#{size},#{suger},#{temp},#{number},#{price})")
	void save(ShoppingCartItem shoppingCartItem);

	// 改	
	@Update("update shoppingCartItem set number=#{number}, price=#{price} where cartItemId=#{cartItemId}")
	void update(ShoppingCartItem shoppingCartItem);
	
	// 删
	@Delete("delete from shoppingCartItem where cartItemId=#{cartItemId}")
	void delete(int cartItemId);
	
	// 通过电话号删
	@Delete("delete from shoppingCartItem where phone=#{phone}")
	void deleteByPhone(String phone);

}
