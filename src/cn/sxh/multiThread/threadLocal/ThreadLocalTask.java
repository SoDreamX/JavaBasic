package cn.sxh.multiThread.threadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * �ֲ߳̾�����
 * @author Sxh
 * 2018��11��8�� ����5:01:05
 */
public class ThreadLocalTask implements Runnable{
	/**
	 * �ֲ߳̾������ֱ�Ϊÿ���̴߳洢�˸��Ե�����ֵ�����ṩ��ÿ���߳�ʹ�á�
	 */
	private static ThreadLocal<String> taskDate = new ThreadLocal<String>() {
		@Override
		protected String initialValue() {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateStr = sdf.format(date);
			return dateStr;
		}
	};
	
	@Override
	public void run() {
		System.out.println("�̡߳�"+Thread.currentThread().getName()+
				"���������ֲ�����taskDateֵΪ��"+taskDate.get());
		long sencondNum = (int)Math.rint((Math.random()*10));
		try {
			TimeUnit.SECONDS.sleep(sencondNum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("�̡߳�"+Thread.currentThread().getName()+
				"���������ֲ�����taskDateֵΪ��"+taskDate.get());
	}
	
	public static void main(String[] args) {
		ThreadLocalTask task = new ThreadLocalTask();
		Thread thread;
		try {
			for(int i=0;i<10;i++) {
				thread = new Thread(task, "Thread-0"+(i+1));
				thread.start();
				TimeUnit.SECONDS.sleep(2);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
