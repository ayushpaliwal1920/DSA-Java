package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree_BFS_04 {

    // Level Order traversal : Breadth First Search

    /*
     * It visits:
     * 
     * First → root (or source node)
     * Then → all neighbors
     * Then → neighbors of neighbors
     * 
     * Use a Queue (FIFO)
     * 
     * Add node → process → add its children
     * 
     */

    public static class Node {
        int val;
        Node right;
        Node left;

        public Node(int val) {
            this.val = val;
        }
    }

    // method 1 : BFS : O(nlogn)

    public static int height(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void nthLevel(Node root, int n) {

        if (root == null)
            return;
        if (n == 1) {
            System.out.print(root.val + " ");
        }
        nthLevel(root.left, n - 1);
        nthLevel(root.right, n - 1);
    }

    public static void bfs1(Node root) {
        int level = height(root);

        for (int i = 1; i <= level; i++) {
            nthLevel(root, i);
        }
    }

    // Method 2 : BFS : O(n)

    public static void bfs(Node root){
        Queue<Node> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }

        while(q.size() > 0 ){
            Node temp = q.peek();
            if(temp.left != null) q.add(temp.left);
            if(temp.right != null) q.add(temp.right);

            System.out.print(temp.val + " ");
            q.remove();
        }
    }


    // Q1 : Diameter of a Binary tree  leetcode 543

    public static int diameterOfBinaryTree(Node root){

       if(root == null) return 0;

        int leftans = diameterOfBinaryTree(root.left);
        int rightans = diameterOfBinaryTree(root.right);
        int mid = height(root.left) + height(root.right);

        if(root.left != null) mid++;
        if(root.right != null) mid++;

        int max = Math.max(leftans,Math.max(rightans, mid));

        return max;

    }

    // ANother method :

    public static int diameter = 0;

    public static int helper(Node root){

        int left = height(root.left);
        int right = height(root.right);

        diameter = Math.max(diameter, left + right);

        return 1+ Math.max(left, right);
    }

    public static int diameterOfBinaryTree2(Node root){
        helper(root);
        return diameter;
    }


    // Q2 : Balanced Binary tree : leetcode 110

    public static boolean isBalanced(Node root){

       if( root == null) return true;

       int lh = height(root.left);
       int rh = height(root.right);

       int d = Math.abs(lh - rh);

       if( d > 1) return false;

       return isBalanced(root.left)&& isBalanced(root.right);
    }


    // Q3 : Same tree = leetcode 100

    public static boolean isSameTree(Node p , Node q){
        if( p == null && q == null) return true;
        if( p == null || q == null) return false;
        if(p.val != q.val) return false;
        else return isSameTree(p.left, q.left) && isSameTree(p.right,q.right);
    }

    // Q4 : Binary tree paths : leetcode 257

    public static void helper(Node root , List<String> ans , String s){

        if( root == null) return;
        if( root.left == null && root.right == null) {
            s+= root.val;
            ans.add(s);
            return;
        }
        helper(root.left , ans, s+root.val+"->");
        helper(root.right, ans, s+root.val+"->");
    }
    
    public static List<String> binaryPath(Node root){
        List<String> ans = new ArrayList<>();
        helper(root , ans , "");
        return ans;
    }

    // Q5 : Lowest Common ancestor of a bbinary tree : Leetcode 236

    // Method 1 : O(n^2)

    public static boolean contains(Node root , Node node){
        if(root == null) return false;
        if( root == node) return true;
        
        return contains(root.left, node)|| contains(root.right, node);
    }

    public static Node lowestCommonAncestor(Node root , Node p , Node  q){
        if( p == root || q == root) return root;
        if( p == q) return p;

        boolean leftp = contains(root.left , p);
        boolean rightq = contains(root.right,q);

        if( leftp && rightq || ( !leftp && !rightq)) return root;
        if( leftp && !rightq) return lowestCommonAncestor(root.left,p,q);
        if( !leftp && rightq) return lowestCommonAncestor(root.right,p,q);
    

        return root;
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        Node a = new Node(2);
        Node b = new Node(3);

        root.left = a;
        root.right = b;

        Node c = new Node(4);
        Node d = new Node(5);

        a.left = c;
        a.right = d;

        Node e = new Node(6);
        Node f = new Node(7);

        b.left = e;
        b.right = f;

        // BFS :

        // bfs1(root);

        bfs(root);
        System.out.println();

        // diameter :

        System.out.println(diameterOfBinaryTree(root));

        // path :
        binaryPath(root);

    }
}
