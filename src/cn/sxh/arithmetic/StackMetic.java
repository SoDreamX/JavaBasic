package cn.sxh.arithmetic;

import java.util.Arrays;

/**
 * �Զ���ջ
 * @author Sxh
 * 2018��11��13�� ����1:29:31
 */
public class StackMetic {
	private int size;//ջ��С
	private Object[] dataArray;//ջ����
	private int top;//ջ��ָ��
	public StackMetic() {
		//�趨����ջ��С��Ĭ��Ϊ10
		this.size = 10;
		this.dataArray = new Object[10];
		this.top = -1;
	}	
	public StackMetic(int satckSize) {
		if(satckSize<0) {
			throw new IllegalArgumentException("ջ��ʼ��������С��0: "+satckSize);
		}
		this.size = satckSize;
		this.dataArray = new Object[satckSize];
		this.top = -1;
	}
	public Object push(Object item) {
		//�Ƿ���Ҫ����
		isGrow(top+1);
		dataArray[++top] = item;
		return item;
	}
	public Object pop() {
		if(isEmpty()) {
			return null;
		}
		Object item = peek();
		remove(top);
		return item;
	}
	/**
	 * ��ȡվ��Ԫ��
	 * @return
	 */
	public Object peek() {
		Object item = dataArray[top];
		return item;
	}
	/**
	 * ɾ��ջ��Ԫ��
	 * @return
	 */
	private void remove(int num) {
		dataArray[num]=null;
		this.top--;
	}
	public boolean isEmpty() {
		return top==-1;
	}
	public int getSize() {
		return size;
	}
	/**
	 * �ж��Ƿ���Ҫ����
	 * @param minCount
	 */
	private boolean isGrow(int minCount) {
		int oldCount = size;
		if(minCount >= oldCount) {
			//��������֮��ջ��������
            int newCount = 0;
			//�����������������ݣ�Ĭ����Ϊ����(����һλ)
			if((minCount<<1)<Integer.MAX_VALUE) {
				newCount = (minCount<<1);
			}else {
				newCount = Integer.MAX_VALUE;
			}
			size = newCount;
			dataArray = Arrays.copyOf(dataArray, newCount);
			return true;
		}else {
			return false;
		}
	}
}
