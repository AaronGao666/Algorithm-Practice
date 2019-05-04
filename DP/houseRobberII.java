import java.util.Arrays;

public class houseRobberII {

    int max=0;


    public int rob(int[] nums) {
        int[] nums1= Arrays.copyOfRange(nums,0,nums.length-1);
        int[] nums2= Arrays.copyOfRange(nums,1,nums.length);
        return Math.max(helper(nums1,0),helper(nums2,0));
    }


    public int helper(int[] nums, int curr){
        if(curr==nums.length-3){
            return Math.max(nums[curr]+nums[curr+2],nums[curr+1]);
        }
        if(curr==nums.length-2){
            return Math.max(nums[curr],nums[curr+1]);
        }
        if(curr<nums.length-2){
            max= Math.max((helper(nums, curr+2) + nums[curr]), helper(nums, curr + 1));
        }
        return max;
    }

    public static void main(String args[]){
        int[] nums= {1,2,3,4,5,6,7,8,9,10,0,15,29};

        houseRobberII obj =new houseRobberII();
        int result=obj.rob(nums);
        System.out.println(result);

    }


}
