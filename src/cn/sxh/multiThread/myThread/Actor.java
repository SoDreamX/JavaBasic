package cn.sxh.multiThread.myThread;
/**
 * �߳�
 * @author Sxh
 * 2018��4��11�� ����2:14:57
 */
public class Actor extends Thread {
	@Override
	public void run() {
		//getName()--��ȡ��ǰ�̵߳�����
		System.out.println(getName()+"��һ����Ա��");
		//��¼�߳��ܵĴ���
		int count = 0;
		boolean keepRunning = true;
		while(keepRunning) {
			System.out.println("��Ա"+getName()+"��̨�ݳ�"+(++count));
			if(count == 100) {
				keepRunning = false;
			}
			if(count%10 == 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("��Ա"+getName()+"���ݳ������ˣ�");
	}
}
