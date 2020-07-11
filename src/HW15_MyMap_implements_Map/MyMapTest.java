package HW15_MyMap_implements_Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MyMapTest {

    MyMap myMap;

    @BeforeEach
    void setUp() {
        myMap = new MyMap();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void size() {
        assertTrue(myMap.size() == 0);
    }

    @Test
    void isEmpty() {
        assertTrue(myMap.isEmpty());
    }

    @Test
    void containsKey() {
        myMap.put(123, "1233");
        myMap.put(123, "1234");
        myMap.put(123, "1235");
        myMap.put(123, "1236");
        myMap.put(124, "124");
        assertTrue(myMap.containsKey(123));
        assertTrue(myMap.containsKey(124));
        assertFalse(myMap.containsKey(10));
    }

    @Test
    void containsValue() {
        myMap.put(123, "1233");
        myMap.put(123, "1234");
        myMap.put(123, "1235");
        myMap.put(123, "1236");
        myMap.put(124, "124");
        assertTrue(myMap.containsValue("1235"));
        assertTrue(myMap.containsValue("124"));
        assertFalse(myMap.containsValue("10"));
    }

    @Test
    void get() {
        myMap.put(123, "1233");
        myMap.put(123, "1234");
        myMap.put(123, "1235");
        myMap.put(123, "1236");
        myMap.put(124, "124");
        assertEquals("1236", myMap.get(123));
        assertNotEquals("12", myMap.get(123));
        assertEquals("124", myMap.get(124));
        assertNotEquals("104", myMap.get(124));

    }

    @Test
    void put() {
        assertEquals(null, myMap.put(1, "1"));
        assertEquals("1", myMap.put(1, "2"));

        assertEquals(null, myMap.put(22, "22"));
        myMap.put(22, "23");
        assertEquals("23", myMap.put(22, "22"));
    }

    @Test
    void remove() {
        myMap.put(123, "1233");
        myMap.put(123, "1234");
        myMap.put(123, "1235");
        myMap.put(123, "1236");
        myMap.put(124, "124");

        assertEquals("1236", myMap.remove(123));
        assertTrue(myMap.size() == 4);

        assertEquals("124", myMap.remove(124));
        assertEquals("1235", myMap.remove(123));
        assertEquals("1234", myMap.remove(123));
        assertEquals("1233", myMap.remove(123));
        assertEquals(null, myMap.remove(123));
        assertTrue(myMap.isEmpty());
    }

    @Test
    void putAll() {
        HashMap mapToAdd = new HashMap();
        mapToAdd.put(12, "1233");
        mapToAdd.put(13, "1235");
        mapToAdd.put(23, "1236");
        mapToAdd.put(123, "1234");
        mapToAdd.put(124, "124");
        myMap.putAll(mapToAdd);
        assertTrue(myMap.size() == 5);
        assertTrue("1235" == myMap.get(13));
        assertEquals("1233", myMap.get(12));
    }

    @Test
    void clear() {
        myMap.clear();
        assertEquals(0, myMap.size());
    }

    @Test
    void keySet() {
        myMap.put(123, "1233");
        myMap.put(123, "1234");
        myMap.put(123, "1235");
        myMap.put(123, "1236");
        myMap.put(124, "124");
        for (Object o : myMap.keySet()) {
            myMap.containsKey(o);
        }
    }

    @Test
    void values() {
        myMap.put(123, "1233");
        myMap.put(123, "1234");
        myMap.put(123, "1235");
        myMap.put(123, "1236");
        myMap.put(124, "124");
        for (Object o : myMap.keySet()) {
            myMap.containsValue(o);
        }
    }

    @Test
    void entrySet() {
        myMap.put(123, "1233");
        myMap.put(123, "1234");
        myMap.put(123, "1235");
        myMap.put(123, "1236");
        myMap.put(124, "124");
        for (Object e : myMap.entrySet()) {
            MyMap.MyEntry entry = (MyMap.MyEntry) e;
            do {
                assertTrue(myMap.containsKey(entry.getKey()) && myMap.containsValue(entry.getValue()));
                entry = entry.getNext();
            }
            while (entry != null);
        }
    }

    @Test
    void getOrDefault() {
        myMap.put(128, "1233");
        myMap.put(123, "1234");
        myMap.put(125, "1235");
        myMap.put(123, "1236");
        myMap.put(124, "124");
        assertEquals("1233", myMap.getOrDefault(128, 0));
        assertEquals("default", myMap.getOrDefault(129, "default"));
    }

    @Test
    void putIfAbsent() {
       myMap.putIfAbsent(1, "1");
       myMap.putIfAbsent(1, "2");

       myMap.putIfAbsent(2, "2");
       myMap.putIfAbsent(2, "3");
       assertTrue(myMap.size()==2);
}

}