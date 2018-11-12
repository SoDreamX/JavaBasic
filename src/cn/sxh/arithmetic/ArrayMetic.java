package cn.sxh.arithmetic;
/**
 * ����
 * @author Sxh
 * 2018��11��12�� ����2:23:47
 */
public class ArrayMetic {
	/**
	 * ѡ������--ÿһ�δӴ����������Ԫ����ѡ����С��һ��Ԫ�أ���������е���ʼλ�ã�
	 * 		       ֱ��ȫ�������������Ԫ�����ꡣ
	 */
	public static void testXZSort() {
		int[] array = {1,3,5,4,2,8,9,7,6,10};
		int len = array.length;
		int temp;
		System.out.print("����ǰ�����");
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
			System.out.print("��["+(i+1)+"]����������");
			showArray(array);
		}
		System.out.print("������������");
		showArray(array);
	}
	/**
	 * ð�����򣺱Ƚ����ڵ�Ԫ�ء������һ���ȵڶ����󣬾ͽ�����������������Ԫ�ػ�����������
	 */
	public static void testMPSort() {
		int[] array = {1,3,5,4,2,8,9,7,6,10};
		int len = array.length;
		int temp;
		System.out.print("����ǰ�����");
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
			System.out.print("��["+i+"]����������");
			showArray(array);
			if(flag) {
				break;
			}
		}
		System.out.print("������������");
		showArray(array);
	}
	/**
	 * ��������ÿһ����һ��������ļ�¼�����뵽ǰ���Ѿ��ź��������������ȥ��ֱ����������Ԫ��Ϊֹ��
	 * 		  ����չʾ����ֱ�Ӳ����㷨��
	 */
	public static void testCRSort() {
		int[] array = {1,3,5,4,2,8,9,7,6,10};
		int len = array.length;
		int temp;
		System.out.print("����ǰ�����");
		showArray(array);
		int j;
		for(int i=1;i<len;i++) {
			//�������ֵ
			temp = array[i];
			j = i;
			while(j>0 && temp<array[j-1]) {
				//������
				array[j] = array[j-1];
				j--;
			}
			array[j] = temp;
			System.out.print("��["+i+"]����������");
			showArray(array);
		}
		System.out.print("������������");
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
		System.out.println("===========ѡ������=============");
		testXZSort();
		System.out.println("===========ð������=============");
		testMPSort();
		System.out.println("===========��������=============");
		testCRSort();
	}
}
