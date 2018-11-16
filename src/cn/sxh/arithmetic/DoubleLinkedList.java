package cn.sxh.arithmetic;
/**
 * ˫������ʵ��
 * @author Sxh
 * 2018��11��16�� ����10:51:45
 */
public class DoubleLinkedList {
	private Node head;//����ͷ
	private Node tail;//����β
	private int size;//����ڵ����
	private class Node{
		private Object data;//�ڵ�����
		private Node prev;//��һ�ڵ�
		private Node next;//��һ�ڵ�
		public Node(Object data) {
			this.data = data;
		}
		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
	}
	
	public DoubleLinkedList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	/**
	 * ����ͷ���ӽڵ�
	 * @param item
	 */
	public void addHead(Object item) {
		Node newNode = new Node(item);
		if(size==0) {
			head = newNode;
			tail = newNode;
		}else {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
		size++;
	}
	/**
	 * ����β���ӽڵ�
	 * @param item
	 */
	public void addTail(Object item) {
		Node newNode = new Node(item);
		if(size==0) {
			head = newNode;
			tail = newNode;
		}else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;
	}
	/**
	 * ɾ��ͷ�ڵ�
	 * @return
	 */
	public Node delHead() {
		Node item = head;
		if(size!=0) {
			head = item.next;
			head.prev = null;
			size--;
		}
		return item;
	}
	/**
	 * ɾ��β�ڵ�
	 * @return
	 */
	public Node delTail() {
		Node item = tail;
		if(size!=0) {
			tail = item.prev;
			tail.next = null;
			size--;
		}
		return item;
	}
	/**
	 * ��ȡ����ڵ����
	 * @return
	 */
	public int getSize() {
		return size;
	}
	/**
	 * �ж������Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty() {
		return (size==0);
	}
	/**
	 * ��ʾ����ڵ���Ϣ
	 * @return
	 */
	public String display() {
		StringBuffer sb = new StringBuffer();
		int showSize = size;
		sb.append("[");
		Node tmp = head;
		while(showSize>0) {
			sb.append(tmp.data);
			if(showSize>1) {
				sb.append("->");
			}
			tmp = tmp.next;
			showSize--;
		}
		sb.append("]");
		return sb.toString();
	}
	public Node getHead() {
		return head;
	}
	public Node getTail() {
		return tail;
	}
	public static void main(String[] args) {
		DoubleLinkedList dlink = new DoubleLinkedList();
		dlink.addHead("A");
		dlink.addHead("B");
		dlink.addHead("C");
		System.out.println(dlink.display());
		dlink.addTail("D");
		dlink.addTail("E");
		System.out.println(dlink.display());
		dlink.delHead();
		System.out.println(dlink.display());
		dlink.delTail();
		System.out.println(dlink.display());
		System.out.println(dlink.getSize());
		System.out.println("head:"+dlink.getHead());
		System.out.println("tail:"+dlink.getTail());
	}
}
