package cn.sxh.arithmetic;

public class TestStack {
	public static void testStack() {
		StackMetic stack = new StackMetic(3);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push("123");
		stack.push("456");
		
		System.out.println("ջ������"+stack.getSize());
		System.out.println("��ջ��"+stack.pop());
		System.out.println("��ջ��"+stack.pop());
		System.out.println("��ջ��"+stack.pop());
		System.out.println("ջ�����ݣ�"+stack.peek());
		
		System.out.println("��ջ��"+stack.pop());
		System.out.println("��ջ��"+stack.pop());
		System.out.println("��ջ��"+stack.pop());
		System.out.println("�Ƿ�Ϊ�գ�"+stack.isEmpty());
	}
	public static void statckReverse() {
		String str = "Hello World!";
		System.out.println("ԭ�ַ�����"+str);
		char[] ch = str.toCharArray();
		StackMetic stack = new StackMetic();
		for(char c:ch) {
			stack.push(c);
		}
		System.out.print("��ת�����");
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
	public static void main(String[] args) {
		//testStack();
		statckReverse();
	}
}
