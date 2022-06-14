package Tree;

public class BalancedTree {


    static class Pair{
        int height;
        boolean balanced;

        Pair(int height,Boolean balanced){
            this.height = 0;
            this.balanced = true;
        }
    }
    
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

    static boolean isBalanced(Node root)
    {
	    if(root == null) return true;
        
        int diff = Math.abs(height(root.left)-height(root.right));
        
        return (diff<=1 && isBalanced(root.left) && isBalanced(root.right))?true:false;
    }

    static Pair isBalanced2(Node root)
    {
	    if(root == null) return new Pair(0,true);
        
        Pair ltree = isBalanced2(root.left);
        Pair rtree = isBalanced2(root.right);
        int diff = Math.abs(ltree.height-rtree.height);
        boolean balanced = (diff<=1 && ltree.balanced && rtree.balanced)?true:false;
        Pair tmp = new Pair(1+Integer.max(ltree.height, rtree.height), balanced);
        return tmp;
    }

    public static void main(String[] args) {  
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        System.out.println("====================================");
        System.out.print((isBalanced2(root).balanced)?"Tree is Balanced\n":"Tree is Unbalanced\n");
        System.out.println("====================================");

    }
}
