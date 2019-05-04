public class MatrixTest {

    int[][] sums;
    int[][] matrix;

    int cols;
    int rows;

    public MatrixTest(int[][] matrix) {
        this.rows=matrix.length;
        this.cols=matrix[0].length;
        this.matrix=matrix;

        this.sums=new int[rows][cols];
        this.sums[0][0]=matrix[0][0];
        for(int i=1;i<this.cols;i++){
            this.sums[0][i]=this.sums[0][i-1]+matrix[0][i];
        }
        for(int i=1;i<this.rows;i++){
            this.sums[i][0]=this.sums[i-1][0]+matrix[i][0];
        }

        for(int i=1;i<this.rows;i++){
            for(int j=1;j<this.cols;j++){
                this.sums[i][j]=this.sums[i-1][j]+this.sums[i][j-1]-this.sums[i-1][j-1]+matrix[i][j];
            }
        }


    }

    public void update(int row, int col, int val) {

        int diff=val-this.matrix[row][col];
        this.matrix[row][col]=val;
        for(int i=row;i<this.rows;i++){
            for(int j=col;j<this.cols;j++){
                this.sums[i][j]+=diff;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {


        if(row1==0&&row2==0){
            return this.sums[row2][col2];
        }
        if(row1==0){
            return this.sums[row2][col2]-this.sums[row2][col1-1];
        }
        if(col1==0){
            return this.sums[row2][col2]-this.sums[row1-1][col2];
        }

        return this.sums[row2][col2]-this.sums[row1-1][col2]-this.sums[row2][col1-1]+this.sums[row1-1][col1-1];

    }



    public static void main(String[] args){
        int[][] matrix={
                {2,4},
                {-3,5}

        };

        MatrixTest obj =new MatrixTest(matrix);
        for(int[] arr:obj.sums){
            for(int i:arr){
                System.out.print(i+"\t");
            }
            System.out.println("");
        }
        System.out.println("");

        obj.update(0,1,3);

        for(int[] arr:obj.sums){
            for(int i:arr){
                System.out.print(i+"\t");
            }
            System.out.println("");
        }
        System.out.println("");
        obj.update(1,1,-3);


        for(int[] arr:obj.sums){
            for(int i:arr){
                System.out.print(i+"\t");
            }
            System.out.println("");
        }
        System.out.println("");
        obj.update(0,1,1);
        for(int[] arr:obj.sums){
            for(int i:arr){
                System.out.print(i+"\t");
            }
            System.out.println("");
        }
    }

}
