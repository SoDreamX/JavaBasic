package cn.sxh.multiThread.myThread;
/**
 * �߳�
 * @author Sxh
 * 2018��4��11�� ����2:25:31
 */
public class Actress implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"��һ����Ա!");
		int count = 0;
		boolean keepRunning = true;
		while(keepRunning) {
			System.out.println("��Ա"+Thread.currentThread().getName()+"��̨�ݳ�"+(++count));
			if(count==100) {
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
		System.out.println(Thread.currentThread().getName()+"���ݳ������ˣ�");
	}

}
