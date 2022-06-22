package CTCI;

public class P2_6 {

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
    }

    public static boolean isPalindrome(Node head){
        Node reversed = reverse(head);
        return isEqual(head, reversed);
    }

    public static Node reverse(Node node){
        Node head = null;
        while(node != null){
            Node n = new Node(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    public static boolean isEqual(Node one, Node two){
        while(one != null && two != null){
            if(one.data != two.data){
                return false;
            }
            one = one.next;
            two = two.next;
        }

        return one == null && two == null;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(5);
        System.out.println(isPalindrome(head));
    }

}
