package cn.sxh.arithmetic.tree.rbTree;
/**
 * 红黑树节点
 * @author Sxh
 * 2018年12月19日 上午11:46:26
 */
public class RBNode<T extends Comparable<T>> {
	String color;//颜色
	RBNode<T> parent;//父节点
	RBNode<T> left;//左子节点
	RBNode<T> right;//右子节点
	T key;//关键字
	
	public RBNode(String color,T key, RBNode<T> parent, RBNode<T> left, RBNode<T> right) {
		super();
		this.color = color;
		this.parent = parent;
		this.left = left;
		this.right = right;
		this.key = key;
	}

	public T getKey() {
		return key;
	}
	//打印关键字，颜色信息
	public String toString() {
		return color+"["+key+"]";
	}
}
