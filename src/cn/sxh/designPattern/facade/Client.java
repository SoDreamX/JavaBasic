package cn.sxh.designPattern.facade;

import cn.sxh.designPattern.facade.facade.Computer;

public class Client {
	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.start();
		System.out.println("====================");
		computer.shutdown();
	}
}
