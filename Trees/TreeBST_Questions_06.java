package Trees;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class TreeBST_Questions_06 {

    public static class Node {
        int val;
        Node right;
        Node left;

        public Node(int val) {
            this.val = val;
        }
    }

    /*
     * Binary Search Trees : Binary Tree with a property every node to left of a
     * given node is smaller than the node .and every node to the right of a node is
     * greater than the node.
     * 
     * Insertion , Deletion , and Searching(logn) is Easy .
     * Usage in implementaion of other data structures like set, map , priority
     * queue .
     * 
     * Disadvantage : lack of support for range queries , Not the efficient in case
     * of unbalanced Trees .
     * 
     * // Applications : PhoneBook , Dictionary , Stock Market Analysis
     */

    // Q1 : Search in BST : Leetcode 700

    public static Node search(Node root, int target) {
        if (root == null)
            return null;

        if (root.val == target)
            return root;
        else if (target < root.val) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }

        return root; // unreacchable statement
    }

    // Q2 : Insert in a Binary search tree : leetcode 701

    public static Node insertBst(Node root, int val) {
        if (root.val > val) {
            if (root.left == null)
                root.left = new Node(val);
            else
                insertBst(root.left, val);
        }
        if (root.val < val) {
            if (root.right == null)
                root.right = new Node(val);
            else
                insertBst(root.right, val);
        }

        return root;
    }

    // Traversals In BST : Verry Imp : Inorder of BST is in always Sorted order.

    public static void preorderBST(Node root){
        if(root == null) return;
        System.out.println(root.val + " ");
        preorderBST(.root.left);
        preorderBST(root.right);
    }

    public static void postorderBST(Node root){
        if(root == null) return;
        postorderBST(.root.left);
        postorderBST(root.right);
        System.out.println(root.val + " ");
    }

    public static void inorderBST(Node root){
        if(root == null) return;
        inorderBST(.root.left);
        System.out.println(root.val + " ");
        inorderBST(root.right);
    }

    // Q3 : Deletion of a Node in BST :

    // The node has 0 child :

    public static void deleteBst_0(Node root, int target) {
        if (root == null)
            return;
        if (root.val > target) {
            if (root.left == null)
                return;
            if (root.left.val == target)
                root.left = null;
            else
                deleteBst_0(root.left, target);
        }
        if (root.val < target) {
            if (root.right == null)
                return;
            if (root.right.val == target)
                root.right = null;
            else
                deleteBst_0(root.right, target);
        }
    }

    // The node has 1 child or 0 child:

    public static void deleteBst_1(Node root, int target) {
        if (root == null)
            return;

        if (root.val > target) {
            if (root.left == null)
                return;
            if (root.left.val == target) {
                Node l = root.left; // node that i wwidh to delete
                if (l.left == null && l.right == null) {// 0 children
                    root.left = null;
                } else if (l.left == null || l.right == null) {
                    if (l.left != null)
                        root.left = l.left;
                    else
                        root.left = l.right;
                }
            } else
                deleteBst_1(root.left, target);
        } else { // go right

            if (root.right == null)
                return;
            if (root.right.val == target) {
                Node r = root.right; // node that i wish to delete
                if (r.left == null && r.right == null)
                    root.right = null;
                else if (r.left == null || r.right == null) {
                    if (r.left != null)
                        root.right = r.left;
                    else
                        root.right = r.right;
                }
            } else {
                deleteBst_1(root.right, target);
            }

        }
    }

    // The node has 2 ,1 or 0 child :

    public void deleteBst_2(Node root, int target) {
        if (root == null)
            return;
        if (root.val > target) {// go left
            if (root.left == null)
                return;
            if (root.left.val == target) {
                Node l = root.left; // l is that node that i wish to delete
                if (l.left == null && l.right == null)
                    root.left = null;
                else if (l.left == null || l.right == null) {
                    if (l.left != null)
                        root.left = l.left;
                    else
                        root.left = l.right;
                } else { // 2 child case
                    Node curr = l;
                    Node pred = curr.left;
                    while (pred.right != null)
                        pred = pred.right;
                    delete(root, pred.val);
                    pred.left = curr.left;
                    ;
                    pred.right = curr.right;
                    root.left = pred;
                }

            } else {
                delete(root.left, target);
            }

        } else {
            if (root.right == null)
                return;
            if (root.right.val == target) {
                Node r = root.right; // r is that node that i wish to delete
                if (r.left == null && r.right == null)
                    root.right = null;
                else if (r.left == null || r.right == null) {
                    if (r.left != null)
                        root.right = r.left;
                    else
                        root.right = r.right;
                } else { // 2 child case
                    Node curr = r;
                    Node pred = curr.left;
                    while (pred.right != null)
                        pred = pred.right;
                    delete(root, pred.val);
                    pred.left = curr.left;
                    pred.right = curr.right;
                    root.right = pred;
                }
            } else {
                delete(root.right, target);
            }

        }

    }

    // Q 4: Lowest common ancestor of a BST : leetcode 235

    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root.val == p.val && root.val == q.val)
            return root;
        if (p.val < root.val && q.val > root.val)
            return root;
        if (p.val > root.val && q.val < root.val)
            return root;
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    // Q5 : Inorder predecesor and successor of value val :

    // Method 1 :
    public static void predAndSucc1(Node root, int val) {
        List<Integer> arr = new ArrayList<>();
        inorderPS(root, arr);
        int idx = -1;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == val) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            System.out.println("Value not found");
            return;
        }

        // Predecessor
        if (idx - 1 >= 0) {
            System.out.println("Pred of val: " + arr.get(idx - 1));
        } else {
            System.out.println("No predecessor");
        }

        // Successor
        if (idx + 1 < arr.size()) {
            System.out.println("Succ of val: " + arr.get(idx + 1));
        } else {
            System.out.println("No successor");
        }
    }

    public static void inorderPS(Node root, List<Integer> arr) {
        if (root == null)
            return;
        inorderPS(root.left, arr);
        arr.add(root.val);
        inorderPS(root.right, arr);
    }

    // method 2 :

    // Global var :

    static Integer pred = null;
    static Integer succ = null;
    static Node prev = null;

    public static void inorder2(Node root, int val) {
        if (root == null)
            return;

        inorder2(root.left, val);

        // find predecessor
        if (root.val == val && prev != null) {
            pred = prev.val;
        }

        // find successor
        if (prev != null && prev.val == val) {
            succ = root.val;
        }

        prev = root;

        inorder2(root.right, val);
    }

    // Q6 : validate BT is a BST :

    // method 1 : Appply inorder traversal and if traversal is in sorted form then
    // it is a binary search tree.

    // method 2 : use global variable :

    static boolean flag2 = true
    static Node prev = null;

    public boolean validate(Node root) {
        flag2 = true;
        prev = null;
        inorder3(root);
        return flag2;
    }

    public void inorder3(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        // magic
        if (prev == null)
            prev = root;
        else if (root.val <= prev.val) {
            flag = false;
        } else {
            prev = root;
        }
        inorder(root.right);
    }

    // Q7 : Convert Sorted array to Balanced BST : Leetcode 108

    public static Node createBST(int[] nums){
        return binary(nums , 0 , nums.length - 1);
    }
    public static Node binary(int[] nums , int low ,int high){
        if( low > high) return null;

        int mid = low + (high - low)/2;
        Node root = new Node(nums[mid]);

        root.left = binary(nums , 0 , mid-1);
        root.right = binary(nums , mid+1 , high);

        return root;
    } 

    // Q8 : kth smallest  element in a BST : leetcode 230

    // method 1 : inorder method 

    public static int kthsmallest(Node root , int k){
        List<Integer> l = new ArrayList<>();
        inorder4(root , l);
        return l.get(k-1);
    }
    public static void inorder4(Node root , List<Integer> l){
        if( root == null) return;
        inorder(root.left,l);
        l.add(root.val);
        inorder(root.right,l);
    }

    // methd 2 :

    public static int kel = 0;
    public static Integer ans = null;


    public static int kthsmallest2(Node root , int k ){
        kel = 0;
        ans = null;
        inorder5(root , k);
        return ans;
    }
    public static void inorder5(Node root , int k){
        if( root == null || ans != null) return;

        inorder5( root.left , k);
        kel++;
        if( kel == k){
            ans = root.val;
            return;
        }
        inorder5( root.right , k);
    }
    public static void main(String[] args) {

    }
}
