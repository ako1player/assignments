package utils;


public class LinkedListQueue<T> implements ILinkedListQueue<T> {
    LinkedListNode<T> front;
    LinkedListNode<T> rear;
    int numElement = 0;
    public LinkedListQueue() {
        front = null;
        rear = null;
    }
    @Override
    public void enqueue(T element) {
        LinkedListNode<T> newNode = new LinkedListNode<T>(element);
        if (front == null) {
            front = newNode;
        } else {
            rear.setPointer(newNode);
        }
        rear = newNode;
        numElement++;
    }

    @Override
    public T dequeue() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException("Dequeue attempted on empty queue.");
        }
        T element = front.getElement();
        if (front == rear) {
            rear = null;
        }
        front = front.getPointer();
        numElement--;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return (front == null);
    }

    @Override
    public int size() {
        return numElement;
    }
}
