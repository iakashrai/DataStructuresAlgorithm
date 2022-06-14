package Tree;

public class HeightOfTree {
    
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

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);     
        
        System.out.println("--------------------------------- ");
        System.out.print("Height: "+ height(root));
    }
}
