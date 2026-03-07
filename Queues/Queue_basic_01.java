package Queues;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Queue_basic_01 {

    // Queue : FIFO : First in First Out , Last in last Out
    // Types : Deque , Circular Queue

    /*
     * 
     * Built in Implementation of Queue : 1. Queue<Integer> q = new LinkedList<>();
     * 2. Queue<Integer> q = new ArrayDeque<>();(
     * 
     * Operations : add() , remove() / poll() , peek() / element() ,size()
     * 
     */

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();

        // insert : add() function

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        System.out.println(q);

        // remove : remove() and poll() function function just like pop().

        System.out.println(q.remove());
        System.out.println(q);

        q.poll();
        System.out.println(q);

        // access : element() function or peek()

        System.out.println(q.element());
        System.out.println(q.peek());

        // length : using size() function

        System.out.println(q.size());

        // print all the element present in given queue without built in function :

        Queue<Integer> helper = new ArrayDeque<>();

        while( q.size() > 0){
            System.out.print(q.peek() + " ");
            helper.add(q.poll());
        }
        while ( helper.size() >0) {
            q.add(helper.poll());
        }

    }

}