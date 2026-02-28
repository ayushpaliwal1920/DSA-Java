package Stacks;

import java.util.Stack;
import java.util.Scanner;

public class Stack_Quesions_02 {

    /*
    Q1 : Copy stack : copy all the elements of the stack in same order.
         Time coplexity : O(n)
    */

    // using two another stacks : first  push the elements in a new stack rt (which will be in reverse order) then use anoather stack for same operation.


    public static Stack<Integer> copyStack(Stack<Integer> st){

        // reverse order :

        Stack<Integer> rt = new Stack<>();
        while( st.size() > 0){
            rt.push(st.pop());
        }

        // now add elements in another stack in reverse order : same as above 

        Stack<Integer> gt = new Stack<>();
        while( rt.size() > 0){
            gt.push(rt.pop());
        }
        return gt;
    }

    /*
    Q2 : Insert at bottom/ any index 
    */

    public static void InsertAtBottom(Stack<Integer> st , int val){
        // create new stack

        Stack<Integer> st2 = new Stack<>();

        // now enter all the elements of st in st2 : which will be in reverse order 

        while( st.size() > 0){
            st2.push(st.pop());
        }

        // now enter new element in st :

        st.push(val);

        // again fill the st and empty st2 :

        while( st2.size() > 0){
            st.push(st2.pop());
        }

        // print st :
        System.out.println(st);
    }

    /*
     Q3 : Insert at any index idx :
    */

     public static void InsertAtIndex(Stack<Integer> st , int val , int idx){
        // create new stack

        Stack<Integer> temp = new Stack<>();

        // now enter the elements of st in temp : which will be in reverse order 
        while( st.size() > idx){
            temp.push(st.pop());
        }

        // now enter new element in st  at idx :
        st.push(val);

        // again fill the st and empty temp :
        while( temp.size() > 0){
            st.push(temp.pop());
        }

        // print st :
        System.out.println(st);
     }

     /*
     Q4 : Print stack without  removing elements of elements : all the operations needed a extra stack
      time complexity = O(n) = spaceComplextity 
     */

    //   Method 1 : using extra stack

     public static void printStack1(Stack<Integer> st){
        Stack<Integer> temp = new Stack<>();

        while( st.size() > 0){
            temp.push(st.pop()); 
        }

        while( temp.size() > 0){
            System.out.print(temp.peek() + " ");
            st.push(temp.pop());
        }

     }

    //  Method 2 : using arrays  : better method

    public static void printStack2(Stack<Integer> st){
         int n = st.size();
         int[] arr = new int[n];

         // ulta loop in array

         for( int i = n-1 ; i>= 0 ; i--){
             arr[i] = st.pop();
         }

        //  now dubara stack mai bhro aage se 

        for( int i = 0 ; i< n ; i++){
            System.out.print(arr[i] + " ");
            st.push(arr[i]);
        } 
    }

    // Method 3 : recursive :

    public static void printStack3(Stack<Integer> st){

        // base case :

        if( st.size() == 0){
            return;
        }

        int top = st.pop();
      
        printStack3(st); // recursive call

        System.out.print(top + " ");
        st.push(top);
    }


    // Method 3 : recursive : but reversee order of stack

    public static void printStack3rev(Stack<Integer> st){

        // base case :

        if( st.size() == 0){
            return;
        }
        int top = st.pop();
        System.out.print(top + " ");
        printStack3rev(st); // recursive call
        st.push(top);
    }


    /*
    Q5 : Remove from bottom any index :

    */

    public static void removeFromBottomIdx(Stack<Integer> st , int idx){
        Stack<Integer> rt = new Stack<>();

        while( st.size() > idx+1){
            rt.push(st.pop());
        }

        st.pop();

        while (!rt.isEmpty()) {
            st.push(rt.pop());
        }
    }


    /*
    Q6 : reverse stack : iterative 
     */

    // method 1:
    
    public static void reverseStack(Stack<Integer> st){
        Stack<Integer> rt = new Stack<>();
        Stack<Integer> gt = new Stack<>();

        while( st.size() > 0){
            rt.push(st.pop());
        }

        while ( rt.size() > 0) {
            gt.push(rt.pop());
        }

        while ( gt.size() > 0) {
            st.push(gt.pop());
        }
    }

    // method 2: recursive

      public static void reverseStackrecursive(Stack<Integer> st){
        
        if( st.size() == 1){
            return;
        }
        int top = st.pop();
        reverseStackrecursive(st);
        InsertAtBottom(st, top);
    }

    //  OVERFLOW : when stack is full 

    //  UNDERFLOW : when stack is empty 

    

    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();

        // int n;
        // System.out.println("Enter the elements you want to insert : ");

        // Scanner sc = new Scanner(System.in);
        // n = sc.nextInt();

        // System.out.println("Enter the elemetns : ");
        // for( int i = 1 ; i<= n ; i++){
        //     int x = sc.nextInt();
        //     st.push(x);
        // }
        // System.out.println(st);

        st.push(1);
        st.push(0);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st);

        Stack<Integer> copiedStack = copyStack(st);
        System.out.println("Original Stack : " + st); // st empty ho gya h after function call.
        System.out.println("Copied stack : " + copiedStack);

        // Enter a element at bottom :

        System.out.println("Inserting element at bottom : ");
        InsertAtBottom(copiedStack, 100);

        System.out.println("Insert at indx idx :");
        InsertAtIndex(copiedStack, 1000, 3); // 0 based indexing

        System.out.println("Printing stack without removing elements using extra stack:");
        printStack1(copiedStack);

        System.out.println();
        System.out.println("Printing stack without removing elements using extra array:");
        printStack2(copiedStack);

        System.out.println();
        System.out.println("Printing stack using recursion(reverse) : ");
        printStack3(copiedStack);

        System.out.println();
        System.out.println("Reversing the stack");
        reverseStackrecursive(copiedStack);
    }
}