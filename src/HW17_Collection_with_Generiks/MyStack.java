package HW17_Collection_with_Generiks;

import java.util.Collection;
import java.util.Iterator;

public class MyStack<E extends Comparable<E>> implements Collection<E> {
    public MyStack() {
    }

    public class Node<E> {
        public Node next;
        public E data;
    }

    Node head;
    private Node current = null;
    private Node tail = null;
    private int size = 0;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
        tail = null;
    }

    @Override
    public boolean add(E e) {
        if (e == null) {
            return false;
        }
        if (head == null) {
            head = new Node();
            head.data = e;
            tail = head;
        } else {
            tail.next = new Node();
            tail.next.data = e;
            tail = tail.next;
        }
        size++;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean addAll(Collection c) {
        if (c == null) {
            return false;
        }
        for (Object o : c) {
            add((E) o);
        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
        if (o != null) {
            o = (E) o;
            current = head;
            while (current != null) {
                if (o.equals(current.data)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size()];
        current = head;
        int i = 0;
        while (current != null) {
            result[i++] = current.data;
            current = current.next;
        }
        return result;
    }


    @Override
    public boolean remove(Object o) {
        if (contains(o)) {
            if (o.equals(head.data)) {
                if (head.next == null) {
                    clear();
                } else {
                    head = head.next;
                    size--;
                }
                return true;
            } else {
                Node previous = new Node();
                current = head;
                while (current != null) {
                    if (o.equals(current.data)) {
                        previous.next = current.next;
                        size--;
                        if (current == tail) {
                            tail = previous;
                        }
                        return true;
                    }
                    previous = current;
                    current = current.next;
                }
            }
        }
        return false;
    }


    @Override
    public boolean retainAll(Collection c) {
        if (c == null) {
            return false;
        }
        current = head;
        while (current != null) {
            if (!c.contains(current.data)) {
                remove(current.data);
            }
            current = current.next;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        if (c == null) {
            return false;
        }
        current = head;
        while (current != null) {
            if (c.contains(current.data)) {
                remove(current.data);
            }
            current = current.next;
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        if (c == null) {
            return false;
        }
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "nothing (is empty)";
        }
        current = head;
        String result = "";
        while (current != null) {
            result += current.data + ", ";
            current = current.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator() {
            Node iterable = head;
            E toReturn = null;

            @Override
            public boolean hasNext() {
                return (!(iterable == null));
            }

            @Override
            public E next() {
                if (hasNext()) {
                    toReturn = (E) iterable.data;
                    iterable = iterable.next;
                    return toReturn;
                }
                return null;
            }
        };
    }
}
