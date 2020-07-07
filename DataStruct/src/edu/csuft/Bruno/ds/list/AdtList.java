package edu.csuft.Bruno.ds.list;

/**
 * java.util.List(已经包含标准库，核心库)
 * 
 * 自定义一套 ADT
 * 
 * @author Bruno 泛型（占位符）
 */
public interface AdtList<T> {

	// 数据

	// 操作

	/**
	 * 判断是否为空
	 * 
	 * @return
	 */
	boolean isEmpty();

	/**
	 * 清空表
	 */
	void clear();

	/**
	 * 获取元素个数
	 * 
	 * @return
	 */
	int size();

	/**
	 * 指定位置添加新元素
	 * 
	 * @param index 位置
	 * @param t     元素
	 */
	void add(int index, T t);

	/**
	 * 在表的末尾添加新元素
	 * 
	 * @param t 新元素
	 */
	void add(T t);
	
	/**
	 * 删除指定位置元素
	 * 
	 * @param index 指定元素
	 * @return 被删除的元素，如果index无效则返回null
	 */
	T remove(int index);
	
	/**
	 * 删除最后一个元素
	 * @return
	 */
	T remove();
}
