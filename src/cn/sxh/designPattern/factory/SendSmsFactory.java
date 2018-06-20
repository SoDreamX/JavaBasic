package cn.sxh.designPattern.factory;

public class SendSmsFactory implements Provider {

	@Override
	public Sender produce() {
		Sender sender = new SmsSender();
		return sender;
	}

}
