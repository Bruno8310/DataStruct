package edu.csuft.Bruno;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public class Db {

	private static List<Goods> list = new ArrayList<>();
	
	static {
		list.add(new Goods(1, "可乐", 3));
		list.add(new Goods(2, "咖啡", 8));
		list.add(new Goods(3, "冰红茶", 4));
		list.add(new Goods(4, "雪碧", 7));
	}
	
	/**
	 * 根据商品编号获得商品信息
	 * 
	 * @param pid
	 * @return
	 */
	public static Goods findGoods(int pid) {
		Goods g = null;
		for (Goods goods : list) {
			if (goods.getId() == pid) {
				g = goods;
				break;
			}
		}
		return g;
	}	
	
	/**
	 * 获得商品列表信息
	 * 
	 * @return
	 */
	public static List<Goods> allGoods() {
		return list;
	}
}
