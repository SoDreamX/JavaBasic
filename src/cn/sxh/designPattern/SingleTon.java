package cn.sxh.designPattern;
/**
 * 单例模式
 * 使用场景:1.要求生成唯一序列号的环境
 * 		  2.在项目中需要一个共享访问点或共享数据，比如一个页面上的计数器
 * 		  3.创建一个对象需要消耗的资源过多，如要访问IO或数据库资源等
 *        4.需要定义大量的静态常量或静态资源（如工具类）的环境
 * @author Sxh
 * 2018年6月11日 下午5:19:10
 */
public class SingleTon {
	//线程安全的写法
	private static final SingleTon singleTon = new SingleTon();
	
	//限制只能产生一个对象
	private SingleTon() {
		
	}
	//通过该方法获得实例对象
	public static SingleTon getSingleTon() {
		return singleTon;
	}
	//其他方法,尽量都用static
	public static void doSomething() {
		
	}
}
