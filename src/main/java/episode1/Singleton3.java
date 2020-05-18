package episode1;

/**
 * 线程安全的
 */
public class Singleton3 {
    private static Singleton3 instance = null;

    private Singleton3(){

    }

    public static Singleton3 getInstance(){
        if (instance==null){
            instance = new Singleton3();
        }
        return instance;
    }

}
