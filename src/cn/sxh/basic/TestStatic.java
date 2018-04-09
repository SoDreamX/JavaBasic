package cn.sxh.basic;
//导入java.lang.System类的静态变量out，可以在本类中直接使用out静态变量
import static java.lang.System.out;
//导入java.lang.Integer的所有静态变量和属性,可直接使用
import static java.lang.Integer.*;

/**
 * static
 * @author sxh
 * static修饰变量、修饰方法
 * 静态块、静态内部类、静态导包
 * static不能修饰类
 * static变量存放在方法区中
 */
public class TestStatic {
	/**
	 * 修饰变量
	 * static修饰的变量是类成员变量，可以由类直接调用，是所有对象所共有的
	 * 某一个对象改变了变量的值，另一对象访问时变量为最新的值
	 */
	private static String mstr = "static";
	
	private String mname = "静态"; 
	
	public static int a = 1;
	public static int b;
	public final static String FINALVALUE = "finalvalue"; 
	
	public TestStatic(){
		System.out.println("调用构造函数!");
	}
	/**
	 * 静态块--static{}
	 * 仅在类被加载的时候执行且仅会被执行一次，
	 * 一般用来初始化静态变量和调用静态方法
	 */
	static{
		System.out.println("调用静态代码块!");
		b = (a+1)*2;
		funcCheck();
	}
	
	public static void funcCheck(){
		System.out.println("调用静态方法!");
		System.out.println("b--------"+b);
	}
	
	/**
	 * 修饰方法
	 * 1.只能调用其他的static方法
	 * 2.只能访问static数据
	 * 3.不能用任何方式引用this和super
	 */
	public static void funcStatic(String type){
		//System.out.println(mname);   //错误
		//mstr+=mname;				   //错误
		System.out.println(mstr+"-"+type);
		mstr+="-x";
		//funcTest();//错误
		//String str = this.mnane;//错误
	}
	
	public void funcTest(){
		String testStr = mstr+"-"+mname;
		System.out.println(testStr);
		funcStatic("funcTest");
		String str = TestStatic.mstr+":"+this.mname;
		System.out.println(str);
	}
	/**
	 * main方法是最常见的static方法
	 * @param args
	 */
	public static void main(String[] args) {
		funcStatic("1");
		TestStatic.funcStatic("2");
		TestStatic test = new TestStatic();
		test.funcTest();
	}
	/**
	 * 静态内部类
	 * 静态内部类可以有静态成员也可以有非静态成员，
	 * 但是静态内部类中的成员函数却不可以访问外部类中的非静态变量和函数，
	 * 哪怕内部类中的非静态函数！
	 * 类B中可以申请到A的对象实例，不过注意不用直接用A，而是Test.A!
	 * @author sxh
	 */
	public static class A{
		public A(){
			System.out.println("静态内部类A的构造方法!");
		}
	}
	/**
	 * 测试静态导包
	 */
	public void testImport(){
		out.println(MAX_VALUE);
		out.println(toHexString(42));
		out.print(b);
	}
}
