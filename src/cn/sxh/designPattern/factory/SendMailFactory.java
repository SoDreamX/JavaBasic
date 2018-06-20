package cn.sxh.designPattern.factory;

public class SendMailFactory implements Provider {

	@Override
	public Sender produce() {
		Sender sender = new MailSender();
		return sender;
	}

}
