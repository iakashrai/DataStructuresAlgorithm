package Tree;

public class DiameterOfTree {

    static class Node{
        private int data;
        private Node left;
        private Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int height(Node root){

        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        int h = 1 + Integer.max(lh,rh);

        return h;

    }
    
    static int diameter(Node root){

        if(root == null){
            return 0;
        }
        
        int lh = height(root.left);
        int rh = height(root.right);

        int ldia = diameter(root.left);
        int rdia = diameter(root.right);

        int dia = Integer.max(ldia, rdia);
        return 1+Integer.max(dia,lh+rh);                                                                                                                                                                                                                                                                                                                                                                                      

    }

    static class Pair{
        int diameter;
        int height;
    }

    static Pair diameterOptimized(Node root){

        if(root==null){
            Pair tmp = new Pair();
            tmp.diameter = 0;
            tmp.height = 0;
            return tmp;
        }

        Pair leftSubTree = diameterOptimized(root.left);
        Pair righSubTree = diameterOptimized(root.right);

        Pair tmp = new Pair();
        tmp.diameter = 1 + Integer.max(Integer.max(leftSubTree.diameter,righSubTree.diameter),leftSubTree.height+righSubTree.height);
        tmp.height = 1 + Integer.max(leftSubTree.height, righSubTree.height);

        return tmp;

    }

    static int diameterOptimizedWraper(Node root){
        return diameterOptimized(root).diameter;
    }

    public static void main(String[] args) {
        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);  
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        System.out.print("---------------------------------\n");
        System.out.print("Height: "+ height(root));
        System.out.print("\n---------------------------------\n");
        long startTime = System.nanoTime();
        System.out.print("Diameter: "+ diameter(root));
        long endTime = System.nanoTime();
        System.out.println("Diameter FN time: " +(endTime - startTime));

        System.out.print("\n---------------------------------\n");
        startTime = System.nanoTime();
        System.out.print("Diameter: "+ diameter(root));
        endTime = System.nanoTime();
        System.out.println("Diameter Optimized FN time: " +(endTime - startTime));

        System.out.print("\n---------------------------------\n");
    }

}


