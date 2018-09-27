package cn.sxh.designPattern.proxy.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.UUID;

public class NginxIInvocationHandler implements InvocationHandler {
	private String[] ips = {"10.228.242.130","10.228.242.143"};
	private Object object;
	public NginxIInvocationHandler(Object object) {
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String remoteIp = UUID.randomUUID().toString();
		int index = Math.abs(remoteIp.hashCode()) % ips.length;
		String realSinaIp = ips[index];
		
		StringBuilder sb = new StringBuilder();
		sb.append("【页面标题：");
		sb.append(method.invoke(object, args));
		sb.append("】,【来源Ip：");
		sb.append(realSinaIp);
		sb.append("】");
		
		return sb.toString();
	}

}
