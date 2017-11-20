package utils;


interface IStack<T> {
    T top() throws UnderflowException;

    T pop() throws UnderflowException;

    boolean isEmpty();

    int size();
}
