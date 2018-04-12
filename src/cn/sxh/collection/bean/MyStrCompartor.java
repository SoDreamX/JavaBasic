package cn.sxh.collection.bean;

import java.util.Comparator;
/**
 * 外部比较器，当系统类提供的比较规则满足不了需求时使用 
 *   1、自己创建一个比较器  实现  Comprator接口 ，添加一个泛型（需要比较的数据类型） 
 *   2、重写comprae方法,用来比较,参数是两个需要比较的对象 
 * @author Sxh
 * 2018年4月11日 上午10:28:18
 */
public class MyStrCompartor implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		//按照字符串长度排序
		return o1.length()-o2.length();
	}

}
