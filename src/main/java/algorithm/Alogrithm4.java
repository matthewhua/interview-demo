package algorithm;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Alogrithm4 {

    /**
     * 统计手机号各个数字个数，按照升序输出
     *
     * @param  用桶输出
     */
    @Test
    public void test4(){
        int[] count = new int[10];
        String phone = "13715545451";
        for (int i = 0; i < phone.length(); i++) { //桶排序
            char c = phone.charAt(i);
            count[c-'0']++;  //@-'0' 是为了转变
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i]>0){
                System.out.println(i+"出现了"+count[i]+"次");
        }
        }
    }

    /**
     * 输入为一个字符串和字节数，输入为按字节截取字符串
     *
     */

    @Test
    public void test5(){
        //查看一个汉字占多少字节
        int lens = String.valueOf('人').getBytes().length;
        System.out.println(lens);


        String str = "人ABC门DEF";
        int count = 6;
        int sum = 0; //已经截取了多少
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int len = String.valueOf(str.charAt(i)).getBytes().length;//每个字符的字节数
            if (sum+len<=count){
                sum += len;
                builder.append(str.charAt(i));
            }else {
                break;
            }
        }
        System.out.println(builder.toString());
    }

    /**
     * 截取字符串
     *<p id = "text">abcdefg</p>
     */
    @Test
    public void test5_1(){
        String str = "<p id = \"text\">abcdefg</p>";
        String reg = "efg";
        int index = str.indexOf(reg);
        String target = str.substring(index,index+reg.length());//不顾尾巴
        System.out.println(target);
    }

    /**
     * 正则方法
     */
    @Test
    public void test5_2(){
        String str = "<p id = \"text\">abcdefg</p>";
       // int index = str.indexOf(reg);
        String reg = "(.*)(efg)(.*)";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
       if (matcher.find()){
           System.out.println(matcher.group(1));
           System.out.println(matcher.group(2));
           System.out.println(matcher.group(3));
        }
    }

    /**
     * 字符串翻转
     */
    @Test
    public void test7(){
        String str = "abbcikdosajio";
        StringBuilder builder = new StringBuilder(str);
        System.out.println(builder.reverse()); //Builder 自带的
    }

    @Test
    public void  test7_2(){
        String str = "abbcikdosajio";
        String desc = "";
        for (int i =  str.length()-1;i>0; i--) {
            desc += str.charAt(i);
        }
        System.out.println(desc);
    }

    @Test
    public  void test7_3(){
        String str = "abbcikdosajio";
        char[] chars = str.toCharArray();
        for (int i=0; i < chars.length/2;i++){
            char temp = chars[i];
            chars[i] = chars[chars.length-i-1];
            chars[chars.length-i-1] = temp;
        }
        System.out.println(new String(chars));
    }


    /**
     * 分割，并以相反的数翻转过来
     */
    @Test
    public void test8(){
        System.out.println(inverseSentence("I love Vanida!!!"," "));
    }

    String inverseSentence(String in,String sep){
        String[] arrs = in.split(sep); //sep 是以什么分割的。
        StringBuilder builder = new StringBuilder();
        for (int i =  arrs.length-1;i>=0 ; i--) {
            builder.append(arrs[i]);
            builder.append(sep);
        }
        //最后多余的分割符要去掉
        return builder.substring(0,builder.length() - sep.length());
    }


    /**
     * 给定一个字符串。反转字符串中每个字符的顺序，同时保留单词和空格的初始位置
     */
     @Test
    public void test9(){
         String str = "Let's Talk about love ";
         String[] arrs = str.split(" ");
         StringBuilder builder = new StringBuilder();
         for (String arr : arrs) {
             for (int i=arr.length()-1;i>=0;i--){
                 builder.append(arr.charAt(i));
             }
             builder.append(" ");
         }
         String target = builder.substring(0,builder.length()-1);
         System.out.println(target);
     }


    /**
     * 判断字符串是不是合法的地址
     * @param xxx.xxx.xxx.xxx 0`255
     */
    @Test
    public void test10(){
        System.out.println(checkIp2("127.23.160.1"));
    }

    public boolean checkIp2(String ip){
        String[] arrs = ip.split("\\."); //必须要转译
        if (arrs.length !=4 ){
            return false;
        }
        String reg="\\d||[1-9]\\d{1,2}";
        for (String arr : arrs) {
            if (!arr.matches(reg)||Integer.parseInt(arr)>255){
                return false;
            }
        }
        try {
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 普通方法
     * @param ip
     * @return
     */
    public boolean checkIp(String ip){
        String[] arrs = ip.split("\\."); //必须要转译
        if (arrs.length !=4 ){
            return false;
        }
        for (String arr : arrs) {
            try {
                Integer num = Integer.parseInt(arr);
                if (num>255||num<0){
                    return false;
                }
                if (!arr.equals("0")&&arr.startsWith("0")){ //避免01 形式出现
                    return false;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }



}
