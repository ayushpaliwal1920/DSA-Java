package Queues;

import java.util.*;

class Queue_InterViewQuestions_06 {

    /*
     * Q1 : Reverse a queue : use a extra stack and insert element in stack then
     * remove from stack :
     */

    public static Queue<Integer> reverseQueue(Queue<Integer> q) {
        Stack<Integer> st = new Stack<>();

        while (q.size() > 0) {
            st.push(q.poll());
        }

        while (st.size() > 0) {
            q.add(st.pop());
        }

        return q;
    }

    /*
     * Q2 : reverse first k elements of a queue :
     */

    public static Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {

        Stack<Integer> st = new Stack<>(); // 1 2 3 4 5 6

        // k element stack mai insert :
        for (int i = 0; i < k; i++) {
            st.push(q.poll());
        }

        // stack se pop and q mai insert :

        while (st.size() > 0) {
            q.add(st.pop()); // 4 5 6 3 2 1
        }

        // front se pop and rear se add :

        for (int i = 0; i <= q.size() - k - 1; i++) { // 3 2 1 4 5 6
            q.add(q.remove());
        }

        return q;
    }

    /*
     * Q3 : Implement stack using queues : Leetcode 225
     */

    public static class MyStack {

        Queue<Integer> q = new LinkedList<>();

        // time complexity : push() : O(1) and pop() : O(n)

        public MyStack() {

        }

        public void push(int x) {
            q.add(x);
        }

        public int pop() {
            // 1 2 3 4
            for (int i = 1; i <= q.size() - 1; i++) {
                q.add(q.remove()); // 4 1 2 3
            }
            int val = q.remove();
            return val;
        }

        public int top() {
            // 1 2 3 4
            for (int i = 1; i <= q.size() - 1; i++) {
                q.add(q.remove()); // 4 1 2 3
            }
            int val = q.peek(); // 4
            q.add(q.remove()); // 1 2 3 4
            return val;
        }

        public boolean empty() {
            if (q.size() == 0)
                return true;
            else
                return false;
        }

        // for time complexity : pop() = O(1) and push() = O(n) : pop() efficeient

        public void push2(int val) {
            if (q.size() == 0) {
                q.add(val);
            } else {
                q.add(val);
                for (int i = 1; i <= q.size() - 1; i++) {
                    q.add(q.remove());
                }
            }
        }

        public int pop2() {
            return q.remove();
        }

    }

    /*
     * Q4 : Queue using stack :
     */

    class MyQueue {

        Stack<Integer> st = new Stack<>();
        Stack<Integer> gt = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            st.push(x);
        }

        public int pop() {
            while (st.size() > 0) {
                gt.push(st.pop());
            }
            int x = gt.pop();

            while (gt.size() > 0) {
                st.push(gt.pop());
            }
            return x;
        }

        public int peek() {
            while (st.size() > 0) {
                gt.push(st.pop());
            }
            int x = gt.peek();

            while (gt.size() > 0) {
                st.push(gt.pop());
            }
            return x;
        }

        public boolean empty() {
            if (st.size() == 0 && gt.size() == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    /*
    Q5: First negative in each window of size k : GFG : Important
    */

    public static int[] printFirstNegativeInteger(int[] arr , int k){
        int n = arr.length;

        int[] res = new int[n-k+1];
        Queue<Integer> q = new LinkedList<>();

        // insert index of all negative numbers in the queue :

        for(int i =0 ; i<n ;i++){
            if( arr[i] < 0){
                q.add(i);
            }
        }

        // now traverse array :

        for(int i=0 ;i <n-k+1 ; i++){
            if(q.size()>0 && q.peek() < i){
                q.remove();
            }
            
            if(q.size() >0 && q.peek() <= i+k-1){
                res[i] = arr[q.peek()];
            }else if( q.size() == 0){
                res[i] =0;
            }else{
                res[i] = 0;
            }
        }
        return res;
    }

    /*
    Q6 : Reorder Queue(Interleave 1st half with 2nd half) : Important GFG

    input : 1,2,3,4,5,6,7,8  output : 1,5,2,6,3,7,4,8
     */

    public static Queue<Integer> reorderQueue(Queue<Integer> q){

        Stack<Integer> st = new Stack<>();
        int mid = q.size()/2;

        // step 1: move first half in stack 

        for( int i = 1 ; i<= mid ; i++){
            st.push(q.remove());
        }

        // step2 : Empty st to queue :

        while( st.size() > 0){
            q.add(st.pop());
        }

        // step 3 : move 1st half of queue to stack :

        for(int i =1 ; i<=mid ; i++){
            st.push(q.remove());
        }

        // step 4 : one by one st.peek() q.peek to q

        while( st.size() >0){
            q.add(st.pop()); // stack se 
            q.add(q.remove()); // queue k front se
        }

        // step 5 : reverse the queue

        while ( q.size() > 0) {
            st.push(q.remove());
        }

        while (st.size() >0) {
            q.add(st.pop());
        }

        return q;
     }


    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);


        System.out.println(q);

        // System.out.println(reverseQueue(q));
        // System.out.println(reverseFirstK(q, 3));
        System.out.println(reorderQueue(q));

    }
}