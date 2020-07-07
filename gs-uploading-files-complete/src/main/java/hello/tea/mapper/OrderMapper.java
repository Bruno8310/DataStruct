package hello.tea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import hello.tea.pojo.Order;


@Mapper
public interface OrderMapper {
	
	@Select("select * from orders where phone=#{phone}")
	List<Order> findOrder(String phone);
	
	// 增
	@Insert("insert into orders(totalPrice,phone) values(#{totalPrice},#{phone})")
	void save(Order order);

}
