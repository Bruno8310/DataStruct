package edu.csuft.Bruno.stack;

/**
 * 队列的抽象定义---- (FIFO)
 * 
 * @author Bruno
 *
 * @param <T>
 */
public interface AdtQueue<T> {

	// 操作

	/**
	 * 判断是否为空
	 * 
	 * @return
	 */
	boolean isEmpty();

	/**
	 * 大小
	 * 
	 * @return
	 */
	int size();

	/**
	 * 清空
	 */
	void clear();

	/**
	 * 添加(offer()/push())
	 * 
	 * @param t
	 */
	void add(T t);

	/**
	 * 删除并取队列头(remove())
	 * 
	 * @return
	 */
	T poll();

	/**
	 * 取队列头(element())
	 * 
	 * @return
	 */
	T peek();

}
