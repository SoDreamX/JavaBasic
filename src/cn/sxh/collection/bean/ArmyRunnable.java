package cn.sxh.collection.bean;
/**
 * �����߳�
 * @author Sxh
 * 2018��4��12�� ����9:18:21
 */
public class ArmyRunnable implements Runnable {

	//volatile��֤���߳̿�����ȷ�Ķ�ȡ�����߳�д���ֵ
	volatile boolean keepRunning = true;
	
	@Override
	public void run() {
		while(keepRunning) {
			//����5����
			for(int i=0;i<5;i++) {
				System.out.println(Thread.currentThread().getName()+"���ڽ����Է�["+(i+1)+"]");
				//�ó�����ʱ�䣬�´�˭��������һ����
				//��ǰ�����߳��ͷŴ�������Դ
				Thread.yield();
			}
		}
	}

}
