package DS.interfaces;

public interface Queue {
    
    public void enqueue(Object ob);

	public Object dequeue();

	public Object peek();

    public boolean isEmpty();
    
    public boolean isFull();

    public int size();
}
