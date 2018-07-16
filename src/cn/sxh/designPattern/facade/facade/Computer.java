package cn.sxh.designPattern.facade.facade;

import cn.sxh.designPattern.facade.children.CPU;
import cn.sxh.designPattern.facade.children.Disk;
import cn.sxh.designPattern.facade.children.Memory;

public class Computer {
	private CPU cpu;
	private Memory memory;
	private Disk disk;
	public Computer() {
		this.cpu = new CPU();
		this.memory = new Memory();
		this.disk = new Disk();
	}
	public void start() {
		System.out.println("Computer start begin...");
		cpu.start();
		memory.start();
		disk.start();
		System.out.println("Computer start end...");
	}
	public void shutdown() {
		System.out.println("Computer shutdown begin...");
		cpu.shutdown();
		memory.shutdown();
		disk.shutdown();
		System.out.println("Computer shutdown end...");
	}
}
