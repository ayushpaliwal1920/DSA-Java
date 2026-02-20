package LinkedList;


public class LLQuestions_04 {

    public static class Node{
        int data;
        Node next;
        Node random; // for question 15 : copy list with random pointer.

        Node(){}
        Node(int data){
            this.data = data;
        }
    }
    public static void display(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("\n");
    }

    /* Q1 . can we delete a  node given the node itself as parameter ?
            is there any efficient way , provided that the give node is not the last node?

            given node is not the last node of linked list and we have to delete that node from the linked list.
            leetcode 237.
    */

    public void deleteNode(Node node) {
        // we don not have the access of the previous data so we can place data of nextNode in the given node and disconnect the nextNode. 
        node.data = node.next.data;
        node.next = node.next.next;
    }

    /*
      Q2. Finding nth node from the end of linked list : nthNodefromEnd(Node head , int n)
          leetcode 19. : delete nth node from end : deleteNthNodeFromEnd(Node head , int n)

          nth node from last = (m -n +1)th node from the start where m is the length of linked list and n is the given node from last.
    */

        //    first approach  :

          public static Node nthNodefromEnd(Node head , int n){
            Node temp = head;
            int size =0 ; 
            while(temp != null){
                temp = temp.next;
                size++;
            }
            int m = size -n +1;
            // nth node from start 
            temp = head;
            for(int i =1; i< m-1 ; i++){
              temp = temp.next;
            }
            return temp;
          }


        //   second approach : best and important : by single iteration : very very important concept :

        public static Node nthNodefromEnd_2(Node head , int n){

            Node fast = head;  // 100(head/fast/slow) ,13 ,4, 5, 12,10 ,null
            Node slow = head;  

            for(int i=1 ; i<= n ; i++){ // 100(head/slow) ,13 , 4(fast) , 5, 12 , 10 ,null
                fast = fast.next; 
            }

            while( fast != null){ // 100(head) , 13 , 4 ,5 , 12(slow), 10 ,null(fast)
                slow = slow.next; 
                fast = fast.next;
            }
            return slow; // 12
        }

        // leetcode 19 :

        public static Node deleteNthNodeFromEnd(Node head , int n){
            // similar but change in while condition :

            Node fast = head; // 100(head/fast/slow) ,13 ,4, 5, 12,10 ,null
            Node slow = head;

            for( int i=1 ; i<=n ; i++){  // 100(head/slow) ,13 , 4(fast) , 5, 12 , 10 ,null
                fast = fast.next;
            }

            if( fast == null){ // if n = number of nodes means we want head to be delete
                head = head.next;
                return head;
            }

            while(fast.next != null){ // 100(head) , 13 , 4 ,5(slow) , 12, 10(fast),null
                slow = slow.next;
                fast = fast.next;
            }
             
            // delete node :
            slow.next = slow.next.next; // 100(head) , 13 , 4 ,5(slow) ,10(fast),null

            return head;

        }

        /*
        Q3 : Finding intersection of two linked list : leetcode 160. : Intersection of two linked list : getIntersectionNode(Node headA , Node headB)
            Two ponters to the rescue :
        */

    public static Node getIntersectionNode(Node headA , Node headB){
        Node tempA = headA;
        Node tempB = headB;

        int lengthA = 0;
        int lengthB = 0;

        while(tempA!= null){
            lengthA++;
            tempA = tempA.next;
        }

        while(tempB != null){
            lengthB++;
            tempB = tempB.next;
        }

        tempA = headA;
        tempB = headB;

        if( lengthA > lengthB){
            int steps = lengthA - lengthB;
            for(int i=1 ;i<= steps ; i++){
                tempA = tempA.next;
            }
        }else{
            int steps = lengthB - lengthA;
            for(int i=1; i< steps ; i++){
                tempB = tempB.next;
            }
        }

        while( tempA != tempB){
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return tempA; // if there is no intersection then it will return null
        }


        /*
        Q4 : Finding Middile element of a linked list :
            1. by finding length of linked list and then traversing till middle element : 2 iterations
            2. by using two pointers : fast and slow : fast will move 2 steps and slow will move 1 step : when fast will reach end then slow will be at middle element : single iteration.
            leetcode 876. : Middle of the linked list : middleNode(Node head)
        */

        public static Node middleNode(Node head){
            Node fast = head;
            Node slow = head;

            while( fast != null || fast.next != null){ // for odd numbers : termination : fast.next == null and for even numbers : termination : fast == null
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        /*
        Q5 : deleting the midddle element of Linked List : leetcode 2095. : delete the middle node of linked list : deleteMiddle(Node head)

         */

        public static Node deleteMiddle(Node head){
            if(head == null || head.next == null){
                return null;
            }
            Node fast = head;
            Node slow = head;
            Node prev = null;

            while( fast != null || fast.next !=null){
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            prev.next = slow.next ;
            return head;

        }
        // or 

        public static Node deleteMiddle2(Node head){
            if( head.next == null){
                return null;
            }
            Node slow = head;
            Node fast = head;
            while(fast.next.next !=null && fast.next.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            slow.next = slow.next.next;
            return head;
        }

        /*
        Q6 : Cycle in a Linked List : leetcode 141. : hasCycle(Node head) : 
        */

        public boolean hasCycle(Node head) {
        
        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // move 1 step
            fast = fast.next.next;    // move 2 steps

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    /*
    Q7 : find out the node where cycle begins : leetcode 142. : cycle detection and finding the starting point of the cycle : detectCycle(Node head)
            Important question
     */
    public Node detectCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while(fast != null || fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        Node temp = head;

        while( temp != slow){
            temp = temp.next;
            slow = slow.next;
        }
        return slow;
    }

    /*
    Q8 : Merge two sorted linked list. : leetcode 21. : mergeTwoLists(Node headA , Node headB)
    very imp :
     */

    // first way using extra space :
    // second way connecting the nodes of given linked list itself : without using extra space : best way : important question :

    // using merge sort algo : not using extra space :


    public static Node mergeTwoLists(Node head1 , Node head2){
        Node temp1 = head1;
        Node temp2 = head2;
        Node head = new Node(-1); // dummy node => ispr hi attach krna hai sorted form mai.
        Node temp = head;

        while( temp1 != null && temp2!= null){
            if( temp1.data < temp2.data){
                temp.next = temp1;
                temp1 = temp1.next;
            }else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next; // temp ko aage badha do : kyuki temp.next hi attach ho rha hai sorted form mai.
        }

      if( temp1 != null){
        temp.next = temp1;
      }else{
        temp.next = temp2;
      }

        return head.next;
    }


    // using extra space : by creating a new linked list and filling it in sorted form by comparing the data of given linked list.

    public static Node mergeTwoList02(Node head1 ,Node head2){
    
        Node temp1 = head1;
        Node temp2 = head2;
        Node head = new Node(-1); // dummy node => ispr hi attach krna
        Node temp = head;

        while( temp1 != null && temp2 != null){
            if( temp1.data < temp2.data){
                Node a = new Node(temp1.data);
                temp.next = a;
                temp = a;
                temp1  = temp1.next;
            }else{
                Node a = new Node(temp2.data);
                temp.next = a;
                temp = a;
                temp2 = temp2.next;
            }
        }

        if( temp1 == null){
            temp.next = temp2;
        }else{
            temp.next = temp1;
        }

        return head.next;
    }


    /*
    Q9 :Given a linked list , split it into two halves : such that one contains odd values , while the other contains even values.

    ismai values dekh k arrnge kiya hai.
     */

      public static Node oddEvenNumberList(Node head) {
            Node odd = new Node(-1);
            Node even = new Node(-2);

            Node temp1 = odd;
            Node temp2 = even;
            Node temp = head;

        while (temp != null) {
             if ((temp.data % 2) != 0) {      
                temp1.next = temp;
                temp1 = temp1.next;
            
             }else {                         
                temp2.next = temp;
                temp2 = temp2.next;         
             }

            temp = temp.next;
    }

        temp2.next = null;        
        temp1.next = even.next;  
        return odd.next;
             
    }

    /*
    
    Q10 : Given head of singly linked list group all the nodes with odd indices ttogether followed by the nodes with even indices return the reordered list.

    leetcode 328. : Odd Even Linked List : oddEvenList(Node head) : important question

    ismai indices k base pr arrange kiya hai.
    */

    public static Node oddEvenIndicesList(Node head){
        if( head == null || head.next == null){
            return head;
        }
        Node odd = new Node(-1);
        Node even = new Node(-2);

        Node temp1 = odd;
        Node temp2 = even;
        Node temp = head;
        int count = 1;

        while( temp != null){
            if( (count % 2) !=0 ){
                temp1.next = temp;
                temp1 = temp1.next;
            }else{
                temp2.next = temp;
                temp2 = temp2.next;
            }
            count++;
            temp = temp.next;
        }
        temp2.next = null;
        temp1.next = even.next;

        return odd.next;
    }

    /*
    Q11 : Remove duplicates form a sorted linked list.
        1. by using extra space : by using hashset : not efficient
        2. by using two pointers : one pointer will traverse the linked list and other pointer will keep track of last unique node : if current node data is same as last unique node data then we will skip that node otherwise we will attach that node to last unique node and update last unique node to current node.
    
        leetcode 83. : Remove duplicates from sorted linked list : deleteDuplicates(Node head) : important question
     
    */

    public static Node deleteDuplicates(Node head){
        if( head == null || head.next == null){
            return head;
        }
        Node temp = head;

        while( temp != null && temp.next != null){
            if( temp.data == temp.next.data){
                temp.next = temp.next.next; // skip the duplicate node
            }else{
                temp = temp.next; // move to next node
            }
        }
        return head;
    }

    /*
    Q12 : Reverse a linked list and return its new head : leetcode 206. : Reverse Linked List : reverseList(Node head) : important question
        
     */

    // method1 : recursive :

    public static Node reverseListRecursive(Node head){
        
        if( head == null || head.next == null){
            return head;
        }

        Node newNode = reverseListRecursive(head.next);

        head.next.next = head; // interchanging connections
        head.next = null;
        return newNode;
    }

    //  method2 : iterative : using three pointer .

    public static Node reverseListIterative(Node head){
        Node curr = head;
        Node prev = null;
        Node agla = null;

        // steps of reversing : prev curr agla

        while( curr != null || agla != null ){
            agla = curr.next;
            curr.next = prev;
            prev = curr ;
            curr = agla;
        }
        return prev;
    }

/*
    Q13 : Check whether a linked list is palindrome or not : leetcode 234. : Palindrome Linked List : isPalindrome(Node head) : important question
*/
    public static boolean isPalindromell(Node head){

        // step1 : find middle element of linked list.
            
        Node fast = head;
        Node slow = head;

        while( fast != null || fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // step 2 : reverse the second half of linked list.

        Node temp = reverseListRecursive(slow.next);
        slow.next = temp; // connecting the first half with reversed second half.


        // Step 3 : compare the first half and second half of linked  list.

        Node p1 = head;
        Node p2 = slow.next;

        while(p2 != null){
            if( p1.data != p2.data){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;

    }

    /*
    Q14 : Find the maximum twin sum of a linked list : leetcode 2130. : Maximum Twin Sum of a Linked List : pairSum(Node head) : important question
         twin of node at (i)th index is the node at (n-i-1)th index. twin sum is the sum of values of a node and its twin.
         
    */

     public static int pairSum(Node head){

        // step 1 : find middle element of linked list.
        Node fast = head;
        Node slow = head;
        while( fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // step 2 : reverse the second half of linked list as we did in palindrome question.

        Node curr = slow.next;
        Node prev = null;
        Node agla = null;

        while( curr != null){
            agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        }

        slow.next = prev; // connectiog first half with reversed second half of linked list.

        // step 3 : find the maximum twin sum by traversing the first half and reversed second half of linked list together.


        Node p1 = head;
        Node p2 = slow.next;
        int max = Integer.MIN_VALUE;

        while (p2 != null) {
            int sum = p1.data + p2.data;
            max = Math.max(max,sum);
            p1 = p1.next;
            p2 = p2.next;
        }
        return max;
    }

    /*
    Q15 : Copy list with Random Pinter : Construct a deep copy of a linked list where each node contains an additional random pointer , which could point to any node in the list or null.

      leetcode 138. : Copy List with Random Pointer : copyRandomList(Node head) : important question

      see again this question last question on linked list video : very important question : watch it again and again : very important question.
    */
    public static Node copyRandomList(Node head){

        // step 1: create a deep copy

        Node head2 = new Node(0);
        Node temp1 = head;
        Node temp2 = head2;
        while( temp1 != null){
            Node newNode = new Node(temp1.data);
            temp2.next = newNode;
            temp2 = temp2.next;
            temp1 = temp1.next;
        }
        head2 = head2.next; // head of new linked list : deep copy of given linked list : but random pointer is not connected yet.
        temp2 = head2; // temp2 ko head2 pe le aao : kyuki abhi hume random pointer connect karna hai : temp2 se connect karenge random pointer : temp1 se connect karenge random pointer of given linked list.
        temp1 = head;


        //  step 2 :connect alternetly the nodes of given linked list and new linked list : so that we can connect random pointer easily in next step.

        Node temp = new Node(-1);

        while(temp1 != null && temp2 != null){
            temp.next = temp1;
            temp1 = temp1.next;
            temp = temp.next;

            temp.next = temp2;
            temp2 = temp2.next;
            temp = temp.next;
        }
        temp1 = head;
        temp2 = head;

        // step 3 : connect random pointer of new linked list by using the random pointer of given linked list. or Assigning random pointers.

        while( temp1!= null && temp2 != null){
            if( temp1.random != null){
                temp2.random = temp1.random.next; // kyuki temp1.random ke next pe hi temp2.random hoga : kyuki humne alternetly connect kiya hai nodes ko.
            }
            temp1 = temp2.next; // kyuki humne alternetly connect kiya hai nodes ko : to next node pe jane ke liye 2 steps badhna padega.
            temp2 = temp1.next; // kyuki new linked list ke nodes bhi alternetly connected hai : to next node pe jane ke liye 1 step badhna padega.
        }

        temp1 = head;
        temp2 = head2;

        // step 4 : seperating or disconnect the two linked list : so that we can get the deep copy of given linked list.

        while( temp1 != null && temp2 != null){
            temp1.next = temp2.next;
            temp1 = temp1.next;

            temp2.next = temp1.next;
            temp2 = temp2.next;
        }

        return head2;

    }

    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);

        a.next = b;
        b.next = c;
        c.next = d;     
        d.next = e;

        display(a);
        Node temp = nthNodefromEnd(a,3);    
        System.out.println(temp.data);     
        a = deleteNthNodeFromEnd(a, 5);
        display(a);
        
    }
}
