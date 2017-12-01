package cn.sxh.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * foreach语句是java5的新特征之一
 * 增强for循环
 * @author sxh
 * 2017年12月1日 下午3:23:03
 */
public class Testforeach {
	/**
	*foreach语句输出一维数组
	*/
	public void test1(){
		//定义并初始化一个数组
		int arr[]={2,3,1};
		System.out.println("----1----排序前的一维数组");
		for(int x:arr){
			System.out.println(x);//逐个输出数组元素的值
		}
		//对数组排序
		Arrays.sort(arr);
		//利用java新特性foreach循环输出数组
		System.out.println("----1----排序后的一维数组");
		for(int x:arr){
			System.out.println(x);//逐个输出数组元素的值
		}
	}
	/**
	*集合转换为一维数组
	*/
	public void listToArray(){
		//创建List并添加元素
		List<String>list=new ArrayList<String>();
		list.add("1");
		list.add("3");
		list.add("4");
		
		//利用froeach语句输出集合元素
		System.out.println("----2----froeach语句输出集合元素");
		for(String x:list){
			System.out.println(x);
		}
		
		//将ArrayList转换为数组
		Object s[]=list.toArray();
		
		//利用froeach语句输出集合元素
		System.out.println("----2----froeach语句输出集合转换而来的数组元素");
		for(Object x:s){
			System.out.println(x.toString());//逐个输出数组元素的值
		}
	}
	
	/**
	*foreach输出二维数组测试
	*/
	public void testArray2(){
		int arr2[][]={{4,3},{1,2}};
		System.out.println("----3----foreach输出二维数组测试");
		for(int x[]:arr2){
			for(int e:x){
				System.out.println(e);//逐个输出数组元素的值
			}
		}
	}
}
