package co.edu.uptc.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyList<E> implements List<E> {
    private Node<E> head;

    @Override
    public boolean add(E e) {
        if (isEmpty()) {
            head = new Node<>(e);
            return true;
        } else {
            Node<E> temp = new Node<>(e);
            Node<E> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(temp);
            return true;
        }
    }

    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node<>(element);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) throws NullPointerException {
        if (c == null) {
            throw new NullPointerException();
        }
        boolean modified = false;
        for (E element : c) {
            if (add(element)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        boolean modified = false;
        for (E element : c) {
            add(index++, element);
            modified = true;
        }
        return modified;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public boolean contains(Object o) {
        if (isInstanceOf(o.getClass(), head.getData())) {
            throw new ClassCastException();
        }
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (it.next().equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MyList<?> myList = (MyList<?>) o;
        if (size() != myList.size())
            return false;
        Iterator<E> it = iterator();
        Iterator<?> it2 = myList.iterator();
        while (it.hasNext()) {
            if (!it.next().equals(it2.next())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> current = (Node<E>) head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

        @Override
        public int hashCode() {
            int result = 1;
            for (E element : this) {
                result = 31 * result + (element == null ? 0 : element.hashCode());
            }
            return result;
        }
    @Override
    public int indexOf(Object o) {
        Node<E> current = head;
        int index = 0;
    
        while (current != null) {
            if (current.getData().equals(o)) {
                return index; 
            }
            current = current.getNext();
            index++;
        }
        return -1; 
    }
    
    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }
    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        Node<E> current = head;
        int i = 0;
        while (current != null) {
            if (current.getData().equals(o)) {
                index = i;
            }
            current = current.getNext();
            i++;
        }
        return index;
    }
    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("sin meetodo");
    }

    @Override

    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("sin meetodo");
    }

    
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> current = (Node<E>) head;
        Node<E> previous = null;
        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) {
            head = current.getNext();
        } else {
            previous.setNext(current.getNext());
        }

        return current.getData();
    }
    @Override
    public boolean remove(Object o) {
        if (isEmpty()) {
            return false;
        }
        Node<E> current = head;
        if (current.getData().equals(o)) {
            head = head.getNext();
            return true;
        }
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(o)) {
                current.setNext(current.getNext().getNext());
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object element : c) {
            if (remove(element)) {
                modified = true;
            }
        }
        return modified;
    }
    
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Node<E> current = head;
        while (current != null) {
            if (!c.contains(current.getData())) {
                remove(current.getData());
                modified = true;
            }
            current = current.getNext();
        }
        return modified;
    }
    
    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> current = (Node<E>) head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        E oldValue = current.getData();
        current.setData(element);

        return oldValue;
    }


    @Override
    public int size() {
        int size = 0;
        Node<E> current = head;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }


    public static <E> boolean isInstanceOf(Class<E> clazz, Object o) {
        return clazz.isInstance(o);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        MyList<E> list = new MyList<>();
        Node<E> current = head;
        for (int i = 0; i < fromIndex; i++) {
            current = current.getNext();
        }
        for (int i = fromIndex; i < toIndex; i++) {
            list.add(current.getData());
            current = current.getNext();
        }
        return list;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        int index = 0;
        Node<E> current = (Node<E>) head;
        while (current != null) {
            array[index++] = current.getData();
            current = current.getNext();
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        int i = 0;
        Iterator<E> current = iterator();
        while (current.hasNext()) {
            a[i] = (T) current.next();
            i++;
        }
        return a;
    }


}
