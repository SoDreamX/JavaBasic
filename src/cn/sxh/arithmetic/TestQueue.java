package cn.sxh.arithmetic;

public class TestQueue {
	public static void testQueue() {
		try {
			QueueMetic queue = new QueueMetic(10);
			queue.insert(1);
			queue.insert(2);
			queue.insert(3);
			queue.insert("a");
			queue.insert("b");
			System.out.println("����Ԫ��=============="+queue.peekFront());
			Object item = queue.remove();
			System.out.println("ɾ��Ԫ��=============="+item);
			item = queue.remove();
			System.out.println("ɾ��Ԫ��=============="+item);
			item = queue.remove();
			System.out.println("ɾ��Ԫ��=============="+item);
			System.out.println("����Ԫ��=============="+queue.peekFront());
			
			queue.insert(1);
			queue.insert(2);
			queue.insert(3);
			queue.insert(4);
			queue.insert(5);
			queue.insert(6);
			queue.insert(7);
			queue.insert(8);
			queue.insert(9);
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		testQueue();
	}
}
