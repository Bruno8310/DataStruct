package edu.csuft.Bruno.binarytree;

/**
 * 二叉搜索树的操作 行为契约
 * 
 * @author Bruno
 *
 */
public interface AdtTree {

	/**
	 * 添加一个新节点
	 * 
	 * @param t
	 * @return 新的二叉搜索树
	 */
	Node insert(Integer t);
	
	/**
	 * 是否包含节点
	 * @param t
	 * @return
	 */
	boolean  contains(Integer t);	
	
	
	/**
	 * 根据节点值查找到节点
	 * @param t
	 * @return
	 */
	Node search(Integer t);
	
	
	/**
	 * 删除
	 * @param t
	 * @return
	 */
	Node remove(Integer t);
	
	/**
	 * 获得最大值
	 * @return
	 */
	Integer max();
	
	/**
	 * 获得最小值
	 * @return
	 */
	Integer min();
	
	/**
	 * 节点个数，树的大小
	 * @return
	 */
	int size();
	
	void clear();
	
	boolean isEmpty();
	
	/**
	 * 先序
	 */
	void preOrder();
	
	/**
	 * 中序
	 */
	void midOrder();
	
	/**
	 * 后序
	 */
	void postOrder();
	
	void reverse();

}
