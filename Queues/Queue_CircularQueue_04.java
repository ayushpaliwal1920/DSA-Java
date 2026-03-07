package Queues;

import java.security.spec.ECFieldF2m;

public class Queue_CircularQueue_04 {

    // Circular Queue :

    // Array Implementation of Circular Queues :

    public static class circularQueueA {
        int[] arr = new int[100];
        int front = -1;
        int rear = -1;
        int size = 0;
        int n = arr.length;
        // Add :

        public void add(int val) throws Exception {
            if (size == 0) { // empty
                front = rear = 0;
                arr[0] = val;
                size++;
            } else if (size == n) { // full
                throw new Exception("Queue id Full");
            } else if (rear < n - 1) { // normal case
                arr[++rear] = val;
                size++;
            } else if (rear == n - 1) {
                rear = 0; // circular case
                arr[0] = val;
                size++;
            } else {
                // eat five star do nothing
            }

        }

        // Remove :

        public int rremove() throws Exception {

            if (size == 0) {
                throw new Exception("Empty Queue");
            } else {
                int val = arr[front];

                if (front == n - 1) {
                    front = 0;
                } else
                    front++;

                size--;
                return val;
            }
        }

        // Peek :

        public int peek() throws Exception {
            if (size == 0)
                throw new Exception("Empty Queue");

            return arr[front];
        }

        // display

        public void display() {
            if (size == 0) {
                System.out.println("Queue id empty");
                return;
            } else if (front < rear) {
                for (int i = front; i < rear; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            } else { // rear < front

                for (int i = front; i < n; i++) {
                    System.out.print(arr[i] + " ");
                }

                for (int i = 0; i < rear; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        }
    }

    // Linked List Implemetation of Circular Queue : useless exact same as ll queue

    public static class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }
    }

    public static class queuell {

        Node head = null;
        Node tail = null;
        int size = 0;

        // Insert or add function :

        public void add(int val) {

            Node newNode = new Node(val);

            if (size == 0) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
                tail.next = head; 
            }

            size++;
        }

        // remove or pop function :
        public int remove() {

            if (size == 0) {
                System.out.println("Queue is empty ");
                return -1;
            }

            int popped = head.val;
            head = head.next;
            tail.next = head;

            size--;
            return popped;

        }
        // Peek function :

        public int peek() {
            if (size == 0) {
                System.out.println("Queue is empty ");
                return -1;
            }
            return head.val;
        }

        // display function :

        public void display() {
            Node temp = head;
            if (size == 0) {
                System.out.println("Empty");
            } else {
                while (temp != null) {
                    System.out.print(temp.val + " ");
                    temp = temp.next;
                }
                System.out.println();
            }
        }

    }

    public static void main(String[] args) throws Exception {
        circularQueueA q = new circularQueueA();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);

        q.display();

        System.out.println(q.rremove());
        q.display();
        q.peek();
    }

}
