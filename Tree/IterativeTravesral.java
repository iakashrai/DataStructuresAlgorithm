package Tree;

import java.util.ArrayList;
import java.util.Stack;
import java.util.spi.CurrencyNameProvider;

import javax.swing.plaf.synth.Region;

/**
 * IterativeTravesral
 */
public class IterativeTravesral {
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
    
    static void preOrderTraverse(Node root){
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node temp = st.pop();
            System.out.print(temp.data+" ");
            if(temp.right!=null)
                st.push(temp.right);
            if(temp.left!=null)
                st.push(temp.left);
        }
    }

    static void inOrderTraversal(Node root){
        Stack<Node> st = new Stack<>();
        Node current = root;
        while(current!=null || st.size()>0){
           
            while(current!=null){
                st.push(current);
                current=current.left;
            }
            
            current= st.pop();
            System.out.print(current.data+" ");
            current=current.right;
            
        }
    }

    // Morris Threaded Tree InOrder Traversal

    // Using two stacks
    /* static void postOrderTraversal(Node root){
        Stack<Node> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        st1.push(root);
        while(!st1.isEmpty()){
            Node temp = st1.pop();
            st2.push(temp.data);
            if(temp.left != null) st1.push(temp.left);
            if(temp.right != null) st1.push(temp.right);
        }

        while(!st2.isEmpty())
            System.out.print(st2.pop()+" ");

    }
    */

    // Using Single stack
    static void postOrderTraversal(Node root){
        
        Stack<Node> st = new Stack<>();
        ArrayList<Integer> alist = new ArrayList<>();
        
        st.push(root);
        Node prev = null;
        while(!st.isEmpty()){
            Node curr = st.peek();

            if(prev == null || prev.left == curr || prev.right == curr){
                if(curr.left != null) st.push(curr.left);
                else if (curr.right  != null) st.push(curr.right);
                else{
                    st.pop();
                    alist.add(curr.data);
                }
            }

            else if (curr.left == prev){
                if(curr.right != null) st.push(curr.right);
                else{
                    st.pop();
                    alist.add(curr.data);
                }
            }
            else if (curr.right == prev){
                st.pop();
                alist.add(curr.data);
            }

            prev = curr;
        }

        for (Integer integer : alist) {
            System.out.print(integer+" ");
        }


    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        inOrderTraversal(root);
        System.out.print("\n----------------------\n");
        preOrderTraverse(root);
        System.out.print("\n----------------------\n");
        postOrderTraversal(root);        

    }
}