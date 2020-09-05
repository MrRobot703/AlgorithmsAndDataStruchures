package dataStruchures.queue;

public interface Queue<E> {

    //Insert element e at the tail of the queue.
    void enqueue(E e);

    //Remove the element at the head of the queue.
    E dequeue();

    //Returns the current size of the queue.
    int size();

    //Returns the element at the head of the queue without changing the queue.
    E peek();
}
