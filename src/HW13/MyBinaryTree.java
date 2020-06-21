package HW13;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

public class MyBinaryTree implements Set {

    private Comparator comparator;

    public MyBinaryTree (Comparator comparator) {
        this.comparator=comparator;
    }

    private class Node {
        Object data;
        Node left;
        Node right;
    }

    private Node root;

    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(Object o) {
        if (isEmpty()) {
            root = new Node();
        }
        return setUp(root, o);
    }

    private boolean setUp(Node node, Object o) {
        if (node.data == null) {
            node.data = o;
            size++;
            return true;
        }
        if (comparator.compare(o, node.data) < 1) {
            if (node.left == null) {
                node.left = new Node();
                node.left.data = o;
                return true;
            } else {
                return setUp(node.left, o);
            }
        } else if (comparator.compare(o, node.data) == 0) {
            return false;
        } else {
            if (node.right == null) {
                node.right = new Node();
                node.right.data = o;
                return true;
            } else {
                return setUp(node.right, o);
            }
        }
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        if (c != null) {
            for (Object o : c) {
                add(o);
            }
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public String toString() {
        return (size == 0) ? "[]" : "[" + print(root) + "]";
    }

    private String print(Node node) {
        String result = "";
        if (node.left != null) {
            print(node.left);
        }
        result += node.data;
        if (node.right != null) {
            print(node.right);
        }
        return result;
    }
}
