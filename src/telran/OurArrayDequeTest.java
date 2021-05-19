package telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class OurArrayDequeTest {
    OurArrayDeque<Integer> ourDeque;
    Deque<Integer> d = new ArrayDeque<>();

    @BeforeEach
    void setUp() {
        ourDeque = new OurArrayDeque<>();
    }

    @Test
    void addLast() {
        ourDeque.addLast(8);
        ourDeque.addLast(19);
        ourDeque.addLast(10);
        assertEquals(10,ourDeque.getLast());
    }

    @Test
    void testaddFirst() {
        ourDeque.addFirst(8);
        ourDeque.addFirst(19);
        ourDeque.addFirst(10);
        assertEquals(10,ourDeque.getFirst());
    }
    @Test
    void testSize_SeveralElm(){
        ourDeque.addFirst(8);
        ourDeque.addLast(19);
        ourDeque.addFirst(10);
        assertEquals(3,ourDeque.size());

    }

    @Test
    void testEmptySize() {
        assertEquals(0,ourDeque.size());
    }

    @Test
    public void textIterator_severalElements(){

        ourDeque.addLast(8);
        ourDeque.addLast(19);
        ourDeque.addLast(10);
        ourDeque.addFirst(0);
        int[] array = {0, 8, 19, 10};

        Iterator<Integer> it = ourDeque.iterator();
        int i = 0;
        while (it.hasNext()){
            int current = it.next();
            assertEquals(array[i],current);
            i++;
        }
        assertEquals(4,i);
        assertThrows(NoSuchElementException.class,() -> it.next());
    }

}