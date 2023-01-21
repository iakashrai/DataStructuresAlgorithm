package SetMatrixSquareZero;

public class Approach2 {
    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length,columns = matrix[0].length;
        int[] trows = new int[rows],tcols = new int[columns];

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(matrix[i][j] == 0){
                    trows[i] = -1;
                    tcols[j] = -1;
                }
            }
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(trows[i]== -1 || tcols[j]== -1 ){
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        
        // int matrix[][]  = {
        //     {1,2,3},
        //     {4,0,6},
        //     {7,8,9}
        // };

        int matrix[][] = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.printf("%d ",matrix[i][j]);
            }
            System.out.print(' ');
        }

    }

}
