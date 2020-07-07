package edu.csuft.Bruno.ds.list;

import java.util.Arrays;

public class LineList<T> implements AdtList<T> {
	
	
	//数据
	//数组
	Object[] data;
	
	//数据元素的个数
	int size;
	
	public LineList() {
		//容量
		data = new Object[3];
		//数据元素个数
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void add(int index, T t) {
		increment();
		if (index < size && index >= 0) {
			//逐个往后移
			for (int i = size - 1; i >= index; i--) {
				data[i + 1] = data[i];
			}
			//将要添加的元素放入指定位置
			data[index] = t;
			size++;
		} else {
			//无效
		}
	}

	//时间复杂度--O(c)
	@Override
	public void add(T t) {
		//扩容
		increment();
		//存储		
		data[size++] = t;
		
	}
	
	//时间复杂度--O(n)
	//私有
	private void increment() {
		if (size == data.length) {
			//数组是不可变，扩容就是创建一个新的数组
			Object[] temp = new Object[size + 3];
			for(int i = 0; i < size; i++) {
				temp[i] = data[i];
			}
			//新数组替换原数组
			data = temp;
			System.out.println("扩容为：" + data.length);
		}
	}

	@Override
	public T remove(int index) {
		if (index < size && index >= 0) {
			T t = (T) data[index];
			//先让size减一，最后一个元素就不存在越界
			size--;
			for (int i = index; i < size; i++) {
				data[i] = data[i + 1];
			}
			return t;
		}
		return null;
	}

	@Override
	public T remove() {
		if (size > 0 ) {
//			T t = (T) data[size - 1];
//			size--;
			return (T) data[--size];
		}
		return null;
		// return size > 0 ?(T) data[--size]:null; 
	}

	@Override
	public String toString() {
		return "LineList [data=" + Arrays.toString(data) + "]";
	}

	

	

}
