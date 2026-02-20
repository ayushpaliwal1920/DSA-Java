package LinkedList;

public class LLDoublyllImplementation_6 {
    
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(){}
        public Node(int data){
            this.data = data;
        }
    }

    public static class DoublyLinkedList{
        Node head = null;
        Node tail = null;

        // 1. displaying or printing the list :

        void printdll(){
            Node temp = head;
            while( temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println("\n");
        }


        // 2. adding or inserting element in list :

        void insertAtHead(int val){
            Node temp = new Node(val);
            if( head == null){
                head  = temp;
                tail = temp;
            }
            else{
                temp.next = head;
                head.prev = temp;
                head = temp;
            }
        }

        // 3. insert at tail/end :
    
        void insertAtTail(int val){
            Node temp = new Node(val);
            if( head == null){
                head = temp;
                tail = temp;
            }else{
                temp.prev = tail;
                tail.next = temp;
                tail = temp;
            }
        }

        // 4. insert at any index : insert at any position in the list

        // method 1:

        void insertAtIndex(int idx , int val){
            Node temp = head;
            Node newNode = new Node(val);


            // Case 1: insert at head
            if (idx == 0) {
                newNode.next = head;
                if (head != null) {
                    head.prev = newNode;
                }
                head = newNode;
                return;
            }
                    
            for( int i=1 ; i<idx ; i++){
                temp = temp.next;
            }

            temp.next.prev = newNode;
            newNode.prev = temp;
            newNode.next = temp.next;
            temp.next = newNode;
    }

    // method2 : 
       void insetAtIndex2(int idx ,int val){
            Node s = head;

            for( int i=1 ; i<idx ; i++){
                s = s.next;
            }

            Node r = s.next; // s is at idx-1 position
            Node t = new Node(val);

            // connections

            s.next = t;
            t.prev = s;
            t.next = r;
            r.prev = t;
       }


    // 5.  deletion at head in doubly inked list :

    void deleteAtHead(){
        head = head.next;
        head.prev = null;
    }

    // 6.  deletion at tail in doubly inked list :

    // case 1 : when head is given :

    void deleteAtTail( Node head){
        Node temp = head;
        while( temp.next != null){
            temp = temp.next;
        }

        temp = temp.prev;
        temp.next = null;
    }

    // case 2 : when tail is given ::

    void deleteAtTail2(){
        Node temp = tail;

        temp = temp.prev;
        temp.next = null;
        tail = temp;
    }

    // 7.  deletion at Index in doubly inked list :

    void deleteAtIndx(int idx , int val){
        Node temp = head;
        
        for(int i = 1; i< idx ; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        temp.next.prev = temp; 
    }


}

    // 3. insert at tail/end if only head pointer is given :

     public static void insertAtTailUsingHead(Node head ,int val){
            Node temp = head;
            // temp upto tail

            while( temp.next != null){
                temp = temp.next;
            }
            // temp is at tail

            Node newNode = new Node(val);
            temp.next = newNode;
            newNode.prev = temp;
        
        }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtHead(10);
        dll.insertAtHead(20);
        dll.insertAtHead(30);           
        dll.insertAtHead(40);
        dll.insertAtHead(50);

        dll.insertAtTail(5);
        dll.insertAtTail(1);

        dll.insetAtIndex2(2,500);
        dll.insertAtIndex(5, 1000);

        dll.printdll();
        
    }
}
