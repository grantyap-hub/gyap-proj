package CTCI;

public class P2_2 {

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    public static int kth_element(Node n, int k){
        int length = 0, target = 0;

        Node ptr = n;
        while(ptr != null){
            length++;
            ptr = ptr.next;
        }
        target = length - k - 1;
        length = 0;
        while(n != null){
            if(length == target){
                return n.data;
            }
            n = n.next;
            length++;
        }
        return -1;
    }

    public static Node nthToLast(Node head, int k){
        Node p1 = head;
        Node p2 = head;

        for(int i = 0; i <= k; i++){
            if (p1 == null) return null;
            p1 = p1.next;
        }

        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(17);
        head.next.next = new Node(11);
        head.next.next.next = new Node(15);
        head.next.next.next.next = new Node(16);

        Node result = nthToLast(head, 4);
        System.out.println(result.data);
        System.out.println(kth_element(head, 1));
        Node out = null;
        System.out.println(nthToLast(out, 2));

    }
}
