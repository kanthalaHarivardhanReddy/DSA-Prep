class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstCol = false;
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; i++) {
            if( matrix[i][0] == 0) 
                firstCol = true;
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        //first row
        if(matrix[0][0] == 0)
            Arrays.fill(matrix[0], 0);
        
        //first col
        if(firstCol){
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        
    }
}