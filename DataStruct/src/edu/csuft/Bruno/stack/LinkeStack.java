package edu.csuft.Bruno.stack;
/**
 * 基于链表实现栈的操作
 * @author Bruno
 *
 * @param <T>
 */
public class LinkeStack<T> implements AdtStack<T> {

	//数据
	int size;
	
	//头
	Node<T> head;
	//尾
	Node<T> tail;
	
	public LinkeStack() {
		size = 0;
		head = new Node<>();
		tail = new Node<>();
		//头尾相连
		head.nextNode = tail;
		tail.preNode = head;
	}
	
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}
	
	/**
	 * 入栈都是在尾部操作
	 */
	@Override
	public void push(T t) {
		Node<T> e = new Node<>();
		e.data = t;
		//新节点的前驱和后继
		e.preNode = tail.preNode;
		e.nextNode = tail;
		//新节点所扮演的角色
		tail.preNode = e;
		tail.preNode.nextNode = e;
		
		size++;
	}

	@Override
	public T pop() {
		if (size == 0) {
			return null;			
		}
		
		//获得栈底元素
		Node e = tail.preNode;
		//删除节点(出栈)
		tail.preNode = e.preNode;
		e.preNode.nextNode = tail;
		
		size--;
		return (T) e.data;
	}

	@Override
	public T peek() {
		if (size == 0) {
			return null;			
		}
		
		//获得栈底元素
		Node e = tail.preNode;
		return (T) e.data;
		//size == 0 ? return null : return (T)tail.preNode.data;
	}

	@Override
	public void clear() {
		size = 0;
		head.nextNode = tail;
		tail.preNode = head;
	}

}
