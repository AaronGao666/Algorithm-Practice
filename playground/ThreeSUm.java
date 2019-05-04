import java.util.*;

public class ThreeSUm {


    public static void main(String[] args){

        int[] nums ={-1,0,1,2,-1,-4};

        Arrays.sort(nums);
         for(int i : nums){
             System.out.print(i + "\t");
         }
         System.out.println("finish！");

        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for(int i = 1; i < len - 1; i++){


            int left = 0;
            int right = len - 1;
            int sum = -nums[i];
            while(left < i && right > i && left >= 0 && right < len){
                 System.out.println(i+ "," + left + "," + right);
                if(nums[left] + nums[right] == sum){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[i]);
                    list.add(nums[right]);
                    res.add(list);
                    break;
                }else if(nums[left] + nums[right] > sum){
                    right --;
                }else{
                    left ++;
                }
            }
        }


        System.out.println(res);

    }
}
