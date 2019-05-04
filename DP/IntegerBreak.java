public class IntegerBreak {

    int[] dp;
    public int integerBreak(int n){
        dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        dp[3]=2;

        for(int i=4;i<=n;i++){
            int max=0;
            for(int j=2;j<=i-2;j++){
                int temp=Math.max(dp[i-j]*j,i);
                max=temp>max?temp:max;
            }
            dp[i]=max;
            System.out.println("dp"+i+":="+dp[i]);
        }
        return dp[n];
    }

    public static void main(String args[]){
        IntegerBreak obj=new IntegerBreak();

        System.out.println(obj.integerBreak(15));
        for (int i:obj.dp) {
            System.out.print(i+",");
        }
    }
}
