package cn.sxh.designPattern;
/**
 * ����ģʽ
 * ʹ�ó���:1.Ҫ������Ψһ���кŵĻ���
 * 		  2.����Ŀ����Ҫһ��������ʵ�������ݣ�����һ��ҳ���ϵļ�����
 * 		  3.����һ��������Ҫ���ĵ���Դ���࣬��Ҫ����IO�����ݿ���Դ��
 *        4.��Ҫ��������ľ�̬������̬��Դ���繤���ࣩ�Ļ���
 * @author Sxh
 * 2018��6��11�� ����5:19:10
 */
public class SingleTon {
	//�̰߳�ȫ��д��
	private static final SingleTon singleTon = new SingleTon();
	
	//����ֻ�ܲ���һ������
	private SingleTon() {
		
	}
	//ͨ���÷������ʵ������
	public static SingleTon getSingleTon() {
		return singleTon;
	}
	//��������,��������static
	public static void doSomething() {
		
	}
}
