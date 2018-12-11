package cn.sxh.other.volatile_;

import java.util.Optional;

/**
 * volatile关键字是java提供的一个轻量级的同步机制。
 * 1.volatile关键字能保证共享变量对所有线程的可见性,但无法保证原子性
 * 2.禁止指令重排序优化 
 * 注意：对于非原子操作(复合操作),volatile不能代替synchronized同步变量
 * @author Sxh
 * 2018年12月7日 上午11:38:01
 */
public class TestVolatile {
	private static volatile int INIT_VALUE = 0;         //使用后效果
//    private static int INIT_VALUE = 0;                //使用前效果
    private static final int MAXINT = 5;

    public static void main(String[] args) {
      /**
       * 定义线程一
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
