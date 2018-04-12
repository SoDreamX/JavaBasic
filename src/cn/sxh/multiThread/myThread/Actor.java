package cn.sxh.multiThread.myThread;
/**
 * 线程
 * @author Sxh
 * 2018年4月11日 下午2:14:57
 */
public class Actor extends Thread {
	@Override
	public void run() {
		//getName()--获取当前线程的名字
		System.out.println(getName()+"是一个演员！");
		//记录线程跑的次数
		int count = 0;
		boolean keepRunning = true;
		while(keepRunning) {
			System.out.println("演员"+getName()+"登台演出"+(++count));
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
		System.out.println("演员"+getName()+"的演出结束了！");
	}
}
