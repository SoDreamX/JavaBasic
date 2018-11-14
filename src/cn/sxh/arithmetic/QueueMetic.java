package cn.sxh.arithmetic;
/**
 * 模拟单向队列
 * @author Sxh
 * 2018年11月14日 下午2:10:20
 */
public class QueueMetic {
	//队列数据
	private Object[] queueArray;
	//队列大小
	private int maxSize;
	//队首
	private int front;
	//队尾
	private int rear;
	//队列中实际元素数目
	private int nItems;
	
	public QueueMetic(int size) {
		maxSize = size;
		queueArray = new Object[size];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	/**
	 * 插入队列数据
	 */
	public void insert(Object item) {
		//判断是否已满
		if(!isFull()) {
			//判断是否尾部指向顶了，那么循环回来，执行队列的第一个元素
			if(rear == maxSize-1) {
				rear = -1;
			}
			//队尾指针加1，然后在队尾指针处插入新的数据
			queueArray[++rear] = item;
			nItems++;
		}else {
			throw new RuntimeException("队列已满！");
		}
	}
	/**
	 * 移除元素
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
	 * 判断是否为空队列
	 * @return
	 */
	public boolean isEmpty() {
		if(nItems == 0) {
			return true;
		}
		return false;
	}
	/**
	 * 判断队列是否已满
	 * @return
	 */
	public boolean isFull() {
		if(nItems==maxSize) {
			return true;
		}
		return false;
	}
	/**
	 * 获取队列数据量大小
	 * @return
	 */
	public int getSize() {
		return nItems;
	}
	/**
	 * 获取队首元素
	 * @return
	 */
    public Object peekFront(){
        return queueArray[front];
    }
}
