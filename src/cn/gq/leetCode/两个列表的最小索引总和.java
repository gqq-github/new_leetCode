package cn.gq.leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author cherry_xx
 * @create 2021/2/6 22:18
 * @update 2021/2/6
 * Description:
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * <p>
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @since 1.0.0
 */
public class 两个列表的最小索引总和 {

    public static String[] findRestaurant(String[] list1, String[] list2) {
        if(list1 ==null|| list2 ==null) {
            return null ;
        }
        if(list1.length == 0 || list2.length ==0) {
            return null;
        }

        if(list1.length>list2.length){

            return result(keyIndex(list1), list2);
        }else {
            return result(keyIndex(list2), list1);
        }
    }

    public static Map<String,Integer> keyIndex(String [] list1) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
            list1[i] = null;
        }
        return map;
    }

    public static  String []  result (Map<String,Integer> map,String [] list2) {
        int minIndex = Integer.MAX_VALUE;
        Integer sameValue;
        int key=-1;
        List<String> res = new LinkedList<>();
        for (int j = 0; j < list2.length ; j++) {
            if ((sameValue = map.get(list2[j]))!=null) {
               if(sameValue+j<minIndex) {
                   res.clear();
                   minIndex = sameValue + j;
                   res.add(list2[j]);
               }else if(sameValue+j==minIndex) {
                   res.add(list2[j]);
               }else {

               }
            }
        }

        if(res.size()>0) {
            return res.toArray(new String[res.size()]);
        }
        else {
            return null;
        }
    }

    public static void main(String[] args) {
        String list1 [] = {"Shogun","Tapioca Express","Burger King","KFC"};
;
        String list2 [] = {"KFC","Burger King","Tapioca Express","Shogun"};
        String[] restaurant = findRestaurant(list2, list1);

        System.out.println();

    }
}
