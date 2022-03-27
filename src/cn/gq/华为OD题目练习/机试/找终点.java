package cn.gq.华为OD题目练习.机试;


import java.util.Scanner;

/**
 * @author cherry_xx
 * @create 2022/3/12 14:04
 * @update 2022/3/12
 * Description:
 * @since 1.0.0
 */
public class 找终点 {
    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
          String instr = in.nextLine() ;
          find(instr);
    }

    public static  void find1(){
        Scanner in = new Scanner(System.in);
        String instr = in.nextLine();
        String[] inputArr = instr.split(" ");
        int length = inputArr.length;
        if(length == 1) {
            System.out.println("-1");
            return;
        }
        if(length == 2) {
            System.out.println("1");
            return;
        }
        int[][] arr = new int[length][length];
        int t1 = 1;
//        int d1 = Integer.parseInt(inputArr[t1]);
        int dmin = -1;
        arr[1][1] = Integer.parseInt(inputArr[t1]);

        for (int t = 1; t < length / 2; t++) {
            arr[t][1] = Integer.parseInt(inputArr[t]);
            for (int d = 2; d < length; d++) {
                int sub = 0;
                for (int i = 0; i < d; i++) {
                    sub += arr[t][i];
                }
                sub += t;
                if (sub >= length) {
                    continue;
                }

                arr[t][d] = Integer.parseInt(inputArr[sub]);
                if (arr[t][d] == Integer.parseInt(inputArr[length - 1]) && sub == length-1 && sub == length-1 && dmin <= d) {
                    dmin = d;
                }
            }

        }
        System.out.print(dmin);
    }


    public static  void find (String data) {
        String[] s = data.split(" ");
        int[] dataInt = new int[s.length];

        for (int i = 0; i < s.length; i++) {
            dataInt[i] = Integer.parseInt(s[i]);
        }
        int sum = Integer.MAX_VALUE;
        int stp = 0;
        for (int t = 1 ; t< dataInt.length/2; t++) {

            stp = 1;
            int temp = dataInt[t];

            for (int k = temp ; k<dataInt.length ; k++) {
                 stp++;
                int value = dataInt[k];
                 if(k+value == dataInt.length-1) {
                    sum =  Math.min(sum, stp);
                 }
                 if(k+value < dataInt.length-1) {
                     k += value;
                     continue;
                 }
                 if(k+value > dataInt.length-1) {
                     break;
                 }
            }
        }

        System.out.println(sum);
    }

}
