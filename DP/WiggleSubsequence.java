public class WiggleSubsequence {




    public int wiggleMaxLenth(int[] nums){
        int len=nums.length;
        int[] dp=new int[len];
        dp[0]=1;
        short riseFlag=0;
        for(int i=1;i<len;i++){
            switch (riseFlag){

                case 1:{
                    if(nums[i]>=nums[i-1]){
                        dp[i]=dp[i-1];
                    }else {
                        dp[i]=dp[i-1]+1;
                        riseFlag=-1;
                    }
                    break;
                }
                case -1:{

                    if(nums[i]<=nums[i-1]){
                        dp[i]=dp[i-1];
                    }else {
                        dp[i]=dp[i-1]+1;
                        riseFlag=1;
                    }
                    break;
                }
                default:
                case 0:{
                    if(nums[i]==nums[i-1]){
                        dp[i]=dp[i-1];
                    }else if(nums[i]>nums[i-1]){
                        riseFlag=1;
                        dp[i]=dp[i-1]+1;
                    }else{
                        riseFlag=-1;
                        dp[i]=dp[i-1]+1;
                    }
                    break;
                }

            }
        }

        return dp[len-1];
    }


    public static void main(String args[]){
        int[] arr={1,2,3,4,5,6,7,8,9};
        WiggleSubsequence obj=new WiggleSubsequence();
        System.out.println(obj.wiggleMaxLenth(arr));
    }

}
