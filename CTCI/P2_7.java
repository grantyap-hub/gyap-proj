package CTCI;

public class P2_7 {
    public static class Node{
        int data;
        Node next;
        public Node(){}
        public Node(int data){
            this.data = data;
        }
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        public void add(Node head, int data){
            Node newNode = new Node(data);
            newNode.next = null;
            if(head == null){
                head = newNode;
            } else{
                Node temp = new Node();
                temp = head;
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }
    }

    public static Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null) return null;

        Node a = headA;
        Node b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.add(head, 1);
        head.add(head, 8);
        head.add(head, 4);
        head.add(head, 5);
        Node head2 = new Node(5);
        head2.add(head, 6);
        head2.add(head, 1);
        head2.add(head, 8);
        head2.add(head, 4);
        head2.add(head, 5);

        //System.out.println(head.data);
    }

}
