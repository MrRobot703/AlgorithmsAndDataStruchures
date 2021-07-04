package dataStruchures.queue.impl;

import dataStruchures.queue.Queue;
import dataStruchures.queue.exceptions.QueueEmptyException;
import dataStruchures.queue.exceptions.QueueOutOfSizeException;

public class CircularArrayQueue<E>  implements Queue<E> {
    private E[] array;
    private int head;
    private int tail;
    private int size;

    @SuppressWarnings("unchecked")
    public CircularArrayQueue(int capacity) {
        array = (E[]) new Object[capacity];
        head = 0;
        tail = -1;
    }

    @Override
    public void enqueue(E e) {
        if (size >= array.length) {
            throw new QueueOutOfSizeException();
        }
        tail = (tail + 1)%array.length;
        array[tail] = e;
        size++;
    }

    @Override
    public E dequeue() {
        if (size <= 0) {
            throw new QueueEmptyException();
        }
        E e = peek();
        head = (head + 1)%array.length;
        size--;
        return e;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E peek() {
        return (E) array[head];
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        for (int i = 0; i < size; i++) {
            string.append(array[(head + i)%array.length]).append(", ");
        }
        if (size == 0) {
            string.append("]");
        } else {
            string.replace(string.length() - 2, string.length(), "]");
        }
        return string.toString();
    }
}
