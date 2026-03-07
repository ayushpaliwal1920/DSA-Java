package Queues;
import java.util.*;
public class Queue_Deque_05 {

    // Deque : Doubly ended queue

    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        
    //   add first :

    dq.addFirst(1);
    dq.addFirst(2);
    dq.addFirst(3);
    dq.addFirst(4);

    // add last :

    dq.addLast(5);
    dq.addLast(6);
    dq.addLast(7);
    dq.addLast(8);
    System.out.println(dq);

    // remove last :

    dq.removeFirst();
    dq.removeLast();

    System.out.println(dq);

    // peek : using getFirst , getLast

    System.out.println(dq.getFirst());
    System.out.println(dq.getLast());


    // remove :

    System.out.println(dq.remove()); // from first 

    dq.removeAll(dq); // remove everything
    System.out.println();

    }
}
