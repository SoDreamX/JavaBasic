package cn.sxh.other.volatile_;

import java.util.Optional;

/**
 * volatile�ؼ�����java�ṩ��һ����������ͬ�����ơ�
 * 1.volatile�ؼ����ܱ�֤��������������̵߳Ŀɼ���,���޷���֤ԭ����
 * 2.��ָֹ���������Ż� 
 * ע�⣺���ڷ�ԭ�Ӳ���(���ϲ���),volatile���ܴ���synchronizedͬ������
 * @author Sxh
 * 2018��12��7�� ����11:38:01
 */
public class TestVolatile {
	private static volatile int INIT_VALUE = 0;         //ʹ�ú�Ч��
//    private static int INIT_VALUE = 0;                //ʹ��ǰЧ��
    private static final int MAXINT = 5;

    public static void main(String[] args) {
      /**
       * �����߳�һ
        */
      Thread tReader = new Thread(()->{
          int localint = INIT_VALUE;
          while(localint < MAXINT){
              if(localint != INIT_VALUE){
                  Optional.of(Thread.currentThread().getName() + " the value is " + localint).ifPresent(System.out::println);
                  localint = INIT_VALUE;
              }
           }
      },"thread-reader");
      tReader.start();

      Thread tWriter = new Thread(()->{
          int localint = 0;
          while(localint < MAXINT){
              try {
                  Thread.sleep(100L);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              Optional.of(Thread.currentThread().getName() + " update the value " + (++localint)).ifPresent(System.out::println);
              INIT_VALUE = localint;
          }
      },"thread-writer");
      tWriter.start();
      System.out.println("the main thread is finished...");
  }
}
