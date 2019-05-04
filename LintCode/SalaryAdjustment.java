package Google1808;

import java.util.Arrays;

public class SalaryAdjustment {

    public int getCap(int[] a, int target) {
        int len=a.length;
        Arrays.sort(a);
        if(target/len<a[0]){
            return -1;
        }

        for(int i=len;i>0;i--){
            if(target/i>=a[i-1]){
                if(target%i==0){
                    return target/i;
                }else{
                    return -1;
                }
            }else{
                target-=a[i-1];
            }
        }
        return -1;
    }





    public static void main(String[] args){
    }
}
