package cn.sxh.designPattern.observer;

public class SubjectModel extends Subject {
	private String status;
	public String getStatus() {
		return status;
	}
	public void change(String status) {
		this.status = status;
		System.out.println("主题对象改变状态为【"+status+"】,通知所有观察者改变状态。");
		this.notifyObserver(status);
	}
	
	public static void main(String[] args) {
		//测试
		//主题对象
		SubjectModel subject = new SubjectModel();
		//观察者1
		ObserverInterface observer1 = new ObserverModel("张飞");
		//观察者2
		ObserverInterface observer2 = new ObserverModel("赵云");
		subject.addObserver(observer1);
		subject.addObserver(observer2);
		
		subject.change("全军进攻！");
	}
}
