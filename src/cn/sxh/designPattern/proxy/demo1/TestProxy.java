package cn.sxh.designPattern.proxy.demo1;

import java.lang.reflect.Proxy;

/**
 * 动态代理
 * @author Sxh
 * 2018年7月13日 下午12:00:15
 */
public class TestProxy {
	public static void main(String[] args) {
		Dao dao = new DaoImpl();
		Dao proxyDao = (Dao) Proxy.newProxyInstance(LogInvocationHandler.class.getClassLoader(),
				new Class<?>[] {Dao.class}, new LogInvocationHandler(dao));
		proxyDao.insert();
		System.out.println("=================分隔符==================");
		proxyDao.update();
		System.out.println("=================分隔符==================");
		proxyDao.delete();
	}
}
