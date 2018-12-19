package cn.sxh.arithmetic.tree.rbTree;
/**
 * ������ڵ�
 * @author Sxh
 * 2018��12��19�� ����11:46:26
 */
public class RBNode<T extends Comparable<T>> {
	String color;//��ɫ
	RBNode<T> parent;//���ڵ�
	RBNode<T> left;//���ӽڵ�
	RBNode<T> right;//���ӽڵ�
	T key;//�ؼ���
	
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
	//��ӡ�ؼ��֣���ɫ��Ϣ
	public String toString() {
		return color+"["+key+"]";
	}
}
