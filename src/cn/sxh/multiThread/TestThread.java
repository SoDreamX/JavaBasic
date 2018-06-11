package cn.sxh.multiThread;

import cn.sxh.collection.bean.StageThread;
import cn.sxh.multiThread.myThread.Actor;
import cn.sxh.multiThread.myThread.Actress;
import cn.sxh.multiThread.myThread.MyThreadPrinter;

public class TestThread {
	
	public static void main(String[] args) {
		TestThread test = new TestThread();
		//test.testActor();
		//test.testArmy();
		try {
			test.testThreadPrinter();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void testArmy() {
		StageThread stage = new StageThread();
		stage.start();
	}

	public void testActor() {
		Thread actor = new Actor();
		actor.setName("Mr.Thread");
		//启动
		actor.start();
		
		Actress actress = new Actress();
		Thread thd = new Thread(actress,"Ms.Runnable");
		thd.start();
	}
	public void testThreadPrinter() throws InterruptedException {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		MyThreadPrinter printa = new MyThreadPrinter("A", c, a);
		MyThreadPrinter printb = new MyThreadPrinter("B", a, b);
		MyThreadPrinter printc = new MyThreadPrinter("C", b, c);
		new Thread(printa).start();
		Thread.sleep(10);
		new Thread(printb).start();
		Thread.sleep(10);
		new Thread(printc).start();
		Thread.sleep(10);
		System.out.println("main线程完毕!");
	}
}
