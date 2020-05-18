package episode2;

import org.junit.Test;


import java.util.concurrent.*;

public class ThreadTest {

    /**
     * run方法不按顺序去调用
     * Start会去抢占cpu资源
     * @throws Exception
     */
    @Test
    public void test1() throws Exception{
        Thread t1 = new ThreadDemo();
        Thread t2 = new ThreadDemo();
        t1.run();
        t2.run();
        Thread.sleep(1000);
    }



    @Test
    public void test() throws Exception{
        Runnable runnable = new MyRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
        Thread.sleep(1000);
    }


    /**
     * 会处于阻塞状态
     * @throws Exception
     */
    @Test
    public void test3() throws Exception{
        Callable<Integer> callable =new MyCallable();
        FutureTask<Integer> task1 = new FutureTask<>(callable);
        FutureTask<Integer> task2 = new FutureTask<>(callable);
        FutureTask<Integer> task3 = new FutureTask<>(callable);
        new Thread(task1).start();
        new Thread(task2).start();
        new Thread(task3).start();
        Integer num1 = task1.get();
        Integer num2 = task2.get();
        Integer num3 = task3.get();
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
    }

    @Test
    public void test4() throws Exception{
        ExecutorService pool = Executors.newFixedThreadPool(3);
        MyRunnable runnable = new MyRunnable();
        pool.submit(runnable);
        pool.submit(runnable);
        pool.submit(runnable);
        pool.submit(runnable);
        Callable<Integer> callable =new MyCallable();
        Future<Integer> future = pool.submit(callable);
        System.out.println(future.get());


        pool.shutdown();
    }

    @Test
    public void test5() throws  Exception{
        MyRunnable runnable = new MyRunnable();
        for (int i = 0; i < 20; i++) {
            new Thread(runnable).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
