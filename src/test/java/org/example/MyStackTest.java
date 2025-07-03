package org.example;

import org.junit.Test;
import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyStackTest {
    MyStack stack = new MyStack();

    @Test
    public void empty() {
        assertEquals(true, stack.empty());
        stack.push(1);
        assertEquals(false, stack.empty());
    }

    @Test
    public void peek() {
        assertThrows(EmptyStackException.class, () -> stack.peek());
        stack.push(1);
        assertEquals(1, stack.peek());
        stack.push(2);
        assertEquals(2, stack.peek());
    }

    @Test
    public void pop() {
        assertThrows(EmptyStackException.class, () -> stack.pop());
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    public void push() {
        assertDoesNotThrow(() -> stack.push(1));
        for (int i = 2; i <= 10; i++) {
            stack.push(i);
        }
        assertThrows(RuntimeException.class, () -> stack.push(10));
    }

    @Test
    public void search() {
        assertEquals(-1, stack.search(1));
        stack.push(1);
        assertEquals(1, stack.search(1));
        stack.push(2);
        assertEquals(2, stack.search(1));
        assertEquals(1, stack.search(2));
        stack.pop();
        assertEquals(-1, stack.search(2));
    }
}