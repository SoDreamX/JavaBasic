package cn.sxh.arithmetic;

import java.util.Arrays;

/**
 * 自定义栈
 * @author Sxh
 * 2018年11月13日 下午1:29:31
 */
public class StackMetic {
	private int size;//栈大小
	private Object[] dataArray;//栈数据
	private int top;//栈顶指针
	public StackMetic() {
		//设定不传栈大小，默认为10
		this.size = 10;
		this.dataArray = new Object[10];
		this.top = -1;
	}	
	public StackMetic(int satckSize) {
		if(satckSize<0) {
			throw new IllegalArgumentException("栈初始容量不能小于0: "+satckSize);
		}
		this.size = satckSize;
		this.dataArray = new Object[satckSize];
		this.top = -1;
	}
	public Object push(Object item) {
		//是否需要扩容
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
	 * 获取站定元素
	 * @return
	 */
	public Object peek() {
		Object item = dataArray[top];
		return item;
	}
	/**
	 * 删除栈顶元素
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
	 * 判断是否需要扩容
	 * @param minCount
	 */
	private boolean isGrow(int minCount) {
		int oldCount = size;
		if(minCount >= oldCount) {
			//定义扩大之后栈的总容量
            int newCount = 0;
			//超出容量，进行扩容，默认扩为两倍(左移一位)
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
