package Stacks;

public class Stack_LLImplementation_04 {

    public static class Node{ // user defined data type
        int val;
        Node next;

        Node(){}
        Node(int val){
            this.val = val;
        }
    }

    public static class llStack { // user defined data structure 
        private Node head = null;
        private int size = 0;

        void push( int x){
            Node temp = new Node(x);
            temp.next = head;
            head = temp;
            size++;
        }

        // display stack  using recursiom :

        void displayrec(Node h){// helper function

            if( h == null){
                return;
            }

            displayrec(h.next);
            System.out.print(h.val + " ");
            
        }

        void display(){
            displayrec(head);
            System.out.println();
        }


        void displayReverse(){
            Node temp = head;
            while( temp != null){
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }


        int size(){ // getter
            return size;
        }

        int pop(){
            if( head == null){
                System.out.println("Stack is empty");
                return -1;
            }
            int x = head.val;
            head = head.next;
            return x;
        }

        int peek(){
             if( head == null){
                System.out.println("Stack is empty");
                return -1;
            } 
            return head.val;
        }

        boolean isEmpty(){
            if( size == 0){
                return true;
            }else{
                return false;
            }
        }
    }
    public static void main(String[] args) {
        llStack st = new llStack();
        st.push(4);
        st.push(5);
        st.push(1);

        st.display();
        st.push(5);
        st.display();
        st.push(1);

        st.display(); // 4,5,1

        System.out.println(st.size());
        st.pop();
        st.display();
    }
}