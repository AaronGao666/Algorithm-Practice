import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class MagicSquare {


    public int[][] magicSquare(int n) {
        if (n % 4 == 0) {
            return doubleEven(n);
        } else if (n % 2 == 0) {
            return singlyEven(n);
        } else {
            return odd(n);
        }
    }


    public int loopInt(int n, int k) {

        if (k < 0) {
            k = n - 1;
        } else if (k >= n) {
            k = 0;
        }
        return k;
    }


    public int[][] odd(int n) {
        int[][] res = new int[n][n];
        int posX = 0;
        int posY = n / 2;
        for (int i = 1; i <= n * n; i++) {

            res[posX][posY] = i;
            if (res[loopInt(n, posX - 1)][loopInt(n, posY + 1)] != 0) {
                posX = loopInt(n, posX + 1);
            } else {
                posX = loopInt(n, posX - 1);
                posY = loopInt(n, posY + 1);
            }

        }
        return res;
    }

    public int[][] singlyEven(int n) {


        int K = (n - 2) / 4;
        int quarterDiff = n * n / 4;
        int[][] res = new int[n][n];
        int[][] quarter = odd(n / 2);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i < n / 2 && j < n / 2) {
                    res[i][j] = quarter[i][j];
                } else if (i >= n / 2 && j >= n / 2) {
                    res[i][j] = quarter[i - n / 2][j - n / 2] + quarterDiff;
                } else if (i >= n / 2 && j < n / 2) {
                    res[i][j] = quarter[i - n / 2][j] + quarterDiff * 3;
                } else {
                    res[i][j] = quarter[i][j - n / 2] + quarterDiff * 2;
                }
            }

        }


        for (int i = 0; i < K; i++) {
            int temp = res[K][K + i];
            res[K][K + i] = res[K + n / 2][K + i];
            res[K + n / 2][K + i] = temp;
            for (int j = 0; j < K; j++) {
                temp = res[i][j];
                res[i][j] = res[i + n / 2][j];
                res[i + n / 2][j] = temp;
                temp = res[i + K + 1][j];
                res[i + K + 1][j] = res[i + K + 1 + n / 2][j];
                res[i + K + 1 + n / 2][j] = temp;
            }
        }

        for (int i = 0; i < K - 1; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = res[j][n - K - i - 1];
                res[j][n - K - i - 1] = res[j + n / 2][n - K - i - 1];
                res[j + n / 2][n - K - i - 1] = temp;
            }
        }

        return res;
    }


    public boolean testMagicSquare(int[][] matrix) {

        int n = matrix.length;
        int magicSum = n * (n * n + 1) / 2;
        int diagSum1 = 0;
        int diagSum2 = 0;
        for (int i = 0; i < n; i++) {
            int colSum = 0;
            int rowSum = 0;
            diagSum1 += matrix[i][i];
            diagSum2 += matrix[i][n - 1 - i];
            for (int j = 0; j < n; j++) {
                colSum += matrix[i][j];
                rowSum += matrix[j][i];
            }
            if (colSum != magicSum || rowSum != magicSum) {

                System.out.println(i);
                return false;
            }
        }
        if (diagSum1 != magicSum || diagSum2 != magicSum) {
            return false;
        }

        return true;
    }


//    public int[][] doubleEven(int n){
//
//        int[][] res=new int[n][n];
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                int minus=i-j;
//                int sum=i+j;
//                if(minus==0 || minus== n/2 || minus==-n/2 || sum==n-1|| sum ==n/2-1 || sum==3*n/2 -1){
//                    res[i][j]=n*n-i*n-j;
//                }else{
//                    res[i][j]=i*n+j+1;
//                }
//            }
//        }
//
//        return res;
//    }


    public int[][] doubleEven(int n) {

        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                boolean insideX = i >= n / 4 && i < 3 * n / 4;
                boolean insideY = j >= n / 4 && j < 3 * n / 4;
                if (insideX ^ insideY) {
                    res[i][j] = n * n - i * n - j;
                } else {
                    res[i][j] = i * n + j + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {


        int n = 4;
        MagicSquare obj = new MagicSquare();
        int[][] res = obj.magicSquare(n);
        for (int[] arr : res) {
            for (int i : arr) {
                System.out.print(i + "\t");
            }
            System.out.println("");
        }


        System.out.println(obj.testMagicSquare(res));


    }
}
