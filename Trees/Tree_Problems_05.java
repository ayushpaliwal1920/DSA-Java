package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class Tree_Problems_05 {

    public static class Node {
        int val;
        Node right;
        Node left;

        public Node(int val) {
            this.val = val;
        }
    }

    public static int height(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Q1 : invert Binary treee : Leetcode 226

    public static Node invert(Node root) {
        if (root == null)
            return root;

        if (root.left != null)
            invert(root.left);
        if (root.right != null)
            invert(root.right);

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    // Q2 : Symmetric tree Leetcode 101

    public static boolean sameTree(Node p, Node q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return sameTree(p.left, q.left) && sameTree(p.right, q.right);

    }

    public static boolean symmetricTree(Node root) {
        return sameTree(invert(root.left), root.right);
    }

    // Q3 : ZigZag Level order Traversal : Leetcode 103

    public static void nthLevel1(Node root, int n) { // left to right
        if (root == null)
            return;
        if (n == 1) {
            System.out.print(root.val + " ");
            return;
        }
        nthLevel1(root.left, n - 1);
        nthLevel1(root.right, n - 1);

    }

    public static void nthLevel2(Node root, int n) { // right to left
        if (root == null)
            return;
        if (n == 1) {
            System.out.print(root.val + " ");
            return;
        }
        nthLevel2(root.right, n - 1);
        nthLevel2(root.left, n - 1);
    }

    public static void zigzagTraversal(Node root) {
        int level = height(root) + 1;
        for (int i = 1; i < level + 1; i++) {
            if (i % 2 != 0) {
                nthLevel1(root, i);
            } else {
                nthLevel2(root, i);
            }
            System.out.println();
        }
    }

    // Q4 : Construct Binary tree from preorder and inorder : Leetcode 105

    // first element of preorder is always the root and last of postorder is always
    // a root

    public static Node buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return helper(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    public static Node helper(int[] preorder, int prelow, int prehigh, int[] inorder, int inlow, int inhigh) {

        if (prelow > prehigh)
            return null;

        // Root Ndoe :
        Node root = new Node(preorder[prelow]);

        // searching root in inorder :

        int i = inlow;

        while (inorder[i] != preorder[prelow])
            i++;

        // size of left side of root node :

        int leftsize = i - inlow;

        // recusive calls to build a tree :

        root.left = helper(preorder, prelow + 1, prelow + leftsize, inorder, inlow, i - 1);
        root.right = helper(preorder, prelow + leftsize + 1, prehigh, inorder, i + 1, inhigh);

        return root;
    }

    // Q5 : path sum i : leetcode 112 && path sum ii 113

    // Q6 : pathsum iii : leetcode 437 : O(n*n) , space complexity = O(n*h)

    public static int pathsumiii(Node root , int target){
        // base case ;

        if(root == null) return 0;

        int count = noOfPaths(root,target); // counts number of path for a node 

        count += (pathsumiii(root.left, target) + pathsumiii(root.right,target)) // counts number of path for a node for all nodes(recursion)
        return count;
    }

    public int noOfPaths(Node root, int target) {
        int count = 0;
        if (root == null)
            return 0;
        if (target - root.val == 0) {
            count++;
        }
        return count + noOfPaths(root.left, target - root.val) + noOfPaths(root.right, target - root.val);
    }

    // Q7 : Flatten Binary Tree to a linked list : leetcode 114
    // TC = O(n) , SC = O(n)

    public static void flatten(Node root) {
        if (root == null)
            return;
        flatten(root.left);
        flatten(root.right);

        Node tempR = root.right;
        root.right = root.left;

        Node temp = root.left;
        root.left = null;

        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = tempR;
    }

    // Follow up : solve in O(1)

    // Morrise traversal principle :

    public static void flatten2(Node root){
        Node curr = root;
        while( curr.right != null){
            if( curr.left != null){
                Node pred = curr.left;
                while(pred.right != null) pred = pred.right;
                pred.right = curr.right;
                curr.right = pred.right;
                curr.left = null
            }
            curr = curr.right;
        }
    }

    // Q8 : Amount of time for binary tree to be Infected : Leetcode 2385

    public static Node getNode(Node root, int start) {

        if (root == null)
            return null;
        if (root.val == start)
            return root;
        TreeNode left = getNode(root.left, start);
        TreeNode right = getNode(root.right, start);
        if (left == null)
            return right;
        else
            return left;
    }

    public void preorder(Node root, Map<Node, Node> p) {
        if (root == null)
            return;
        if (root.left != null) {
            p.put(root.left, root); // (child , parent)
        }
        if (root.right != null) {
            p.put(root.right, root);
        }
        preorder(root.left, p);
        preorder(root.right, p);
    }

    public static int amountofTime(Node root, int start) {

        Node node = getNode(root, start);
        Map<Node, Node> p = new HashMap<>(); // parent child
        preorder(root, p);

        // bfs

        Queue<Node> q = new LinkedList();
        q.add(node);

        Map<Node, Integer> v = new HashMap<>();// visited/infected
        v.put(node, 0);

        while (q.size() > 0) {
            Node temp = q.peek();
            int level = v.get(temp);
            if (temp.left != null && !v.containsKey(temp.left)) {
                q.add(temp.left);
                v.put(temp.left, level +1);
            }

            if (temp.right != null && !v.containsKey(temp.right)) {
                q.add(temp.right);
                v.put(temp.right, level +1);
            }

            if (p.containsKey(temp) && !v.containsKey(p.get(temp))) {
                q.add(p.get(temp));
                v.put(p.get(temp), level + 1);
            }

            q.remove();
        }

        int max = -1;
        for (int level : v.values()) {
            max = Math.max(max, level);
        }

        return max;
    }
    public static void main(String[] args) {

    }
}
