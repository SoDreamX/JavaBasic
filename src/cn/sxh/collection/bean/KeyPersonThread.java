package cn.sxh.collection.bean;
/**
 * 关键人物
 * @author Sxh
 * 2018年4月12日 上午9:26:26
 */
public class KeyPersonThread extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"开始战斗!");
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+"左突右杀，攻击敌人...");
		}
		System.out.println(Thread.currentThread().getName()+"结束战斗!");
	}
}
