package utils;



/**
 * Created by tkanchanawanchai6403 on 7/6/2016.
 */
public class ArrayQueue<T> implements IArrayQueue<T> {

    @Override
    public void enqueue(T element) throws OverflowException {

    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public T dequeue() throws UnderflowException {
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
