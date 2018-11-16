package cn.sxh.arithmetic;

import java.util.Arrays;
import java.util.Comparator;

/**
 * �㷨������
 * @author Sxh
 * 2018��11��15�� ����1:59:54
 */
public class MeticUtil {
	private MeticUtil() {}
	/**
	 * �����۰����
	 * ʹ��ѭ��ʵ��
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
	 * �����۰����
	 * ʹ��ѭ��ʵ��
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
	 * �ݹ�ʵ�ֶ����۰��ѯ
	 * @param array
	 * @param key
	 * @return
	 */
	public static <T extends Comparable<T>> int binarySearch(T[] array,T key) {	
		return binarySearch(array, 0, array.length-1, key);
	}
	
	public static <T extends Comparable<T>> int binarySearch(T[] array, int low, int height, T key) {
		if(low <= height) {
			//Ϊ��ֹlow + height�����������ֵ��ʹ������ȡ�м�ֵ(>>>���߼����ƣ��ǲ�������λ������)
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
