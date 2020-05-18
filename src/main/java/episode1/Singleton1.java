package episode1;

public enum Singleton1 {
    INSTANSE{
        @Override
        protected void doSomething() {
            System.out.println("doSometing");
        }
    };

    protected abstract  void doSomething();
}
