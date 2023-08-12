package interfaces;

public interface Queue {
    
    public void queue(Object ob);

	public Object dequeue();

	public Object peek();

	public boolean isEmpty();

	public int size();
}
