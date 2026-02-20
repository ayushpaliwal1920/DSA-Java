package LinkedList;

public class LLCircularllImplementation_07 {

    // Circular ll : singly circular ll  and doubly circular ll.

    // Implementation of singly linked list : same as singly and doubly linkedlist 

    public  static class Node{
        int val;
        Node next;

        Node(){}
        Node(int val){
          this.val = val;
          this.next = null;
        }
    }

    public  static class Node2{
        int data;
        Node2 next;
        Node2 prev;

        Node2(){}
        Node2(int data ){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static class DoublyCircularLinkedList {
    public Node2 head = null;

    // Method to add a node to an empty list
    public void addtoEmpty(int data) {
        if (head != null) return;

        Node2 newNode = new Node2(data);
        head = newNode;
        newNode.next = head;
        newNode.prev = head;
    }

    // Method to insert a node at the beginning
    public void insertAtBeginning(int data) {
        if (head == null) {
            addtoEmpty(data);
            return;
        }

        Node2 newNode = new Node2(data);
        Node2 last = head.prev; // The last node is the one before the head

        newNode.next = head;
        newNode.prev = last;
        head.prev = newNode;
        last.next = newNode;
        head = newNode; // Update head to the new node
    }

    // Method to insert a node at the end
    public void insertAtEnd(int data) {
        if (head == null) {
            addtoEmpty(data);
            return;
        }

        Node2 newNode = new Node2(data);
        Node2 last = head.prev; // The last node

        newNode.prev = last;
        newNode.next = head;
        last.next = newNode;
        head.prev = newNode;
    }

    // Method to traverse and print the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node2 current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}


    // circular singly linked list : 
    public static void printCircularll(Node head){
        Node temp = head.next;
        while( temp != head){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    // circular doubly linked list :

    
    public static void main(String[] args) {
        DoublyCircularLinkedList list = new DoublyCircularLinkedList();

        list.addtoEmpty(10);
        list.insertAtBeginning(5);
        list.insertAtEnd(15);
        list.insertAtBeginning(2);

        System.out.print("Doubly Circular Linked List: ");
        list.display(); // Output: 2 5 10 15
    }
}
