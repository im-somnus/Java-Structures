import LinkedList.LinkedList;
import Node.Node;

public class Main {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        LinkedList list = new LinkedList(node1);
        //list.print();

        Node node0 = new Node(0);
        list.insertFirst(node0);

        Node node5 = new Node(5);
        list.insertLast(node5);
        list.print();

        list.removeHead();
        list.print();
        Node node6 = new Node(6);
        list.insertNodeAtPosition(node6, 3);
        list.print();


        if (list.findNode(node4) != null) {
            System.out.println("Node is on the list: " + list.findNode(node4));
        }
        else {
            System.out.println("Node is not on the list: " + node4);
        }

        System.out.println("Number of elements on the list: " + list.getSize());

    }
}