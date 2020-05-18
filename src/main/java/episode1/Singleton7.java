package episode1;

import java.util.concurrent.atomic.AtomicReference;

/**
 * CAS
 */
public class Singleton7 {
    private static final AtomicReference<Singleton7> instance = new AtomicReference<>();
    private Singleton7(){
        System.out.println("Singleton7 Loaded...");
    }

    public static  final  Singleton7 getInstance(){
        for (;; ){
        Singleton7 current = instance.get();
        if (current!=null){
            return current;
        }
        //延迟加载
        current = new Singleton7();
        if (instance.compareAndSet(null, current)) {
            return current;
        }
    }
    }
}
