package cn.sxh.designPattern.factory;
/**
 * ����ģʽ�ʺϣ����ǳ����˴����Ĳ�Ʒ��Ҫ���������Ҿ��й�ͬ�Ľӿ�ʱ������ͨ����������ģʽ���д�����
 * @author Sxh
 * 2018��6��19�� ����11:18:45
 */
public class TestFactory {
	public static void main(String[] args) {
		//���󹤳�ģʽ����
		Provider factory = new SendMailFactory();
		Sender sender = factory.produce();
		sender.send();
	}
}
