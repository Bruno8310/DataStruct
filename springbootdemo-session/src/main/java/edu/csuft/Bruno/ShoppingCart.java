package edu.csuft.Bruno;
/**
 * 
 * 购物车
 * 
 * @author Bruno
 *
 */

import java.util.Collection;
import java.util.HashMap;


public class ShoppingCart {
	// 购物车中核心数据
	private HashMap<Integer, Integer> info = new HashMap<>();

	public ShoppingCart() {
	}
	
	/**
	 * 通过商品编号获得数量
	 * 
	 * @param pid
	 * @return
	 */
	public int pidNum(int pid) {
		return info.get(pid);
	}
	
	/**
	 * 获得商品编号的列表
	 * 
	 * @return
	 */
	public Collection<Integer> pidList() {
		return info.keySet();
	}

	// 默认的方法，添加的数量是1
	public void add(int pid) {
		// info.put(pid, 1);
		if (info.containsKey(pid)) {
			// 购物车中已存在
			info.put(pid, info.get(pid) + 1);
		} else {
			// 购物车中不存在
			info.put(pid, 1);
		}
	}

	// 添加的数量是n
	public void add(int pid, int n) {
		info.put(pid, n);
	}

	/**
	 * 商品项的数量
	 * 
	 * @return
	 */
	public int size() {
		// 获得value构成的集合
		Collection<Integer> values = info.values();
		// 获得累加数量
		int sum = 0;
		for (Integer n : values) {
			sum += n;
		}
		return sum;
	}
}
