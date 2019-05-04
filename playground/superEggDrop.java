public class superEggDrop {


//    public int superEggDrop(int K, int N) {
//        int[][] dp = new int[N + 1][K + 1];
//        int m = 0;
//        while (dp[m][K] < N) {
//            ++m;
//            for (int k = 1; k <= K; ++k)
//                dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1;
//        }
//        return m;
//    }

    public int superEggDrop(int K, int N) {

        int count = 0;
        while(K > 1){
            N = N/2 + N%2;
            K--;
            count ++;
        }

        return N -2 + count;

    }




    public static void main(String[] args){

        superEggDrop obj =new superEggDrop();
        System.out.println(obj.superEggDrop(2,19));



    }
}
