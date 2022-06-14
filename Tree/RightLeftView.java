package Tree;

import java.util.ArrayList;

public class RightLeftView {

    static void leftView(Node root,int level,ArrayList<Integer> res){
        if(root == null){
            return;
        }
     
        if(level==res.size()) res.add(root.data);

        leftView(root.left, level+1, res);
        leftView(root.right, level+1, res);

    }

    static void rigthView(Node root,int level,ArrayList<Integer> res){
        if(root == null) return;
        if(level == res.size()) res.add(root.data);

        rigthView(root.right, level+1, res);
        rigthView(root.right, level+1, res);
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> res1 = new ArrayList<>();
        ArrayList<Integer> res2 = new ArrayList<>();
        leftView(new BinaryTree().getTree(),0,res1);
        rigthView(new BinaryTree().getTree(),0,res2);

        System.out.println("=====================");
        for (Integer integer : res1) {
            System.out.print(integer+" ");
        }

        System.out.println("\n");
        System.out.println("=====================");

        for (Integer integer : res2) {
            System.out.print(integer+" ");
        }
        
    }

}
