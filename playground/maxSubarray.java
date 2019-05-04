public class maxSubarray {

    public int maxSubArray(int[] nums) {
        int len=nums.length;
        if(len==0){
            return 0;
        }
        if(len==1){
            return nums[0];
        }

        int[] res=new int[len];
        res[0]=nums[0];
        int max=res[0],min=res[0];
        for(int i=1;i<len;i++){
            res[i]=res[i-1]+nums[i];

        }

        System.out.println(max);
        System.out.println(min);
        return max-min;

    }
    public static void main(String[] args){

        int[] arr={-2,-1};
        maxSubarray obj=new maxSubarray();

        obj.maxSubArray(arr);

    }

}
