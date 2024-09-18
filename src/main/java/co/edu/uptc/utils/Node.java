package co.edu.uptc.utils;

public class Node<T> {
    T data;
    Node next;

    public Node(T data) {
        this.data = data;
        next = null;
    }

    public T getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String toString() {
        return data + "\n -> \n" + next;
    }

    public void setData(T data) {
        this.data = data;
    }

}