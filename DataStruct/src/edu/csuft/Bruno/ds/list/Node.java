package edu.csuft.Bruno.ds.list;
/**
 * 数据节点(表中一个数据元素)
 * @author Bruno
 *
 */
public class Node<T> {

	//数据
	T data;
	//指向后一个元素
	Node nextNode;
	//指向前一个元素
	Node preNode;
	
	public Node() {
		nextNode = null;
		preNode = null;
	}

	/**
	 * 
	 * @param data 数据
	 * @param nextNode 后继
	 * @param preNode 前驱
	 */
	public Node(T data, Node preNode, Node nextNode) {
		super();
		this.data = data;
		this.preNode = preNode;
		this.nextNode = nextNode;
	}
	
	
}
