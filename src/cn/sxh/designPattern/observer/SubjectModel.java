package cn.sxh.designPattern.observer;

public class SubjectModel extends Subject {
	private String status;
	public String getStatus() {
		return status;
	}
	public void change(String status) {
		this.status = status;
		System.out.println("�������ı�״̬Ϊ��"+status+"��,֪ͨ���й۲��߸ı�״̬��");
		this.notifyObserver(status);
	}
	
	public static void main(String[] args) {
		//����
		//�������
		SubjectModel subject = new SubjectModel();
		//�۲���1
		ObserverInterface observer1 = new ObserverModel("�ŷ�");
		//�۲���2
		ObserverInterface observer2 = new ObserverModel("����");
		subject.addObserver(observer1);
		subject.addObserver(observer2);
		
		subject.change("ȫ��������");
	}
}
