package org.example;

import java.util.NoSuchElementException;

public class MyQueue {
    MyStack masterStack = new MyStack();
    MyStack slaveStack = new MyStack();
    boolean isMaster = true;

    boolean add(int item) {
        try {
            if (isMaster) {
                masterStack.push(item);
            } else {
                while (!slaveStack.empty()) {
                    masterStack.push(slaveStack.pop());
                }
                masterStack.push(item);
                isMaster = true;
            }
        } catch (RuntimeException e) {
            throw new IllegalStateException();
        }
        return true;
    }

    boolean offer(int item) {
        try {
            if (isMaster) {
                masterStack.push(item);
            } else {
                while (!slaveStack.empty()) {
                    masterStack.push(slaveStack.pop());
                }
                masterStack.push(item);
                isMaster = true;
            }
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }

    Integer peek() {
        if (isMaster == true) {
            if (masterStack.empty()) {
                return null;
            }
            while (!masterStack.empty()) {
                slaveStack.push(masterStack.pop());
            }
            isMaster = false;
        } else {
            if (slaveStack.empty()) {
                return null;
            }
        }
        return slaveStack.peek();
    }

    int element() {
        if (isMaster == true) {
            if (masterStack.empty()) {
                throw new NoSuchElementException();
            }
            while (!masterStack.empty()) {
                slaveStack.push(masterStack.pop());
            }
            isMaster = false;
        } else {
            if (slaveStack.empty()) {
                throw new NoSuchElementException();
            }
        }
        return slaveStack.peek();
    }

    int remove() {
        if (isMaster == true) {
            if (masterStack.empty()) {
                throw new NoSuchElementException();
            }
            while (!masterStack.empty()) {
                slaveStack.push(masterStack.pop());
            }
            isMaster = false;
        } else {
            if (slaveStack.empty()) {
                throw new NoSuchElementException();
            }
        }
        return slaveStack.pop();
    }

    Integer poll() {
        System.out.println(isMaster);
        System.out.println(masterStack.empty());
        System.out.println(slaveStack.empty());
        if (isMaster == true) {
            if (masterStack.empty()) {
                return null;
            }
            while (!masterStack.empty()) {
                slaveStack.push(masterStack.pop());
            }
            isMaster = false;
        } else {
            if (slaveStack.empty()) {
                return null;
            }
        }
        return slaveStack.pop();
    }
}