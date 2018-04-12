package cn.sxh.multiThread;

import cn.sxh.multiThread.myThread.Actor;
import cn.sxh.multiThread.myThread.Actress;

public class TestThread {
	
	public static void main(String[] args) {
		TestThread test = new TestThread();
		//test.testActor();
		test.testArmy();
	}

	public void testArmy() {
		System.out.println("ս����ʼ��...");
	}

	public void testActor() {
		Thread actor = new Actor();
		actor.setName("Mr.Thread");
		//����
		actor.start();
		
		Actress actress = new Actress();
		Thread thd = new Thread(actress,"Ms.Runnable");
		thd.start();
	}
}
