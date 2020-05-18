package algorithm;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 字符串处理
 */
public class Alogrithm3 {


    /**
     * @apiNote 出现最多到字符
     * @param 双重for循环
     */
   @Test
    public void test1(){
       String str = "gsdbsahiodhasiohdioaskduiashuidhasdhaszh真好喝或或或或或或或或或";
       //统计每一个字符出现的次数
       char res = str.charAt(0);
       int max = 0; //最多出现了多少次
       for (int i = 0; i < str.length() ; i++) {
           char temp = str.charAt(i);
           int count = 0;
           for (int j = 0; j <str.length() ; j++) {
               if (str.charAt(j) == temp){ //可以计算出temp出现了多少次
                   count++;
               }
           }
           if (count>=max){
               max = count;
               res = temp;
           }
       }
       System.out.println(res+"出现次数最多:" + max);
   }

    @Test
    public void test2(){
        String str = "gsdbsahiodhasiohdioaskduiashuidhasdhaszh真好喝或或或或或或或或或";
        char res = str.charAt(0);
        int max = 0; //最多出现了多少次
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Integer count = map.get(c);
            if (count==null){//字符串没有出现过
                count =1;
                //map.put(c,1);
            }else {
                count++;
                //map.put(c,count+1);
            }
            map.put(c,count);
            if (count>max){
                res=c;
                max = count;
            }
        }
        System.out.println(res+"出现次数最多:" + max);
    }
    @Test
    public void test3(){
        String str = "gggggggggggggggggsdbsahiodhasiohdioaskduiashuidhasdhaszh真好喝或或或或或或或或或";
        char res = str.charAt(0);
        int min = 0; //最少的出现了多少次
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Integer count = map.get(c);
            if (count==null){//字符串没有出现过
                count =1;
            }else {
                count++;
            }
            map.put(c,count);
            if (count<min){
                res = c;
                min = count;
            }
        }
        System.out.println(res+"出现次数最少:" + min);
    }

    /**
     *出现的第一个重复的数字
     */
    @Test
    public void test2_1(){
       String str = "abccbaa";
//        Set<Character> set = new HashSet<>();
//        for (int i = 0; i < str.length(); i++) {
//            if (!set.add(str.charAt(i))){ // 已经存在了
//                System.out.println(str.charAt(i));
//                break;
//            }
        Map<Character,Object> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))){
                System.out.println(str.charAt(i));
                break;
        }else {
                map.put(str.charAt(i),1);
            }
        }
    }

    /**
     * @第一次出现的且只出现一次的字符串
     */
    @Test
    public void test3_1(){
        String str = "abacccsjjib";
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Integer count = map.get(str.charAt(i));
            if (count == null){
                count = 1;
            }else {
                count++;
            }
            map.put(str.charAt(i),count);
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i))==1){
                System.out.println(str.charAt(i));
                break;
            }
        }
    }

    @Test
    public void test3_2(){
        String str = "abacccsjjib";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (str.indexOf(c) == str.lastIndexOf(c)){ //第一次出现和最后一次出现的位置一样
                System.out.println(c);
                break;
            }
        }
    }



}
