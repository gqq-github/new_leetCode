package cn.gq.华为OD题目练习;

import com.sun.scenario.effect.Merge;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author cherry_xx
 * @create 2022/3/6 16:53
 * @update 2022/3/6
 * Description:
 * @since 1.0.0
 */
public class 链表合并 {

    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(2);
        ListNode listNode23 = new ListNode(3);
        ListNode listNode24 = new ListNode(4);
        listNode21.next = listNode22;
        listNode22.next = listNode23;
        listNode23.next = listNode24;
        ListNode merge = Merge(listNode21, listNode2);
        System.out.println();
    }


    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists != null && lists.size() == 1) {
            return lists.get(0);
        }

        ListNode mergeData = merge(lists.get(0), lists.get(1));
        for (int i = 2; i <lists.size() ; i++) {
            mergeData = Merge(mergeData, lists.get(i));
        }
        return mergeData;
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        int val1 = list1.val;
        int val2 = list2.val;
        if (val1 < val2) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    public static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(0);
        ListNode listNode1 = list1;
        ListNode listNode2 = list2;
        ListNode next = head;
        while (listNode1 != null && listNode2 != null) {

            if (listNode1.val < listNode2.val) {
                next.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                next.next = listNode2;
                listNode2 = listNode2.next;
            }
            next = next.next;
        }
        if (listNode1 != null) {
            next.next = listNode1;
        }
        if (listNode2 != null) {
            next.next = listNode2;
        }

        return head.next;
    }

}

