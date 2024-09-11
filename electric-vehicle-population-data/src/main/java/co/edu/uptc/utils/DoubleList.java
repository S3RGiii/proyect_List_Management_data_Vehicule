package co.edu.uptc.utils;
    
import java.util.Iterator;

public class DoubleList<T> implements Iterable<T>{
    private DoubleNode<T> head;

    public DoubleList() {
        head = null;
    }

    public void insert(T data) {
        DoubleNode<T>newNode = new DoubleNode<T>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            DoubleNode<T> aux = head;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(newNode);
            newNode.setPrevious(aux);
        }
    }

    public boolean exist(T data) {
        DoubleNode<T> aux = head;
        while (aux != null) {
            if (aux.getData().equals(data)) {
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    public void remove(T data) {
        if (!isEmpty()) {
            DoubleNode<T> aux = head;
            DoubleNode<T> aux2 = null;
            while (aux != null) {
                if (aux.getData() == data) {
                    if (aux == head) {
                        head = aux.getNext();
                    } else {
                        aux2.setNext(aux.getNext());
                    }
                    return;
                }
                aux2 = aux;
                aux = aux.getNext();
            }
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String show() {
        return head.toString();
    }

    public String invertedShow() {
            StringBuilder result = new StringBuilder();
            DoubleNode<T> current = LastNode();
            while (current != null) {
                result.append(current.invertedToString());
                if (current.getPrevious() != null) {
                    result.append(" -> ");
                }
                current = current.getPrevious();
            }
            return result.toString();
    }
    
    private DoubleNode<T> LastNode() {
        DoubleNode<T> aux = head;
        while (aux.getNext() != null) {
            aux = aux.getNext();
        }
        return aux;
    }
    

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            private DoubleNode<T> actual = head;
            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                T data = actual.getData();
                actual = actual.getNext();
                return data;
            }
        };
        return it;
    }
    
}
