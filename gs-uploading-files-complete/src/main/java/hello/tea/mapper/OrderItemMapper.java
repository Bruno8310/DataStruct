package hello.tea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import hello.tea.pojo.OrderItem;


@Mapper
public interface OrderItemMapper {
	
		// 查
		@Select("select o.orderId,itemId,goodsNum,others,size,suger,"
				+ "temp,goodsId,goodsName,itemPrice "
				+ "from orders as o inner join orderItems as oi on o.orderId=oi.orderId and o.orderId=#{orderId};")
		List<OrderItem> findOrderItems(int orderId);
		
		// 增
		@Insert("insert into orderItems(goodsNum,others,size,suger,temp,goodsId,goodsName,itemPrice,orderId)"
				+ "select number,others,size,suger,temp,goodsId,goodsName,price,Id from "
				+ "(select * from shoppingCartItem where phone=#{phone}) as a, "
				+ "(select orderId Id,phone phone2 from orders where phone=#{phone}) as b "
				+ "where a.phone=b.phone2;")
		void save(String phone);

}
