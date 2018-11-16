package cn.sxh.arithmetic;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 算法工具类
 * @author Sxh
 * 2018年11月15日 下午1:59:54
 */
public class MeticUtil {
	private MeticUtil() {}
	/**
	 * 二分折半查找
	 * 使用循环实现
	 * @param array
	 * @param key
	 * @param comp
	 * @return
	 */
	public static <T> int binaryLoopSearch(T[] array,T key,Comparator<T> comp) {
		int low = 0;
		int height = array.length-1;
		while(low <= height) {
			int mid = (low + height)>>>1;
			int num = comp.compare(key, array[mid]);
			if(num < 0) {
				height = mid-1;
			}else if(num > 0) {
				low = mid+1;
			}else {
				return mid;
			}
		}
		return -1;
	}
	/**
	 * 二分折半查找
	 * 使用循环实现
	 * @param array
	 * @param key
	 * @return
	 */
	public static <T extends Comparable<T>> int binaryLoopSearch(T[] array,T key) {
		int low = 0;
		int height = array.length-1;
		while(low <= height) {
			int mid = (low + height)>>>1;
			int num = key.compareTo(array[mid]);
			if(num < 0) {
				height = mid-1;
			}else if(num > 0) {
				low = mid+1;
			}else {
				return mid;
			}
		}
		return -1;
	}
	/**
	 * 递归实现二分折半查询
	 * @param array
	 * @param key
	 * @return
	 */
	public static <T extends Comparable<T>> int binarySearch(T[] array,T key) {	
		return binarySearch(array, 0, array.length-1, key);
	}
	
	public static <T extends Comparable<T>> int binarySearch(T[] array, int low, int height, T key) {
		if(low <= height) {
			//为防止low + height超过最大整数值，使用右移取中间值(>>>是逻辑右移，是不带符号位的右移)
			int mid = (low + height)>>>1;
			int comp = array[mid].compareTo(key);
			if(comp<0) {
				low = mid+1;
				return binarySearch(array,low,height,key);
			}else if(comp>0) {
				height = mid-1;
				return binarySearch(array,low,height,key);
			}else {
				return mid;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		String [] array = {"asss","dsss","esss","bsss","csss","fsss"};
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		String key = "msss";
		int index = MeticUtil.binarySearch(array, key);
		System.out.println(index);
		System.out.println(MeticUtil.binaryLoopSearch(array, key));
	}
}
