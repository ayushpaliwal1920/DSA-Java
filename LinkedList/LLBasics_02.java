package LinkedList;

public class LLBasics_02 {

    // Node => stores key value and pointer which stores the address of the next node

    public static class Node{
            int data;   // value
            Node next;  // address of next node

            Node(){}

            Node(int data){
                this.data = data;
            }
    }

    // Displaying LINKED LIST : 

    public static void DisplayLL( Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next ;
        }
        System.out.println("\n");
    }

    // Displaying LINKED LIST recursively :

    public static void DisplayllR(Node head){
        if(head == null){
            System.out.println("\n");
            return ;
        }
        System.out.print(head.data + " ");
        DisplayllR(head.next);
    } 

    // Displaying REVERSED LINKED LIST :

    public static void ReverseLLR(Node head){
        if(head == null){
            return ;
        }
        ReverseLLR(head.next);
        System.out.print(head.data + " ");
    }

    // LENGTH OF A LINKED LIST : find out the length of linked list 

    public static int lengthLL(Node head){
        int count = 0;
        Node temp = head;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }


    public static Node insertAtEnd(Node head ,int val){
        Node newNode = new Node(val);

        Node temp = head;

        if(temp == null){
            return newNode;
        }

        while( temp.next != null){
            temp = temp.next;
        }

        temp.next = newNode;
        
        return head;
    }

    public static void main(String[] args) {
        
        Node a = new Node(5);

        System.out.println("adress of a before linked list :" +a.next); //null
        Node b = new Node(15);
        Node c = new Node(51);
        Node d = new Node(55);
        Node e = new Node(25);

        // 5->15->51->55->25 // creating linked list manually

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println("Address of a after linked list :" + a.next); // LinkedList.LLBasics_02$Node@7344699f

        System.out.println(a); // LinkedList.LLBasics_02$Node@28a418fc
        System.out.println(b); // LinkedList.LLBasics_02$Node@7344699f
        System.out.println(c); // LinkedList.LLBasics_02$Node@5305068a
        System.out.println(d); // LinkedList.LLBasics_02$Node@1f32e575
        
        System.out.println("Data of a :" + a.data);
        System.out.println("Data of b using a :"+ a.next.data) ; // data of b using a
        System.out.println("Data of c using b :"+ b.next.data);  // data of c using b
        System.out.println("Data of c using a :"+ a.next.next.data); // data of c ussing head(a) 
        System.out.println("Data of d using a :"+ a.next.next.next.data); // data of d using head node
        System.out.println("Data of e using a :"+ a.next.next.next.next.data); // data of e using head node

        // Displaying a linked list using 'for' loop :

        System.out.println("Displaying a linked list using 'for' loop :");
        
        Node temp = a;
        for(int i =1 ; i<=5 ; i++){
            System.out.print(temp.data+ " ");
            temp = temp.next; // means -> if temp = a then temp = temp.next = b , and so on 
        }
        System.out.println("\n");


        // Displaying a linked list using "while" loop where we need only head node :

        System.out.println("Displaying linked list using 'while' loop :");
        DisplayLL(a);

        // Displaying a linked list using recursive function :

        System.out.println("Displaying linked list using 'recursion' :");
        DisplayllR(a);

        // Displaying the reverse linked list :

        System.out.println("Displaying 'reversed' linked list :");
        ReverseLLR(a);
        

        // Length of a linked list  :

        System.out.println("\n\nDisplaying the 'length' of a linked list : \n" + lengthLL(a));

        

        

    }
    
}
