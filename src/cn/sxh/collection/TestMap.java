package cn.sxh.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * MAP:保存键值对成员，基于键找值操作，compareTo或compare方法对键排序
 * HashMap:键值对，key不能重复，value可以重复；允许null的键或值
 * Hashtable:线程安全，不允许null键或值
 * @author Sxh
 * 2018年4月9日 上午11:33:17
 */
public class TestMap {
	/**
	 * 键值对，key不能重复，value可以重复；允许null的键或值
	 * HashMap线程同步的方法：
	 * ①.Map<Integer,String> hashMap = new HashMap<Integer,String>();
	 * 	 hashMap = Collections.syncchronizedMap(hashMap);
	 * ②.ConcurrentHashMap<Integer,String> map = new ConcurrentHashMap<Integer,String>();
	 */
	public void testHashMap() {
		Map<String, Integer> hash = new HashMap<String, Integer>();
		//HashMap同步方法
		//Collections.synchronizedMap(hash);
		System.out.println("HashMap的初始值:"+hash.size());
		System.out.println("hashMap是否为空:"+(hash.isEmpty()?"是":"否"));
		//添加元素
		hash.put("erqing", 1);
		hash.put("niuniu", 2);
		hash.put("egg", 3);
		System.out.println(hash.size());
		System.out.println("hashMap是否为空:"+(hash.isEmpty()?"是":"否"));
		//遍历元素--无序
		Set<String> set = hash.keySet();
		for(String s:set) {
			System.out.println(s+"---"+hash.get(s)+",hashcode---"+s.hashCode());
		}
		System.out.println(hash.containsKey("egg"));
		System.out.println(hash.containsValue(2));
		System.out.println(hash.hashCode());
	}
	/**
	 * TreeMap--对key排好序的map;key就是TreeSet,value对应每个key
	 */
	public void testTreeMap() {
		Map<String,Integer> map = new TreeMap<>();
		//添加
		map.put("zgg", 1);
		map.put("erqing", 3);
		map.put("niu", 0);
		map.put("abc", 2);
		map.put("aaa", 5);
		//遍历--有序
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
