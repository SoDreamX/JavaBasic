package cn.sxh.collection.bean;
/**
 * �ؼ�����
 * @author Sxh
 * 2018��4��12�� ����9:26:26
 */
public class KeyPersonThread extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"��ʼս��!");
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+"��ͻ��ɱ����������...");
		}
		System.out.println(Thread.currentThread().getName()+"����ս��!");
	}
}
