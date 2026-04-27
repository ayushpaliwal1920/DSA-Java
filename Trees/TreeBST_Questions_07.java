package Trees;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class TreeBST_Questions_07 {

    public static class Node {
        int val;
        Node right;
        Node left;

        public Node(int val) {
            this.val = val;
        }
    }

    // INTERVIEW QUESTIONS IMP ON BST :

    // Q1 : Linked List t0 BST : leetcode 109

    public static Node sortedListToBST(ListNode head) {
        // calculate the size of list

        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // values of list in array :

        int[] arr = new int[size];

        temp = head;
        int idx = 0;
        while (temp != null) {
            arr[idx++] = temp.val;
            temp = temp.next;
        }

        return binary(arr, 0, size - 1);
    }

    public static Node binary(int[] arr, int low, int high) {
        if (low > high)
            return null;
        int mid = low + (high - low) / 2;
        Node root = new Node(arr[mid]);
        root.left = binary(arr, low, mid - 1);
        root.right = binary(arr, mid + 1, high);
        return root;
    }

    // Q2 : Construct a BSt from preorder Traversal : 1008

    public static Node constructBst(int[] preorder) {
        Node root = new Node(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            root = insertIntoBST(root, preorder[i]);
        }
        return root;
    }

    public static Node insertIntoBST(Node root, int val) {
        if (root == null)
            return new Node(val);

        if (val < root.val) {
            if (root.left == null)
                root.left.val = new Node(val);
            else
                insertIntoBST(root.left, val);
        } else {
            if (root.right == null)
                root.right.val = new Node(val);
            else
                insertIntoBST(root.right, val);
        }
        return root;
    }

    // Q3 : Convert BST to Greater tree : Leetcode 538

    public static int max1 = 0; // global var

    public static Node greaterTree(Node root) {
        max1 = 0; // reset for every cases
        inorderRev(root);
        return root;
    }

    public static void inorderRev(Node root) { // ulta inorder // right-root-left
        if (root == null)
            return;

        inorderRev(root.right);

        max1 += root.val;
        root.val = max1;

        inorderRev(root.left);
    }

    // method 2 without globarl var :

    public static Node greaterTree2(Node root) {
        int[] sum = new int[1]; // for sending value by pass by reference : use array
        sum[0] = 0;
        helper1(root, sum);
        return root;
    }

    public static void helper1(Node root, int[] sum) {
        if (root == null)
            return;
        helper1(root.right, sum);

        root.val = root.val + sum[0];
        sum[0] = root.val;

        helper1(root.left, sum);
    }

    // Q4 : Minimum diff between BST nodes : Leetcode 783

    public static int mindiff = Integer.MAX_VALUE;
    public static Integer prev = null;

    public static int minDiffInBST(Node root) {
        mindiff = Integer.MAX_VALUE; // reset global var for another cases
        prev = null; // reset global var for another cases
        inorder2(root);
        return mindiff;
    }

    public static void inorder2(Node root) {
        if (root == null)
            return;

        inorder2(root.left);

        if (prev != null) {
            mindiff = Math.min(mindiff, root.val - prev);
        }
        prev = root.val;

        inorder2(root.right);
    }

    // method 2 : without global variable :

    public static int minDiffInBST2(Node root) {
        int[] 
        helper2(root);
        return mindiff;
    }

    public static void helper2(Node root , int[] mindiff)

    //Q5 : MORRIS TRAVERSAL : Inorder in O(1) space complexity  and O(n) TC  

    public static List<Integer> morrisInorder(Node root , List<Integer> arr ){
        Node curr = root;

        while( curr != null){
            if(curr.left != null){ 
                // find pred 
                Node pred = curr.left;
                while( pred.right != null && pred.right != curr){ pred = pred.right;}

                // connection of predecessors :
                // if pred.right is null then connect it to curr(temp link) else unlink
                if(pred.right == null) {
                     pred.right = curr;
                     curr = curr.left;
                }
                if(pred.right == curr){
                    // pehle se visited - unlink kr do
                    pred.right = null;
                    arr.add(curr.val);  // node traversed
                    curr = curr.right;
                }
            }else{
                // no pred case :
                arr.add(curr.val) // visit or node traversed
                curr = curr.right;
            }
        }
        return arr;
    }

    // Q6 : All element in two BST : Leetcode 1305

    public List<Integer> getAllElements(Node root1, Node root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        morrisInorder(root1, l1);
        morrisInorder(root2, l2);

        List<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) == l2.get(j)) {
                ans.add(l1.get(i));
                ans.add(l2.get(j));
                i++;
                j++;
            } else if (l1.get(i) < l2.get(j)) {
                ans.add(l1.get(i));
                i++;
            } else {
                ans.add(l2.get(j));
                j++;
            }
        }

        while (i < l1.size()) {
            ans.add(l1.get(i));
            i++;
        }

        while (j < l2.size()) {
            ans.add(l2.get(j));
            j++;
        }

        return ans;

    }

    // Q7 : Trim a binary search tree : leetcode 669

    public static Node trim(Node root, int low, int high) {
        if (root == null)
            return null;

        if (root.val < low)
            return trim(root.right, low, high);
        if (root.val > high)
            return trim(root.left, low, high);

        root.left = trim(root.left, low, high);
        root.right = trim(root.right, low, high);

        return root;
    }

    // Q8 : Recover Binary Tree : leeetcode 99

    public static void morrisInorder2(Node root, List<Node> arr) {
        Node curr = root;
        Node prev = null;

        while (curr != null) {
            if (curr.left != null) {
                Node pred = curr.left;
                while (pred.right != null && pred.right != curr)
                    pred = pred.right;

                if (pred.right == null) {// connect
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    // work
                    if (prev != null && prev.val > curr.val) {
                        arr.add(prev);
                        arr.add(curr);
                    }
                    prev = curr;
                    // work finished
                    curr = curr.right;
                }
            } else {
                // work
                if (prev != null && prev.val > curr.val) {
                    arr.add(prev);
                    arr.add(curr);
                }
                prev = curr;
                // work finished
                curr = curr.right;
            }
        }
    }

    public static void recoverTree(Node root) {
        List<Node> arr = new ArrayList<>();

        morrisInorder2(root, arr); // Imp

        // swap nodes :
        Node first = arr.get(0);
        Node second = arr.get(arr.size() - 1); // Imp -> -33 , 321 , 55 , 71 , 146 , 231 , -13 , 399
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    public static void main(String[] args) {

    }
}
