package cn.sxh.multiThread.ProCustom;
/**
 * 生产者
 * @author Sxh
 * 2018年7月20日 上午10:17:34
 */
public class Producer {
	private Object lock;
	
	public Producer(Object lock) {
		this.lock = lock;
	}
	
	public void createProduce(int number) {
		try {
			synchronized (lock) {
				if(!"".equals(BufferObject.value))lock.wait();
				String value = "产品【"+number+"】";
				System.out.println("生产者生产产品:"+value);
				BufferObject.value = value;
				lock.notify();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
