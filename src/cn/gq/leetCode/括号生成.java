package cn.gq.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cherry_xx
 * @create 2022/2/27 22:54
 * @update 2022/2/27
 * Description:
 * @since 1.0.0
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class 括号生成 {
    public static void main(String[] args) {

        List<String> res = new ArrayList<>();

        create(res,0,0,new StringBuilder(),3);
        System.out.println(res);
    }


    public static void create(List<String> res , int left , int right,StringBuilder bf , int n) {
        if(bf.length() == 2*n){
            res.add(bf.toString());
            return;
        }
        if(left<n){
            bf.append("(");
            create(res, left+1, right, bf, n);
            bf.deleteCharAt(bf.length() - 1);
        }

        if(right<left) {
            bf.append(")");
            create(res,left,right+1,bf,n);
            bf.deleteCharAt(bf.length() - 1);
        }
    }
}
