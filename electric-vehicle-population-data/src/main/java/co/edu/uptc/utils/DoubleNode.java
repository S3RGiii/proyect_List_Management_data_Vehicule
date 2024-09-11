package co.edu.uptc.utils;
public class DoubleNode <T>{
    DoubleNode previous;
    DoubleNode next;
    T data;
    public DoubleNode(T data) {
        this.data = data;
        next = null;
        previous = null;
    }

    public T getData() {
        return data;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public DoubleNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode previous) {
        this.previous = previous;
    }

    public String toString() {
        return data + "-> " + next;
    }
    public String invertedToString() {
        return data.toString();
    }

    
}