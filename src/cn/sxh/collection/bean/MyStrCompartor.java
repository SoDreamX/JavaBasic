package cn.sxh.collection.bean;

import java.util.Comparator;
/**
 * �ⲿ�Ƚ�������ϵͳ���ṩ�ıȽϹ������㲻������ʱʹ�� 
 *   1���Լ�����һ���Ƚ���  ʵ��  Comprator�ӿ� �����һ�����ͣ���Ҫ�Ƚϵ��������ͣ� 
 *   2����дcomprae����,�����Ƚ�,������������Ҫ�ȽϵĶ��� 
 * @author Sxh
 * 2018��4��11�� ����10:28:18
 */
public class MyStrCompartor implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		//�����ַ�����������
		return o1.length()-o2.length();
	}

}
