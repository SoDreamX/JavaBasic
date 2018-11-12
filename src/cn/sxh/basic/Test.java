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
		Test test = new Test();
		test.testIntern();
	}
	
	public void testByte() {
		int i = 100;
		byte b = (byte) i;
		System.out.println(b);
		
		i = 130;
		b = (byte) i;
		System.out.println(b);
	}
	
	public void testShort() {
		short s1 = 1;
		//s1 = s1+1;
		s1+=1;
		System.out.println(s1);
	}
	public void testInteger() {
		Integer s1=120,s2=120,s3=150,s4=150;
		System.out.println("s1==s2:"+(s1==s2));
		System.out.println("s3==s4:"+(s3==s4));
	}
	public void testIntern() {
		String s3 = new String("1") + new String("1");
	    s3.intern();
	    String s4 = "11";
	    System.out.println(s3 == s4);
	    String s5 = new String("22");
	    s5.intern();
	    String s6 = "22";
	    System.out.println(s5 == s6);
	    System.out.println(s5.intern() == s6);
		//true -- jdk6返回false;jdk7中intern时，如果这个字符串在常量池中是第一次出现，
		//则不会重新创建对象，直接返回它在堆中的引用
		String s1 = new StringBuilder("go")
		    .append("od").toString();
		System.out.println(s1.intern() == s1);
		//false  -- java已存在于常量池中
		String s2 = new StringBuilder("ja")
			    .append("va").toString();
		System.out.println(s2.intern() == s2);
	}
	
	public void testString() {
		String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s5);//true
        System.out.println(s1 == s6);//false
        System.out.println(s1 == s6.intern());//true
        System.out.println(s2 == s2.intern());//false
	}
}
