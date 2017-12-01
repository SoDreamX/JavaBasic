package cn.sxh.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import cn.sxh.basic.assist.User;

/**
 * 使用transient关键字不序列化变量
 * @author sxh
 * 2017年11月30日 下午5:17:01
 * 1）一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。
 * 2）transient关键字只能修饰变量，而不能修饰方法和类。注意，本地变量是不能被transient关键字修饰的。变量如果是用户自定义类变量，则该类需要实现Serializable接口。
 * 3）被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化。
 */
public class TestTransient {
	public static void test(){
		User user = new User();
		user.setUserName("username");
		user.setPassword("password");
		
		//序列化开始
		System.out.println("序列化之前:"+"用户名-"+user.getUserName()+";密码-"+user.getPassword());
		try {
			ObjectOutputStream ops = new ObjectOutputStream(new FileOutputStream("E:/user.txt"));
			ops.writeObject(user);
			ops.flush();
			ops.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//序列化完毕
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:/user.txt"));
			user = (User)ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("序列化对象后："+"用户名-"+user.getUserName()+";密码-"+user.getPassword());
	}
	public static void main(String[] args) {
		test();
	}
}
