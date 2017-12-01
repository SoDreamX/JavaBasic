package cn.sxh.basic;

import cn.sxh.basic.TestStatic;
/**
 * @author sxh
 * java内存分成4块,
 * 一块是堆,用来存放new的对象,
 * 一个是栈,用来存放局部变量,(基础数据类型的对象和自定义对象的引用(不是对象))
 * 然后就是静态变量区,存放常量,静态变量,
 * 以及代码区,存放代码
 */
public class Test {
	public void testStatic(){
		
		try {
			//加载类
			Class.forName("sxh.basic.TestStatic");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//调用类的静态方法时会加载类
		TestStatic.funcStatic("test");
		//调用类的静态变量时会加载类
		System.out.println(TestStatic.b);
		//调用类的静态常量的时候，是不会加载类
		System.out.println(TestStatic.FINALVALUE);
	}
	
	public static void main(String[] args) {
		
	}
	
}
