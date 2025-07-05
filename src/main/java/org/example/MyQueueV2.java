package org.example;

import java.util.NoSuchElementException;

public class MyQueueV2 {
    MyStack masterStack = new MyStack();
    MyStack slaveStack = new MyStack();
    boolean isMaster = true;

    boolean add(int item) {
        try {
            masterStack.push(item);
        } catch (RuntimeException e) {
            throw new IllegalStateException();
        }
        return true;
    }

    boolean offer(int item) {
        try {
            masterStack.push(item);
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }

    Integer peek() {
        if (slaveStack.empty()) {
            while (!masterStack.empty()) {
                slaveStack.push(masterStack.pop());
            }
        }
        return slaveStack.empty() ? null : slaveStack.peek();
    }

    int element() {
        if (slaveStack.empty()) {
            while (!masterStack.empty()) {
                slaveStack.push(masterStack.pop());
            }
        }
        if (slaveStack.empty()) {
            throw new NoSuchElementException();
        }
        return slaveStack.peek();
    }

    Integer poll() {
        if (slaveStack.empty()) {
            while (!masterStack.empty()) {
                slaveStack.push(masterStack.pop());
            }
        }
        return slaveStack.empty() ? null : slaveStack.pop();
    }

    int remove() {
        if (slaveStack.empty()) {
            while (!masterStack.empty()) {
                slaveStack.push(masterStack.pop());
            }
        }
        if (slaveStack.empty()) {
            throw new NoSuchElementException();
        }
        return slaveStack.pop();
    }
}