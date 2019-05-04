package googleKickStart;

import java.util.*;
public class LuckyDip {


    public double LuckyDip(int N, int K, int[] arr){

        TreeMap<Integer, Integer> map = new TreeMap<>();
        double avg = 0;
        for(int i : arr){
            if(map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }else{
                map.put(i, 1);
            }
            avg += i;
        }
//@todo overflow?
        avg /= N;


        int max = map.lastKey();

        double[] num = new double[map.keySet().size()];
        int[] count = new int[map.keySet().size()];
        int index = 0;
        for(int i : map.keySet()){
            num[index] = i;
            if(index == 0) count[index] = map.get(i);
            else count[index] += count[index - 1] + map.get(i);
            index ++;
        }

//
//        for(double d : num){
//            System.out.print(d + "\t");
//        }
//        System.out.println("");
//        for(int c : count){
//            System.out.print(c + "\t");
//        }
//        System.out.println("");

        double[] dp = new double[K + 1];

        dp[0] = avg;


        for(int i = 1; i <= K; i ++){
            index = Arrays.binarySearch(num, dp[i - 1]);
            if(index < 0) index = -index - 1;

            for(int j = N - 1; j >= index; j --){
                dp[i] += ((double)(count[j] - count[j - 1])) / N * num[j];
            }


            if(index > 0) dp[i] += (double)count[index - 1] / N * dp[i - 1];
        }


        for(double d : dp){
            System.out.print(d + "\t");
        }

        return dp[K];

    }



    public static void main(String[] args){

        int[] arr = {16,11,7,4,1};
        int N = 5;
        int K = 3;
        System.out.println(new LuckyDip().LuckyDip(N, K, arr));

    }


}
