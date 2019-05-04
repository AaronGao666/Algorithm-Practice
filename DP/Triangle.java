import java.util.List;

public class Triangle {


    int row=0;//行数，不是第几行
    int[] dp;


    public int minimumTotal(List<List<Integer>> triangle) {
        row=triangle.size();
        dp=new int[row];
        dp[0]=triangle.get(0).get(0);
        return helper(triangle,0,0);
    }

    public int helper(List<List<Integer>> triangle, int rowNo, int currNo){

        if(rowNo==row-1){
            return Math.min(triangle.get(rowNo).get(currNo),triangle.get(rowNo).get(currNo+1));
        }

        return Math.min(helper(triangle,rowNo+1,currNo),helper(triangle,rowNo+1,currNo+1));

    }



}
