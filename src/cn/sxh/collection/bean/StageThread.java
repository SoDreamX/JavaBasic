package cn.sxh.collection.bean;
/**
 * 舞台
 * @author Sxh
 * 2018年4月12日 上午9:31:06
 */
public class StageThread extends Thread {
	@Override
	public void run() {
		System.out.println("欢迎收看隋唐演义！");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("大幕徐徐拉开。。");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("话说隋朝末年，隋军与农民起义军杀得昏天暗地...");
		//隋朝军队
		ArmyRunnable scArmy = new ArmyRunnable();
		//农民起义军
		ArmyRunnable nmArmy = new ArmyRunnable();
		//创建对应线程
		Thread scThread = new Thread(scArmy, "隋朝军队");
		Thread nmThread = new Thread(nmArmy, "农民起义军");
		//启动线程，开始作战
		scThread.start();
		nmThread.start();
		//舞台线程休眠，大家专心看战场的厮杀
		try {
			//Thread会指向当前类的线程
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("正当双方激战正酣，半路杀出了个程咬金");
		System.out.println("程咬金的理想就是结束战争，使百姓安居乐业！");
		Thread mrCheng = new KeyPersonThread();
		mrCheng.setName("程咬金");
		
		//停止军队作战
		//停止线程的方法
		scArmy.keepRunning = false;
		nmArmy.keepRunning = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//历史大戏留给关键人物
		mrCheng.start();
		try {
			//其他线程等待该线程执行完毕
			mrCheng.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("战争结束，人民安居乐业，程先生实现了积极的人生梦想，为人民作出了贡献！");
		System.out.println("谢谢观看隋唐演义，再见！");
	}
}
