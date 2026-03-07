package Queues;

public class Queue_LLImplementation_03 {

    // Linked list Implementation :

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

    public static void main(String[] args) {
        queuell q = new queuell();

        q.add(0);
        q.add(1);
        q.add(21);
        q.add(31);
        q.add(3);

        q.display();

        q.remove();
        q.display();

        System.out.println(q.peek());

    }
}
