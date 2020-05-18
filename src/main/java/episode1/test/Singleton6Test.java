package episode1.test;

import episode1.Singleton6;
import org.junit.Test;

import java.io.IOException;

public class Singleton6Test {
    @Test
    public void test1(){
        Singleton6 s1 = Singleton6.getInstance();
        Singleton6 s2 = Singleton6.getInstance();
        System.out.println(s1==s2);
    }

    @Test
    public void test2(){
        for (int i = 0; i < 50; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton6 s1 = Singleton6.getInstance();
                    Singleton6 s2 = Singleton6.getInstance();
                    System.out.println(Thread.currentThread().getName()+ ","+((s1==s2) + " " + s1));
                }
            }).start();
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
