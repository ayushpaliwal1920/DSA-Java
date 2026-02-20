package LinkedList;

public class LLQuestions_08 {

  
    public static class Node{
        int val;
        Node prev , next;

        Node(){}
        Node(int val){
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

      /*
    Q1 : palindrom likedlist : doubly linked list 
     */

        public static boolean isPalindrom(Node head){
        if (head == null || head.next == null) {
            return true;
        }

        // find tail
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        // just like array two pointer
        Node left = head;
        Node right = tail;

        while (left != right && left.prev != right) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.prev;
        }

        return true;
        }
    

    /*
    Q2 : Two sum in a doubly linked list : sorted in non decreasing order 
    */

    public  static  void twoSum(Node head, int target){
        Node h = head;
        Node tail = head;

        // find tail
        while( tail.next != null){
            tail = tail.next;
        }

        Node t = tail;

        while( h.val < t.val){
            if( h.val + t.val == target){
                System.out.println(h.val + " " + t.val);
                h = h.next;
                t = t.prev;
            }else if( (h.val + t.val) > target ){
                t = t.prev;
            }else{
                h = h.next;
            }
        }
    }

    /*
    Q3 : Critical point max and min distance : LeetCode 2058
    
    */

    /*
    Q4 : LeetCode 430 : flatter a multilevel Doubly linked list 
    */


    public static void main(String[] args) {
        
    }
}
