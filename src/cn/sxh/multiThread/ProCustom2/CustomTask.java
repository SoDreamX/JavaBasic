package cn.sxh.multiThread.ProCustom2;

import java.util.List;

/**
 * ������
 * @author Sxh
 * 2018��11��9�� ����3:20:07
 */
public class CustomTask implements Runnable{
	//��Ʒ�ֿ�
	private List<ProductBean> productList;
	
	public CustomTask(List<ProductBean> productList) {
		this.productList = productList;
	}

	@Override
	public void run() {
		//��ѯ�ֿ⣬���Ѳ�Ʒ
		while(true) {
			try {
				consume();
				//��������
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("�����ֻ��쳣��");
				e.printStackTrace();
			}
		}
	}

	private void consume() throws InterruptedException {
		if(productList.size()==0) {
			synchronized (productList) {
				System.out.println("�ֿ��Ѷϻ�����ͣ����");
				//�ֿ�û������ͣ����
				productList.wait();
			}
		}
		synchronized (productList) {
			ProductBean bean = productList.remove(0);
			System.out.println("����"+bean.getFldname()+"�ɹ���");
			//���Ѳֿ�
			productList.notifyAll();
		}
	}

}
