package Tree;

public class ValidateBST {
    
    static boolean validateBST(Node root,long min,long max){
        if(root == null) return true;

        if(root.data <= min || root.data >=max) return false;

        return validateBST(root.left, root.data, max) && validateBST(root.left, min, root.data); 
    }

    public static void main(String[] args) {
        System.out.println(validateBST(new BinaryTree().getTree(),Long.MIN_VALUE,Long.MAX_VALUE));
    }
}
