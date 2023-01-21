package SetMatrixSquareZero;

public class Approach3 {
    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length,columns = matrix[0].length;
        int col0 = 1;
        
        for(int i=0;i<rows;i++){
            if(matrix[i][0] == 0) col0 = 0;
            for(int j=1;j<columns;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0]=matrix[0][j]=0;
                }
            }
        }

        for(int i=rows-1;i>=0;i--){
            for(int j=columns-1;j>=0;j--){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j] = 0;
                }
            }
            if(col0 == 0) matrix[i][0]=0;
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
