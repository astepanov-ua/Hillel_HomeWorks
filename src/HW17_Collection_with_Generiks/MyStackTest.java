package HW17_Collection_with_Generiks;

import HW18_Save_to_JSON.Worker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {
    MyStack<Worker> stack;

    @BeforeEach
    void setUp() {
        stack = new MyStack<>();
    }

    @Test
    void isEmpty() {
        assertTrue(stack.isEmpty());
        stack.add(new Worker("Ivan", 24));
        assertFalse(stack.isEmpty());
    }

    @Test
    void size() {
        assertTrue(stack.size() == 0);
        stack.add(new Worker("Ivan", 24));
        assertTrue(stack.size() == 1);
        stack.add(new Worker("Anton", 24));
        assertTrue(stack.size() == 2);
    }

    @Test
    void clear() {
        stack.add(new Worker("Ivan", 24));
        stack.add(new Worker("Anton", 24));
        assertTrue(stack.isEmpty() & stack.size() == 0 & stack.head == null);
        stack.clear();
    }

    @Test
    void add() {
        stack.add(new Worker("Anton", 24));
        stack.add(new Worker("Ivan", 24));
        assertTrue(stack.head.data.equals(new Worker("Anton", 24)));
    }

    @Test
    void addAll() {
        Collection collectionToAdd = new LinkedList();
        collectionToAdd.add(new Worker("Anton", 24));
        collectionToAdd.add(new Worker("Ivan", 25));
        collectionToAdd.add(new Worker("John", 21));
        stack.addAll(collectionToAdd);
        assertTrue(stack.size() == 3);
    }

    @Test
    void contains() {
        stack.add(new Worker("Anton", 24));
        stack.add(new Worker("Ivan", 24));
        assertTrue(stack.contains(new Worker("Anton", 24)));
        assertFalse(stack.contains(new Worker("Anton", 25)));
    }

    @Test
    void toArray() {
        stack.add(new Worker("Anton", 24));
        stack.add(new Worker("Ivan", 25));
        stack.add(new Worker("Boris", 34));
        stack.add(new Worker("Ravshan", 26));
        for (Object o : stack.toArray()) {
            assertTrue(stack.contains(o));
        }
    }

    @Test
    void remove() {
        stack.add(new Worker("Anton", 24));
        stack.add(new Worker("Ivan", 25));
        stack.add(new Worker("Boris", 34));

        stack.remove(new Worker("Ivan", 25));
        assertTrue(stack.size() == 2);
        stack.remove(new Worker("Anton", 24));
        stack.remove(new Worker("Boris", 34));
        assertTrue(stack.isEmpty());
    }

    @Test
    void retainAll() {
        Collection collectionToRetain = new LinkedList();
        collectionToRetain.add(new Worker("Anton", 24));
        collectionToRetain.add(new Worker("Ivan", 25));
        collectionToRetain.add(new Worker("John", 21));


        stack.add(new Worker("Anton", 24));
        stack.add(new Worker("Ivan", 25));
        stack.add(new Worker("John", 200000));
        stack.retainAll(collectionToRetain);

        assertTrue(stack.size() == 2);
    }

    @Test
    void removeAll() {
        Collection collectionToRemove = new LinkedList();
        collectionToRemove.add(new Worker("Anton", 24));
        collectionToRemove.add(new Worker("Ivan", 25));
        collectionToRemove.add(new Worker("John", 21));


        stack.add(new Worker("Anton", 24));
        stack.add(new Worker("Ivan", 25));
        stack.add(new Worker("John", 200000));
        stack.removeAll(collectionToRemove);
        System.out.println(stack.size());
        assertTrue(stack.size() == 1);
    }

    @Test
    void containsAll() {
        stack.add(new Worker("Anton", 24));
        stack.add(new Worker("Ivan", 25));
        stack.add(new Worker("John", 200000));


        Collection c = new ArrayList<Worker>();
        for (Object o : stack.toArray()) {
            c.add(o);
        }
        stack.add(new Worker("Anton", 24000));
        assertTrue(stack.containsAll(c));

        c.add(new Worker("Andrey", 1));
        assertFalse(stack.containsAll(c));
    }

    @Test
    void iterator() {
        for (Object o : stack) {
            assertTrue(o instanceof Worker);
        }
    }
}