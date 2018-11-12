package cn.sxh.multiThread.ProCustom2;

import java.util.List;

/**
 * 生产者
 * @author Sxh
 * 2018年11月9日 下午3:00:50
 */
public class ProducerTask implements Runnable {
	//产品仓库
	private List<ProductBean> productList;
	private int size;
	
	public ProducerTask(List<ProductBean> productList, int size) {
		this.productList = productList;
		this.size = size;
	}

	@Override
	public void run() {
		//循环生成产品，假设总共生产15个
		for(int i=0;i<15;i++) {
			try {
				produce(i);
				//休息一下
				Thread.sleep(50);
			} catch (InterruptedException e) {
				System.out.println("生产手机【"+(i+1)+"】异常！");
				e.printStackTrace();
			}
		}
	}

	private void produce(int i) throws InterruptedException {
		//判断产品是否已满
		if(productList.size()==size) {
			//暂停生产，等待消费者消费
			synchronized (productList) {
				System.out.println("手机仓库已满，暂停生产！");
				productList.wait();
			}
		}
		synchronized (productList) {
			//生产产品
			ProductBean bean = new ProductBean((i+1)+"", "手机【"+(i+1)+"】号");
			productList.add(bean);
			System.out.println("手机【"+(i+1)+"】号生产完毕，已入库！");
			//唤醒仓库
			productList.notifyAll();
		}
	}

}
