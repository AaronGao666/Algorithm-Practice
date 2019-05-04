

public class ArithmeticSlices {



    public int numberOfArithmeticSlices(int[] A){

        if(A.length<3) return 0;
        int nums=A.length;
        int[] dp=new int[nums];//dpi代表以i结尾的slice个数
        dp[2]=(A[2]-A[1])==(A[1]-A[0])?1:0;

        for(int i=3;i<nums;i++){
            if((A[i]-A[i-1])==(A[i-1]-A[i-2])){
                if(dp[i-1]==0){
                    dp[i]=1;
                }else{
                    dp[i]=dp[i-1]+1;
                }
            }
        }

        int res=0;
        for(int i=0;i<nums;i++ ){
            System.out.println(dp[i]);
            res+=dp[i];
        }
        return res;

    }

    public static void main(String args[]){
        int[] A={2,1,3,4,2,3};
        ArithmeticSlices obj=new ArithmeticSlices();
        System.out.println(obj.numberOfArithmeticSlices(A));

    }


}
