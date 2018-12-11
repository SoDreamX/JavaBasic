package cn.sxh.other.volatile_;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 校验volatile对复合操作的效果
 * @author Sxh
 * 2018年12月7日 下午2:33:30
 */
public class TestVolatileCount {
	//public static volatile int num = 0;
	//原子操作integer类
	public static AtomicInteger num = new AtomicInteger(0);
	public static void main(String[] args) {
		int count = 10;
		CountDownLatch cdl = new CountDownLatch(count);
		for(int i=0;i<count;i++) {
			new Thread() {
				@Override
				public void run() {
					for(int j=0;j<10000;j++) {
						//num++;
						num.incrementAndGet();//原子性的num++,通过循环CAS方式
					}
					cdl.countDown();
				}			
			}.start();
		}
		try {
			cdl.await();
			System.out.println(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
