package cn.sxh.other.volatile_;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * У��volatile�Ը��ϲ�����Ч��
 * @author Sxh
 * 2018��12��7�� ����2:33:30
 */
public class TestVolatileCount {
	//public static volatile int num = 0;
	//ԭ�Ӳ���integer��
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
						num.incrementAndGet();//ԭ���Ե�num++,ͨ��ѭ��CAS��ʽ
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
