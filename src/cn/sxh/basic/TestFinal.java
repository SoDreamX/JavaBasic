package cn.sxh.basic;

import java.util.ArrayList;
import java.util.List;

import cn.sxh.basic.assist.Bird;
/**
 * Final关键字
 * 可修饰，方法，成员变量和本地变量
 * (在方法中或在代码块中的变量称为本地变量)
 * 1.final修饰的类不能被继承，常见的final类有:String,Integer以及其他包装类等
 * 2.final修饰的方法不能被子类重写--比非final方法快，因为在编译时已经静态绑定了，不会在运行时动态绑定
 * 3.final修饰的基本数据类型变量值不能改变，修饰的引用类型变量不能修改其引用，可以修改其属性值
 * 
 * final关键字的好处
 * 1.final关键字提高了性能，java和JVM应用都会缓存final变量
 * 2.final变量可以安全的在多线程环境下进行共享，而不需要额外的同步消耗
 * 3.使用final关键字，JVM会对类、方法和变量进行优化
 * @author sxh
 */
public class TestFinal {
	//修饰成员变量，和static一起使用，作为常量，声明时必须初始化
	public static final String LRON = "lron";
	//final修饰的成员变量必须在声明时或在构造方法里初始化
	public final String TESTFINAL;
	//final修饰的集合可以增加删除，但不能更改引用
	private final List<String> Loans = new ArrayList<String>();	
	public TestFinal() {
		super();
		TESTFINAL = "testfinal";
	}
	//在匿名类中变量都必须是final变量
	public void testBird(final String name,final double mspeed){
		String fly = new Bird(name) {
			String color = "黄色";
			public String fly() {
				return color+"的"+name+"飞起来了,"+"速度为:"+mspeed;
			}
		}.fly();
		System.out.println(fly);
	}
	public static void main(String[] args) {
		TestFinal test = new TestFinal();
		test.testBird("百灵鸟", 0.25);
	}
}
