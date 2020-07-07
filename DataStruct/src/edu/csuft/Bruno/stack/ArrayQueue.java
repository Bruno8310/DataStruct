package edu.csuft.Bruno.stack;
/**
 * 基于数组实现队列
 * @author Bruno
 *
 */
public class ArrayQueue<T> implements AdtQueue<T> {

	//数据
	
	Object[] data;
	//定义头指针的索引
	int head;
	//尾指针的索引
	int tail;
	
	//队列元素个数[可选] tail - head
	int size;
	
	public ArrayQueue() {
		data = new Object[10];
		head = 0;
		tail = -1;
		size = 0;
	}
	
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		//回到初始状态
		head = 0;
		tail = -1;
		size = 0;
	}

	@Override
	public void add(T t) {
		data[++tail] = t;
		size++;
	}

	@Override
	public T poll() {
		if (size > 0) {	
			size--;
			return (T) data[head++];
		}
		return null;
	}
	
	
	@Override
	public T peek() {
		if (size > 0) {
			return (T) data[head];
		}
		return null;
	}

	
	
}
