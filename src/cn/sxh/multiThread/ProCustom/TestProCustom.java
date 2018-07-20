package cn.sxh.multiThread.ProCustom;

public class TestProCustom {
	public static void main(String[] args) throws InterruptedException {
		Object lock = new Object();
		final Producer producer = new Producer(lock);
		final Customer customer = new Customer(lock);
		Runnable produceRunnable = new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					producer.createProduce(i+1);
				}
			}
		};
		Runnable customRunnable = new Runnable() {
			@Override
			public void run() {
				while(true) {
					customer.consumeProduce();
				}
			}
		};
		
		Thread produceThread = new Thread(produceRunnable);
		Thread customThread = new Thread(customRunnable);
		produceThread.start();
		Thread.sleep(100);
		customThread.start();
	}
}
