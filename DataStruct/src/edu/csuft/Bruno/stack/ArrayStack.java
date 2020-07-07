package edu.csuft.Bruno.stack;
/**
 * 基于数组的栈的操作实现
 * @author Bruno
 *
 * @param <T>
 */


public class ArrayStack<T> implements AdtStack<T> {
	
	//数据
	
	Object[] data;
	//标明栈的位置
	int top;
	
	public ArrayStack() {
		//初始容量为10
		data = new Object[10];
		top = -1;
	}
	
	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public int size() {
		return top+1;
	}

	@Override
	public void push(T t) {
		increment();
		data[++top] = t;
	}
	
	

	private void increment() {
		if (top == data.length - 1) {
			Object[] temp = new Object[top + (top >> 1)];
			for (int i = 0; i < top ; i++) {
				temp[i] = data[i];
			}
			data = temp;
		}
	}

	@Override
	public T pop() {
		return (T) data[top--];
	}

	@Override
	public T peek() {
		if (top == -1) {
			return null;
		}
		return (T) data[top];
	}

	@Override
	public void clear() {
		top = -1;
	}



	
	

}
