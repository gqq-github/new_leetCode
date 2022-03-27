package cn.gq.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cherry_xx
 * @create 2020/11/29 19:39
 * @update 2020/11/29
 * Description:
 * @since 1.0.0
 */
public class 正数转化罗马数字 {
    public static void main(String[] args) {
        String s = intToRome("1994");
        System.out.println(s);
    }

    /**
     * @param data  原数字
     * @param twice 第几位数字
     * @return
     */
    public static int getSubNum(int data, int twice) {
        return data % 10;
    }

    public static String intToRome(String data) {
        int length = data.length();
        int[] temp = new int[length];
        int num = Integer.parseInt(data);
        for (int i = 1; i <= length; i++) {
            temp[i - 1] = getSubNum(num, i);
            num = (num - temp[i - 1]) / 10;
        }
        StringBuilder buf = new StringBuilder();
        for (int i = temp.length-1 ; i>=0 ; i--) {
            buf.append(getNumRome(temp[i], i));
        }
        return buf.toString();
    }

    public static String getNumRome(int num, int index) {
       if(num==0) {
           return "";
       }
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "I,V,X");
        map.put(1, "X,L,C");
        map.put(2, "C,D,M");
        map.put(3, "M");
        StringBuilder buf = new StringBuilder();
        String s = map.get(index);
        if (index < 3) {
            String[] split = s.split(",");
            if (0 < num && num < 4) {
                for (int i = 0; i < num; i++) {
                    buf.append(split[0]);
                }
            } else if (num == 4) {
                buf.append(split[0]).append(split[1]);
            } else if (num == 5) {
                buf.append(split[1]);
            } else if (5 < num && num < 9) {
                buf.append(split[1]);
                for (int i = 0; i < num - 5; i++) {
                    buf.append(split[0]);
                }
            } else {
                buf.append(split[0]).append(split[2]);
            }
        }else {
            for (int i = 0; i < num; i++) {
                buf.append(s);
            }
        }
        return buf.toString();
    }
}
