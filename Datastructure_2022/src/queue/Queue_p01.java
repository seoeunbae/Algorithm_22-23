package queue;

import java.util.ArrayList;
import java.util.List;

public class Queue_p01 {
    public static List enqueue(Integer number, List queue){
        queue.add(0, number);
        return queue;
    }

    public static List dequeue(List queue){
        int length = queue.size();
        queue.remove(length-1);
        return queue;
    }

    public static void main(String[] args) {
        List<Integer> queue = new ArrayList();

        enqueue(1,queue);
        System.out.println(queue);
        enqueue(2,queue);
        System.out.println(queue);
        enqueue(3,queue);
        System.out.println(queue);
        enqueue(4,queue);
        System.out.println(queue);
        dequeue(queue);
        System.out.println(queue);
        dequeue(queue);
        System.out.println(queue);
        dequeue(queue);
        System.out.println(queue);
        dequeue(queue);
        System.out.println(queue);
    }
}
