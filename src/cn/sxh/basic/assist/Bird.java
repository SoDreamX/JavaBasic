package cn.sxh.basic.assist;
/**
 * @author sxh
 * @version 
 */
public abstract class Bird {
	private String name;
	
	public Bird(String name){
		this.name = name;
	}
	public abstract String fly();
}
