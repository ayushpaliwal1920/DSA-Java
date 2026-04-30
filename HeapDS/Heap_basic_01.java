package HeapDS;

import java.util.Collections;
import java.util.PriorityQueue;

public class Heap_basic_01 {

     // Heap DS :

    /*
    A heap is a complete binary tree that follows a specific rule:

                🔹 Min Heap
                            Parent ≤ Children
                            Smallest element is at the root
                🔹 Max Heap
                            Parent ≥ Children
                            Largest element is at the root

    Operations :
                    🔹 Insert (O(log n))
                                    Add at end
                                    Move up (heapify up)
                    🔹 Delete (O(log n))
                                    Remove root
                                    Replace with last element
                                    Move down (heapify down)
                    🔹 Peek (O(1))
                                    Get min/max (root)
 */

/*  PRIORITY QUEUE :

A PriorityQueue in Java is a queue where elements are ordered based on their priority, rather than the order of insertion. By default, it uses natural ordering (min-heap), but a custom comparator can be used to define different priorities.

Elements are processed based on priority rather than insertion order.
Supports standard queue operations like add(), poll(), and peek().
Automatically grows as elements are added and null insertion is not possible .
Uses a heap data structure internally to ensure efficient insertion and removal of the highest-priority element.

/*

HOW TO KNOW QUESTION ID ON HEAP(MIN/MAX):

 kth smallest , largest , closest , most frequency then use heap 
 contineous sorting 

*/

   public static void main(String[] args) {

        // 🔹 MIN HEAP (default)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(30);
        pq.add(10);
        pq.add(18);
        pq.add(20);
        pq.add(15);

        System.out.println("Head of Queue / Min heap: " + pq.peek());

        pq.remove();

        System.out.println("Head of Queue / Min heap: " + pq.peek());



        // 🔹 MAX HEAP
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        pq2.add(30);
        pq2.add(10);
        pq2.add(18);
        pq2.add(20);
        pq2.add(15)

        System.out.println("Head of Queue / Min heap: " + pq2.peek());

        pq2.remove();

        System.out.println("Head of Queue / Min heap: " + pq2.peek());


        // print heap :

        for(int el : pq){
            System.out.print(el + " ");
        }

        // CUSTOM COMPARATOR : uses for when we want to sort objects based on some attribute of obj.

        // Compare based on distance btw point(a = [1,2] , b = [3,2]) and the origin
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> ((b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])));
    }
}