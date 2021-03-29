package com.knowledge.test.Feb.fives;

import java.util.stream.IntStream;

/**
 * @author xj
 * @create Y E A R − {YEAR}-YEAR−{MONTH}-05 2:19 下午
 */
public class SyncScopeTest {


    public static void main(String[] args) {
        ScopTest1 scopTest = new ScopTest1();
        Thread t1 = new Thread(scopTest,"t1");
        Thread t2 = new Thread(scopTest,"t2");
        t1.start();
        t2.start();

    }

//    public static Thread createThread(ScopTest scopTest,String name){
//        return new Thread(scopTest,name);
//    }
}

class ScopTest implements Runnable{

    static int nub = 1;
    final static int max = 100;

    @Override
    public synchronized void run() {
        while (nub<max){
            nub++;
            System.out.println(Thread.currentThread().getName()+":"+nub);
        }
    }
}
class ScopTest1 implements Runnable{

    int nub = 1;
    final  int max = 100;

    @Override
    public  void run() {
            for (;;){
                synchronized (this){
                    if (nub<max){
                        nub++;
                        System.out.println(Thread.currentThread().getName()+":"+nub);
                    }else{
                        break;
                    }
                }
            }
    }


}