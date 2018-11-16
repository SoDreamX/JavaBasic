package cn.sxh.arithmetic;
/**
 * 双向链表实现
 * @author Sxh
 * 2018年11月16日 上午10:51:45
 */
public class DoubleLinkedList {
	private Node head;//链表头
	private Node tail;//链表尾
	private int size;//链表节点个数
	private class Node{
		private Object data;//节点数据
		private Node prev;//上一节点
		private Node next;//下一节点
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
	 * 链表头增加节点
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
	 * 链表尾增加节点
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
	 * 删表头节点
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
	 * 删表尾节点
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
	 * 获取链表节点个数
	 * @return
	 */
	public int getSize() {
		return size;
	}
	/**
	 * 判断链表是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return (size==0);
	}
	/**
	 * 显示链表节点信息
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
