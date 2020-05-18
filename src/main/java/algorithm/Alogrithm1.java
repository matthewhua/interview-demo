package algorithm;
/*
编程实现最大数的加法
 */
public class Alogrithm1 {

    public static void main(String[] args) {
        String a = "100010";
        String b = "9999999";
        char[] lager = null;
        char[] small = null;
        if (a.length() >= b.length()){
            lager=a.toCharArray();
            small=b.toCharArray();
        }else {
            lager=b.toCharArray();
            small=a.toCharArray();
        }
        //时间复杂度为3n;
        int[] sums = new int[lager.length+1]; //最终结果的位数 最高位可能是0；
        for (int i = 0; i < lager.length; i++) {
            sums[i] = lager[lager.length -i - 1] - '0';
        }
        for (int i = 0; i < small.length; i++) {
            sums[i] += small[small.length -i - 1] - '0';
        }
        for (int i = 0; i < sums.length - 1; i++) {
            if (sums[i]>9){
                sums[i + 1] += sums[i]/10; //左边是进位，右边是降位
                sums[i] %= 10;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = sums.length - 1;i>=0 ; i--) {
            builder.append(sums[i]);
        }
        String result = builder.toString();
        if (result.startsWith("0")){
            result = result.substring(1);
        }
        System.out.println(result);
    }



}
