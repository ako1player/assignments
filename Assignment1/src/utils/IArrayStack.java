package utils;


/**
 * Created by tkanchanawanchai6403 on 7/6/2016.
 */
interface IArrayStack<T> extends IStack<T> {
    void push(T element) throws OverflowException;

    boolean isFull();
}
