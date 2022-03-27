package cn.gq.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author cherry_xx
 * @create 2022/2/26 20:10
 * @update 2022/2/26
 * Description: 括号匹配
 * @since 1.0.0
 */
public class 括号匹配 {

    public static void main(String[] args) {
        //

        System.out.println(isValid("[{(()}]"));
    }

    public static boolean isValid(String s) {
        if (null == s || s.length() == 0) {
            return false;
        }

        Stack<Character> stack_data = new Stack<>();
        Stack<Character> stack_temp = new Stack<>();
        // init stack data
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            stack_data.push(aChar);
        }

        Map<Character, Character> split = new HashMap<>();
        split.put(')', '(');
        split.put(']', '[');
        split.put('}', '{');
        while (stack_data.size() > 0) {
            Character pop = stack_data.pop();
            char now = split.getOrDefault(pop,'#');

            Character peek = '!';
            if (stack_data.size()>0) {
                peek = stack_data.peek();
            }else {
                System.out.println();
            }


            if (now == peek) {
                stack_data.pop();
            } else {
                if (stack_temp.size() > 0) {
                    Character peek1 = split.get(stack_temp.peek());
                    if (peek1 == pop) {
                        stack_temp.pop();
                    } else {
                        stack_temp.push(pop);
                    }
                } else {
                    stack_temp.push(pop);
                }
            }
        }
        if (stack_temp.size() > 0) {
            return false;
        }
        return true;
    }
}
