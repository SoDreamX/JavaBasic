package cn.sxh.arithmetic;
/**
 * 数组
 * @author Sxh
 * 2018年11月12日 下午2:23:47
 */
public class ArrayMetic {
	/**
	 * 选择排序--每一次从待排序的数据元素中选出最小的一个元素，存放在序列的起始位置，
	 * 		       直到全部待排序的数据元素排完。
	 */
	public static void testXZSort() {
		int[] array = {1,3,5,4,2,8,9,7,6,10};
		int len = array.length;
		int temp;
		System.out.print("排序前结果：");
		showArray(array);
		for(int i=0;i<len-1;i++) {
			int min = i;
			for(int j=i+1;j<len;j++) {
				if(array[min]>array[j]) {
					min = j;
				}
			}
			if(min!=i) {
				temp = array[min];
				array[min] = array[i];
				array[i] = temp;
			}
			System.out.print("第["+(i+1)+"]轮排序结果：");
			showArray(array);
		}
		System.out.print("最终排序结果：");
		showArray(array);
	}
	/**
	 * 冒泡排序：比较相邻的元素。如果第一个比第二个大，就交换他们两个。最后的元素会是最大的数。
	 */
	public static void testMPSort() {
		int[] array = {1,3,5,4,2,8,9,7,6,10};
		int len = array.length;
		int temp;
		System.out.print("排序前结果：");
		showArray(array);
		boolean flag;
		for(int i=1;i<len;i++) {
			flag = true;
			for(int j=0;j<len-i;j++) {
				if(array[j]>array[j+1]) {
					temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
					flag = false;
				}
			}
			System.out.print("第["+i+"]轮排序结果：");
			showArray(array);
			if(flag) {
				break;
			}
		}
		System.out.print("最终排序结果：");
		showArray(array);
	}
	/**
	 * 插入排序：每一步将一个待排序的记录，插入到前面已经排好序的有序序列中去，直到插完所有元素为止。
	 * 		  本例展示的是直接插入算法。
	 */
	public static void testCRSort() {
		int[] array = {1,3,5,4,2,8,9,7,6,10};
		int len = array.length;
		int temp;
		System.out.print("排序前结果：");
		showArray(array);
		int j;
		for(int i=1;i<len;i++) {
			//待插的数值
			temp = array[i];
			j = i;
			while(j>0 && temp<array[j-1]) {
				//往右移
				array[j] = array[j-1];
				j--;
			}
			array[j] = temp;
			System.out.print("第["+i+"]轮排序结果：");
			showArray(array);
		}
		System.out.print("最终排序结果：");
		showArray(array);
	}
	private static void showArray(int[] array) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i=0,len=array.length;i<len;i++) {
			sb.append(""+array[i]);
			if(i<len-1) {
				sb.append(",");
			}
		}
		sb.append("]");
		System.out.println(sb.toString());
	}
	public static void main(String[] args) {
		System.out.println("===========选择排序=============");
		testXZSort();
		System.out.println("===========冒泡排序=============");
		testMPSort();
		System.out.println("===========插入排序=============");
		testCRSort();
	}
}
