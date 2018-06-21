package cn.sxh.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;

public class TestIO {
	//用字节流写文件
	public static void writeByteToFile() throws IOException {
		String str = "测试用字节流写文件123abc";
		byte[] bys = str.getBytes("utf-8");
		File file = new File("E:/IO/test.txt");
		//因为是用字节流来写媒介，所以对应的是OutputStream 
		//又因为媒介对象是文件，所以用到子类是FileOutputStream
		FileOutputStream fo = new FileOutputStream(file);
		fo.write(bys);
		fo.close();
	}
	//用字节流读文件
	public static void readByteFromFile() throws IOException {
		File file = new File("E:/IO/test.txt");
		System.out.println(file.length());
		//因为是用字节流来读媒介，所以对应的是InputStream 
		//又因为媒介对象是文件，所以用到子类是FileInputStream
		FileInputStream fi = new FileInputStream(file);
		byte[] bys = new byte[(int) file.length()];
		int size = fi.read(bys);
		System. out.println( "大小:"+size +";内容:" +new String(bys,"utf-8"));
		fi.close();
	}
	//用字符流写文件
	public static void writeCharToFile() throws IOException {
		String str = "测试用字符流写文件test";
		File file = new File("E:/IO/testchar.txt");
		FileWriter fw = new FileWriter(file);
		fw.write(str);
		fw.close();
	}
	//用字符流读文件
	public static void readCharFromFile() throws IOException {
		File file = new File("E:/IO/testchar.txt");
		System.out.println(file.length());
		char[] chars = new char[(int) file.length()];
		FileReader fr = new FileReader(file);
		int size = fr.read(chars);
		System.out.println("大小:"+size +";内容:" +new String(chars));
		fr.close();
	}
	//字节流转换为字符流
	public static void convertByteToChar() throws IOException {
		File file = new File("E:/IO/testchar.txt");
		char[] chars = new char[(int) file.length()];
		InputStream is = new FileInputStream(file);
		Reader reader = new InputStreamReader(is);
		int size = reader.read(chars);
		System.out.println("大小:"+size +";内容:" +new String(chars));
		is.close();
		reader.close();
	}
	//随机写入File文件
	public static void randomWriteToFile() throws IOException {
		String str = "HELLO RANDOM测试";
		byte[] b = str.getBytes("utf-8");
		RandomAccessFile rf = new RandomAccessFile("E:/IO/testrandom.txt", "rw");
		rf.seek(5);//通过seek方法来移动读写位置的指针
		long point_b = rf.getFilePointer();
		rf.write(b);
		long point_e = rf.getFilePointer();
		System.out.println("point_b--"+point_b+",point_e--"+point_e);
		rf.close();
	}
	//随机读取File文件
	public static void randomReadFile() throws IOException {
		File file = new File("E:/IO/testrandom.txt");
		byte[] b = new byte[(int) file.length()];
		RandomAccessFile rf = new RandomAccessFile(file, "rw");
		rf.seek(3);//通过seek方法来移动读写位置的指针
		long point_b = rf.getFilePointer();
		int size = rf.read(b);
		long point_e = rf.getFilePointer();
		System.out.println("大小:"+size +";内容:" +new String(b,"utf-8"));
		System.out.println("point_b--"+point_b+",point_e--"+point_e);
		rf.close();
	}
	//读写管道
	//管道主要用来实现同一个虚拟机中的两个线程进行交流。因此，一个管道既可以作为数据源媒介也可作为目标媒介。
	public static void pipedInOut() throws IOException {
		PipedOutputStream po = new PipedOutputStream();
		PipedInputStream pi = new PipedInputStream(po);
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				String str = "测试--Hello Piped!";
				try {
					po.write(str.getBytes("utf-8"));
					po.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					byte[] b = new byte[1024];
					pi.read(b);
					String str = new String(b, "utf-8");
					System.out.println(str);
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					try {
						pi.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t1.start();
		t2.start();
	}
	//用字节缓冲流读文件-比单字节的操作效率要高的多
	public static void bufferInputFile() throws IOException {
		File file = new File("E:/IO/test.txt");
		byte[] b = new byte[(int) file.length()];
		BufferedInputStream bf = new BufferedInputStream(new FileInputStream(file));
		int size = bf.read(b);
		System.out.println("size--"+size+",内容--"+new String(b,"utf-8"));
		bf.close();
	}
	//用字符缓冲流读文件
	public static void bufferReadFile() throws IOException {
		File file = new File("E:/IO/testchar.txt");
		char[] cbuf = new char[(int) file.length()];
		BufferedReader br = new BufferedReader(new FileReader(file));
		int size = br.read(cbuf);
		System.out.println("size--"+size+",内容--"+new String(cbuf));
		br.close();
	}

	public static void main(String[] args) {
		try {
			//writeByteToFile();
			//readByteFromFile();
			//writeCharToFile();
			//readCharFromFile();
			//convertByteToChar();
			//randomWriteToFile();
			//randomReadFile();
			//pipedInOut();
			bufferInputFile();
			bufferReadFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
