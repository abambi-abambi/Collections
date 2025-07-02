package org.example;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MyQueueTest {
    MyQueue queue = new MyQueue();

    @Test
    public void add() {
        assertDoesNotThrow(() -> queue.add(1));
        assertEquals(true, queue.add(2));
        for (int i = 0; i < 8; i++) {
            queue.add(i);
        }
        assertThrows(IllegalStateException.class, () -> queue.add(15));
    }

    @Test
    public void offer() {
        assertEquals(true, queue.offer(3));
        for (int i = 0; i < 9; i++) {
            queue.offer(i);
        }
        assertEquals(false, queue.offer(15));
    }

    @Test
    public void peek() {
        assertEquals(null, queue.peek());
        queue.add(1);
        assertEquals(1, queue.peek());
    }

    @Test
    public void element() {
        assertThrows(NoSuchElementException.class, () -> queue.element());
        queue.add(1);
        assertEquals(1, queue.element());
    }

    @Test
    public void remove() {
        assertThrows(NoSuchElementException.class, () -> queue.remove());
        queue.add(1);
        assertEquals(1, queue.poll());
    }

    @Test
    public void poll() {
        assertEquals(null, queue.poll());
        queue.add(1);
        assertEquals(1, queue.poll());
    }
}