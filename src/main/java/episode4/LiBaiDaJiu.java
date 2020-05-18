package episode4;

public class LiBaiDaJiu {
    //李白遇店加一倍，遇花喝一斗
    //开始有两斗，共遇店5次，遇到花10次，最后一次遇到花，正好把酒喝光

    static String[] tagSt;
    static int num;
    static int wine;
    public static void main(String[] args) {
        tagSt=new String[15];
        num=0;
        wine=2;
        computer(0, 0);
        System.out.println(num);
    }
    public static void computer(int time,int flower){
        if(time==15){
            if(flower==10&&wine==0&&"b".equals(tagSt[14])){
                print();
                num++;
            }
            return ;
        }
        for (int i = 0; i < 2; i++) {
            if(i==0){
                //a店  加一倍
                wine*=2;
                tagSt[time]="a";
                computer(time+1, flower);
                wine/=2;
            }else{
                //b 花 喝一斗
                wine-=1;
                tagSt[time]="b";
                computer(time+1, flower+1);
                wine+=1;
            }
        }
    }
    public static void print(){
        for (int i = 0; i < tagSt.length; i++) {
            System.out.print(tagSt[i]);
        }
        System.out.println();
    }


}
