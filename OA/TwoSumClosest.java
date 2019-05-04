package AmazonOA;

import java.util.*;

public class TwoSumClosest {

    public static void findOptimalWeights(double capacity, double[] weights, int numOfContainers) {
        double min = 0.0;
        int minPos = 0;
        int maxPos = weights.length - 1;
        int i = 0, j = weights.length - 1;

        Arrays.sort(weights);

        while (i < j) {
            double sum = weights[i] + weights[j];

            if (sum > min && sum <= capacity) {
                min = sum;
                minPos = i;
                maxPos = j;
            }

            if (sum > capacity) {
                j--;
            } else {
                i++;
            }
        }

        System.out.println("The two numbers for which sum is closest to target are "
                + weights[minPos] + " and " + weights[maxPos]);
    }


    public static void flight(int traveldis, List<int[]> forward, List<int[]> backward) {


        int optimal = 0;
        List<int[]> result = new ArrayList<>();
        Collections.sort(forward, (a, b) -> (a[1] - b[1]));
        Collections.sort(backward, (a, b) -> (a[1] - b[1]));

        for (int[] r : forward) {
            if (traveldis >= r[1]){
                int index = Collections.binarySearch(backward, new int[]{0, traveldis - r[1]}, (a, b) -> (a[1] - b[1]));
                if(index < 0) index = -index - 2;
                if(index >= 0){
                    int dis = r[1] + backward.get(index)[1];
                    if(dis <= traveldis && optimal < dis){

                        optimal = dis;
                        result.clear();
                        result.add(new int[]{r[0], backward.get(index)[0]});
                    }else if(dis <= traveldis && optimal == dis){
                        result.add(new int[]{r[0], backward.get(index)[0]});
                    }
                }
            }

        }
        System.out.println("结果是");
        for(int[] a : result){
            System.out.print("("+a[0] + "," + a[1]+") \t");
        }

    }


    public static void main(String[] args) {

//        double cap = 43.3;
//        double[] weight = {7.33, 8.13, 103.7313, 11.24, 23.79, 18.350, 0.0, 43.0, 0.1, 43.1};
//        findOptimalWeights(cap, weight, weight.length);


        int travelDis = 10000;
        List<int[]> forward = new ArrayList<>();
        List<int[]> backward = new ArrayList<>();
        forward.add(new int[]{4, 10000});
        forward.add(new int[]{1, 3000});
        forward.add(new int[]{2, 5000});
        forward.add(new int[]{3, 7000});

        backward.add(new int[]{4,5000});
        backward.add(new int[]{1,2000});
        backward.add(new int[]{2,3000});
        backward.add(new int[]{3,4000});
        flight(travelDis,forward,backward);


    }


}
