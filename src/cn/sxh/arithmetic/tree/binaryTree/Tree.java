package cn.sxh.arithmetic.tree.binaryTree;
/**
 * 二叉搜索树
 * @author Sxh
 * 2018年11月30日 上午11:56:44
 */
public interface Tree {
	//查找节点
	public Node find(int value);
	//插入新节点
	public boolean insert(int value);
	
	//中序遍历
	public void infixOrder(Node current);
	//前序遍历
	public void preOrder(Node current);
	//后序遍历
	public void postOrder(Node current);
	
	//查最大值
	public Node findMax();
	//查最小值
	public Node findMin();
	
	//删除节点
	public boolean delete(int value);
}
