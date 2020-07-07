package edu.csuft.Bruno.stack;
/**
 * 基于链表实现队列
 * 约瑟夫环问题
 * @author Bruno
 *
 */


public class LinkeQueue<T> implements AdtQueue<T> {
	
	//头
	Node<T> head;
	//尾
	Node<T> tail;
	//大小
	int size;
	
	public  LinkeQueue() {
		head = new Node<>();
		tail = new Node<>();
		//初始化 首尾相连
		head.nextNode = tail;
		tail.preNode = head;
		
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
		size = 0;
		head.nextNode = tail;
		tail.preNode = head;
	}

	@Override
	public void add(T t) {
		Node<T> e = new Node<>();
		e.data = t;
		e.nextNode = tail;
		e.preNode = tail.preNode;
		
		tail.preNode = e;
		tail.preNode.nextNode = e;
		
		size++;
	}

	@Override
	public T poll() {
		if (size > 0) {
			//获得队首节点
			Node e = head.nextNode;
			//删除队首节点
			e.nextNode.preNode = e.preNode;	
			head.nextNode = e.nextNode;
			
			size--;
			//返回队首节点的数据
			return (T) e.data;
		}
		return null;
	}

	@Override
	public T peek() {
		if (size > 0) {
			Node e = head.nextNode;
			return (T) e.data;
		}
		return null;
	}
	
	
	/**
	 * 打印方式1
	 */
	public void print() {
		Node currentNode = head.nextNode;
		while(currentNode != null) {
			System.out.print(currentNode.data+",");
			currentNode = currentNode.nextNode;
		}
	}
	
	
	/**
	 * 打印方式2
	 * @param index
	 * @return
	 */
	public Node item(int index) {		
		Node e = tail.preNode;
		for (int i = 1; i <= index; i++) {
			e = e.preNode;
		}
		return e;
	}

}
