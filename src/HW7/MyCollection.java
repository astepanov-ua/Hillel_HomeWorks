package HW7;

public class MyCollection {
    private Object[] data = new Object[10];
    private int numberElements = 0;

    public int size() {
        return numberElements;
    }

    public boolean isEmpty() {
        return (data == null || numberElements == 0);
    }

    public boolean contains(Object object) {
        if (!isEmpty()) {
            for (int i = 0; i < length(); i++) {
                if (object != null && object.equals(data[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public void add(Object object) {
        checkingBeforeAdd();
        for (int i = 0; i < length(); i++) {
            if (data[i] == null) {
                data[i] = object;
                if (object != null) {
                    numberElements++;
                }
                break;
            }
        }
    }

    public void remove(Object object) {
        for (int i = 0; i < length(); i++) {
            if (data[i] != null && data[i].equals(object)) {
                data[i] = null;
                if (object != null) {
                    numberElements--;
                }
            }
        }
    }

    public void addAll(MyCollection collection) {
        for (int i = 0; i < collection.length(); i++) {
            add(collection.data[i]);
        }
    }

    public void clear() {
        data = null;
        numberElements = 0;
    }

    public void retainAll(MyCollection collection) {
        for (int i = 0; i < length(); i++) {
            if (!collection.contains(data[i])) {
                if (data[i] != null) {
                    numberElements--;
                }
                data[i] = null;
            }
        }
    }

    public void removeAll(MyCollection collection) {
        for (int i = 0; i < collection.length(); i++) {
            while (contains(collection.data[i])) {
                remove(collection.data[i]);
            }
        }
    }

    public boolean containsAll(MyCollection collection) {
        for (int i = 0; i < collection.length(); i++) {
            if (collection.data[i] != null && !contains(collection.data[i])) {
                return false;
            }
        }
        return true;
    }

    private int length() {
        return data.length;
    }

    private boolean isFull() {
        return (length() > 0 && length() == numberElements);
    }

    private void checkingBeforeAdd() {
        if (isEmpty()) {
            data = new Object[10];
        }
        if (isFull()) {
            Object[] newData = new Object[length() * 2];
            for (int i = 0; i < length(); i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    @Override
    public String toString() {
        String result = "";
        if (data == null) {
            return "[]";
        }
        for (int i = 0; i < length(); i++) {
            if (data[i] != null) {
                result += data[i] + ", ";
            }
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

}
