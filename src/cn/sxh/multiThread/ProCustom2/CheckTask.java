package cn.sxh.multiThread.ProCustom2;

import java.util.ArrayList;
import java.util.List;

public class CheckTask {
	public static void main(String[] args) throws InterruptedException {
		List<ProductBean> productList = new ArrayList<>();
		int size = 5;
		ProducerTask protask = new ProducerTask(productList, size);
		CustomTask custask = new CustomTask(productList);
		//��������
		new Thread(protask).start();
		//�Ե�Ƭ��
		Thread.sleep(100);
		//��ʼ����
		new Thread(custask).start();
	}
}
