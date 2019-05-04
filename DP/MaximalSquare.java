//public class MaximalSquare {
//
//
//
//
//    public int maximalSquare(char[][] matrix){
//
//        int rows=matrix.length;
//        int width=matrix[0].length;
//
//        int size=rows;
//        char[][] expMatrix;
//        if(width<rows){
//            expMatrix=new char[size][size];
//            for(int i=0;i<rows;i++){
//                int j=0;
//                for(;j<width;j++){
//                    expMatrix[i][j]=matrix[i][j];
//                }
//                for(;j<size;j++){
//                    expMatrix[i][j]='0';
//                }
//            }
//        }else if(width>rows){
//            size=width;
//            expMatrix=new char[size][size];
//            for(int i=0;i<size;i++){
//                for(int j=0;j<size;j++){
//                    if(i<rows){
//                        expMatrix[i][j]=matrix[i][j];
//                    }else{
//                        expMatrix[i][j]='0';
//                    }
//                }
//            }
//        }else{
//            expMatrix=matrix;
//        }
//
//        //initialization to a square matrix by filling up 0s.
//        //其实这个初始化没有意义！！！
//
//
//
//        int[][] result=new int[size+1][size+1];//resul存放到该点的时候，框内最大的一个正方形的"边长"。
//
//
//        //应该保存以该点结束的正方形的边长。
//
//        result[0][0]=expMatrix[0][0]=='1'?1:0;
//
//        for(int i=1;i<size;i++){
//            for(int j=1;j<size;j++){
//
//            }
//        }
//
//
//
//
//
//    }
//}
