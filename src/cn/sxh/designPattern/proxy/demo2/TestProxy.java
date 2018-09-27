package cn.sxh.designPattern.proxy.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestProxy {
	private static String nginxUrl = "http://10.228.228.7/NRMS";
	
	public static void main(String[] args) {
		MTServer server = new MTNrmsServer();
		InvocationHandler invocation = new NginxIInvocationHandler(server);
		MTServer proxy = (MTServer)Proxy.newProxyInstance(
				NginxIInvocationHandler.class.getClassLoader(), new Class[] {MTServer.class},
				invocation);
		String serverName = "";
		for(int i=0;i<10;i++) {
			serverName = proxy.getServerName(nginxUrl);
			System.out.println("serverName===================="+serverName);
		}
	}
}
