package episode1.test;

import episode1.Singleton2;
import episode1.Singleton3;
import episode1.Singleton4;
import episode1.Singleton5;
import org.junit.Test;

import java.io.IOException;

public class Singleton2Test {
    @Test
    public void test1(){
        Singleton2 s1 = Singleton2.getInstance();
        Singleton2 s2 = Singleton2.getInstance();
        System.out.println(s1==s2);
    }

    @Test
    public void test2(){
        for (int i = 0; i < 20 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Singleton5.getInstance());
                }
            }).start();
        }
        try {
            System.in.read();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
