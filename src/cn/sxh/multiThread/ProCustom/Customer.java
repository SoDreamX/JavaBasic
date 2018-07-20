package cn.sxh.multiThread.ProCustom;
/**
 * ������
 * @author Sxh
 * 2018��7��20�� ����11:53:07
 */
public class Customer {
	private Object lock;
	
	public Customer(Object lock) {
		this.lock = lock;
	}
	
	public void consumeProduce() {
		try {
			synchronized (lock) {
				if("".equals(BufferObject.value))lock.wait();
				System.out.println("���������Ѳ�Ʒ:"+BufferObject.value);
				BufferObject.value = "";
				lock.notify();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
