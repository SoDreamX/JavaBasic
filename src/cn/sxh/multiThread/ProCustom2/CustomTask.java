package cn.sxh.multiThread.ProCustom2;

import java.util.List;

/**
 * 消费者
 * @author Sxh
 * 2018年11月9日 下午3:20:07
 */
public class CustomTask implements Runnable{
	//产品仓库
	private List<ProductBean> productList;
	
	public CustomTask(List<ProductBean> productList) {
		this.productList = productList;
	}

	@Override
	public void run() {
		//轮询仓库，消费产品
		while(true) {
			try {
				consume();
				//过会再买
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("购买手机异常！");
				e.printStackTrace();
			}
		}
	}

	private void consume() throws InterruptedException {
		if(productList.size()==0) {
			synchronized (productList) {
				System.out.println("仓库已断货，暂停购买！");
				//仓库没货，暂停消费
				productList.wait();
			}
		}
		synchronized (productList) {
			ProductBean bean = productList.remove(0);
			System.out.println("购买"+bean.getFldname()+"成功！");
			//唤醒仓库
			productList.notifyAll();
		}
	}

}
