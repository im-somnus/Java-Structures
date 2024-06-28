package Node;

import java.util.Objects;

/**
 * A simple implementation of a node in a singly linked list.
 * <p>
 * This class represents a node in a singly linked list, storing an integer value and a reference
 * to the next node in the list. The {@code Node} class provides methods to get and set the value
 * and the next node, as well as methods for equality checking and generating a string representation.
 * </p>
 * <p>
 *
 * @version 1.0
 * @since 2024-06-28
 * author im-somnus
 */
public class Node {
    private int value;
    private Node next;

    /**
     * Constructs a node with a specified value and next node reference.
     *
     * @param value the value to be stored in the node.
     * @param next the reference to the next node in the list.
     */
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    /**
     * Constructs a node with a specified value.
     *
     * @param value the value to be stored in the node.
     */
    public Node(int value) {
        this(value, null);
    }

    /**
     * Constructs a node with a reference to the next node and a default value of 0.
     *
     * @param node the reference to the next node in the list.
     */
    public Node(Node node) {
        this(0, node);
    }

    /**
     * Constructs a node with a default value of 0 and no next node.
     */
    public Node() {
        this(0, null);
    }

    /**
     * Returns the value stored in the node.
     *
     * @return the value stored in the node.
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns the reference to the next node in the list.
     *
     * @return the reference to the next node in the list.
     */
    public Node getNext() {
        return next;
    }

    /**
     * Sets the reference to the next node in the list.
     *
     * @param next the reference to the next node.
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Sets the value stored in the node.
     *
     * @param value the value to be stored in the node.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Returns a string representation of the node.
     *
     * @return a string representation of the node.
     */
    @Override
    public String toString() {
        return "[" +
                "value=" + this.value +
                ", nextNodeValue=" + (next != null ? this.next.value : "null") +
                ']';
    }

    /**
     * Checks if this node is equal to another object.
     *
     * @param o the object to compare with.
     * @return {@code true} if this node is equal to the specified object, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return this.value == node.value && Objects.equals(this.next, node.next);
    }

    /**
     * Returns the hash code value for the node.
     *
     * @return the hash code value for the node.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.value, this.next);
    }
}
