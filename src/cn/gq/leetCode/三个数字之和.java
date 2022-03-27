package cn.gq.leetCode;

import java.util.*;

/**
 * @author cherry_xx
 * @create 2020/12/3 22:43
 * @update 2020/12/3
 * Description: 三个数字之和
 * @since 1.0.0
 */
public class 三个数字之和 {
    public static void main(String[] args) {
        int data[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> treeSum = getTreeSum(data);
        System.out.println(treeSum);
    }
    public static List<List<Integer>> getTreeSum(int data []) {
     // 1.首先给其进行排序
        if(data.length<3){
            return null;
        }
        Arrays.sort(data);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            if (data[i] > 0) {
                break;
            }
            if(i>0&&data[i]==data[i-1]){

                continue;
            }
            int temp = data[i];
            int   l = i + 1;
            int r = data.length - 1;
             while (l<r){
                 int sum = data[l] + data[r]+temp;
                 if(sum>0){
                     r--;
                 } else if(sum == 0 ) {
                     ArrayList<Integer> integers = new ArrayList<>();
                     integers.add(temp);
                     integers.add(data[l]);
                     integers.add(data[r]);
                     res.add(integers);
                     // 去除重复的数字
                     while (data[l] == data[l + 1]) {
                         l++;
                     }
                     // 去除重复的数字
                     while (data[r]==data[r-1]){
                         r--;
                     }
                     l++;
                     r--;
                 } else {
                     l++;
                 }
             }
        }
        return res;
        }
    }