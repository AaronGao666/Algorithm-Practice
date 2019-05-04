/**
 * 思路：先求出数组和，然后用dp找出一半
 */


public class PartitionEqualSubsetSum {




    public boolean canPartition(int[] nums){
        int len=nums.length;
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2!=0) return false;
        sum=sum/2;
        boolean[][] dp=new boolean[len][sum+1];
        dp[0][0]=true;
        for(int i=1;i<=sum;i++){//前0个数字可以组成i
            dp[0][i]=false;
        }
        for(int i=1;i<len;i++){//前i个数字可以组成0
            dp[i][0]=true;
        }

        for(int i=1;i<len;i++){
            for(int j=1;j<=sum;j++){
                if(j>=nums[i]){
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[len-1][sum];

    }

    public static void main(String args[]){
        int[] arr={1, 5, 11, 5};
        PartitionEqualSubsetSum obj=new PartitionEqualSubsetSum();
        System.out.println(obj.canPartition(arr));
    }
}
