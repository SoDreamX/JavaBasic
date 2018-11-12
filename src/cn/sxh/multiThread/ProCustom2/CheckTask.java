package cn.sxh.multiThread.ProCustom2;

import java.util.ArrayList;
import java.util.List;

public class CheckTask {
	public static void main(String[] args) throws InterruptedException {
		List<ProductBean> productList = new ArrayList<>();
		int size = 5;
		ProducerTask protask = new ProducerTask(productList, size);
		CustomTask custask = new CustomTask(productList);
		//启动生产
		new Thread(protask).start();
		//稍等片刻
		Thread.sleep(100);
		//开始购买
		new Thread(custask).start();
	}
}
