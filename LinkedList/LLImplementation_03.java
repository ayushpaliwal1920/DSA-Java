package LinkedList;

public class LLImplementation_03 {

    //  Creating linked list =>  generalized implementation :


    // step1 =>  Node creation =>  used defined datatype
    public static class Node{
        int data;
        Node next;

        Node(){}
        Node(int data){
            this.data = data;
        }
    }

    // => step2 ==> linked list creation => creation of linked list and its ,methods

    public static class linkedlist{

         Node head = null;
         Node tail = null;

         // 1. adding or inserting element in list :
         void insertAtEnd(int val){
            Node temp = new Node(val);
            if( head == null){ // for empty list
                head = temp;
                // tail = temp;u
            }else{
                tail.next = temp;
                // tail = temp;
            }
             tail = temp;
         }

        // 2.  displaying or printing the list :
        void printll(){

             Node temp = head;
             while( temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
             }
             System.out.println("\n"); 
        }

         // 3. getting length or size of a list :
         int size(){

            Node temp = head;
            int count = 0;
            while( temp != null){
                count++;
                temp = temp.next;
            }
            return count;
         }

        // 4. insert at head/head :

        void insertAtStart(int val){
            Node temp = new Node(val);
            if( head == null){  // empty list
                head = temp;
                tail = temp;
                // or 
                // insertAtEnd(val);
            }else{ // non empty list
               temp.next = head;
               head = temp;
            }
        }

        // 5. insert at any index :
        /*
        Steps : order wise steps :
                first make a new node which we want to add
                then traverse temp upto given idx-1;
                then connect newNode to Nextnode or(temp.next) 
                then connec temp to newNode .
        */

        void insertAt(int idx , int val){
            Node newNode = new Node(val);
            Node temp = head;

            // when adding at end
            if(idx == size()){ 
                insertAtEnd(val);
                return;
            }

            // inserting at start
            if(idx ==0 ){
                insertAtStart(val);
                return;
            }else if( idx < 0  || idx > size()){
                System.out.println("wrong index");
                return;
            }

            // insert at idx :
            for(int i=1 ; i<= idx-1 ; i++){
            //  traverse temp upto idx-1
                temp = temp.next;
            }
            // connect newNode to nextNode( or temp.next)
            newNode.next = temp.next;
            // connect temp to Newnode 
            temp.next = newNode;
        }

        // 6. getElement Method : reeturn the element at given index of ll.

        int getElementAt(int idx){
            Node temp = head;

             if(idx > size() || idx == 0){
                return -1;
             }

            for(int i =1 ; i<=idx ;i++){
                temp = temp.next;
            }
            return temp.data;
        }

        // 7. deleteAtTail method :

        void deleteAtTail(){

            if(size() == 0 ){return;}
            if(size() == 1){
                head = tail = null;
                return;
            }

            Node temp = head;

            for(int i=0 ; i<size()-2 ;i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            tail = temp;
        }


        // 8. deleteAtHead method :

        void deleteAtHead(){
                head = head.next;
        }

        // 9. deleterAtIndex method : implement a fxn to delete a node at a given index.

        void deleterAtIndex(int idx){
            Node temp = head;

            if(idx == size()-1){
                deleteAtTail();
            }

            if(idx == 0){
                deleteAtHead();
            }

            for(int i =1 ; i<= idx-1; i++){
                temp = temp.next;
            }

            temp.next = temp.next.next; // we cut the connection of the node of given index.
    
        }


    }


    public static void main(String[] args) {

        linkedlist l1 = new linkedlist();
        l1.insertAtEnd(1);
        l1.insertAtEnd(57);
        l1.insertAtEnd(16);
        l1.insertAtEnd(145);
        l1.insertAtEnd(177);
        l1.insertAtEnd(1001);
        l1.insertAtStart(400);
        l1.insertAtStart(800);
        l1.insertAtStart(900);
        l1.insertAt(1, 10);

        l1.deleteAtHead();
        l1.deleteAtTail();
        l1.deleterAtIndex(5);
        System.out.println("Printing linked list :");
        l1.printll();

        System.out.println("Length of created linked list l1 : \n"+ l1.size());
        System.out.println(l1.getElementAt(5));
        
        
    }
}
