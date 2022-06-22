package CTCI;

public class P2_8 {

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                ListNode newHead = head;
                while(slow != newHead){
                    slow = slow.next;
                    newHead = newHead.next;
                }
                return newHead;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }

}
