package HW10_MyLinkedList_implements_Collecton_;

import java.util.Collection;
import java.util.Iterator;

public class MyStack implements Collection {
    private class Node {
        private Node next;
        private Object data;
    }

    Node head = new Node();
    private Node current = null;
    private Node tail = null;
    private int size = 0;

    public Object getTail() {
        return (tail == null) ? null : tail.data;
    }

    @Override
    public boolean isEmpty() {
        return head.data == null;
    }

    @Override
    public void clear() {
        head = new Node();
        size = 0;
        tail = null;
    }

    @Override
    public boolean add(Object o) {
        if (o == null) {
            return false;
        }
        if (head.data == null) {
            head.next = new Node();
            head.data = o;
            tail = head;
        } else {
            tail.next = new Node();
            tail.next.data = o;
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
        MyStack incomeStack = (MyStack) c;
        current = incomeStack.head;
        while (current != null) {
            add(current.data);
            current = current.next;
        }
        return true;
    }


    @Override
    public boolean contains(Object o) {
        if (o != null) {
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
        MyStack incomeStack = (MyStack) c;
        current = head;
        while (current != null) {
            if (!incomeStack.contains(current.data)) {
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
        MyStack stack = (MyStack) c;
        current = head;
        while (current != null) {
            if (stack.contains(current.data)) {
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
        MyStack incomeStack = (MyStack) c;
        Node local = incomeStack.head;
        while (local != null) {
            if (!contains(local.data)) {
                return false;
            }
            local = local.next;
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
    public Iterator iterator() {
        return null;
    }
}
