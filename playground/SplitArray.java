
/*
https://leetcode.com/problems/split-array-largest-sum/description/
 */


public class SplitArray {


    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] presum = new int[n];
        presum[0] = nums[0];
        for(int i = 1; i < n; i ++){
            presum[i] = presum[i-1] + nums[i];
        }

        return helper(presum, n, m - 1, 1);

    }
    private int helper(int[] presum, int n, int m, int start){



        if(m == 0){
            return presum[n - 1] - presum[start];
        }

        int max = 0;
        for(int i = start; i < n; i ++){

            int temp = presum[i] - presum[start];

        }

        return max;

    }


    public static void main(String[] args){

        int[] arr = {7,2,5,10,8};
        int m = 2;
        SplitArray obj = new SplitArray();
        System.out.println(obj.splitArray(arr, m));


    }
}
