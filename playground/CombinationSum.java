import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        int len=candidates.length;
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        helper(res,temp,candidates,target, 0, len);
        return res;

    }

    private void helper(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int pos, int len){

        System.out.println("当前遍历到："+pos+"，target="+target);
        if(target==0){
            res.add(new ArrayList<>(temp));
            System.out.println("添加了一个结果，在pos="+pos);
            return;
        }

        if(candidates[pos]>target){
            System.out.println("无效，返回，pos="+pos);
            return;
        }


        for(int i=pos;i<len;i++){
            temp.add(candidates[i]);
            helper(res,temp,candidates,target-candidates[i],i,len);
            temp.remove(temp.size()-1);
        }

    }


    public static void main(String[] args){


        int[] can={2,3,6,7};
        CombinationSum obj=new CombinationSum();
        System.out.println(obj.combinationSum(can,7));

    }

}
