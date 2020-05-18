package episode4;

public class lianxi14 {
    //题目：两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。
    // 已抽签决定比赛名单。有人向队员打听比赛的名单。
    // a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单。
    public static void main(String[] args) {
        char[] m = {'A','B','C'};
        char[] n = {'X','Y','Z'};
        for (int i = 0; i <m.length ; i++) {
            for (int j = 0; j <n.length ; j++) {
                if (m[i]=='A'&&n[j]=='X'){
                    continue;
                }else{
                    if ((m[i]=='C'&&n[j]=='X')||(m[i]=='C'&&n[j]=='Z')){
                        continue;
                    }else {
                        System.out.println(m[i]+"  vs  "+n[j]);
                    }
                }
            }
        }
    }
}
