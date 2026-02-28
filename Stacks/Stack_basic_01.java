package Stacks;


import java.util.Stack;

public class Stack_basic_01 {

    // Stack : first in last out : LIFO  : FILO
    // Operations : push() , pop() , peek() , size()

    /*  Stack : has unlimited size ,
                Time complexity of basic operation : O(1),
                functions : size() , isEmpty() , isFull() , pop() , push() etc.
    */

    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();

        System.out.println(st.isEmpty());

        st.push(2132);
        st.push(212);
        st.push(22);
        st.push(32);
        System.out.println(st.isEmpty());

        st.push(2132);
        st.push(212);
        st.push(22);
        st.push(32);
        st.push(2);

        st.push(2);

        System.out.println(st.peek()); // peek operation

        System.out.println(st); // print complete stack

        st.pop(); // pop operation on stack

        System.out.println(st);

        System.out.println("Size is : " + st.size());  // size of stack 


        // Accesssing first element :

        while( st.size() > 1){
            st.pop();
        }
        System.out.println(st.peek());

        System.out.println(st.isEmpty()); // chekcing stack is empty or not



     }  
}
