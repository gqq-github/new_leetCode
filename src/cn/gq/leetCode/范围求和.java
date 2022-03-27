package cn.gq.leetCode;

/**
 * @author cherry_xx
 * @create 2021/2/6 21:55
 * @update 2021/2/6
 * Description:
 * @since 1.0.0
 */
public class 范围求和 {
    public static void main(String[] args) {
        int[][] ops = new int[2][2];
        ops[0][0] = 0;

        ops[0][1] = 1;

        ops[1][0] = 1;

        ops[1][1] = 1;
        int length = ops.length;
        if(ops.length==0 || ops[0].length ==0 ) {

        }
        for (int op []:ops) {
           System.out.println(op);
       }
        int m = Integer.MAX_VALUE;
        int n = 7;
        System.out.println(m*n);
    }
    public int maxCount(int m, int n, int[][] ops) {


        m= Integer.MAX_VALUE ;
        n = Integer.MAX_VALUE ;
        for(int [] op: ops) {
            m = Math.min(m,op[0]);
            n = Math.min(n,op[1]);
        }
        return m*n ;
    }
}
