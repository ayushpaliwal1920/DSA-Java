package Trees;

public class Tree_Traversals_03 {

    public static class Node {
        int val ;
        Node right;
        Node left;

        public Node(int val){
            this.val = val;
        }
    }

    // PreOrder : Root Left Right 

    public static void preOrder(Node root){

        if( root == null) return;

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }


    // InOrder : Left Root Right

    public static void inOrder(Node root){

        if(root == null) return;

        inOrder(root.left);

        System.out.print(root.val + " ");

        inOrder(root.right);
    }

    // PostOrder : Left Right root

    public static void postOrder(Node root){

        if ( root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }


    // Q1 : Print elements of nth level :

    public static void nthLevel(Node root , int n ){
        
        if(root == null) return;
        if( n == 1) System.out.print(root.val + " ");
        nthLevel(root.left, n-1);
        nthLevel(root.right, n-1);
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

        // preorder

        System.out.println("PreOrder");
        preOrder(root);
        System.out.println();

        // in order
        System.out.println("Inorder");
        inOrder(root);
        System.out.println();

        // postOrder 

        System.out.println("PostOrder");
        postOrder(root);
        System.out.println();

        //nth level :

        nthLevel(root, 2);
    }
}
