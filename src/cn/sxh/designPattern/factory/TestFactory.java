package cn.sxh.designPattern.factory;
/**
 * 工厂模式适合：凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法模式进行创建。
 * @author Sxh
 * 2018年6月19日 上午11:18:45
 */
public class TestFactory {
	public static void main(String[] args) {
		//抽象工厂模式测试
		Provider factory = new SendMailFactory();
		Sender sender = factory.produce();
		sender.send();
	}
}
