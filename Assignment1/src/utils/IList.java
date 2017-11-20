package utils;

/**
 * Created by tkanchanawanchai6403 on 7/11/2016.
 */
interface IList<T> {
    int size();

    void add(T element);

    boolean contains(T element);

    T remove(T element);

    T get(T element);

    String toString();

    void reset();

    T getNext();

    boolean isEmpty();
}
