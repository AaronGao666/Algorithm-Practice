public class FourKeyboard {


    public int maxNum(int steps){
        if(steps<=6){
            return steps;
        }
        int[] dp=new int[steps+1];
        for(int i=1;i<7;i++){
            dp[i]=i;
        }
        for(int i=7;i<=steps;i++){
            dp[i]=Math.max(Math.max(2*dp[i-3],3*dp[i-4]),4*dp[i-5]);
        }

        return dp[steps];

    }

    public static void main(String args[]){
        FourKeyboard obj=new FourKeyboard();
        System.out.println(obj.maxNum(9));
    }
}
