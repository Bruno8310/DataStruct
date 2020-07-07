package edu.csuft.Bruno.tree;

/**
 * 普通的树的节点定义
 * 普通的树可以转换成二叉树
 * @author Bruno
 *
 */
public class Node<T> {

	/**
	 * 数据
	 */
	T data;
	
	/**
	 * 相邻的一个兄弟
	 */
	Node<T> nextSibling;
	
	/**
	 * 第一个子节点
	 */
	Node<T> firstChild;
	
	public Node() {
		
	}
	
}
