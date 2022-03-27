package cn.gq.华为机试;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cherry_xx
 * @create 2022/2/23 23:11
 * @update 2022/2/23
 * Description:
 * 作者：牛客752473244号
 * 链接：https://ac.nowcoder.com/discuss/835543?type=1
 * 来源：牛客网
 *
 * 有A，B两个同学想要分苹果。A的想法是使用二进制进行，1 + 1相加不进一位，如（9 + 5 = 1001 +101 = 12）、
 * 。B同学的想法是使用十进制进行，并且进一位。 会输入两组数据，
 * 一组是苹果总数，一组分别是每个苹果的重量。如果让B同学在满足A同学的情况下获取到苹果的总重量且返回，如果不能则返回-1。
 * @since 1.0.0
 */
public class 分苹果 {
    public static void main(String[] args) {
        int n = 3;
        int[] data = {9,5,12,12};
        LinkedList<List<Integer>> que = new LinkedList<>();
        int sum = 0;
        // 初始化队列
        for (int i = 0; i < data.length; i++) {
            List<Integer> index = new ArrayList<>();
            index.add(i);
            que.addLast(index);
            sum += data[i];
        }
        int sumA = 0;
        int res = Integer.MAX_VALUE;
        while (que.size()>0) {
            List<Integer> first = que.getFirst();
            sumA += first.stream().mapToInt(temp -> data[temp]).sum();
            int sumB = 0 ;
            for (int i = 0; i < data.length; i++) {
                if(first.contains(i)) {
                    continue;
                }
                if(first.size()<n>>1) {
                List<Integer> index = new ArrayList<>(first);
                index.add(i);
                que.addLast(index);
                }
                sumB ^= data[i];
            }
            if (sumB == sumA) {
               res = Math.min(res, sum-sumA);
            }
            que.removeFirst();
        }
        System.out.println(res);
    }
}
