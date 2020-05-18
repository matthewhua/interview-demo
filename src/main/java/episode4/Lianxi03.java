package episode4;

public class Lianxi03 {
    /*题目：打印出所有的 "水仙花数 "，所谓 "水仙花数 "是指一个三位数，
    其各位数字立方和等于该数本身。例如：153是一个 "水仙花数 "，
    因为153=1的三次方＋5的三次方＋3的三次方。*/
    public static void main(String[] args) {
        int b1, b2,b3;
        for (int i = 100; i <1000 ; i++) {
            b3 = i/100;         //百位
            b2 = i%100/10;  //十位
            b1 = i%10; //个位
            if ((b3*b3*b3+b2*b2*b2+b1*b1*b1)==i){
                System.out.println(i+"是一个水仙花数");
            }
        }
    }
}
