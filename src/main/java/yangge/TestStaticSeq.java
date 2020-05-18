package yangge;

class Father{
    //构造方法最后被加载
    public Father(){
        System.out.println("11111");
    }
    {
        System.out.println("222222");
    }
    static {
        System.out.println("3333333");
    }
}
//先加载父类的东西
class Son extends Father{
    public Son(){
        System.out.println("444444");
    }
    {
        System.out.println("555555");
    }
    static {
        System.out.println("66666");
    }
}
//主次分明，主类先行
public class TestStaticSeq {
    public static void main(String[] args) {
        System.out.println("7777777777");
        new Son();
        System.out.println("==============");
        new Father();
        System.out.println("==============");

    }
}
