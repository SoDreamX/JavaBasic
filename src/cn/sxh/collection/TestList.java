package cn.sxh.collection;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * List:������б��������ظ���Ԫ��
 * ArrayList:����ʵ�֣���ѯ�죬��ɾ����������(�̲߳���ȫ)
 * LinkedList:˫������ʵ�֣���ѯ������ɾ��(�̲߳���ȫ)
 * Vector:����ʵ�֣�������(�̰߳�ȫ��ʹ����)
 * @author Sxh
 * 2018��4��10�� ����1:18:22
 */
public class TestList {
	/**
	 * �ṩ���ٵĻ��������ĳ�Ա����
	 */
	public void testArrayList() {
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("��ʼ����С��"+list.size());
		list.add("aaa");
		list.add("egg");
		list.add("hell");
		list.add("child");
		System.out.println("��ǰ������"+list.size());
		/* ��ArrayList�Ĵ�С��ʵ������Ԫ�صĴ�С����һ�� */    
		list.trimToSize();
		//����
		for(String s:list) {
			System.out.println(s);
		}
		//ָ��λ�ò�������
		list.add(2, "zhu");
		//����
		for(String s:list) {
			System.out.println(s);
		}
		System.out.println("------------------");
		//���list
		list.clear();
		//����
		for(String s:list) {
			System.out.println(s);
		}
		System.out.println("------------------");
	}
	/**
	 * ˫������ʵ�֣���ѯ������ɾ��
	 */
	public void testLinkedList() {
		LinkedList<Integer> link = new LinkedList<>();
		System.out.println(link.size());
		//���Ԫ��
		link.add(222);
		link.add(111);
		link.add(0);
		link.add(3333);
		link.add(8888);
		System.out.println(link.size());
		//����
		for(int i:link) {
			System.out.println(i);
		}
		/* ��ȡ��һ��Ԫ�� ,��header��next��*/    
        System.out.println("��һ��Ԫ����:" + link.getFirst());       
        /*��ȡ���һ��Ԫ��,��header��previous��*/    
        System.out.println("���һ��Ԫ����:"+link.getLast()); 
	}
	public static void main(String[] args) {
		TestList test = new TestList();
		test.testArrayList();
		test.testLinkedList();
	}
}
