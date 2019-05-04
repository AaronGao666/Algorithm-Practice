package Google1808;

public class CutConnection {



    public int[][] removeOne(int[][] matrix, int x, int y) {

        int cols=matrix[0].length;
        int rows=matrix.length;
        matrix[x][y]=0;
        for(int i=x;i<rows;i++){
            matrix[i][y]=0;
        }

        return matrix;
    }


    public static void main(String[] args){

    }
}
