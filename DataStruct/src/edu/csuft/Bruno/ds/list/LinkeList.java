package edu.csuft.Bruno.ds.list;


public class LinkeList<T> implements AdtList<T> {

	// 数据
	int size = 0;
	// 链表的头
	Node<T> head = new Node<>();
	// 链表的尾
	Node<T> tail = new Node<>();

	public LinkeList() {
		// 头尾相连
		head.nextNode = tail;
		tail.preNode = head;
		
		// 默认
		head.preNode = null;
		tail.nextNode = null;
	}

	// 操作
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		size = 0;
		head.nextNode = tail;
		tail.preNode = head;
	}

	@Override
	public int size() {
		return size;
	}
	
	//h,2,3,4,5,t
	@Override
	public void add(int index, T t) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException(""+index);
		}
		//获得索引位置的节点
		Node item = item(index);
		Node e = new Node();
		e.data = t;
		//插入元素的前驱 后继
		e.preNode = item.preNode;
		e.nextNode = item;
		
		//新节点的前驱 后继
		item.preNode.nextNode = e;
		item.preNode = e;
		size++;
		
	}
	
	//通过索引找到对应节点
	public Node item(int index) {
		Node item;
		//分情况，优化
		/*if (index > size/2) {
			//从后往前找
			item = tail.preNode;
			for (int i = size -1; i > index; i--) {
				item = tail.preNode;
			}
			
		} else {
			//从头往后找
			item = head.nextNode;//索引为0
			for (int i = 1; i < index; i++) {
				item = item.nextNode;
			}
		}*/
		
		//从头往后找
		item = head.nextNode;//索引为0
		for (int i = 1; i <= index; i++) {
			item = item.nextNode;
		}
		return item;
	}

	@Override
	public void add(T t) {
		// 创建下一个节点
		Node<T> node = new Node<>();
		node.data = t;
		//尾节点的前驱
		node.nextNode = tail;
		node.preNode = tail.preNode;
		
		//Node<T> node = new Node<>(t, tail.preNode, tail)
		
		//前驱 后继指向 节点
		tail.preNode.nextNode = node;
		tail.preNode = node;
		size++;
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index > size) {
			return null;
		} 
		//取到指定索引的节点
		Node e = item(index);
		//跳过自身
		e.nextNode.preNode = e.preNode;
		e.preNode.nextNode = e.nextNode;
		size--;
		
		
		return (T) e.data;
	}

	@Override
	public T remove() {
		if (size == 0) {			
			return null;
		}
		//存在节点
		Node item = tail.preNode;
		//删除
		//h,1,2,3,4,5,t
		item.preNode.nextNode = tail;
		tail.preNode = item.preNode;
		size--;
		
		return (T) item.data;
	}

}
