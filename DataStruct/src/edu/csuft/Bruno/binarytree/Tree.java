package edu.csuft.Bruno.binarytree;


public class Tree implements AdtTree {

	/**
	 * 树的大小
	 */
	int size;

	/**
	 * 根节点
	 */
	Node root;

	public Tree() {
		size = 0;
		root = null;

	}

	@Override
	public Node insert(Integer t) {

		// 最开始根节点不存在，先创建
		if (root == null) {
			root = new Node(t, null, null, null);
			size++;
			return root;
		}
		// 依次从根节点比较大小，插入
		return insert(t, root);
	}

	/**
	 * 把t追加到n上去
	 * 
	 * @param t
	 * @param n
	 * @return
	 */
	private Node insert(Integer t, Node n) {
		// 给每个要插入的数值，封装成节点
		if (n == null) {
			n = new Node(t, null, null, null);
			size++;
		}

		// 当封装成节点后，与当前根节点比较，插入合适位置
		if (t < n.data) {
			// 左子树
			n.leftNode = insert(t, n.leftNode);

		} else if (t > n.data) {
			// 右子树
			n.rightNode = insert(t, n.rightNode);

		} else {
			// 与当前根相等
			return n;
		}
		return n;

	}

	@Override
	public boolean contains(Integer t) {
		return contains(t, root);
	}

	private boolean contains(Integer t, Node n) {

		if (n == null) {
			return false;
		}

		if (t == n.data) {
			return true;
		} else if (t < n.data) {
			// 小于
			return contains(t, n.leftNode);
		} else {
			// 大于
			return contains(t, n.rightNode);

		}

	}

	@Override
	public Node remove(Integer t) {

		// 查找到指定数据的节点
		Node node = search(t);
		if (node == null) {
			return null;
		}
		return remove(node);
	}

	private Node remove(Node node) {

		// 1.该节点的左子树与右子树都存在
		if (node.leftNode != null && node.rightNode != null) {

			// 要找到对二叉搜索树中序遍历中该节点的后一个比它大的节点

		}

		//2.删除叶子结点		
		if (node.leftNode == null && node.rightNode == null) {
			node = null;
			
		}
		
		
		// 临时存放获取的节点
		Node tempNode;
		if (node.leftNode != null) {
			tempNode = node.leftNode;
		} else  {
			tempNode = node.rightNode;			
		} 

		// 3.只有一个叶子结点的情况
		if (tempNode != null) {
			tempNode.parentNode = node.parentNode;
		}		
		
		// 3.删除只有一个叶子节点的根节点
		if (node.parentNode == null) {
			root = tempNode;
		} else if (node == node.parentNode.leftNode) {
			node.parentNode.leftNode = tempNode;
		} else {
			node.parentNode.rightNode = tempNode;
		}		
		
		return node;

	}

	@Override
	public Integer max() {

		return max(root);

	}

	/**
	 * 循环实现
	 * 
	 * @param n
	 * @return
	 */
	private Integer max(Node n) {
		if (n == null) {
			return null;
		}
		Integer maxNode = null;
		while (n.rightNode != null) {
			n = n.rightNode;
			maxNode = n.data;
		}
		return maxNode;
	}

	@Override
	public Integer min() {
		return min(root).data;
	}

	/**
	 * 递归实现
	 * 
	 * @param n
	 * @return
	 */
	private Node min(Node n) {
		if (n == null) {
			return null;
		} else if (n.leftNode == null) {
			return n;
		} else {
			return min(n.leftNode);
		}

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		root = null;
		size = 0;

	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void preOrder() {
		System.out.println("先序遍 历二叉搜索树:");
		preOrder(root);
	}

	private void preOrder(Node n) {
		if (n == null) {
			return;
		}
		// 先根
		System.out.printf("%d ", n.data);
		// 递归左子树
		preOrder(n.leftNode);
		// 递归右子树
		preOrder(n.rightNode);

	}

	@Override
	public void midOrder() {
		System.out.println("中序遍历二叉搜索树");
		midOrder(root);

	}

	private void midOrder(Node n) {
		if (n == null) {
			return;
		}
		// 左
		midOrder(n.leftNode);
		// 中
		System.out.printf("%d ", n.data);
		// 右
		midOrder(n.rightNode);

	}

	@Override
	public void postOrder() {
		System.out.println("后序遍历二叉搜索树:");
		postOrder(root);
	}

	private void postOrder(Node n) {
		if (n == null) {
			return;
		}

		// 递归左子树
		postOrder(n.leftNode);

		// 递归右子树
		postOrder(n.rightNode);
		// 根
		System.out.printf("%d ", n.data);
	}

	/**
	 * 旋转二分搜索树
	 */
	@Override
	public void reverse() {
		reverse(root);
	}

	/**
	 * 翻转二叉搜索树
	 * 
	 * @param n
	 */
	private void reverse(Node n) {

		if (n == null) {
			return;
		}

		// 交换左右叶子结点
		exchange(n);
		// 翻转以当前左叶子节点为根节点
		reverse(n.leftNode);
		// 翻转以当前右叶子节点为根节点
		reverse(n.rightNode);

	}

	/**
	 * 交换当前根节点的左叶子结点与右叶子结点
	 * 
	 * @param n
	 */
	private void exchange(Node n) {
		Node temp = null;
		if (n == null) {
			return;
		}
		// 交换左右子节点
		temp = n.rightNode;
		n.rightNode = n.leftNode;
		n.leftNode = temp;
	}

	@Override
	public Node search(Integer t) {

		return search(root, t);
	}

	private Node search(Node n, Integer t) {

		if (n == null) {
			return null;
		}

		Node node;

		if (t < n.data) {
			node = search(n.leftNode, t);
		} else if (t > n.data) {
			node = search(n.rightNode, t);
		} else {
			return n;
		}

		return node;
	}

}
