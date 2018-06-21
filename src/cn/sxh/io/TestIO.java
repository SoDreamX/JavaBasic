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
	//���ֽ���д�ļ�
	public static void writeByteToFile() throws IOException {
		String str = "�������ֽ���д�ļ�123abc";
		byte[] bys = str.getBytes("utf-8");
		File file = new File("E:/IO/test.txt");
		//��Ϊ�����ֽ�����дý�飬���Զ�Ӧ����OutputStream 
		//����Ϊý��������ļ��������õ�������FileOutputStream
		FileOutputStream fo = new FileOutputStream(file);
		fo.write(bys);
		fo.close();
	}
	//���ֽ������ļ�
	public static void readByteFromFile() throws IOException {
		File file = new File("E:/IO/test.txt");
		System.out.println(file.length());
		//��Ϊ�����ֽ�������ý�飬���Զ�Ӧ����InputStream 
		//����Ϊý��������ļ��������õ�������FileInputStream
		FileInputStream fi = new FileInputStream(file);
		byte[] bys = new byte[(int) file.length()];
		int size = fi.read(bys);
		System. out.println( "��С:"+size +";����:" +new String(bys,"utf-8"));
		fi.close();
	}
	//���ַ���д�ļ�
	public static void writeCharToFile() throws IOException {
		String str = "�������ַ���д�ļ�test";
		File file = new File("E:/IO/testchar.txt");
		FileWriter fw = new FileWriter(file);
		fw.write(str);
		fw.close();
	}
	//���ַ������ļ�
	public static void readCharFromFile() throws IOException {
		File file = new File("E:/IO/testchar.txt");
		System.out.println(file.length());
		char[] chars = new char[(int) file.length()];
		FileReader fr = new FileReader(file);
		int size = fr.read(chars);
		System.out.println("��С:"+size +";����:" +new String(chars));
		fr.close();
	}
	//�ֽ���ת��Ϊ�ַ���
	public static void convertByteToChar() throws IOException {
		File file = new File("E:/IO/testchar.txt");
		char[] chars = new char[(int) file.length()];
		InputStream is = new FileInputStream(file);
		Reader reader = new InputStreamReader(is);
		int size = reader.read(chars);
		System.out.println("��С:"+size +";����:" +new String(chars));
		is.close();
		reader.close();
	}
	//���д��File�ļ�
	public static void randomWriteToFile() throws IOException {
		String str = "HELLO RANDOM����";
		byte[] b = str.getBytes("utf-8");
		RandomAccessFile rf = new RandomAccessFile("E:/IO/testrandom.txt", "rw");
		rf.seek(5);//ͨ��seek�������ƶ���дλ�õ�ָ��
		long point_b = rf.getFilePointer();
		rf.write(b);
		long point_e = rf.getFilePointer();
		System.out.println("point_b--"+point_b+",point_e--"+point_e);
		rf.close();
	}
	//�����ȡFile�ļ�
	public static void randomReadFile() throws IOException {
		File file = new File("E:/IO/testrandom.txt");
		byte[] b = new byte[(int) file.length()];
		RandomAccessFile rf = new RandomAccessFile(file, "rw");
		rf.seek(3);//ͨ��seek�������ƶ���дλ�õ�ָ��
		long point_b = rf.getFilePointer();
		int size = rf.read(b);
		long point_e = rf.getFilePointer();
		System.out.println("��С:"+size +";����:" +new String(b,"utf-8"));
		System.out.println("point_b--"+point_b+",point_e--"+point_e);
		rf.close();
	}
	//��д�ܵ�
	//�ܵ���Ҫ����ʵ��ͬһ��������е������߳̽��н�������ˣ�һ���ܵ��ȿ�����Ϊ����Դý��Ҳ����ΪĿ��ý�顣
	public static void pipedInOut() throws IOException {
		PipedOutputStream po = new PipedOutputStream();
		PipedInputStream pi = new PipedInputStream(po);
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				String str = "����--Hello Piped!";
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
	//���ֽڻ��������ļ�-�ȵ��ֽڵĲ���Ч��Ҫ�ߵĶ�
	public static void bufferInputFile() throws IOException {
		File file = new File("E:/IO/test.txt");
		byte[] b = new byte[(int) file.length()];
		BufferedInputStream bf = new BufferedInputStream(new FileInputStream(file));
		int size = bf.read(b);
		System.out.println("size--"+size+",����--"+new String(b,"utf-8"));
		bf.close();
	}
	//���ַ����������ļ�
	public static void bufferReadFile() throws IOException {
		File file = new File("E:/IO/testchar.txt");
		char[] cbuf = new char[(int) file.length()];
		BufferedReader br = new BufferedReader(new FileReader(file));
		int size = br.read(cbuf);
		System.out.println("size--"+size+",����--"+new String(cbuf));
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
