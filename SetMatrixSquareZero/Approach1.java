package SetMatrixSquareZero;
/**
 * --Approach 1--
 * We will traverse through the array and
 * whenever we hit a zero we will make the that column and row as -1
 * taking care of all other zeroes in those row and column
 * on another loop we will change all -1 to 0
 * 
 * -- Time Complexity
 * -- Space Complexity
 */
public class Approach1{
    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]==0) {
                    int idx = i-1;
                    while (idx >= 0) {
                        if (matrix[idx][j] != 0) {
                            matrix[idx][j] = -1;
                        }
                    idx--;
                    }

                    idx = i+1;
                    while (idx < rows) {
                        if (matrix[idx][j] != 0) {
                            matrix[idx][j] = -1;
                        }
                    idx++;
                    }

                    idx = j-1;
                    while (idx >= 0) {
                        if (matrix[i][idx] != 0) {
                            matrix[i][idx] = -1;
                        }
                    idx--;
                    }

                    idx = j+1;
                    while (idx < cols) {
                        if (matrix[i][idx] != 0) {
                            matrix[i][idx] = -1;
                        }
                    idx++;
                    }
                }
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==-1) {
                    matrix[i][j]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        
        int matrix[][]  = {
            {1,2,3},
            {4,0,6},
            {7,8,9}
        };

        setZeroes(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.printf("%d ",matrix[i][j]);
            }
            System.out.print(' ');
        }

    }
}