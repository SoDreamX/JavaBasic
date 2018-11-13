package cn.sxh.arithmetic;

public class TestStack {
	public static void testStack() {
		StackMetic stack = new StackMetic(3);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push("123");
		stack.push("456");
		
		System.out.println("栈容量："+stack.getSize());
		System.out.println("出栈："+stack.pop());
		System.out.println("出栈："+stack.pop());
		System.out.println("出栈："+stack.pop());
		System.out.println("栈顶数据："+stack.peek());
		
		System.out.println("出栈："+stack.pop());
		System.out.println("出栈："+stack.pop());
		System.out.println("出栈："+stack.pop());
		System.out.println("是否为空："+stack.isEmpty());
	}
	public static void statckReverse() {
		String str = "Hello World!";
		System.out.println("原字符串："+str);
		char[] ch = str.toCharArray();
		StackMetic stack = new StackMetic();
		for(char c:ch) {
			stack.push(c);
		}
		System.out.print("反转结果：");
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
	public static void main(String[] args) {
		//testStack();
		statckReverse();
	}
}
