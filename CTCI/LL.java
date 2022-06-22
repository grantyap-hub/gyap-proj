package CTCI;

public class LL {

    Node head;

    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    public static LL insert(LL list, int data){
        Node new_node = new Node(data);
        new_node.next = null;

        if(list.head == null){
            list.head = new_node;
        }
        else{

            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;
        }
        return list;
    }

    public static void printList(LL list){
        Node currNode = list.head;

        System.out.println("LL: ");

        while(currNode != null){
            System.out.println(currNode.data + " ");

            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        LL list = new LL();

        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 8);
        list = insert(list, 13);
        list = insert(list, 11);
        list = insert(list, 3);
        list = insert(list, 5);

        printList(list);

    }
}
