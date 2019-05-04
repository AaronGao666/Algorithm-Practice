
import java.util.Arrays;

public class PredictTheWinner {


    public boolean PredictTheWinner(int[] nums){


        int lenth=nums.length;

        boolean isOdd=false;
        if(lenth%2!=0){
            isOdd=true;
        }


        int[][] dp=new int[lenth][lenth];//代表i到j的这么一段数据，下一个要挑选的人的最大可能值。
        int[] sum=new int[lenth+1];//代表数到第几个数字的总和

        for(int i=0;i<lenth;i++){
            dp[i][i]=nums[i];
            sum[i+1]=sum[i]+nums[i];
        }


        for(int i=0;i<lenth-1;i++){
            if((nums[i]>=nums[i+1])^isOdd){
                dp[i][i+1]=nums[i];
                dp[i+1][i]=nums[i+1];
            }else{
                dp[i][i+1]=nums[i+1];
                dp[i+1][i]=nums[i];
            }
        }
        for(int i=2;i<lenth;i++){//i代表两条的偏移量。

            if((i%2!=0)^isOdd){//当前步骤A（左上）为先手，否则为后手。
                for(int j=0;j+i<lenth;j++){
                    dp[j][j+i]=Math.max(dp[j][j+i-1]+nums[j+i],dp[j+1][j+i]+nums[j]);
                    dp[j+i][j]=sum[j+i+1]-sum[j]-dp[j][j+i];
                }
            }else{
                for(int j=0;j+i<lenth;j++){
                    dp[j+i][j]=Math.max(dp[j+i-1][j]+nums[j+i],dp[j+i][j+1]+nums[j]);
                    dp[j][j+i]=sum[j+i+1]-sum[j]-dp[j+i][j];
                }
            }

        }

        for(int[] arr:dp){
            for(int i:arr){
                System.out.print(i+"\t\t");
            }
            System.out.println("");
        }
        System.out.println("finished");
        int resultA=dp[0][lenth-1];
        int resultB=sum[lenth]-resultA;
        return resultA>=resultB?true:false;

    }

    public static void main(String args[]){
        int[] arr={1,3,1};
        PredictTheWinner obj=new PredictTheWinner();
        System.out.println(obj.PredictTheWinner(arr));

    }

}
