package hello.tea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import hello.tea.pojo.PriceList;


@Mapper
public interface PriceListMapper {
	
	@Select("select * from priceList")
	List<PriceList> findPriceList();

}
