package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

/**
 * ZigZagTravesral
 */
public class ZigZagTravesral {

    static void zigzag(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        Stack<Node> stack = new Stack<>();
        boolean flag = true;
        while (!q.isEmpty()) {
            if(q.peek() == null){
                q.remove();
                if(flag==true) flag=false;
                else flag = true;
                q.add(null);
            }
            else{
                if(flag == true){
                    while(q.peek()!=null){
                        Node temp = q.remove();
                        System.out.print(temp.data+" ");
                        if(temp.left != null) q.add(temp.left);
                        if(temp.right != null) q.add(temp.right);
                    }
                }
                else{
                    while(q.peek()!=null){
                        Node temp = q.remove();
                        stack.push(temp);
                        if(temp.left != null) q.add(temp.left);
                        if(temp.right != null) q.add(temp.right);
                    }

                    while(!stack.isEmpty()){
                        System.out.print(stack.pop().data);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Node root = new BinaryTree().getTree();
        zigzag(root);
    }
    
}