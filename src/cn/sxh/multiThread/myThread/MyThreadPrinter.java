package cn.sxh.multiThread.myThread;
/**
 * 模拟用线程依次打印ABC10次
 * @author Sxh
 * 2018年5月16日 下午6:26:06
 */
public class MyThreadPrinter implements Runnable{
	private String name;
	private Object prev;
	private Object self;
	public MyThreadPrinter(String name,Object prev,Object self) {
		this.name = name;
		this.prev = prev;
		this.self = self;
	}
	@Override
	public void run() {
		int count = 10;
		while(count>0) {
			synchronized (prev) {
				synchronized(self) {
					//System.out.println(name);
					count--;
					System.out.println("【"+name+"-"+count+"】释放"+getObjectName(name,1)+"锁");
					self.notify();
				}
				try {
					//保证最后一次不让线程一直等待
					if(count > 0) {
						System.out.println("【"+name+"-"+count+"】等待"+getObjectName(name,0)+"");
						prev.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("【"+name+"】执行完毕。");
	}

	private String getObjectName(String mname, int type) {
		String objectName = "";
		if(type == 0) {
			if(mname.equals("A")){
				objectName = "c";
			}else if(mname.equals("B")) {
				objectName = "a";
			}else {
				objectName = "b";
			}
		}else {
			objectName = mname.toLowerCase();
		}
		return objectName;
	}
	public static void main(String[] args) throws Exception {
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
	}
}
