package cn.sxh.multiThread.ProCustom;
/**
 * 消费者
 * @author Sxh
 * 2018年7月20日 上午11:53:07
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
				System.out.println("消费者消费产品:"+BufferObject.value);
				BufferObject.value = "";
				lock.notify();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
