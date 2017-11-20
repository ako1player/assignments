package utils;

/**
 * Created by tkanchanawanchai6403 on 7/11/2016.
 */
public class ArrayOrderedList<T> implements IList<T> {

    private final int DEFCAP = 100;
    private T orderdList[];
    private int numElement;
    private int origSize;

    public ArrayOrderedList() {
        orderdList = (T[]) new Object[DEFCAP];
        origSize = DEFCAP;
        numElement = 0;
    }

    public ArrayOrderedList(int size) {
        orderdList = (T[]) new Object[size];
        origSize = size;
        numElement = 0;
    }

    @Override
    public int size() {
        return numElement;
    }

    @Override
    public void add(T element) {
        int location = 0;
        T item;
        //check if the array is full
        if (orderdList.length == size()) {
            enlarge();
        }

        //search for location to insert the new element
        for (int i = location; i < size(); i++) {
            item = orderdList[location];
            if (((Comparable) item).compareTo(element) < 0) {
                location++;
            } else {
                break;
            }
        }

        //shifting
        for (int i = numElement; i > location; i--) {
            orderdList[i] = orderdList[i - 1];
        }
        orderdList[location] = element;
        numElement++;
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public T remove(T element) {
        return null;
    }

    @Override
    public T get(T element) {
        return null;
    }

    @Override
    public void reset() {

    }

    @Override
    public T getNext() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private void enlarge() {
        T[] largerList = (T[]) new Object[2 * origSize];
        for (int i = 0; i < orderdList.length; i++) {
            largerList[i] = orderdList[i];
        }
        orderdList = largerList;
    }

    public String toString() {
        String list = "";
        for (T value : orderdList) {
            list += value + "\n";
        }
        return list;
    }
}
