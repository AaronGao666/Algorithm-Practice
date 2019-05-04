import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        List<String> res =new ArrayList<>();
        String curr="";
        helper(0,n,res,curr, n);
        return res;
    }
    public void helper(int counter, int avaliable, List<String> res, String curr, int n){

        if(avaliable==0){
            for(int i=curr.length();i<2*n;i++){
                curr+=")";
            }
            res.add(curr);
            return;
        }


            if(counter==0){
                helper(counter+1, avaliable-1, res, curr+"(",n);
            }else{
                helper(counter+1,avaliable-1,res,curr+"(",n);
                helper(counter-1,avaliable, res, curr+")",n);
            }

    }

    public static void main(String[] args){
        GenerateParentheses obj=new GenerateParentheses();
        List<String> res=obj.generateParenthesis(3);

        System.out.println(res);

    }


}
