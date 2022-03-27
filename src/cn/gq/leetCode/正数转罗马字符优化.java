package cn.gq.leetCode;

/**
 * @author cherry_xx
 * @create 2020/11/29 21:01
 * @update 2020/11/29
 * Description: 使用贪心算法
 * @since 1.0.0
 */
public class 正数转罗马字符优化 {
    public static void main(String[] args) {
       // 定义map 匹配 对应的罗马字符
       int num [] = {1000,900,500,400,100,90,50,40,10,9,5,4,1} ;
        String rome[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int data = 3999;
        int index = 0;
        StringBuffer bf = new StringBuffer();
        while (data!=0) {
            if(data>=num[index]){
                bf.append(rome[index]);
                data = data - num[index];
            }else {
                index++;
            }
        }
        System.out.println(bf.toString());
    }
}
