package utils;

/**
 * Created by tkanchanawanchai6403 on 7/11/2016.
 */
interface IIndexedList<T> extends IList<T> {
    void add(int index, T element);

    T set(int index, T element);

    T get(int index);

    int indexOf(T element);

    T remove(int index);
}
