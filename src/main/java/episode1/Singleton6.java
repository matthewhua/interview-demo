package episode1;

/**
 * Thred Local
 */
public class Singleton6 {
    private static Singleton6 instance = null;

    private  Singleton6(){

    }

    private static final ThreadLocal<Singleton6> thr = new ThreadLocal<Singleton6>(){
        @Override
        protected Singleton6 initialValue() {
            return new Singleton6();
        }
    };

    public  static Singleton6 getInstance(){
        return thr.get();
    }

}
