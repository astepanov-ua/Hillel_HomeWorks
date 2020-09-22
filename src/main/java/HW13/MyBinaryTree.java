package HW13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class MyBinaryTree implements Collection {
    private Comparator comparator;

    public MyBinaryTree(Comparator comparator) {
        this.comparator = comparator;
    }

    private class Node {
        Object data;
        Node left;
        Node right;
        Node parent;
    }

    private Node root;
    private int size = 0;

    private Node minimum(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

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
                node.left.parent = node;
                size++;
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
                node.right.parent = node;
                size++;
                return true;
            } else {
                return setUp(node.right, o);
            }
        }
    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty() || !contains(o)) {
            return false;
        }
        root = delete(root, o);
        size--;
        return true;
    }

    private Node delete(Node node, Object o) {
        if (node == null) {
            return node;
        }
        if (comparator.compare(o, node.data) < 0) {
            node.left = delete(node.left, o);
        } else if (comparator.compare(o, node.data) > 0) {
            node.right = delete(node.right, o);
        } else {
            if (node.left != null && node.right != null) {
                node.data = minimum(node.right).data;
                node.right = delete(node.right, node.data);
            } else {
                if (node.left != null) {
                    node.left.parent = node.parent;
                    node = node.left;
                } else if (node.right != null) {
                    node.right.parent = node.parent;
                    node = node.right;
                } else {
                    node = null;
                }
            }
        }
        return node;
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
        return search(root, o);
    }

    private boolean search(Node root, Object o) {
        if (comparator.compare(o, root.data) > 0) {
            return root.right == null ? false : search(root.right, o);
        } else if (comparator.compare(o, root.data) < 0) {
            return root.left == null ? false : search(root.left, o);
        } else {
            return true;
        }
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return (size == 0) ? null : collectElements(root, new ArrayList()).toArray();
    }

    private ArrayList collectElements(Node node, ArrayList array) {
        if (node.left != null) {
            collectElements(node.left, array);
        }
        array.add(node.data);
        if (node.right != null) {
            collectElements(node.right, array);
        }
        return array;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean hasChanged = false;
        for (Object o : c) {
            if (!hasChanged) {
                hasChanged = remove(o);
            } else {
                remove(o);
            }
        }
        return hasChanged;
    }

    @Override
    public boolean retainAll(Collection c) {
        Object[] array = toArray();
        for (Object o : array) {
            if (!c.contains(o)) {
                remove(o);
            }
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
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
        if (size == 0) {
            return "[]";
        }
        String toString = print(root, "");
        return "[" + toString.substring(0, toString.length() - 2) + "]";
    }

    private String print(Node node, String incomeResult) {
        String result = incomeResult;
        if (node.left != null) {
            result = print(node.left, result);
        }
        result += node.data + ", ";
        if (node.right != null) {
            result = print(node.right, result);
        }
        return result;
    }
}
