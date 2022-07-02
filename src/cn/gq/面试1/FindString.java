package cn.gq.面试1;

import java.util.HashSet;

/**
 * @author cherry_xx
 * @create 2022/3/28 19:32
 * @update 2022/3/28
 * Description:给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *
 * @since 1.0.0
 */
public class FindString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String data = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(data));
    }


}
class Solution {
    public int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();
        int max = 0;

        for (int i = 0; i < chars.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            HashSet<Character> characters = new HashSet<>();
            characters.add(chars[i]);
            stringBuilder.append(chars[i]);
            for (int j = i+1; j<chars.length;j++) {
               if(characters.contains(chars[j])){
                   if(characters.size()>=max){
                       System.out.println(stringBuilder.toString());
                       max = characters.size();
                       break;
                   }
               }else {
                   stringBuilder.append(chars[j]);
                   characters.add(chars[j]);
               }
            }
        }
        return max;
    }
}