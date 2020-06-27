package HW13;

import org.junit.jupiter.api.*;

import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

class MyBinaryTreeTest {
    MyBinaryTree tree;

    @BeforeEach
    void setUp() {
        tree = new MyBinaryTree(new IntComparator());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void size() {
        assertTrue(tree.size() == 0);
        tree.add(43);
        assertTrue(tree.size() == 1);
    }

    @Test
    void isEmpty() {
        assertTrue(tree.isEmpty());
        tree.add(43);
        assertTrue(!tree.isEmpty());
    }

    @Test
    void add() {
        tree.add(233);
        assertTrue(tree.size() == 1);
        tree.add(233);
        tree.add(233);
        tree.add(233);
        assertEquals(4, tree.size());
    }

    @Test
    void clear() {
        tree.add(123);
        tree.clear();
        assertTrue(tree.isEmpty());
    }

    @Test
    void addAll() {
        Collection c = new LinkedList();
        c.add(1);
        c.add(156);
        c.add(14);
        c.add(63);
        c.add(761);
        c.add(431);
        c.add(981);
        c.add(13);
        c.add(125);
        tree.addAll(c);
        assertEquals(9, tree.size());
    }

    @Test
    void toArray() {
        int numberOfElements = 10;
        Object[] temp = new Object[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            tree.add(i * numberOfElements);
            temp[i] = i * numberOfElements;
        }
        assertEquals(numberOfElements, tree.toArray().length);
        Object[] fromTree = tree.toArray();
        for (int i = 0; i < tree.toArray().length; i++) {
            if (!fromTree[i].equals(temp[i])) {
                fail();
            }
        }
    }

    @Test
    void contains() {
        tree.add(1);
        tree.add(2);
        tree.add(33);
        tree.add(16);
        tree.add(37);
        tree.add(13);
        assertTrue(tree.contains(37));
    }

    @Test
    void containsAll() {
        int numberOfElements = 10;
        Collection c = new LinkedList();
        for (int i = 0; i < numberOfElements; i++) {
            tree.add(i * numberOfElements);
            c.add(i * numberOfElements);
        }
        assertTrue(tree.containsAll(c));
        c.remove(0);
        assertTrue(tree.containsAll(c));
        c.add(-1);
        assertTrue(!tree.containsAll(c));
    }

    @Test
    void testToString() {
        tree.add(222);
        tree.add(333);
        tree.add(111);
        tree.add(555);
        assertEquals("[111, 222, 333, 555]", tree.toString());
    }

    @Test
    void remove() {
        tree.add(7);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.remove(3);
        assertEquals(3, tree.size());
        assertEquals("[5, 7, 8]", tree.toString());
    }

    @Test
    void removeAll() {
        tree.add(1);
        tree.add(156);
        tree.add(14);
        tree.add(63);
        Collection toRemove = new ArrayList();
        toRemove.add(1);
        toRemove.add(431);
        toRemove.add(981);
        toRemove.add(13);
        toRemove.add(14);
        assertTrue(tree.removeAll(toRemove));
        assertEquals("[63, 156]", tree.toString());
    }

    @Test
    void retainAll() {
        tree.add(156);
        tree.add(1);
        tree.add(63);
        tree.add(14);
        Collection toRetain = new LinkedList();
        toRetain.add(1);
        toRetain.add(13);
        toRetain.add(14);
        assertTrue(tree.retainAll(toRetain));
        assertEquals("[1, 14]", tree.toString());
    }

    @Test
    void iterator() {
        for (int i = 0; i < 10; i++) {
            tree.add(i);
        }
        int summ = 0;
        for (Object o : tree) {
            summ += (Integer) o;
        }
        assertTrue(summ == 45);
    }


}
