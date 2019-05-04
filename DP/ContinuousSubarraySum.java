public class ContinuousSubarraySum {


    public boolean checkSubarraySum(int[] nums, int k) {
        int len=nums.length;
        if(len<2){
            return false;
        }

        if(k==0){
            for (int i=0;i<len;i++) {
                if(nums[i]==0) {
                    if(i==len-1) {
                        return false;
                    }else if(nums[i]==nums[i+1]){
                        return true;
                    }
                }
            }
            return false;
        }

        if(k<0) k=-k;

        int[] sum=new int[len+1];
        for(int i=1;i<=len;i++){
            sum[i]=sum[i-1]+nums[i-1];
        }
        for(int i=0;i<len;i++){
            for(int j=i+2;j<=len;j++){
                if((sum[j]-sum[i])%k==0){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]){
        int[] arr={5,2,4};
        int k=5;
        ContinuousSubarraySum obj=new ContinuousSubarraySum();
        System.out.println(obj.checkSubarraySum(arr,k));

    }

}
