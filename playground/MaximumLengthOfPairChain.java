import java.util.*;

public class MaximumLengthOfPairChain {

    public int findLongestChain(int[][] pairs) {
//        if (pairs == null || pairs.length == 0) return 0;
//        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
//
//        for(int[] a: pairs){
//            System.out.print(a[0] + "," + a[1] + "\t\t");
//        }
//        System.out.println("");
//
//
//        int[] dp = new int[pairs.length];
//        Arrays.fill(dp, 1);
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < i; j++) {
//                dp[i] = Math.max(dp[i], pairs[i][0] > pairs[j][1]? dp[j] + 1 : dp[j]);
//            }
//        }
//
//        for(int  i: dp){
//            System.out.print(i + "\t");
//        }
//        System.out.println("\n");
//        return dp[pairs.length - 1];


        int len = pairs.length;
        if (len <= 1) return len;

        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));


        int[] dp = new int[len];
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i : dp) {
            System.out.print(i + "\t");
        }
        System.out.println("\n");
        return dp[len - 1];


    }





    public static void main(String[] args) {

//        int[][] pairs = {{1,2}, {2,3}, {3,4}, {9,10}, {11,12}, {4,5}, {8,9}};


        int[][] pairs = {{-6, 9}, {1, 6}, {8, 10}, {-1, 4}, {-6, -2}, {-9, 8}, {-5, 3}, {0, 3}};
        MaximumLengthOfPairChain obj = new MaximumLengthOfPairChain();

        System.out.println(obj.findLongestChain(pairs));


    }
}
