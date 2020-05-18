package episode1;

/**
 * 线程安全的
 */
public class Singleton4 {
    private static Singleton4 instance = null;

    private Singleton4(){

    }

    public static Singleton4 getInstance(){
        synchronized (Singleton4.class) {
            if (instance == null) {
                instance = new Singleton4();
            }
        }
            return instance;
        }

    }


