package DS.implementations;
import DS.interfaces.Queue;

public class QueueArray implements Queue {

    private int head;
    private int tail;
    private Object[] queueArray;

    public QueueArray(int length) {

        this.head = -1;
        this.tail = -1;
        if (length <= 0) {
            this.queueArray = new Object[2];
        } else this.queueArray = new Object[length];
    }

    public QueueArray(int length, int head) {

        this(length);
        this.head = 0;
        queueArray[head] = head;
    }

    @Override
    public void enqueue(Object object) {
        if (isEmpty()) {
            this.queueArray[head] = object;
            head = tail = 0;
            return;
        }
        if (isFull()) resize();
        tail = (tail + 1) % queueArray.length;
    }

    @Override
    public Object dequeue() {
        
        if (isEmpty()) {
            System.out.println("The queue is empty");
            return null;
        }

         Object dequeuedItem = queueArray[head];
        if (tail == 0 && head == 0) {
            tail = head = -1;
            return queueArray[0];
        } else {
            head = (head + 1) % queueArray.length;
        }
        return dequeuedItem;
    }
    @Override
    public Object peek() {
    
        if (isEmpty()) {
            System.out.println("The queue is empty");
            return null;
        }
        return queueArray[head];
    }

    @Override
    public boolean isEmpty() {

        return head == tail && head == -1;
    }

    @Override
    public boolean isFull() {
        if (head == 0 && tail == queueArray.length - 1 || tail == head - 1)
            return true;
        return false;
    }

    @Override
    public int size() {
        return tail - head + 1;
    }

    public void resize() {
        Object[] newQueueArray = new Object[queueArray.length + queueArray.length / 2];
        if (head <= tail) {
            System.arraycopy(queueArray, head, newQueueArray, 0, size());
        } else {
            System.arraycopy(queueArray, head, newQueueArray, 0, queueArray.length - head);
            System.arraycopy(queueArray, 0, newQueueArray, queueArray.length - head, tail + 1);
        }
        head = 0;
        tail = size() - 1;
        queueArray = newQueueArray;
    }

    public void printQueue() {
    if (isEmpty()) {
        System.out.println("The queue is empty");
        return;
    }
    
    int current = head;
    while (current != tail) {
        System.out.print(queueArray[current] + "-->");
        current = (current + 1) % queueArray.length;
    }
    System.out.println(queueArray[tail]);
}

    
}