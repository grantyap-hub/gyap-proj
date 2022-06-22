package CTCI;

import java.util.*;
import java.util.LinkedList;

public class P2_5 {

    static class Node{
        int data;
        Node next;

        public Node(){}

        public Node(int data){this.data = data;}

        public Node(int data, Node next){ this.data = data; this.next = next;}
    }

    public Node sumListsReverse(Node l1, Node l2){
        Node head = new Node(0);
        Node p = l1, q = l2, curr = head;
        int carry = 0;
        while(p != null || q != null){
            int x = (p != null) ? p.data : 0;
            int y = (q != null) ? q.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }
        if(carry > 0){
            curr.next = new Node(carry);
        }
        return head.next;
    }

    public Node sumListsForward(Node l1, Node l2){
        Node head = new Node(0);
        Node p = l1, q = l2, curr = head;
        while(p != null || q != null){

        }
        return head;
    }

    static List<Integer> revsum(Iterator<Integer> a, Iterator<Integer> b){
        var ans = new LinkedList<Integer>();
        int carry = 0;
        while(a.hasNext() || b.hasNext()){
            int A = a.hasNext() ? a.next() : 0;
            int B = b.hasNext() ? b.next() : 0;
            int S = A + B + carry;
            ans.add(S%10);
            carry = S/10;
        }
        if(carry > 0){
            ans.add(carry);
        }
        return ans;
    }

    static List<Integer> forward(LinkedList<Integer> a, LinkedList<Integer> b){
        List<Integer> out = revsum(a.descendingIterator(), b.descendingIterator());
        Collections.reverse(out);
        return out;
    }

    static List<Integer> backward(LinkedList<Integer> a, LinkedList<Integer> b){
        return revsum(a.iterator(), b.iterator());
    }


    public static void main(String[] args) {
        LinkedList<Integer> back = new LinkedList<Integer>();
        back.add(7);
        back.add(1);
        back.add(6);
        LinkedList<Integer> back1 = new LinkedList<Integer>();
        back1.add(5);
        back1.add(9);
        back1.add(2);
        System.out.println(backward(back, back1));
        LinkedList<Integer> forward = new LinkedList<Integer>();
        forward.add(6);
        forward.add(1);
        forward.add(7);
        LinkedList<Integer> forward1 = new LinkedList<Integer>();
        forward1.add(2);
        forward1.add(9);
        forward1.add(5);
        System.out.println(forward(forward, forward1));

    }
}
