package CTCI;

public class P2_3 {

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    public static boolean deleteNode(Node n){
        if(n == null || n.next == null){
            return false;
        }

        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(7);
        head.next.next = new Node(11);
        head.next.next.next = new Node(15);
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
        deleteNode(head.next);
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
