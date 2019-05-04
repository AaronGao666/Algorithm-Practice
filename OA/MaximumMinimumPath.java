package AmazonOA;

public class MaximumMinimumPath {

    public int maxMinPath(int[][] matrix){

        for(int i = matrix.length - 1; i >=0 ; i --){
            for(int j = matrix[0].length - 1; j >=0; j --){

                if(i < matrix.length - 1 && j < matrix[0].length - 1){
                    matrix[i][j] = Math.min(matrix[i][j], Math.max(matrix[i + 1][j], matrix[i][j + 1]));
                }else if(i < matrix.length - 1){
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i + 1][j]);
                }else if(j < matrix[0].length - 1){
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][j + 1]);
                }
            }
        }


        return matrix[0][0];

    }



    public static void main(String[] args){
        int[][] matrix = {
                {8,4,7},
                {6,5,9}
        };

        System.out.println(new MaximumMinimumPath().maxMinPath(matrix));

    }
}
