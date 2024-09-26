package co.edu.uptc.utils;

public class Node<T> {
    private T data;
    private Node<T> next;  // Corregido a Node<T> para manejar el tipo genérico

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data + " -> " + (next != null ? next.toString() : "null");
    }
}
