package HW15_MyMap_implements_Map;
import java.util.*;

public class MyMap implements Map {


    public static class MyEntry {
        public Object getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        private Object key;
        private Object value;
        private MyEntry next;

        public MyEntry(Object key, Object value, MyEntry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public MyEntry getNext() {
            return next;
        }
    }

    ;
    private int size = 0;
    private MyEntry[] table = new MyEntry[100];

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        int index = key.hashCode() % 100;
        MyEntry current = table[index];
        while (current != null) {
            Object o = current.key;
            if (Objects.equals(o, key)) {
                return true;
            } else
                current = current.next;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (MyEntry o : table) {
            MyEntry current = o;
            while (current != null) {
                if (Objects.equals(value, current.value)) {
                    return true;
                } else {
                    current = current.next;
                }
            }
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        return getOrDefault(key, null);
    }

    @Override
    public Object put(Object key, Object value) {
        int index = key.hashCode() % 100;
        Object toReturn = null;
        MyEntry last = table[index];
        if (last != null) {
            toReturn = table[index].value;
        }
        table[index] = new MyEntry(key, value, last);
        size++;
        return toReturn;
    }

    @Override
    public Object remove(Object key) {
        if (containsKey(key)) {
            int index = key.hashCode() % 100;
            Object toReturn = table[index].value;
            if (Objects.equals(key, table[index].key)) {
                table[index] = table[index].next;
                size--;
                return toReturn;
            }
            MyEntry prev = table[index];
            MyEntry curr = prev;
            while (curr.next != null) {
                curr = curr.next;
                if (Objects.equals(key, curr.key)) {
                    prev.next = curr.next;
                    size--;
                    return curr.value;
                } else {
                    prev = curr;
                }
            }
        }
        return null;
    }

    @Override
    public void putAll( Map m) {
        for (Object o : m.keySet()) {
            put(o, m.get(o));
        }
    }

    @Override
    public void clear() {
        size = 0;
        table = new MyEntry[100];
    }


    @Override
    public Set keySet() {
        Set keysSet = new HashSet();
        for (MyEntry e : table) {
            if (e != null) {
                keysSet.add(e.key);
            }
        }
        return keysSet;
    }


    @Override
    public Collection values() {
        Collection valuesCollection = new ArrayList();
        for (Object o: entrySet()) {
            MyEntry entry = (MyEntry)o;
            if (entry != null) {
                valuesCollection.add(entry.value);
            }
        }
        return valuesCollection;
    }


    @Override
    public Set entrySet() {
        Set entrySet = new HashSet();
        for (MyEntry e : table) {
            if (e != null) {
                entrySet.add(e);
            }
            }

        return entrySet;
    }

    @Override
    public Object getOrDefault(Object key, Object defaultValue) {
        if (containsKey(key)) {
            int index = key.hashCode() % 100;
            MyEntry current = table[index];
            while (current != null) {
                Object o = current.key;
                if (Objects.equals(o, key)) {
                    return current.value;
                } else {
                    current = current.next;
                }
            }
        }
        return defaultValue;
    }


    @Override
    public Object putIfAbsent(Object key, Object value) {
        int index = key.hashCode() % 100;
        if (table[index] == null || table[index].value == null) {
            table[index] = new MyEntry(key, value, null);
            size++;
            return null;
        }
        return table[index].value;
    }
}