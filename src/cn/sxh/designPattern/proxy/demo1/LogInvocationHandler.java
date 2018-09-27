package cn.sxh.designPattern.proxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInvocationHandler implements InvocationHandler {
	private Object obj;
	public LogInvocationHandler(Object obj) {
		this.obj = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String methodName = method.getName();
		System.out.println("��������==========="+methodName);
		if("insert".equalsIgnoreCase(methodName)||"update".equalsIgnoreCase(methodName)) {
			System.out.println("����"+methodName+"ǰ��ӡ��־��Ϣ��");
			Object result = method.invoke(obj, args);
			System.out.println("����"+methodName+"���ӡ��־��Ϣ��");
			return result;
		}
		return method.invoke(obj, args);
	}

}
