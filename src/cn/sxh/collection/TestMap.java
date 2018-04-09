package cn.sxh.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * MAP:保存键值对成员，基于键找值操作，compareTo或compare方法对键排序
 * @author Sxh
 * 2018年4月9日 上午11:33:17
 */
public class TestMap {
	/**
	 * 键值对，key不能重复，value可以重复；允许null的键或值
	 */
	public void testHashMap() {
		Map<String, Integer> hash = new HashMap<String, Integer>();
		System.out.println("HashMap的初始值:"+hash.size());
		System.out.println("hashMap是否为空:"+(hash.isEmpty()?"是":"否"));
		//添加元素
		hash.put("erqing", 1);
		hash.put("niuniu", 2);
		hash.put("egg", 3);
		System.out.println(hash.size());
		System.out.println("hashMap是否为空:"+(hash.isEmpty()?"是":"否"));
		//遍历元素
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
