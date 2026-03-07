package Queues;

public class Queue_ArrayImplementation_02 {

    // Array Implementation :

    public static class queueA {

        int f = -1;
        int r = -1;
        int[] arr = new int[100];
        int size = 0;

        public queueA(){}

        // add function : insertion at rear

        public void add(int val) {

            if (r == arr.length - 1) {
                System.out.println("Queue is full");
                return;
            }

            if (f == -1) { // array is empty
                r = 0;
                f = 0;
            } else {
                r++;
            }

            arr[r] = val;
            size++;
        }

        // remove function : remove from front :

        public int remove() {
            if (f == -1 || f > r) {
                System.out.println("Queue is empty");
                return -1;
            } else {
                int x = arr[f];
                f++;
                size--;
                return x;
            }

        }

        // peek fuinction :

        public int peek() {
            if (f == -1) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[f];
        }

        public void display(){

            if( size == 0 ){ System.out.println("Queue is empty");}
            for( int i = f ; i<= r ; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        queueA q = new queueA();

        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        q.display();

        q.remove();

        q.display();

        int p = q.peek();
        System.out.println(p);
    }
}
