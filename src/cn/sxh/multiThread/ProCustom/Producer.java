package cn.sxh.multiThread.ProCustom;
/**
 * ������
 * @author Sxh
 * 2018��7��20�� ����10:17:34
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
				String value = "��Ʒ��"+number+"��";
				System.out.println("������������Ʒ:"+value);
				BufferObject.value = value;
				lock.notify();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
