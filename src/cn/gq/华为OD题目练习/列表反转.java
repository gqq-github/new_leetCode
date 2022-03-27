package cn.gq.华为OD题目练习;

import java.util.List;

/**
 * @author cherry_xx
 * @create 2022/3/6 14:06
 * @update 2022/3/6
 * Description:
 * @since 1.0.0
 */
public class 列表反转 {

    public static ListNode ReverseList(ListNode head) {


        if(head == null||head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(0);
        ListNode newHeadNext = null;
        while (head!=null) {
            ListNode temp = head.next;
            head.next = newHeadNext;
            newHead.next = head;
            newHeadNext = newHead.next;
            head = temp;
        }
        return newHead.next;
    }

    public static ListNode ReverseList2(ListNode head) {


        if(head == null||head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode listNode = ReverseList2(next);
        next.next = head;
        head.next = null;
        return listNode;
    }

    public static ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        if(m == n) {
            return head;
        }
        ListNode listNodeM = null;
        ListNode listNodeN = null ;
        ListNode headT = head;
        int i = 1;
        while (i<n) {
            if(i== m-1) {
                listNodeM = headT;
            }
            i++;
            headT = headT.next;
        }

        listNodeN = headT.next;
        ListNode preNode = null;
        if(m==1) {
            listNodeM = head;
        }else {
            preNode = listNodeM;
            listNodeM = listNodeM.next;
        }
        headT.next = null ;
        ListNode listNode = ReverseList2(listNodeM);
        listNodeM.next = listNodeN;
        if(preNode !=null) {
            preNode.next = listNode;
            return head;
        }else {
            return listNode;
        }
    }

     /*
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        if(k==0) {
            return head;
        }
        int n = 0;
        ListNode headT = head;
        while (headT!=null) {
            n++;
            headT = headT.next;
        }
        int sc = n / k;
        for (int i = 0; i < sc ; i++) {
            head = reverseBetween(head, i*k, i * k + k);
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2 ;
        listNode2.next = listNode3;

//        ListNode listNode = ReverseList(listNode1);
        ListNode listNode = reverseBetween(listNode1, 1, 2);
        System.out.println();
    }
}

