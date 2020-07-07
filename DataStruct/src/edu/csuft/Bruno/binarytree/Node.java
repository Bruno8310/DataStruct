package edu.csuft.Bruno.binarytree;
/**
 * 二叉搜索树节点定义
 * @author Bruno
 *
 */
public class Node {
	
	/**
	 * 节点数据
	 */
	Integer data;
	
	/**
	 * 左孩子节点
	 */
	Node leftNode;
	
	/**
	 * 右孩子节点
	 */
	Node rightNode;
	
	/**
	 * 节点的父节点
	 */
	Node parentNode;
	
	public Node() {
		
	}
	
	public Node(Integer data, Node leftNode, Node righrNode, Node parentNode) {
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = righrNode;
		this.parentNode = parentNode;
	}
	
}
