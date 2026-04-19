package Trees;

public class Tree_Implementation_01 {

    // Trees : A non linear data structure ,it is a Heirarchical data structure 

    /*Components : Root node , 
                   leaf node - has no child
                   intermediate/child node - has parent and child both 
                   Ancenstor Node 
                   Descendent NOde 
                   sibling Nodes , Parent Nodes.
    
     Terminology : Level 
                   Number of Edges = size -1
                   Height = based on nodes => height = level ,
                            based on edges => height =  level - 1
                   Size = no. of nodes
                   Subtree = left subtree and right subtree in binary tree 
    
     Properties : 1. Traversing in a tree is done by DFS anf BFS
                  2. No loop , no Circuit
                  3. It has no self - loop
    */ 

    // Types of Trees : 

    /*
    1. Generic Trees : Each node can have any number of child trees

    2. Binary trees  : Each node can have atmost 2 child nodes. left child node and right child node.

    3. Binary Search tree :   Each node can have atmost 2 child nodes. left child node and right child node.
                              Every node to the left of the node is smaller and every node the right has a greater value.

    4. AVL Trees : balanced  BST's
    */
    public static class Node{
        int val;
        Node left;  // Null
        Node right; // Null

        public Node(int val){
            this.val = val;
        }
    }

    // Display tree : using recursion 

    public static void display(Node root){

        if(root == null) return ; 

          System.out.print(root.val+ " -> ");
          if(root.left != null) System.out.print(root.left.val+ " ");
          if(root.right != null)System.out.print(root.right.val);
          System.out.println();

          display(root.left);
          display(root.right);
    }
    
    public static void main(String[] args) {
        Node root = new Node(2);

        Node a = new Node(4);
        Node b = new Node(10);

        root.left = a;
        root.right = b;

        Node c = new Node(6);
        Node d = new Node(5);

        a.left = c;
        a.right = d;

        Node e = new Node(11);

        b.right = e;

        // Display tree : 

        display(root);

        
    }
}