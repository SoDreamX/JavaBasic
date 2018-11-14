package cn.sxh.arithmetic;
/**
 * ģ�ⵥ�����
 * @author Sxh
 * 2018��11��14�� ����2:10:20
 */
public class QueueMetic {
	//��������
	private Object[] queueArray;
	//���д�С
	private int maxSize;
	//����
	private int front;
	//��β
	private int rear;
	//������ʵ��Ԫ����Ŀ
	private int nItems;
	
	public QueueMetic(int size) {
		maxSize = size;
		queueArray = new Object[size];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	/**
	 * �����������
	 */
	public void insert(Object item) {
		//�ж��Ƿ�����
		if(!isFull()) {
			//�ж��Ƿ�β��ָ���ˣ���ôѭ��������ִ�ж��еĵ�һ��Ԫ��
			if(rear == maxSize-1) {
				rear = -1;
			}
			//��βָ���1��Ȼ���ڶ�βָ�봦�����µ�����
			queueArray[++rear] = item;
			nItems++;
		}else {
			throw new RuntimeException("����������");
		}
	}
	/**
	 * �Ƴ�Ԫ��
	 * @return
	 */
	public Object remove() {
		Object item = null;
		if(!isEmpty()) {
			item = queueArray[front];
			queueArray[front++] = null;
			if(front == maxSize){
                front = 0;
            }
			nItems--;
		}
		return item;
	}
	/**
	 * �ж��Ƿ�Ϊ�ն���
	 * @return
	 */
	public boolean isEmpty() {
		if(nItems == 0) {
			return true;
		}
		return false;
	}
	/**
	 * �ж϶����Ƿ�����
	 * @return
	 */
	public boolean isFull() {
		if(nItems==maxSize) {
			return true;
		}
		return false;
	}
	/**
	 * ��ȡ������������С
	 * @return
	 */
	public int getSize() {
		return nItems;
	}
	/**
	 * ��ȡ����Ԫ��
	 * @return
	 */
    public Object peekFront(){
        return queueArray[front];
    }
}
