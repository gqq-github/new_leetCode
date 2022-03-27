package cn.gq.华为OD题目练习;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cherry_xx
 * @create 2022/3/6 21:11
 * @update 2022/3/6
 * Description:
 * @since 1.0.0
 */
public class 判断列表是否有环 {
    public static void main(String[] args) {

    }

    public static boolean hasCycle(ListNode head) {

        return getCycleNode(head) != null;
    }

    public static ListNode getCycleNode(ListNode head) {

        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        if (head.next.next == null) {
            return null;
        }
        ListNode fistPre = head;
        ListNode first = head;

        while (fistPre!=null && fistPre.next != null) {
            first = first.next;
            fistPre = fistPre.next.next;
            if (fistPre == first) {
                return first;
            }
        }
        return null;
    }

    /**
     * @Author:cherry_xx
     * @Date: 2022/3/6 21:26
     * 方法解释： 获取环的入口
     */
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (!hasCycle(pHead)) {
            return null;
        }
        Set<ListNode> vis = new HashSet<>();
        while (pHead != null) {
            if (vis.contains(pHead)) {
                break;
            }
            vis.add(pHead);
            pHead = pHead.next;
        }
        return pHead;
    }

    public static ListNode EntryNodeOfLoop2(ListNode pHead) {
        ListNode cycleNode = getCycleNode(pHead);

        if (cycleNode == null) {
            return null;
        }
        ListNode fast = pHead;
        while (cycleNode != fast) {
            fast = fast.next;
            cycleNode = cycleNode.next;
        }
        return fast;
    }


}
