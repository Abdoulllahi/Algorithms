package DS.interfaces;

public interface Queue<E> {
    
    public void enqueue(E e);
    public E dequeue();
    public E peek();

    public boolean isEmpty();
    
    public boolean isFull();

    public int size();
}
