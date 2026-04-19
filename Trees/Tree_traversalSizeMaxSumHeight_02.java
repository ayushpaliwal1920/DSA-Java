package Trees;

public class Tree_traversalSizeMaxSumHeight_02 {


    public static class Node {
        int val;
        Node right;
        Node left;

        public Node(int val) {
            this.val = val;
        }
    }
    // Trvaersals : travelling each and every element of the tree.

    // preorder traversal :

    public static void preOrder(Node root) {

        if (root == null)
            return;

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    // size :

    public static int size(Node root){
        if( root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    // sum : 

    public static int sum(Node root){
        if( root == null){
            return 0;
        } 
        return root.val + sum(root.left) + sum(root.right);
    }

    // max :

    public static int max(Node root){

        if( root == null) return Integer.MIN_VALUE;

        int a = root.val;
        int b = max(root.left);
        int c = max(root.right);

        return Math.max(a, Math.max(b,c));
    }

    // height : edges wise

    public static int height(Node root){

        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0 ;

        return 1 + Math.max(height(root.left) , height(root.right));
    }

    // min :

    public static int mini(Node root){

        if( root == null) return Integer.MAX_VALUE;

        return Math.min(root.val,Math.min(mini(root.left),mini(root.right)));
    }

    // product :

    public static int product(Node root){

        if( root == null) return 1;
        return root.val * product(root.left) * product(root.right);
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

        Node e = new Node(600);

        b.right = e;

        // traverse :

        // preOrder(root);

        // size :

       System.out.println(size(root));

        // sum :

        System.out.println(sum(root));

        // max

        System.out.println(max(root));
        
        // height

        System.out.println(height(root));

        // min :
        System.out.println(mini(root));

        // product :

        System.out.println(product(root));
    }

}
