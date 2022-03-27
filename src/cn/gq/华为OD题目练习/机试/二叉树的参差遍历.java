package cn.gq.华为OD题目练习.机试;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author cherry_xx
 * @create 2022/3/12 13:24
 * @update 2022/3/12
 * Description:
 * @since 1.0.0
 */
public class 二叉树的参差遍历 {
    static class ThreeNode {
        public Character value;
        public ThreeNode leftChild;
        public ThreeNode rightChild;

        public ThreeNode(Character value) {
            this.value = value;
        }
    }

    public static int index = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String instr = in.nextLine();
        String[] s = instr.split(" ");
        String las = s[0];
        String mid = s[1];
        index = las.length() - 1;
        ThreeNode threeNode = CreatBThree(mid.toCharArray(), las.toCharArray(), 0, las.length() - 1);
         print(threeNode);
    }

    public static ThreeNode CreatBThree(char[] inOrder, char[] postOrder, int start, int end) {

        Character value = postOrder[index];
        int i = 0;
        for (; i < inOrder.length; i++) {
            if (value == inOrder[i]) {
                break;
            }
        }
        ThreeNode node = new ThreeNode(value);
        if (end >= i + 1) {
            index--;
            node.rightChild = CreatBThree(inOrder, postOrder, i + 1, end);
        }
        if (start <= i - 1) {
            --index;
            node.leftChild = CreatBThree(inOrder, postOrder, start, i - 1);
        }
        return node;
    }

    public static void print(ThreeNode head) {
        LinkedList<ThreeNode> que = new LinkedList<>();
        // init
        que.add(head);
        StringBuffer bf = new StringBuffer();
        while (!que.isEmpty()) {
            ThreeNode first = que.getFirst();
            bf.append(first.value);
            if (first.leftChild != null) {
                que.addLast(first.leftChild);
            }
            if (first.rightChild != null) {
                que.addLast(first.rightChild);
            }
            que.removeFirst();
        }
        System.out.println(bf.toString());
    }
}
