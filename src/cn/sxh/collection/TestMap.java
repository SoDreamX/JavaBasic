package cn.sxh.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * MAP:�����ֵ�Գ�Ա�����ڼ���ֵ������compareTo��compare�����Լ�����
 * HashMap:��ֵ�ԣ�key�����ظ���value�����ظ�������null�ļ���ֵ
 * Hashtable:�̰߳�ȫ��������null����ֵ
 * @author Sxh
 * 2018��4��9�� ����11:33:17
 */
public class TestMap {
	/**
	 * ��ֵ�ԣ�key�����ظ���value�����ظ�������null�ļ���ֵ
	 * HashMap�߳�ͬ���ķ�����
	 * ��.Map<Integer,String> hashMap = new HashMap<Integer,String>();
	 * 	 hashMap = Collections.syncchronizedMap(hashMap);
	 * ��.ConcurrentHashMap<Integer,String> map = new ConcurrentHashMap<Integer,String>();
	 */
	public void testHashMap() {
		Map<String, Integer> hash = new HashMap<String, Integer>();
		//HashMapͬ������
		//Collections.synchronizedMap(hash);
		System.out.println("HashMap�ĳ�ʼֵ:"+hash.size());
		System.out.println("hashMap�Ƿ�Ϊ��:"+(hash.isEmpty()?"��":"��"));
		//���Ԫ��
		hash.put("erqing", 1);
		hash.put("niuniu", 2);
		hash.put("egg", 3);
		System.out.println(hash.size());
		System.out.println("hashMap�Ƿ�Ϊ��:"+(hash.isEmpty()?"��":"��"));
		//����Ԫ��--����
		Set<String> set = hash.keySet();
		for(String s:set) {
			System.out.println(s+"---"+hash.get(s)+",hashcode---"+s.hashCode());
		}
		System.out.println(hash.containsKey("egg"));
		System.out.println(hash.containsValue(2));
		System.out.println(hash.hashCode());
	}
	/**
	 * TreeMap--��key�ź����map;key����TreeSet,value��Ӧÿ��key
	 */
	public void testTreeMap() {
		Map<String,Integer> map = new TreeMap<>();
		//���
		map.put("zgg", 1);
		map.put("erqing", 3);
		map.put("niu", 0);
		map.put("abc", 2);
		map.put("aaa", 5);
		//����--����
		Set<String> set = map.keySet();
		for(String s:set) {
			System.out.println(map.get(s)+"--"+s);
		}
	}
	
	public static void main(String[] args) {
		TestMap test = new TestMap();
		test.testHashMap();
		test.testTreeMap();
	}
}
