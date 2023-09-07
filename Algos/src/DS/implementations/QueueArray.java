package DS.implementations;
import DS.interfaces.Queue;

public class QueueArray implements Queue {

    private int head;
    private int tail;
    private Object[] queueArray;
    private int currentSize;

    public QueueArray(int length) {

        this.head = -1;
        this.tail = -1;
        if (length <= 0) {
            this.queueArray = new Object[2];
        } else this.queueArray = new Object[length];
        currentSize = 0;
    }

    public QueueArray(int length, int head) {

        this(length);
        this.head = 0;
        queueArray[head] = head;
        currentSize = 1;
    }

    @Override
    public void enqueue(Object object) {
        if (isEmpty()) {
            head = tail = 0;
            this.queueArray[head] = object;
            currentSize++;
            return;
        }
        if (isFull()) resize();
        tail = (tail + 1) % queueArray.length;
        queueArray[tail] = object;
        currentSize++;
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
            currentSize = 0;
            return queueArray[0];
        } else {
            head = (head + 1) % queueArray.length;
            currentSize--;
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
        return currentSize;
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
        System.out.println(toString());
    }

    @Override
    public String toString() {
        
        if (isEmpty())
            return "";
        if (head == tail && head != -1) {
            return "head: " + queueArray[head];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(queueArray[head]);
        int current = head + 1;
        while (current != tail) {
            stringBuilder.append("-->").append(queueArray[current]);
            current = (current + 1) % queueArray.length;
        }
        stringBuilder.append("-->" + queueArray[tail]);
        return stringBuilder.toString();
    }
    
}