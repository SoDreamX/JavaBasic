package cn.sxh.designPattern.builder;
/**
 * ������ģʽ
 * ������ģʽ�ṩ���Ǵ����������ģʽ����������ģʽ���ǽ����ֲ�Ʒ�����������й��������������϶���.
 * ������һ�����⣬������Ҫ����һ��ѧ������������name,number,className,age,school�����ԣ�
 * ���ÿһ�����Զ�����Ϊ�գ�Ҳ����˵���ǿ���ֻ��һ��name,Ҳ������һ��school,name,����һ��class,number��
 * ������������ĸ�ֵ������һ��ѧ��������ʱ����ô���죿
 * @author Sxh
 * 2018��6��19�� ����1:34:43
 */
public class Builder {
	public static void main(String[] args) {
		Student s1 = new StudentBuilder().setName("A").setNumber("1").build();
		System.out.println(s1);
		Student s2 = new StudentBuilder().setName("B").setClassName("1-1").build();
		System.out.println(s2);
	}
}
