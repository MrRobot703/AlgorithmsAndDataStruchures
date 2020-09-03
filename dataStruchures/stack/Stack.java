package dataStruchures.stack;

public interface Stack<E> {

    //insert element e at the top of the stack.
    void push(E e);

    //remove the element at the top of the stack.
    E pop();

    //returns the current size of the stack.
    int size();
    
    //returns the element at the top of the stack without changing the stack.
    E peek();
}
