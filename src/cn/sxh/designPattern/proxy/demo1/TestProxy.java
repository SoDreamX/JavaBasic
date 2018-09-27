package cn.sxh.designPattern.proxy.demo1;

import java.lang.reflect.Proxy;

/**
 * ��̬����
 * @author Sxh
 * 2018��7��13�� ����12:00:15
 */
public class TestProxy {
	public static void main(String[] args) {
		Dao dao = new DaoImpl();
		Dao proxyDao = (Dao) Proxy.newProxyInstance(LogInvocationHandler.class.getClassLoader(),
				new Class<?>[] {Dao.class}, new LogInvocationHandler(dao));
		proxyDao.insert();
		System.out.println("=================�ָ���==================");
		proxyDao.update();
		System.out.println("=================�ָ���==================");
		proxyDao.delete();
	}
}
