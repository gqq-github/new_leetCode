package cn.gq.华为机试;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author cherry_xx
 * @create 2021/4/17 18:34
 * @update 2021/4/17
 * Description:
 * 输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。
 *
 * 链表的值不能重复。
 *
 * 构造过程，例如
 *
 * 1 <- 2
 *
 * 3 <- 2
 *
 * 5 <- 1
 *
 * 4 <- 5
 *
 * 7 <- 2
 * @since 1.0.0
 */
public class 列表的插入 {
    public static void main(String[] args) throws Exception {
        LinkedList<Integer> node = new LinkedList<>();
        Scanner in = new Scanner(System.in);
       int num  =  in.nextInt();
       int head = in.nextInt();
       new Node(head, null);
       for (int i = 0 ; i<num-1 ;i++) {
           int lastData = in.nextInt();
           int preData  = in.nextInt();
           Node.insertNode(Node.findNode(preData), lastData);
       }
        int del = in.nextInt();
        Node.deleteNode(Node.findNode(del));
        Node.print();
    }

    static class  Node {
       private Integer value;
       private Node next;
       private static Node head;
        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(Integer value, Node next) {
            this.value = value;
            this.next = next;
            if(head==null) {
                head = this;
            }

        }
      public static void   insertNode (Node node,Integer vale) {

       if(node==head) {
           node.next = new Node(vale, node.next);
       }else {
           node.next.next = new Node(vale, node.next.next);
       }

      }
      public static void deleteNode(Node node) {
            if(node==head) {
               Node temp = node.next;
                head.next = null;
                head = temp;
                return;
            }
            node.next = node.next.next;

      }
        // 返回列表的前一个节点
        public static Node findNode(Integer value) throws Exception {
            if(head==null) {
                throw new Exception("列表没有初始化");
            }
            if(head.value.compareTo(value)==0) {
                return head;
            }
            Node pre = head;
            Node nextNode = pre.next;
            while (nextNode!=null) {
               if(nextNode.value.compareTo(value)==0){
                   break;
               }
                pre = nextNode;
                nextNode = nextNode.next;
            }
            return pre;
        }

        public static boolean  isHead(Integer value){
            return head.value.compareTo(value) == 0;
        }

        public static void print () {
            Node printNode = head;
            StringBuilder buf = new StringBuilder();
            while (printNode!=null) {
                buf.append(printNode.value).append("#");
                printNode = printNode.next;
            }
            if(buf.length()>0) {
                buf.delete(buf.length() - 1, buf.length());
            }
            System.out.println(buf.toString());
        }
    }

}
