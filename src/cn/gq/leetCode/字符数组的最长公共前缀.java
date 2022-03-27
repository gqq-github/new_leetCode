package cn.gq.leetCode;

/**
 * @author cherry_xx
 * @create 2020/11/29 21:45
 * @update 2020/11/29
 * Description:
 * @since 1.0.0
 */
public class 字符数组的最长公共前缀 {
    public static void main(String[] args) {
        String data[] = {"a", "ab"};
        System.out.println(longestCommonPrefix(data));
    }
    public static String longestCommonPrefix(String[] strs) {
       if(!validate(strs)){
           return "";
       }
       if(strs.length==1){
           return strs[0];
       }
        boolean isPrefix = true;
        String a = strs[0];
        int index = 0;
        StringBuilder bd = new StringBuilder();
        while (isPrefix) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length()>index && a.charAt(index) == strs[i].charAt(index)) {
                    continue;
                }else {
                    isPrefix = false;
                    break;
                }
            }
            if(isPrefix){
                bd.append(a.charAt(index));
                index++;
            }
            if(index>=a.length()){
                isPrefix = false;
            }
       }
        return bd.toString();
    }
    public static  boolean validate (String [] strs ) {
        if(strs==null||strs.length==0){
            return false;
        }
        for (String str : strs) {
            if (str.equals("")) {
                return false;
            }
        }
        return true;
    }
}
