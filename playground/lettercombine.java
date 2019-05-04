import java.util.ArrayList;
import java.util.List;

public class lettercombine {


    public List<String> letterCombinations(String digits) {
        int len=digits.length();
        char[][] map={
                {'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'}
        };
        char[] chars=digits.toCharArray();
        List<String> res =new ArrayList<>();
        helper(chars,res,0,len,map);
        return res;
    }
    public void helper(char[] chars, List<String> res, int curr, int len, char[][] map){
        if(curr==len){
            return;
        }
        List<String > newRes =new ArrayList<>();
        for(char c: map[chars[curr]-'2']){
            if(!res.isEmpty()){
                for(String s:res){
                    newRes.add(s+c);
                }
            }else{
                newRes.add(c+"");
            }
        }
        System.out.println(newRes);
        res=newRes;
        helper(chars, res, curr+1, len, map);
    }


    public static void main(String[] args){

        String digits="23";
        lettercombine obj=new lettercombine();
        obj.letterCombinations(digits);


    }
}
