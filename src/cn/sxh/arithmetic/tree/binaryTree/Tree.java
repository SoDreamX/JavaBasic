package cn.sxh.arithmetic.tree.binaryTree;
/**
 * ����������
 * @author Sxh
 * 2018��11��30�� ����11:56:44
 */
public interface Tree {
	//���ҽڵ�
	public Node find(int value);
	//�����½ڵ�
	public boolean insert(int value);
	
	//�������
	public void infixOrder(Node current);
	//ǰ�����
	public void preOrder(Node current);
	//�������
	public void postOrder(Node current);
	
	//�����ֵ
	public Node findMax();
	//����Сֵ
	public Node findMin();
	
	//ɾ���ڵ�
	public boolean delete(int value);
}
