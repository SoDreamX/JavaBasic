package cn.sxh.collection.bean;
/**
 * ��̨
 * @author Sxh
 * 2018��4��12�� ����9:31:06
 */
public class StageThread extends Thread {
	@Override
	public void run() {
		System.out.println("��ӭ�տ��������壡");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("��Ļ������������");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("��˵�峯ĩ�꣬�����ũ�������ɱ�û��찵��...");
		//�峯����
		ArmyRunnable scArmy = new ArmyRunnable();
		//ũ�������
		ArmyRunnable nmArmy = new ArmyRunnable();
		//������Ӧ�߳�
		Thread scThread = new Thread(scArmy, "�峯����");
		Thread nmThread = new Thread(nmArmy, "ũ�������");
		//�����̣߳���ʼ��ս
		scThread.start();
		nmThread.start();
		//��̨�߳����ߣ����ר�Ŀ�ս������ɱ
		try {
			//Thread��ָ��ǰ����߳�
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("����˫����ս��������·ɱ���˸���ҧ��");
		System.out.println("��ҧ���������ǽ���ս����ʹ���հ�����ҵ��");
		Thread mrCheng = new KeyPersonThread();
		mrCheng.setName("��ҧ��");
		
		//ֹͣ������ս
		//ֹͣ�̵߳ķ���
		scArmy.keepRunning = false;
		nmArmy.keepRunning = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��ʷ��Ϸ�����ؼ�����
		mrCheng.start();
		try {
			//�����̵߳ȴ����߳�ִ�����
			mrCheng.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ս�����������񰲾���ҵ��������ʵ���˻������������룬Ϊ���������˹��ף�");
		System.out.println("лл�ۿ��������壬�ټ���");
	}
}
