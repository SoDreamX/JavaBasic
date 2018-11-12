package cn.sxh.multiThread.ProCustom2;

import java.util.List;

/**
 * ������
 * @author Sxh
 * 2018��11��9�� ����3:00:50
 */
public class ProducerTask implements Runnable {
	//��Ʒ�ֿ�
	private List<ProductBean> productList;
	private int size;
	
	public ProducerTask(List<ProductBean> productList, int size) {
		this.productList = productList;
		this.size = size;
	}

	@Override
	public void run() {
		//ѭ�����ɲ�Ʒ�������ܹ�����15��
		for(int i=0;i<15;i++) {
			try {
				produce(i);
				//��Ϣһ��
				Thread.sleep(50);
			} catch (InterruptedException e) {
				System.out.println("�����ֻ���"+(i+1)+"���쳣��");
				e.printStackTrace();
			}
		}
	}

	private void produce(int i) throws InterruptedException {
		//�жϲ�Ʒ�Ƿ�����
		if(productList.size()==size) {
			//��ͣ�������ȴ�����������
			synchronized (productList) {
				System.out.println("�ֻ��ֿ���������ͣ������");
				productList.wait();
			}
		}
		synchronized (productList) {
			//������Ʒ
			ProductBean bean = new ProductBean((i+1)+"", "�ֻ���"+(i+1)+"����");
			productList.add(bean);
			System.out.println("�ֻ���"+(i+1)+"����������ϣ�����⣡");
			//���Ѳֿ�
			productList.notifyAll();
		}
	}

}
