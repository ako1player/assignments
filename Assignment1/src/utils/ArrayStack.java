package utils;


/**
 * Created by tkanchanawanchai6403 on 7/6/2016.
 */
public class ArrayStack<T> implements IArrayStack<T> {

    @Override
    public void push(T element) throws OverflowException {

    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public T top() throws UnderflowException {
        return null;
    }

    @Override
    public T pop() throws UnderflowException {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
