package episode2;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    private int num = 10;
    @Override
    public Object call() throws Exception {
        num--;
        System.out.println(Thread.currentThread().getName()+ ":" + num);
        return num;
    }
}
