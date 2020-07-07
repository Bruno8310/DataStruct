package edu.csuft.Bruno.binarytree;

import java.util.TreeMap;
import java.util.TreeSet;

public class App {

	public static void main(String[] args) {
		Tree tree = new Tree();
		
		tree.insert(4);
		tree.insert(2);
		tree.insert(7);
		tree.insert(1);
		tree.insert(3);
		tree.insert(6);
		tree.insert(9);
		tree.insert(9);
		
		System.out.println("根节点为："+ tree.root.data);
		
		System.out.println("最大值:"+ tree.max());
		
		System.out.println("最小值:"+ tree.min());
		
		System.out.println(tree.contains(20));
		System.out.println(tree.contains(32));
		System.out.printf("树的节点个数为%d\n",tree.size());
		
		tree.preOrder();
		System.out.println();
		
		tree.midOrder();
		System.out.println();
		
		tree.postOrder();
		System.out.println();
		
		tree.reverse();
		tree.midOrder();
		
		
	}
}
