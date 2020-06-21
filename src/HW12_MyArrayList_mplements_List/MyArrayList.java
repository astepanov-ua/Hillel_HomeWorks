package HW12_MyArrayList_mplements_List;

import java.util.*;

public class MyArrayList implements List {
    private int size;
    private Object[] dataArray;

    public MyArrayList() {
        size = 0;
        dataArray = new Object[size];
    }

    private MyArrayList(int lenght) {
        size = 0;
        dataArray = new Object[lenght];
    }

    @Override
    public String toString() {
        String result = "";
        if (size != 0) {
            for (Object object : dataArray) {
                if (object != null) {
                    result += object + ", ";
                }
            }
            result = "[" + result.substring(0, result.length() - 2) + "]";
        } else {
            result = "[]";
        }
        return result;
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
        if (size >= dataArray.length) {
            increaseArray();
        }
        dataArray[size] = o;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null || size == 0) {
            return false;
        }
        for (int i = 0; i < dataArray.length; i++) {
            if (Objects.equals(dataArray[i], o)) {
                for (int j = i; j < size - 1; j++) {
                    dataArray[j] = dataArray[j + 1];
                }
                dataArray[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        for (Object object : c) {
            add(object);
        }
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        if (isIndexCorrect(index) && c.size() != 0) {
            for (Object fromColl : c) {
                add(index++, fromColl);
            }
            return true;
        }
        return false;
    }

    @Override
    public void sort(Comparator c) {
        if (dataArray.length > 1) {
            boolean needToSort = true;
            Object temp;
            while (needToSort) {
                for (int i = 0; i < dataArray.length - 1; i++) {
                    if (c.compare(dataArray[i + 1], dataArray[i]) < 0) {
                        temp = dataArray[i];
                        dataArray[i] = dataArray[i + 1];
                        dataArray[i + 1] = temp;
                        needToSort = true;
                        break;
                    } else {
                        needToSort = false;
                    }
                }
            }
        }
    }

    @Override
    public void clear() {
        dataArray = new Object[0];
        size = 0;

    }

    @Override
    public Object get(int index) {
        Object toReturn;
        return toReturn = (isIndexCorrect(index)) ? dataArray[index] : null;
    }

    @Override
    public Object set(int index, Object element) {
        if (isIndexCorrect(index)) {
            dataArray[index] = element;
            return true;
        }
        return false;
    }

    @Override
    public void add(int index, Object element) {
        if (isIndexCorrect(index)) {
            Object elementToAdd = element;
            Object elementToShift;
            for (int i = index; i < size; i++) {
                elementToShift = dataArray[i];
                dataArray[i] = elementToAdd;
                elementToAdd = elementToShift;
            }
            add(elementToAdd);
        }
    }

    @Override
    public Object remove(int index) {
        Object toReturn = null;
        if (isIndexCorrect(index)) {
            toReturn = dataArray[index];
        }
        return remove(toReturn);
    }

    @Override
    public int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++) {
                if (Objects.equals(dataArray[i], o)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o != null) {
            for (int i = size - 1; i >= 0; i--) {
                if (Objects.equals(dataArray[i], o)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        if (fromIndex <= toIndex && isIndexCorrect(fromIndex) && isIndexCorrect(toIndex)) {
            List toReturn = new MyArrayList(toIndex - fromIndex);
            while (fromIndex < toIndex) {
                toReturn.add(dataArray[fromIndex++]);
            }
            return toReturn;
        }
        return null;
    }

    @Override
    public boolean contains(Object o) {
        for (Object data : dataArray) {
            if (Objects.equals(data, o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object objectFromCollection : c) {
            if (!contains(objectFromCollection)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection c) {
        boolean dataIsChanged = false;
        for (Object data : dataArray) {
            if (c.contains(data)) {
                dataIsChanged = remove(data);
            }
        }
        return dataIsChanged;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean dataIsChanged = false;
        for (Object objectFromCollection : c) {
            if (dataIsChanged) {
                remove(objectFromCollection);
            } else {
                dataIsChanged = remove(objectFromCollection);
            }
        }
        return dataIsChanged;
    }

    @Override
    public Object[] toArray(Object[] a) {
        Object[] toReturn = new Object[size];
        for (int i = 0, j = 0; i < dataArray.length; i++) {
            if (dataArray[i] != null) {
                toReturn[j++] = dataArray[i];
            }
        }
        return toReturn;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0, j = 0; i < dataArray.length; i++) {
            if (dataArray[i] != null) {
                result[j++] = dataArray[i];
            }
        }
        return result;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            Object[] iterArray = toArray();
            int i = 0;

            @Override
            public boolean hasNext() {
                return (i < iterArray.length);
            }

            @Override
            public Object next() {
                return (hasNext()) ? iterArray[i++] : null;
            }
        };
    }

    @Override
    public ListIterator listIterator() {
        return new ListIterator() {
            Object[] array = toArray();
            int nextI = 0;
            int previousI = -1;
            int lastCalledIndex;

            @Override
            public boolean hasNext() {
                return nextI < array.length;
            }

            @Override
            public Object next() {
                lastCalledIndex = nextI;
                return array[nextI++];
            }

            @Override
            public boolean hasPrevious() {
                return previousI > 0;
            }

            @Override
            public Object previous() {
                lastCalledIndex = previousI;
                return array[previousI--];
            }

            @Override
            public int nextIndex() {
                return Math.min(nextI, array.length);
            }

            @Override
            public int previousIndex() {
                return Math.max(previousI, -1);
            }

            @Override
            public void remove() {
                MyArrayList.this.remove(lastCalledIndex);
            }

            @Override
            public void set(Object o) {
                MyArrayList.this.set(lastCalledIndex, o);
            }

            @Override
            public void add(Object o) {
                MyArrayList.this.add(lastCalledIndex, o);
            }
        };
    }

    @Override
    public ListIterator listIterator(int index) {
        return new ListIterator() {
            Object[] array = toArray();
            int nextI = index;
            int previousI = index - 1;
            int lastCalledIndex;

            @Override
            public boolean hasNext() {
                return nextI < array.length;
            }

            @Override
            public Object next() {
                lastCalledIndex = nextI;
                return array[nextI++];
            }

            @Override
            public boolean hasPrevious() {
                return previousI > 0;
            }

            @Override
            public Object previous() {
                lastCalledIndex = previousI;
                return array[previousI--];
            }

            @Override
            public int nextIndex() {
                return Math.min(nextI, array.length);
            }

            @Override
            public int previousIndex() {
                return Math.max(previousI, -1);
            }

            @Override
            public void remove() {
                MyArrayList.this.remove(lastCalledIndex);
            }

            @Override
            public void set(Object o) {
                MyArrayList.this.set(lastCalledIndex, o);
            }

            @Override
            public void add(Object o) {
                MyArrayList.this.add(lastCalledIndex, o);
            }
        };
    }

    private boolean isIndexCorrect(int index) {
        return index >= 0 && index < size;
    }

    private void increaseArray() {
        int newArrayLenght = (int) (dataArray.length * 1.5 + 1);
        Object[] newDataArray = new Object[newArrayLenght];
        for (int i = 0; i < dataArray.length; i++) {
            newDataArray[i] = dataArray[i];
        }
        dataArray = newDataArray;
    }
}
