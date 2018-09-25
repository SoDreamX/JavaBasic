package cn.sxh.designPattern.prototype;

public class Client {
	public static void main(String[] args) {
		ConcreteProtoType cp = new ConcreteProtoType();
		for (int i = 0; i < 10; i++)
        {
			ConcreteProtoType clonecp = (ConcreteProtoType)cp.clone();
            clonecp.show();
        }
	}
}
