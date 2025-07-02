package org.example;

import java.util.EmptyStackException;

public class MyStack {
    int counter = 0;
    int[] arr= new int[10];

    /**
     * Tests if this stack is empty
     */
    public boolean empty() {
        return counter == 0 ? true : false;
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack
     */
    public int peek() {
        if (counter == 0) {
            throw new EmptyStackException();
        } else {
            return arr[counter - 1];
        }
    }

    /**
     * Removes the object at the top of this stack and returns that object as the value of this function
     */
    public int pop() {
        if (counter == 0) {
            throw new EmptyStackException();
        } else {
            return arr[--counter];
        }
    }

    /**
     * Pushes an item onto the top of this stack
     */
    public void push(int item) {
        if ((counter) == arr.length) {
            throw new RuntimeException("Stack reached it's maximum limit");
        } else {
            arr[counter++] = item;
        }
    }

    /**
     * Returns the 1-based position where an object is on this stack
     */
    public int search(int item) {
        for (int i = counter - 1; i >= 0; i--) {
            if (item == arr[i]) {
                return counter - i;
            }
        }
        return -1;
    }
}

