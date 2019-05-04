import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subSet {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums,0);

        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int curr){

        res.add(new ArrayList<>(list));

        for(int i=curr;i<nums.length;i++){
            list.add(nums[i]);
            helper(res,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }


    public static void main(String[] args){
        int[] nums={1,2,3};
        subSet obj=new subSet();
        System.out.println(obj.subsets(nums));
    }
}
