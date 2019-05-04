public class pivotIndex {


    public int pivotIndex(int[] nums) {

        int start = -1;
        int end = nums.length;

        if(end == 0){
            return -1;
        }


        int leftsum = 0;
        int rightsum = 0;
        while(start + 2 < end){

            if(leftsum >= rightsum){
                end --;
                rightsum += nums[end];

            }else{
                start++;
                leftsum += nums[start];
            }

        }

         System.out.println(start+","+end+","+leftsum+","+rightsum);

        if(leftsum == rightsum){
            return start+1;
        }else{
            return -1;
        }

    }

    public static void main(String[] args){
        int[] nums ={-1,-1,-1,-1,-1,0};
        System.out.println(new pivotIndex().pivotIndex(nums));

    }
}
