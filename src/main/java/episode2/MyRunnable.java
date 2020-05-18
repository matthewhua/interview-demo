package episode2;

import java.util.concurrent.locks.ReentrantLock;

public class MyRunnable implements Runnable {

    //可以共享
    private  int num = 10 ;
    ReentrantLock lock = new ReentrantLock();
    @Override
    public    void run() {
        //synchronized
        lock.lock();
        try {
            if (num >= 1){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num--;
                System.out.println(Thread.currentThread().getName() + ":" +num);
            }else {
                System.out.println("库存不足！！");
            }
        } finally {
            lock.unlock();
        }
    }
}
