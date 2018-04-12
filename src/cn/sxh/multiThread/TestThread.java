package cn.sxh.multiThread;

import cn.sxh.collection.bean.StageThread;
import cn.sxh.multiThread.myThread.Actor;
import cn.sxh.multiThread.myThread.Actress;

public class TestThread {
	
	public static void main(String[] args) {
		TestThread test = new TestThread();
		//test.testActor();
		test.testArmy();
	}

	public void testArmy() {
		StageThread stage = new StageThread();
		stage.start();
	}

	public void testActor() {
		Thread actor = new Actor();
		actor.setName("Mr.Thread");
		//Æô¶¯
		actor.start();
		
		Actress actress = new Actress();
		Thread thd = new Thread(actress,"Ms.Runnable");
		thd.start();
	}
}
