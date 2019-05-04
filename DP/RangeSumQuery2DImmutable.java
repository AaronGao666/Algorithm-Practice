public class RangeSumQuery2DImmutable {

    public int[][] sum;

    public RangeSumQuery2DImmutable(int[][] matrix) {

        int rows=matrix.length;
        int width=matrix[0].length;

        sum =new int[rows][width];
        sum[0][0]=matrix[0][0];

        for(int i=1;i<width;i++){
            sum[0][i]=sum[0][i-1]+matrix[0][i];
        }
        for(int i=1;i<rows;i++){
            sum[i][0]=sum[i-1][0]+matrix[i][0];
        }

        for(int i=1;i<rows;i++){
            for(int j=1;j<width;j++){
                sum[i][j]=sum[i][j-1]+sum[i-1][j]-sum[i-1][j-1]+matrix[i][j];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1--;
        col1--;
        return sum[row2][col2]-sum[row2][col1]+sum[row1][col1]-sum[row1][col2];

    }


    public static void PrintMatrix(int[][] matrix){
        System.out.println("Your Matrix:");
        for (int[] arr: matrix) {
            System.out.print("[");
            for (int i:arr) {
                System.out.print(i+",");
            }
            System.out.println("]");
        }
    }



    public static void main(String args[]){

        int[][] mat={
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };


        RangeSumQuery2DImmutable obj=new RangeSumQuery2DImmutable(mat);
        PrintMatrix(obj.sum);

        System.out.println(obj.sumRegion(1,2,2,4));
    }


}
