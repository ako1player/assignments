package utils;



interface IArrayQueue<T> extends IQueue<T> {
    void enqueue(T element) throws OverflowException;

    boolean isFull();
}
