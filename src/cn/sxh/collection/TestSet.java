package cn.sxh.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import cn.sxh.collection.bean.MyStrCompartor;
import cn.sxh.collection.bean.Student;

/**
 * Set:无序集合，不允许存放重复的元素；允许使用null元素
 * HashSet:哈希表，存储数据无序
 * LinkedHashSet:双链表，存储数据有序
 * TreeSet:使用元素的自然顺序对元素进行排序，或根据创建set时提供的Comparator进行排序；二叉树实现
 * @author Sxh
 * 2018年4月11日 上午9:24:59
 */
public class TestSet {
	
	public static void main(String[] args) {
		TestSet test = new TestSet();
		test.testHashSet();
		test.testTreeSet();
	}
	/**
	 * 外部有序遍历成员
	 * 1、可以自动排序(系统类  自然排序) 
	 * 2、不可重复(去重) 
	 * 3、只能存放一种数据类型 
	 */
	private void testTreeSet() {
		System.out.println("========TreeSet=========");
		MyStrCompartor comp = new MyStrCompartor();
		//TreeSet<String> ts = new TreeSet<String>(comp);
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("xiaomi32313");  
        ts.add("zhangliguo5");  
        ts.add("asima1");  
        ts.add("baibaibai4");  
        ts.add("sansan2");    
        System.out.println(ts);
		System.out.println("========TreeSet=========");
	}
	/**
	 * 外部无序的遍历成员
	 */
	private void testHashSet() {
		System.out.println("========HashSet=========");
		Set set = new HashSet();
		set.add("a");
		set.add("b");
		System.out.println(set);
		Student stu = new Student(18, "小名", 60);
		set.add(stu);
		set.add(new Student(19, "小明", 60));
		set.add(new Student(19, "小明", 60));
		set.add(new Student(20, "小明", 61));
		//判断对象是否重复，看的是对象的hashCode()取值是否一样
		System.out.println(set);
		System.out.println("========HashSet=========");
	}
}
