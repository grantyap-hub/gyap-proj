package CTCI;

import java.util.HashSet;

public class P2_1 {

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
            next = null;
        }
    }


    public static void deleteDups(ListNode n){
        if(n == null){
            return;
        }
        ListNode ptr = n;
        ListNode previous = n;
        HashSet<Integer> set = new HashSet<Integer>();

        while(ptr != null) {
            if (set.contains(ptr.val)) {
                previous.next = ptr.next;
            } else {
                set.add(ptr.val);
                previous = ptr;
                }

            ptr = ptr.next;
        }
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }





    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(4);
        head.next.next = new ListNode(11);

        printList(head);
        deleteDups(head);
        printList(head);
    }
}
