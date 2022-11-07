package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class RecursiveLevelTraversal {
    
    static void recursiveFunction(Queue<Node> queue){
        
        if(queue.isEmpty()) return;
        int size = queue.size();
        while(size>0){
            Node temp = queue.remove();
            System.out.print(temp.data+" ");
            if(temp.left != null) queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);
            size--;
        }
        recursiveFunction(queue);

    }

    static void recursiveFunction2(Node root,int level){
        
    }

    public static void main(String[] args) {
        Node root = new BinaryTree().getTree();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        recursiveFunction(queue);
    }
}
