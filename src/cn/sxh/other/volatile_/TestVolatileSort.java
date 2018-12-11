package cn.sxh.other.volatile_;
/**
 * volatile禁止指令重排序
 * 重排序是指编译器和处理器为了优化程序性能而对指令序列进行排序的一种手段。
 * 1.重排序操作不会对存在数据依赖关系的操作进行重排序。（例：int a=1; int b=a+1;）
 * 2.重排序是为了优化性能，但是不管怎么重排序，单线程下程序的执行结果不能被改变
 * @author Sxh
 * 2018年12月7日 下午3:35:10
 */
public class TestVolatileSort {
	
}
