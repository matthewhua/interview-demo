package episode1.test;

import episode1.Singleton7;
import org.junit.Test;

public class Singleton7Test {
    @Test
    public void test1()throws Exception{
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Singleton7.getInstance());
                }
            }).start();
        }
        System.in.read();
    }
}
