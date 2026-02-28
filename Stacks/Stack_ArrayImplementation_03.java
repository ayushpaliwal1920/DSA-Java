package Stacks;

public class Stack_ArrayImplementation_03 {

    public static class Stack {
        
        private int arr[] = new int[100];
        private int idx = 0 ; // v.v.v important

        // push()
        void push(int x){
            if( isFull()){
                System.out.println("Stack is full");
                return;
            }

            arr[idx] = x;
            idx++;
        }

        // peek()
        int peek(){
            if( idx == 0){
                System.out.println("Stack is empty");
                return -1;
            }
            return arr[idx-1];
        }

        // pop()
        int pop(){
            if( idx ==0 ){
                System.out.println("Stack is empty ");
                return -1;
            }

            // removing and setting idx
            int top = arr[idx-1];
            arr[idx-1] = 0;
            idx--;

            return top;
        }

        // display()
        void display(){
            for( int i = 0 ; i<= idx-1 ; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        // size()
        int size(){
            return idx;
        }

        //  isEmpty()

        boolean isEmpty(){
            if( size() == 0){
                return true;
            }else{
                return false;
            }
        }

        boolean isFull(){
            if( idx == arr.length){
                return true;
            }else{
                return false;
            }
        }

        // capacity()

        int capacity(){
            return arr.length;
        }

    }
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(4);
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
