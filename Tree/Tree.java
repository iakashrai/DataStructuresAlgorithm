package Tree;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Tree
 */
public class Tree {
    
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

    Node root;
    

    static Node BuildTree(Node root){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("Enter Value");
        int x = scanner.nextInt();
        root = new Node(x);
        if(x==-1) return null;

        System.out.println("Enter Left Child Value for "+root);
        root.left=BuildTree(root.left);

        System.out.println("Enter right Child Value for "+root);
        root.right=BuildTree(root.right);
        
        return root;
    }

    // static void  levelOrderTraversal(Node root){
    //     if(root == null)
    //         System.out.println("Tree is Empty");

    //     Queue<Node> q = new LinkedList<>();
    //     q.add(root);
    //     q.add(null);

    //     while(!q.isEmpty()){
    //         Node temp = q.peek();
    //         q.remove();
    //         if(temp==null){
    //             System.out.println(" ");
    //             if(!q.isEmpty()) q.add(null);
    //         }
    //         else{
    //             System.out.println(temp.data);
    //             if(temp.left!=null) q.add(temp.left);
    //             if(temp.right!=null) q.add(temp.right);
    //         }
    //     }

    // }

    static void levelOrderTraversal(Queue<Node> q){
        if(q.isEmpty()) return;
        while(q.peek()!=null){
            Node temp = q.remove();
            if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null)q.add(temp.right);
            System.out.print(temp.data+" ");
        }
        q.remove();
        System.out.println(" ");
        if(!q.isEmpty()) {
            q.add(null);
            levelOrderTraversal(q);
        }
    }

    static void preOrderTraversal(Node root){
        if(root == null) return;
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static void postOrderTraversal(Node root){
        if(root == null) return;
        
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+" ");

    }

    static void inOrderTraversal(Node root){
        if(root == null) return;
        
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        
        Node root = Tree.BuildTree(null);
        /*
        Node root = new Node(4);
        Node a1 = new Node(6);
        Node a2 = new Node(3);
        Node b1 = new Node(2);
        Node b2 = new Node(5);
        Node b3 = new Node(2);
        Node c1 = new Node(1);

        root.left=a1;
        root.right=a2;

        a1.left = b1;
        a1.right = b2;

        a2.left = b3;

        b1.left = c1; */

        Queue<Node> q = new LinkedList<>();
        levelOrderTraversal(q);
        System.out.println(" ");
        preOrderTraversal(root);
        System.out.println(" ");
        postOrderTraversal(root);
        System.out.println(" ");
        inOrderTraversal(root);

        // 4 6 3 2 -1 5 -1 -1 2 1 -1 -1 -1
    }
}