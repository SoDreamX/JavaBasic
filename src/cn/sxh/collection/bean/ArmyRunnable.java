package cn.sxh.collection.bean;
/**
 * 军队线程
 * @author Sxh
 * 2018年4月12日 上午9:18:21
 */
public class ArmyRunnable implements Runnable {

	//volatile保证了线程可以正确的读取其他线程写入的值
	volatile boolean keepRunning = true;
	
	@Override
	public void run() {
		while(keepRunning) {
			//发动5连击
			for(int i=0;i<5;i++) {
				System.out.println(Thread.currentThread().getName()+"正在进攻对方["+(i+1)+"]");
				//让出处理时间，下次谁进攻还不一定呢
				//当前运行线程释放处理器资源
				Thread.yield();
			}
		}
	}

}
