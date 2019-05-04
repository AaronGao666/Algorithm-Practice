
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

//    public static volatile int num = 0;
    //使用CountDownLatch来等待计算线程执行完
    static CountDownLatch countDownLatch = new CountDownLatch(30);

    public static AtomicInteger num = new AtomicInteger(0);



    public static void main(String []args) throws InterruptedException {
//        //开启30个线程进行累加操作
//        for(int i=0;i<30;i++){
//            new Thread(){
//                public void run(){
//                    for(int j=0;j<10000;j++){
//                        num++;//自加操作
//                    }
//                    countDownLatch.countDown();
//                }
//            }.start();
//        }
//        //等待计算线程执行完
//        countDownLatch.await();
//        System.out.println(num);

//
//        for(int i=0;i<30;i++){
//            new Thread(){
//                public void run(){
//                    for(int j=0;j<10000;j++){
//                        num.incrementAndGet();//原子性的num++,通过循环CAS方式
//                    }
//                    countDownLatch.countDown();
//                }
//            }.start();
//        }
//        //等待计算线程执行完
//        countDownLatch.await();
//        System.out.println(num);


//
//        ClassLoader loader = Main.class.getClassLoader();
//        while(loader != null){
//            System.out.println(loader.toString());
//            loader = loader.getParent();
//        }

        HashMap map = new HashMap();





    }

}
