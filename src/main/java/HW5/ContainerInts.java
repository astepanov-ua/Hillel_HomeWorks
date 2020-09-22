package HW5;

public class ContainerInts {
    private int[] array = new int[0];

    public void add(int element) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = element;
        array = newArray;
    }

    public void addAll(int[] arrayToAdd) {
        if (array.length == 0) {
            array = new int[arrayToAdd.length];
            for (int i = 0; i < arrayToAdd.length; i++) {
                array[i] = arrayToAdd[i];
            }
        } else {
            int[] newArray = new int[array.length + arrayToAdd.length];
            for (int i = 0; i < array.length + arrayToAdd.length; i++) {
                newArray[i] = (i < array.length) ? array[i] : arrayToAdd[i - array.length];
            }
            array = newArray;
        }
    }

    public void clear() {
        array = new int[0];
    }

    public boolean contains(int element) {
        for (int i : array) {
            if (i == element) {
                return true;
            }
        }
        return false;
    }

    public int[] getArray() {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public int[] getAllIndexesOf(int element) {
        int[] indexes = {-1};
        int count = 0;
        if (contains(element)) {
            for (int value : array) {
                if (value == element) {
                    count++;
                }
            }
            indexes = new int[count];
            for (int i = 0, j = 0; i < array.length; i++) {
                if (array[i] == element) {
                    indexes[j++] = i;
                }
            }
        }
        return indexes;
    }

    public int getByIndex(int index) {
        return (index >= array.length || index < 0) ? -1 : array[index];
    }

    public int getFirstIndexOf(int element) {
        if (contains(element)) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == element) {
                    return i;
                }
            }
            return -1;
        } else {
            return -1;
        }
    }

    public int getSize() {
        return array.length;
    }

    public boolean isEqualsByLink(int[] arrayToCheck) {
        return (array == arrayToCheck);
    }

    public boolean isEqualsByContent(int[] arrayToCheck) {
        if (array.length == arrayToCheck.length) {
            for (int value : arrayToCheck) {
                if (!contains(value)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void printArrayInLane() {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void sort() {
        boolean needToSort;
        do {
            needToSort = false;
            if (getSize() > 1) {
                for (int i = 1; i < getSize(); i++) {
                    if (array[i] < array[i - 1]) {
                        array[i] += array[i - 1];
                        array[i - 1] = array[i] - array[i - 1];
                        array[i] = array[i] - array[i - 1];
                        needToSort = true;
                        break;
                    }
                }
            }
        } while (needToSort);
    }
}

