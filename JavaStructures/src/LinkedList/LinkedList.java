package LinkedList;

import Node.Node;

/**
 * A simple implementation of a singly linked list.
 * <p>
 * This class provides basic functionalities for a singly linked list including:
 * <ul>
 * <li>Constructing an empty list or a list with an initial head node.</li>
 * <li>Getting and setting the head node.</li>
 * <li>Inserting nodes at the beginning, end, or a specific position.</li>
 * <li>Removing the head node or a specific node.</li>
 * <li>Finding a node or its position in the list.</li>
 * <li>Checking if the list is empty and getting its size.</li>
 * <li>Generating a string representation of the list.</li>
 * </ul>
 * </p>
 * <p><strong>Note:</strong> This implementation assumes that the {@code Node} class provides
 * methods like {@code getValue()}, {@code getNext()}, {@code setNext()}, and overrides {@code equals()} for node comparison.</p>
 *
 * @version 1.0
 * @since 2024-06-28
 * @see Node
 * author im-somnus
 */
public class LinkedList {
    private Node head;

    /**
     * Default constructor initializing an empty list.
     */
    public LinkedList() {
        head = null;
    }

    /**
     * Constructor initializing the list with a given head node.
     *
     * @param head the initial head node of the list.
     * @throws IllegalArgumentException if the node is null.
     */
    public LinkedList(Node head) {
        if (head == null) {
            throw new IllegalArgumentException("The node can't be null");
        }

        this.head = head;
    }

    /**
     * Returns the head node of the list.
     *
     * @return the head node of the list.
     */
    public Node getHead() {
        return this.head;
    }

    /**
     * Sets the head node of the list.
     *
     * @param head the new head node.
     * @throws IllegalArgumentException if the node is null.
     */
    public void setHead(Node head) {
        if (head == null) {
            throw new IllegalArgumentException("The node can't be null");
        }

        this.head = head;
    }

    /**
     * Returns a string representation of the list.
     *
     * @return a string representation of the list.
     */
    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        Node current = this.head;

        while (current != null) {
            list.append("[").append(current.getValue()).append("]->");
            current = current.getNext();
        }

        list.append("NULL");

        return list.toString();
    }

    /**
     * Prints the string representation of the list to the console.
     */
    public void print()
    {
        System.out.println(this);
    }

    /**
     * Inserts a node at the beginning of the list.
     *
     * @param node the node to be inserted.
     * @throws IllegalArgumentException if the node is null.
     */
    public void insertFirst(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("The node can't be null");
        }

        node.setNext(this.head);
        this.head = node;
    }

    /**
     * Inserts a node at the end of the list.
     *
     * @param node the node to be inserted.
     * @throws IllegalArgumentException if the node is null.
     */
    public void insertLast(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("The node can't be null");
        }

        if (isEmpty()) {
            this.head = node;
        }
        else {
            Node current = this.head;

            while (current.getNext() != null) {
                current = current.getNext();
            }

            current.setNext(node);
        }
    }

    /**
     * Finds a node in the list.
     *
     * @param node the node to be found.
     * @return the found node, or null if the node is not found.
     */
    public Node findNode(Node node) {
        if (node == null || this.head == null) {
            return null;
        }

        Node current = this.head;

        while (current != null && !current.equals(node)) {
            current = current.getNext();
        }

        return current;
    }

    /**
     * Removes the head node of the list.
     *
     * @throws IndexOutOfBoundsException if the list is empty.
     */
    public void removeHead() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Can't remove the head from an empty list.");
        }

        this.head = this.head.getNext();
    }

    /**
     * Removes a specific node from the list.
     *
     * @param node the node to be removed.
     * @throws IllegalArgumentException if the node is null.
     * @throws IndexOutOfBoundsException if the list is empty.
     */
    public void removeNode(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("The node to remove can't be null.");
        }

        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Can't remove a node from an empty list.");
        }

        Node current = this.head;
        Node previous = current;

        while (current != null) {
            if (current.equals(node)) {
                if (current == this.head) {
                    this.head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }

                return;
            }

            previous = current;
            current = current.getNext();
        }
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return this.head == null;
    }

    /**
     * Finds the position of a node in the list.
     *
     * @param node the node whose position is to be found.
     * @return the position of the node, or -1 if the node is not found.
     * @throws IllegalArgumentException if the node is null.
     * @throws IndexOutOfBoundsException if the list is empty.
     */
    public int findNodePosition(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("The node which position you are trying to find can't be null");
        }

        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Can't find the position of a node in an empty list.");
        }

        int position = 0;
        Node current = this.head;

        while (current != null) {
            if (current.equals(node)) {
                return position;
            }
            current = current.getNext();
            position++;
        }

        return -1;
    }

    /**
     * Returns the size of the list.
     *
     * @return the size of the list.
     */
    public int getSize() {
        if (isEmpty()) {
            return 0;
        }

        Node current = this.head;
        int size = 0;

        while (current != null) {
            current = current.getNext();
            size++;
        }

        return size;
    }

    /**
     * Inserts a node at a specific position in the list.
     *
     * @param node the node to be inserted.
     * @param position the position at which to insert the node.
     * @throws IllegalArgumentException if the node is null or the position is negative.
     * @throws IndexOutOfBoundsException if the position is out of bounds.
     */
    public void insertNodeAtPosition(Node node, int position) {
        if (node == null) {
            throw new IllegalArgumentException("The node you are trying to insert can't be null");
        }

        if (position < 0) {
            throw new IllegalArgumentException("The position you are trying to insert at can't be a negative integer.");
        }

        if (position == 0) {
            insertFirst(node);
            return;
        }

        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Can't insert the node at position " + position + " in an empty list.");
        }

        Node current = this.head;
        int currentPosition = 0;

        while (current != null && currentPosition < position-1) {
            current = current.getNext();
            currentPosition++;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException("The position " + position + " is out of bounds, list will not be extended to reach that position.");
        }

        node.setNext(current.getNext());
        current.setNext(node);
    }
}
