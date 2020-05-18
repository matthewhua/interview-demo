package episode2;

public class ThreadDemo extends Thread {

    @Override
    public void run() {
        System.out.println(super.getName() + "Started!");
        Thread t1 = new Thread();
        Thread t2 = new Thread();
    }
}
