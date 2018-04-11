package cn.sxh.collection;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * List:有序的列表，允许存放重复的元素
 * ArrayList:数组实现，查询快，增删慢，轻量级(线程不安全)
 * LinkedList:双向链表实现，查询慢，增删快(线程不安全)
 * Vector:数组实现，重量级(线程安全，使用少)
 * @author Sxh
 * 2018年4月10日 下午1:18:22
 */
public class TestList {
	/**
	 * 提供快速的基于索引的成员访问
	 */
	public void testArrayList() {
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("初始化大小："+list.size());
		list.add("aaa");
		list.add("egg");
		list.add("hell");
		list.add("child");
		System.out.println("当前容量："+list.size());
		/* 将ArrayList的大小和实际所含元素的大小设置一致 */    
		list.trimToSize();
		//遍历
		for(String s:list) {
			System.out.println(s);
		}
		//指定位置插入数据
		list.add(2, "zhu");
		//遍历
		for(String s:list) {
			System.out.println(s);
		}
		System.out.println("------------------");
		//清空list
		list.clear();
		//遍历
		for(String s:list) {
			System.out.println(s);
		}
		System.out.println("------------------");
	}
	/**
	 * 双向链表实现，查询慢，增删快
	 */
	public void testLinkedList() {
		LinkedList<Integer> link = new LinkedList<>();
		System.out.println(link.size());
		//添加元素
		link.add(222);
		link.add(111);
		link.add(0);
		link.add(3333);
		link.add(8888);
		System.out.println(link.size());
		//遍历
		for(int i:link) {
			System.out.println(i);
		}
		/* 获取第一个元素 ,即header的next域*/    
        System.out.println("第一个元素是:" + link.getFirst());       
        /*获取最后一个元素,即header的previous域*/    
        System.out.println("最后一个元素是:"+link.getLast()); 
	}
	public static void main(String[] args) {
		TestList test = new TestList();
		test.testArrayList();
		test.testLinkedList();
	}
}
