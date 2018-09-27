package cn.sxh.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	private List<ObserverInterface> observers = new ArrayList<ObserverInterface>();
	
	public void addObserver(ObserverInterface observer) {
		this.observers.add(observer);
	}
	
	public void delObserver(ObserverInterface observer) {
		this.observers.remove(observer);
	}
	
	public void notifyObserver(String status) {
		for(ObserverInterface observer:this.observers) {
			observer.update(status);
		}
	}
}
