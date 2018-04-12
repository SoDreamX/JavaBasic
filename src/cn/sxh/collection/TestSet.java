package cn.sxh.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import cn.sxh.collection.bean.MyStrCompartor;
import cn.sxh.collection.bean.Student;

/**
 * Set:���򼯺ϣ����������ظ���Ԫ�أ�����ʹ��nullԪ��
 * HashSet:��ϣ���洢��������
 * LinkedHashSet:˫�����洢��������
 * TreeSet:ʹ��Ԫ�ص���Ȼ˳���Ԫ�ؽ������򣬻���ݴ���setʱ�ṩ��Comparator�������򣻶�����ʵ��
 * @author Sxh
 * 2018��4��11�� ����9:24:59
 */
public class TestSet {
	
	public static void main(String[] args) {
		TestSet test = new TestSet();
		test.testHashSet();
		test.testTreeSet();
	}
	/**
	 * �ⲿ���������Ա
	 * 1�������Զ�����(ϵͳ��  ��Ȼ����) 
	 * 2�������ظ�(ȥ��) 
	 * 3��ֻ�ܴ��һ���������� 
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
	 * �ⲿ����ı�����Ա
	 */
	private void testHashSet() {
		System.out.println("========HashSet=========");
		Set set = new HashSet();
		set.add("a");
		set.add("b");
		System.out.println(set);
		Student stu = new Student(18, "С��", 60);
		set.add(stu);
		set.add(new Student(19, "С��", 60));
		set.add(new Student(19, "С��", 60));
		set.add(new Student(20, "С��", 61));
		//�ж϶����Ƿ��ظ��������Ƕ����hashCode()ȡֵ�Ƿ�һ��
		System.out.println(set);
		System.out.println("========HashSet=========");
	}
}
