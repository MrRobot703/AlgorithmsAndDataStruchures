package dataStruchures.stack.impl;

import dataStruchures.stack.Stack;
import dataStruchures.stack.exceptions.StackOverflowException;
import dataStruchures.stack.exceptions.StackUnderflowException;

public class ArrayStack<E> implements Stack<E> {
    private Object[] array;
    private int nextIndex;

    public ArrayStack(int size) {
        this.array = new Object[size];
    }

    @Override
    public void push(E e) {
        if (nextIndex == array.length) {
            throw new StackOverflowException();
        } else {
            array[nextIndex] = e;
            nextIndex++;
        }
    }

    @Override
    public E pop() {
        E e = checkLast();
        nextIndex--;
        return e;
    }

    @Override
    public int size() {
        return nextIndex;
    }

    @Override
    public E peek() {
        return checkLast();
    }

    @SuppressWarnings("unchecked")
    private E checkLast() {
        if(nextIndex <= 0) {
            throw new StackUnderflowException();
        } else {
            return (E) array[nextIndex - 1];
        }
    }

    @Override
    public String toString() {
        StringBuilder arrayString = new StringBuilder();
        arrayString.append("[");
        for (int i = 0; i < nextIndex; i++) {
            arrayString.append(array[i]).append(", ");
        }
        arrayString.replace(arrayString.length() - 2, arrayString.length(), "]");
        return arrayString.toString();
    }
}
