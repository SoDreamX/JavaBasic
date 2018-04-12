package cn.sxh.multiThread.myThread;
/**
 * 线程
 * @author Sxh
 * 2018年4月11日 下午2:25:31
 */
public class Actress implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"是一个演员!");
		int count = 0;
		boolean keepRunning = true;
		while(keepRunning) {
			System.out.println("演员"+Thread.currentThread().getName()+"登台演出"+(++count));
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
		System.out.println(Thread.currentThread().getName()+"的演出结束了！");
	}

}
