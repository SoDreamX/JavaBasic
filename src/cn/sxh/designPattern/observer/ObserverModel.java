package cn.sxh.designPattern.observer;

public class ObserverModel implements ObserverInterface{
	private String status;
	private String name;
	
	public ObserverModel(String name) {
		this.name = name;
	}
	
	@Override
	public void update(String status) {
		this.status = status;
		System.out.println("观察者【"+this.name+"】状态改变为========="+this.status);
	}

}
