package co.edu.uptc.utils;

import java.util.Comparator;

public class LinkedListSorter<T> {

    public Node<T> sort(Node<T> head, Comparator<T> comparator) {
        // Base case: if head is null or only one node, return the list
        if (head == null || head.getNext() == null) {
            return head;
        }

        // Find the middle of the list
        Node<T> middle = getMiddle(head);
        Node<T> nextOfMiddle = middle.getNext();

        // Set the next of middle node to null, splitting the list
        middle.setNext(null);

        // Recursively sort both halves
        Node<T> left = sort(head, comparator);
        Node<T> right = sort(nextOfMiddle, comparator);

        // Merge the sorted halves
        return merge(left, right, comparator);
    }

    // Helper method to get the middle of the linked list
    private Node<T> getMiddle(Node<T> head) {
        if (head == null) {
            return head;
        }

        Node<T> slow = head;
        Node<T> fast = head.getNext();

        // Move fast pointer twice as fast as the slow pointer
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }

    // Helper method to merge two sorted linked lists
    private Node<T> merge(Node<T> left, Node<T> right, Comparator<T> comparator) {
        if (left == null) {
            System.out.println("Left is null, returning right: " + right);
            return right;
        }
    
        if (right == null) {
            System.out.println("Right is null, returning left: " + left);
            return left;
        }
    
        // Verifica si left y right son el mismo nodo (evitar ciclos)
        if (left == right) {
            throw new IllegalStateException("A cycle has been detected in the list");
        }
    
        System.out.println("Merging nodes: Left = " + left.getData() + ", Right = " + right.getData());
    
        if (comparator.compare(left.getData(), right.getData()) <= 0) {
            left.setNext(merge(left.getNext(), right, comparator));
            return left;
        } else {
            right.setNext(merge(left, right.getNext(), comparator));
            return right;
        }
    }
}
