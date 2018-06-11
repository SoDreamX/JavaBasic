package cn.sxh.multiThread.myThread;
/**
 * ģ�����߳����δ�ӡABC10��
 * @author Sxh
 * 2018��5��16�� ����6:26:06
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
					System.out.println("��"+name+"-"+count+"���ͷ�"+getObjectName(name,1)+"��");
					self.notify();
				}
				try {
					//��֤���һ�β����߳�һֱ�ȴ�
					if(count > 0) {
						System.out.println("��"+name+"-"+count+"���ȴ�"+getObjectName(name,0)+"");
						prev.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("��"+name+"��ִ����ϡ�");
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
