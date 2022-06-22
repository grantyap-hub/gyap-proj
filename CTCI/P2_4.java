package CTCI;

public class P2_4 {

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    public static Node partition(Node n, int target){
        Node head = n;
        Node tail = n;

        while (n != null) {
            Node next = n.next;
            if(n.data < target){
                n.next = head;
                head = n;
            } else{
                tail.next = n;
                tail = n;
            }
            n = next;
        }
        tail.next = null;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(5);
        head.next.next = new Node(8);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);
        //head = partition(head, 5);

        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }

    }
}
