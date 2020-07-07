package edu.csuft.Bruno.priorityqueue;
/**
 * 优先级队列:  用数组实现。物理上数据元素之间连续存储
 * 逻辑上是一颗完全二叉树
 * @author Bruno
 *
 */
public class PriorityQueue {

	//数据
	int[] data;
	
	//队列大小
	int size;
	
	public PriorityQueue() {
		data = new int[9];
		
		size = 0;
	}
	
	
	//操作
	//插入
	public void add() {
		
		
	}
	
	//取出队列头
	public int poll() {
		return 0;
	}
	
	public int size() {
		return size;
	}
	
	public void clear() {
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
}
