package edu.csuft.Bruno.stack;
/**
 * 自定义栈的操作----(只在一端进行操作)---LIFO
 * @author Bruno
 *
 * @param <T>
 */

import java.util.Stack;

public interface AdtStack<T> {

	Stack<String> stack = new Stack<>();
	//操作
	/***
	 * 判断是否为空
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 * 栈的大小
	 * @return
	 */
	int size();
	
	/**
	 * 清空栈
	 */
	void clear();
	
	
	/**
	 * 入栈
	 * @param t
	 */
	void push(T t);
	
	/**
	 * 出栈
	 * @return
	 */
	T pop();
	
	/**
	 * 获得栈顶元素
	 * @return
	 */
	T peek();
	

	
	
	
	
}
