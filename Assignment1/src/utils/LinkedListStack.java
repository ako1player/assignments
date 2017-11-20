package utils;

public class LinkedListStack<T> implements ILinkedListStack<T> {
    private LinkedListNode<T> top;
    private int numElement=0;
    @Override
    public T top() throws UnderflowException {
        if(isEmpty()) {
            throw new UnderflowException("Cannot top an empty stack!");
        }
        return top.getElement();
    }

    @Override
    public T pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException("Cannot top an empty stack!");
        }
        T element = top.getElement();
        top = top.getPointer();
        return element;
    }

    @Override
    public void push(T element) {
        LinkedListNode<T> newNode = new LinkedListNode<T>(element);
        newNode.setPointer(top);
        top = newNode;
        numElement++;
    }

    @Override
    public boolean isEmpty() {
        return (numElement==0);
    }

    @Override
    public int size() {
        return numElement;
    }

    public String toString() {
        LinkedListNode<T> current = top;
        String list="";
        while(current!=null) {
            list+= current.getElement() + "\t";
            current = current.getPointer();
        }
        return list;
    }
}
