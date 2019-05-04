import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        int count = row * col;


        boolean[][] visited = new boolean[row][col];

        for(int c = 0; count > 0; c --){


            for(int[] arr: matrix){
                for(int i : arr){
                    System.out.print(i + "\t");
                }
                System.out.println("");
            }

            System.out.println("Count 有" +count );
            for(int i = 0; i < row; i ++){
                for(int j = 0; j < col; j ++){
                    if(!visited[i][j] && matrix[i][j] == c){
                        visited[i][j] = true;
                        count --;
                        if(i > 0 && matrix[i - 1][j] == 1){
                            matrix[i - 1][j] = c - 1;
                        }
                        if(j > 0 && matrix[i][j - 1] == 1){
                            matrix[i][j - 1] = c - 1;
                        }
                        if(i < row - 1 && matrix[i + 1][j] == 1){
                            matrix[i + 1][j] = c - 1;
                        }
                        if(j < col - 1 && matrix[i][j + 1] == 1){
                            matrix[i][j + 1] = c - 1;
                        }
                    }
                }
            }


            for(int[] arr: matrix){
                for(int i : arr){
                    System.out.print(i + "\t");
                }
                System.out.println("");
            }

            System.out.println("");
            System.out.println("Count 还有： "+count);

        }





        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                matrix[i][j] = - matrix[i][j];
            }
        }

        return matrix;
    }


    public static void main(String[] args){



//        int[][] matrix = {{0,0,0} , {0,1,0}, {0,0,0}};
        int[][] matrix = {{1, 0, 1, 1, 0, 0, 1, 0, 0, 1}, {0, 1, 1, 0, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 1, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 1, 0}, {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};

        ZeroOneMatrix obj = new ZeroOneMatrix();
        obj.updateMatrix(matrix);





    }
}
