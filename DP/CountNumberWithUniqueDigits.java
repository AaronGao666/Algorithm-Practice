public class CountNumberWithUniqueDigits {




    public int countNumbersWithUniqueDigits(int n){

        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=10;
        for(int i=2;i<=n;i++){
            dp[i]=(dp[i-1]-dp[i-2])*(11-i)+dp[i-1];
        }
        return dp[n];
    }

    public static void main(String args[]){
        CountNumberWithUniqueDigits obj =new CountNumberWithUniqueDigits();
        System.out.println(obj.countNumbersWithUniqueDigits(3));
    }
}
