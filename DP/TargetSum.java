public class TargetSum {


    public int findTargetSumWays(int[] nums,int S){
        int len=nums.length;

        int range=0;  //数组无论怎么折腾不会出range的范围.
        for(int i:nums){
            if(i>=0){
                range+=i;
            }else{
                range+=-i;
            }
        }
        S=Math.abs(S);
        if(range<S){
            return 0;
        }


        int[][] dp=new int[len][2*range+1];  //range代表坐标系0，左边代表负数，右边代表正数
        dp[0][range+nums[0]]=nums[0]==0?2:1;
        dp[0][range-nums[0]]=dp[0][range+nums[0]];
        for(int i=1;i<len;i++){
            for(int j=0;j<2*range+1;j++){//j从0开始，0代表是-range。2range是range。range是0
                if(dp[i-1][j]!=0){
                    dp[i][Math.abs(j-nums[i])]+=dp[i-1][j];
                    dp[i][j+nums[i]]+=dp[i-1][j];
                }
            }


        }

        for(int[] arr:dp){
            for (int i: arr) {
                System.out.print(i+",");
            }
            System.out.println("");
        }
        System.out.println("结果为：");
        return dp[len-1][range+S];

    }

    public static void main(String args[]){
        int[] arr={0,0,0,0,0,0,0,0,1};
        int target=1;
        TargetSum obj=new TargetSum();
        System.out.println(obj.findTargetSumWays(arr,target));
    }




}
