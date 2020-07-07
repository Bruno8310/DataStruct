package edu.csuft.Bruno.binarytree.rb;

public class NodeRB {

	private static final boolean BLACK = true;
	
	private static final boolean RED = false;
	
	
	//树中所放的数据元素
	Object data;
	
	//左节点
	NodeRB left;
	
	//右节点
	NodeRB right;
	
	//父节点
	//红色节点的子节点必须为黑色
	NodeRB parent;
	
	//节点着色（根节点是黑色）
	//通过改变节点的着色满足 红黑树的定义规则
	//不满足就需要通过旋转来实现
	boolean color = BLACK;
	
}
