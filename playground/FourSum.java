import java.util.*;
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        for (int i: nums){
            System.out.print(i+"\t");
        }
        System.out.println("finish");

        List<List<Integer>> res = new ArrayList<>();

        int len = nums.length;
        for(int i = 0; i < len - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            System.out.println("第一个在"+i);
            List<List<Integer>> list = threeSum(nums, i + 1, target - nums[i]);
            if(!list.isEmpty()){
                for(List<Integer> l : list ){
                    l.add(0,nums[i]);
                }
                res.addAll(list);
            }

        }

        return res;
    }
    public List<List<Integer>> threeSum(int[] nums, int start, int target){
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len < 3){
            return res;
        }
        for(int i = start; i < len - 2; i++){
            if(i > start && nums[i] == nums [i - 1] ){
                continue;
            }
            System.out.println("第二个在"+i);
            int second = i + 1;
            int third = len - 1;
            int sum = target - nums[i];
            while(second < third){
                int currSum = nums[second] + nums[third];
                if(currSum == sum){

                    res.add(new LinkedList<>(Arrays.asList(nums[i], nums[second], nums[third])));
                    while(second < third && nums[second + 1] == nums[second]){
                        second ++;
                    }
                    while(third > second && nums[third - 1] == nums[third]){
                        third --;
                    }
                    second ++;
                    third --;
                }else if(currSum > sum){
                    third --;
                }else{
                    second ++;
                }
            }


        }
        System.out.println("3sum返回了"+res);
        return res;

    }

    public static void main(String[] args){

        FourSum obj = new FourSum();
        int[] arr = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(obj.fourSum(arr,target));


    }
}
