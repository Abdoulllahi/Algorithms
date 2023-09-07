package DS;

import DS.implementations.QueueArray;
import DS.interfaces.Queue;

public class App {
   
    public static void main(String[] args) {
        Queue queue = new QueueArray(2);
        queue.enqueue(1);
        System.out.println(queue.size());
        System.out.println(queue);
        queue.enqueue(2);
        System.out.println(queue);
        queue.enqueue(3);
        System.out.println(queue);
        System.out.println(queue.size());
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.size());
    }
}
