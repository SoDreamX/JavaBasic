package cn.sxh.multiThread.threadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 线程局部变量
 * @author Sxh
 * 2018年11月8日 下午5:01:05
 */
public class ThreadLocalTask implements Runnable{
	/**
	 * 线程局部变量分别为每个线程存储了各自的属性值，并提供给每个线程使用。
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
		System.out.println("线程【"+Thread.currentThread().getName()+
				"】启动，局部变量taskDate值为："+taskDate.get());
		long sencondNum = (int)Math.rint((Math.random()*10));
		try {
			TimeUnit.SECONDS.sleep(sencondNum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("线程【"+Thread.currentThread().getName()+
				"】结束，局部变量taskDate值为："+taskDate.get());
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
