package LinkedList;

public class LLDoublyAndCircularll_05 {
    
    // Doubly Linked list : head ka prev null hota hai aur tail ka next null hota hai, dono me prev and next pointer hote hai.


    
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(){}
        public Node(int data){
            this.data = data;
        }
    }

    // Display function using head pointer :

    public static void displaydll(Node head){
        Node temp = head;
        while( temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("\n");
    }


    // Display function using tail pointer : reverse order

     public static void displaydllrev(Node tail){
        Node temp = tail;
        while( temp != null){
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println("\n");
    }

    // Display randomly using any pointer : print ll to the head pointer

    public static void displaydllrandomToHead(Node node){
        Node temp = node;

        while( temp != null){
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println("\n");
    }

     // Display randomly using any pointer : print ll to the tail pointer

    public static void displaydllrandomToTail(Node node){
        Node temp = node;

        while( temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("\n");
    }

    // Display random : given any pointer print the whole linked list

    public static void displaydllrandom(Node node){
        Node temp = node;

        while( temp.prev != null){
            temp = temp.prev;
        }
        // now temp is at head pointer

        // print the list

        while( temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("\n");
    }
    public static void main(String[] args) {
        // 4,10,2,99,13

        Node a = new Node(4);
        Node b = new Node(10);
        Node c = new Node(2);
        Node d = new Node(99);
        Node e = new Node(13);
        // Now we have created 5 nodes for our linked list, now we will link them together

        a.next = b; // prev is null 
        b.prev = a;
        b.next =c;
        c.prev = b;
        c.next = d;
        d.prev = c;
        d.next = e;
        e.prev = d;  // prev is null

        displaydll(a);
        displaydllrev(e);
        displaydllrandomToHead(c);
        displaydllrandomToTail(c);
        displaydllrandom(c);
    }
}
