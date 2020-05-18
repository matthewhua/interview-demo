package algorithm;

import org.junit.Test;

import java.util.*;

/**
 * 数组相关
 */
public class Alogrithm5 {

    /**
     * @求和最大的子序列
     * 给定一整数序列A1,A2，**** An（可能有负数），求
     * A1~An 的一个子序列AI` An 的子序列Ai~Aj,使得Ai到Aj得到的和最大，并输出子序列的内容。
     */
    @Test //暴力破解法
    public void test1_1(){
        int[] nums = {-1,-2,1,6,-10,16,28};
        int step = 1; //参与求和的元素个数
        int maxSum = nums[0];
        int start = 0;
        int end = 0;
        while (step <= nums.length){
            for (int i=0;i <= nums.length-step;i++){
                int tempSum = nums[i];
                for (int j = i+1;j < i+step ; j++) {
                    tempSum += nums[j];
                }
                    if (tempSum>= maxSum){
                    start = i;
                    end = i + step - 1;
                    maxSum = tempSum;
                    }
            }
            step++;
        }
        System.out.println(maxSum + ";start="+start+";end="+end);
    }

    @Test
    public void test1_2(){
        int[] nums = {-1,-2,1,6,-10,16,28};
        //-1
        //-2
        //1
        int max = nums[0];
        //以第i个元素结尾的和最大的子序列 的和 sums[1] 以角标为1 的元素结尾的最大子序列的和
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        int end = 0;
        int[] starts = new int[nums.length]; //以第i个元素结尾的和最大的子序列 从几开始的
        for (int i=1;i<nums.length;i++){
            if (sums[i-1]>0){ //它前面的子序列和大于0
                sums[i] = sums[i-1]+nums[i];
                starts[i] = starts[i - 1];
            }else {
                sums[i] = nums[i];
                starts[i] = i;  //判断开始的地方
            }
            if (sums[i]>max){
                max = sums[i];
                end = i;  //判断结束的地方
            }
        }
        System.out.println(max+";start="+starts[end]+";end=" + end);
    }

    /**
     * 排序并去重输出
     */
    @Test
    public void test2_2(){
        int[] nums = {1,35,2,6,5,9,2,0,2};
        Set<Integer> set = new TreeSet<>();
        for (int num : nums){
            set.add(num);
        }
        for(Integer integer : set){
            System.out.println(integer);
        }
    }

    @Test
    public void test3_1(){
        int[] nums = {1,2,2,2,6,6,6,5,9,10,33,33,35};
        for (int i=0; i < nums.length-1;i++){
            if (nums[i]!=nums[i+1]){
                System.out.print(nums[i]);
                System.out.print(",");
            }
        }
        System.out.println(nums[nums.length-1]);
    }

    @Test
    public void test3_2() {
        int[] nums = {1, 2, 2, 2, 6, 6, 6, 5, 9, 10, 33, 33, 35};
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.add(num)){
                System.out.print(num);
                System.out.print(",");
            }
        }
    }

    /**
     *
     */
    @Test
    public void test5(){
        int[] nums = {7,6,4,8,9,0,2,1,3,5,4};
        int[] orders = new int[nums.length]; //nums[i] 序号就是orders[i]
        for (int i = 0; i < nums.length; i++) {
            orders[i] = i + 1;
        }
        for (int i = 0; i < nums.length;i++){
            for (int j=i+1;j < nums.length;j++){
                if (nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    temp = orders[i];
                    orders[i] = orders[j];
                    orders[j] = temp;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]+"序号"+orders[i]);
        }
    }

    /**
     * 奇数在前面，偶数在后面
     */
    @Test
    public void test4_1(){
        Integer[] nums = {7,6,5,9,0,4,5,1,3,1,4,3};
        List<Integer> list = new ArrayList<>();//奇数
        List<Integer> list2= new ArrayList<>();//偶数
        for (int num : nums) {
            if (num % 2 == 0 ){
                list2.add(num);
            }else {
                list.add(num);
            }
        }
        list.addAll(list2);
        list.toArray(nums);
        System.out.println(Arrays.toString(nums));
    }


    @Test
    public void test4_2() {
        Integer[] nums = {7, 6, 5, 9, 0, 4, 5, 1, 3, 1, 4, 3};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] % 2 == 1) {
                        int temp = nums[j];
                        for (; j > i; j--) {
                            nums[j] = nums[j - 1];
                        }
                        nums[i] = temp;
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }


}
