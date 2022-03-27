package cn.gq.leetCode;

/**
 * @author cherry_xx
 * @create 2022/2/27 20:31
 * @update 2022/2/27
 * Description: 链表合并
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
        ListNode listNode = Solution.mergeTwoLists(listNode21, listNode2);
        System.out.println();
    }

}


 //Definition for singly-linked list.
 class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        ListNode head = new ListNode();
        ListNode listNode1 = list1;
        ListNode listNode2 = list2;
        ListNode next = head;
        while (listNode1 != null && listNode2 != null) {

            if(listNode1.val<listNode2.val) {
                next.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                next.next = listNode2;
                listNode2 = listNode2.next;
            }
            next = next.next;
        }
        if(listNode1!=null) {
            next.next = listNode1;
        }
        if(listNode2 != null) {
            next.next = listNode2;
        }

        return head.next;

    }


}
