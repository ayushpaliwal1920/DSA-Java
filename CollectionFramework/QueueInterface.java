package CollectionFramework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueInterface {

    // Queue :

    static void queueExample() {

        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        q.offer(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println(q);

        System.out.println(q.peek());// give null when queue is empty
        System.out.println(q.element()); // gives exception when queue is empty

        q.poll(); // give null when queue is empty
        q.remove(); // gives exception when queue is empty

        System.out.println(q);
    }

    // Priority Queue :

    static void priorityQueueExample() {

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min PQ : b default
        pq.add(10);
        pq.add(5);
        pq.add(15);
        pq.add(1);
        pq.add(25);

        System.out.println(pq); // 1 , 5 ,10 ,15 ,25

        System.out.println(pq.peek());

        System.out.println(pq.poll());

        System.out.println(pq);

        System.out.println("max priority queue");

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder()); // max priority queue

        pq2.add(10);
        pq2.add(5);
        pq2.add(15);
        pq2.add(1);
        pq2.add(25);

        System.out.println(pq2); // 1 , 5 ,10 ,15 ,25

        System.out.println(pq2.peek());

        System.out.println(pq2.poll());

        System.out.println(pq2);

    }

    // Deque :

    static void dequeExample() {

        Deque<Integer> dq = new LinkedList<>();

        dq.addFirst(10);
        dq.addFirst(5);
        dq.addFirst(15);
        dq.addLast(1);
        dq.addLast(25);

        System.out.println(dq); // 1 , 5 ,10 ,15 ,25

        System.out.println(dq.peekFirst());

        System.out.println(dq.pollLast());

        System.out.println(dq);

    }

    public static void main(String[] args) {
        queueExample();

        System.out.println("Priority Queue :");
        priorityQueueExample();


        System.out.println("Deque");
        dequeExample();
    }
}
