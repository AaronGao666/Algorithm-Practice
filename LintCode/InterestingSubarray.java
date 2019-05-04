package Google1808;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class InterestingSubarray {




    public int maxLen(int[] a) {

        int len=a.length;
        int[][] dp=new int[len][len];//dpij 代表i到j 的满足subarray
        for(int i=0;i<len;i++){
            dp[i][i]=1;
        }
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(dp[i][j-1]==1){
                    if(dp[i][j]==dp[i][j-1]){
                        dp[i][j]=1;
                    }else{
                        dp[i][j]=2;
                    }
                }else if(dp[i][j-1]==2){
                    for (int k=i;k<j;k++) {//from i --> j-1. @todo this can be optimized
                        if(a[k]==a[j]){
                            dp[i][j]=2;
                        }
                    }
                }else if(dp[i][j-1]==0){
                    break;
                }
            }
        }


        for (int[] arr:dp) {
            for(int i:arr){
                System.out.print(i+"\t");
            }
            System.out.println("");
        }


        int max=1;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){

                if(dp[i][j]==0){
                    max=max>=(j-i)?max:j-i;
                    break;
                }else if(j==len-1){
                    max=max>=(j-i+1)?max:j-i+1;
                }
            }
            System.out.println("current row:"+max);
        }
        return max;
    }


    public int maxLenNew(int[] a) {

        int len=a.length;
        int max=1;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int num1=a[i];
                int num2=a[i];
                for(int k=i;k<=j;k++){
                    if(num1==num2){
                        if(a[k]==num1){
                            max=max>k-i+1?max:k-i+1;
                        }else{
                            max=max>k-i+1?max:k-i+1;
                            num2=a[k];
                        }
                    }else{
                        if(a[k]==num1||a[k]==num2){
                            max=max>k-i+1?max:k-i+1;
                        }else{
                            j=len;
                            break;
                        }
                    }
                }
            }
        }
        return max;


    }


    public static void main(String[] args){
        int[] a={3,2,3,1,5,2,5,1};
        InterestingSubarray obj=new InterestingSubarray();
        System.out.println(obj.maxLenNew(a));
    }



}
