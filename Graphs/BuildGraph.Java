import java.util.*;
import java.lang.*;

class BuildGraph{
    
    private int numberofnodes;
    private int[][] adjmatrix;
    BuildGraph(int numberofnodes){
        this.numberofnodes = numberofnodes;
        adjmatrix = new int[numberofnodes][numberofnodes];
    }

    void addEdge(int u,int v){
        this.adjmatrix[u][v] = 1;
        this.adjmatrix[v][u] = 1;
    }

    void printGraph(){
        for(int i = 0;i<numberofnodes;i++){
            for(int j=0;j<numberofnodes;j++){
                if(j<numberofnodes-1)
                    System.out.print(adjmatrix[i][j]+",");
                else
                    System.out.print(adjmatrix[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Edge Number of Nodes");
        int nodes = sc.nextInt();
        BuildGraph graph = new BuildGraph(nodes);
        System.out.println("=====               Enter Edge from vertix a to b                    =====");
        System.out.println("=====                   Enter in format of: 1 2                      =====");
        System.out.println("=====           THIS WILL ADD A EDGE FROM 1 TO 2 AND 2 TO 1          =====");
        System.out.println("===== Enter -1 after adding edge to quit building graph and print it =====");
        while(true){
            int a = sc.nextInt(),b = sc.nextInt();
            graph.addEdge(a,b);
            int choice = sc.nextInt();
            if(choice == -1){
                sc.close();
                break;
            }
        }
        graph.printGraph();
    }
}