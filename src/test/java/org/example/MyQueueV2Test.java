package org.example;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class MyQueueV2Test {

    MyQueueV2 queue = new MyQueueV2();

    @Test
    public void add() {
        for (int i = 1; i <= 10; i++) {
            assertEquals(true, queue.add(i));
        }
        assertThrows(IllegalStateException.class, () -> queue.add(11));
    }

    @Test
    public void offer() {
        for (int i = 1; i <= 10; i++) {
            assertEquals(true, queue.offer(i));
        }
        assertEquals(false, queue.offer(10));
    }

    @Test
    public void peek() {
        assertEquals(null, queue.peek());
        queue.add(1);
        assertEquals(1, queue.peek());
        queue.add(2);
        assertEquals(1, queue.peek());
    }

    @Test
    public void element() {
        assertThrows(NoSuchElementException.class, () -> queue.element());
        queue.add(1);
        assertEquals(1, queue.element());
        queue.add(2);
        assertEquals(1, queue.element());
    }

    @Test
    public void remove() {
        assertThrows(NoSuchElementException.class, () -> queue.remove());
        queue.add(1);
        queue.add(2);
        assertEquals(1, queue.remove());
        assertEquals(2, queue.remove());
    }

    @Test
    public void poll() {
        assertEquals(null, queue.poll());
        for (int i = 1; i <= 10; i++) {
            queue.add(i);
        }
        for (int i = 1; i <= 10; i++) {
            assertEquals(i, queue.poll());
        }
    }
}