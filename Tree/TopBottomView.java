package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopBottomView {
    
    static class qObj{
        Node node;
        int hd;

        qObj(Node node,int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    static void topView(Node root,TreeMap<Integer,Integer> map){
        Queue<qObj> q = new LinkedList<>();
        q.add(new qObj(root,0));

        while(!q.isEmpty()){
            qObj temp = q.remove();

            if(!map.containsKey(temp.hd)){
                map.put(temp.hd, temp.node.data);
            }

            if(temp.node.left != null) q.add(new qObj(temp.node.left, temp.hd-1));
            if(temp.node.right != null) q.add(new qObj(temp.node.right, temp.hd+1));

        }
    }

    static void bottomView(Node root,TreeMap<Integer,Integer> map){
        Queue<qObj> q = new LinkedList<>();
        q.add(new qObj(root,0));

        while(!q.isEmpty()){
            qObj temp = q.remove();

            if(map.containsKey(temp.hd)){
                map.replace(temp.hd, temp.node.data);
            }
            else map.put(temp.hd, temp.node.data);

            if(temp.node.left != null) q.add(new qObj(temp.node.left, temp.hd-1));
            if(temp.node.right != null) q.add(new qObj(temp.node.right, temp.hd+1));

        }
    }

    public static void main(String[] args) {
        TreeMap<Integer,Integer> map1 = new TreeMap<>();
        TreeMap<Integer,Integer> map2 = new TreeMap<>();

        topView(new BinaryTree().getTree(), map1);
        bottomView(new BinaryTree().getTree(), map2);
        // bottomView(new BinaryTree().getTree(), map2);
        // TreeMap<Integer,Integer> tmap = new TreeMap<Integer, Integer>(map1);
        for (Map.Entry<Integer,Integer> entry : map1.entrySet()) {
            System.out.print(entry.getValue()+" ");
        }

        System.out.println("\n=====================");
        for (Map.Entry<Integer,Integer> entry : map1.entrySet()) {
            System.out.print(entry.getKey()+" ");
        }

        System.out.println("\n=====================");
        System.out.println("\n=====================");

        for (Map.Entry<Integer,Integer> entry : map2.entrySet()) {
            System.out.print(entry.getValue()+" ");
        }

        System.out.println("\n=====================");
        for (Map.Entry<Integer,Integer> entry : map2.entrySet()) {
            System.out.print(entry.getKey()+" ");
        }
        

    }
}
