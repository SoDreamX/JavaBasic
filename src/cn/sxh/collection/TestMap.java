package cn.sxh.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * MAP:�����ֵ�Գ�Ա�����ڼ���ֵ������compareTo��compare�����Լ�����
 * @author Sxh
 * 2018��4��9�� ����11:33:17
 */
public class TestMap {
	/**
	 * ��ֵ�ԣ�key�����ظ���value�����ظ�������null�ļ���ֵ
	 */
	public void testHashMap() {
		Map<String, Integer> hash = new HashMap<String, Integer>();
		System.out.println("HashMap�ĳ�ʼֵ:"+hash.size());
		System.out.println("hashMap�Ƿ�Ϊ��:"+(hash.isEmpty()?"��":"��"));
		//���Ԫ��
		hash.put("erqing", 1);
		hash.put("niuniu", 2);
		hash.put("egg", 3);
		System.out.println(hash.size());
		System.out.println("hashMap�Ƿ�Ϊ��:"+(hash.isEmpty()?"��":"��"));
		//����Ԫ��
		Set<String> set = hash.keySet();
		for(String s:set) {
			System.out.println(s+"---"+hash.get(s)+",hashcode---"+s.hashCode());
		}
		System.out.println(hash.containsKey("egg"));
		System.out.println(hash.containsValue(2));
		System.out.println(hash.hashCode());
	}
	
	public static void main(String[] args) {
		TestMap test = new TestMap();
		test.testHashMap();
	}
}
