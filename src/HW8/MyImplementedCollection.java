package HW8;

import java.util.Collection;
import java.util.Iterator;

public class MyImplementedCollection implements Collection {
    private Object[] data = new Object[10];
    private int numberElements = 0;

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public int size() {
        return numberElements;
    }

    @Override
    public boolean isEmpty() {
        return (data == null || numberElements == 0);
    }

    @Override
    public boolean contains(Object object) {
        if (!isEmpty()) {
            for (Object datum : data) {
                if (object != null && object.equals(datum)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[i];
        }
        return result;
    }

    @Override
    public boolean add(Object o) {
        checkLenght();
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = o;
                if (o != null) {
                    numberElements++;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object object) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null && data[i].equals(object)) {
                data[i] = null;
                numberElements--;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        Object[] objects = c.toArray();
        for (Object object : objects) {
            add(object);
        }
        return true;
    }

    @Override
    public void clear() {
        data = null;
        numberElements = 0;
    }

    @Override
    public boolean retainAll(Collection c) {
        Object[] objects = c.toArray();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < c.size(); j++) {
                if (data[i] != null && objects[j].equals(data[i])) {
                    numberElements--;
                    data[i] = null;
                }
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        Object[] objects = c.toArray();
        for (Object o : objects) {
            while (contains(o)) {
                remove(o);
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        Object[] objects = c.toArray();
        for (Object o :
                objects) {
            if (o != null && !contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String result = "";
        if (data == null) {
            return "[]";
        }
        for (Object datum : data) {
            if (datum != null) {
                result += datum + ", ";
            }
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    private boolean isFull() {
        return (data.length > 0 && data.length == numberElements);
    }

    private void checkLenght() {
        if (isEmpty()) {
            data = new Object[10];
        }
        if (isFull()) {
            Object[] newData = new Object[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }


}
