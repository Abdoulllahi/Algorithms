import interfaces.Queue;

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

    // public QueueArray(int length, int head) {
    //     this(length);
    //     this.head = 0;
    //     queueArray[head] = head;
    // }

    @Override
    public void queue(Object object) {
        if (head == -1) {
            this.queueArray[head] = object;
            head = tail = 0;
            return;
        }
        if (head == 0 && tail == queueArray.length || head == tail +1) {
            resize();
            queueArray[tail++] = object; 
        } else {

        }
    }

    @Override
    public Object dequeue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dequeue'");
    }
    @Override
    public Object peek() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'peek'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public int size() {
        return tail - head + 1;
    }

    public void resize() {
        Object[] newQueueArray = new Object[queueArray.length + queueArray.length / 2];
        System.arraycopy(queueArray, head, newQueueArray, head, queueArray.length);
        queueArray = newQueueArray;
    }
    
}