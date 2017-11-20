package utils;


interface IQueue<T> {
    T dequeue() throws UnderflowException;

    boolean isEmpty();

    int size();
}
