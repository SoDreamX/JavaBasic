package cn.sxh.arithmetic.tree.binaryTree;
/**
 * 节点
 * @author Sxh
 * 2018年11月30日 上午11:54:44
 */
public class Node {
	private int data;
	private Node leftNode;
	private Node rightNode;
	private boolean isDelete;
	public Node() {
		super();
	}
	public Node(int data) {
		super();
		this.data = data;
	}
	public String display() {
		return "Node["+data+"]";
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	public Node getRightNode() {
		return rightNode;
	}
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
}
