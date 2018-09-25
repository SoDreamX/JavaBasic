package cn.sxh.designPattern.prototype;

public abstract class ProtoType implements Cloneable {
	
	protected ProtoType clone(){
		ProtoType prototype = null;
		try {
			prototype = (ProtoType)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return prototype;
	}
	
	public abstract void show();
}
