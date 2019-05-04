import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {


    public boolean wordBreak(String s, List<String> wordDict){


//        List<List<String>> hashDict=new ArrayList<>();
//
//        for(int i=0;i<26;i++){
//            hashDict.add(new ArrayList<>());
//        }
//
//        for (String str: wordDict ) {
//            hashDict.get(str.charAt(0)-'a').add(str);
//        }
//
//        int len=s.length();
//        boolean[] dp=new boolean[len];
//
//        for(int i=1;i){
//
//        }



        //采用dp：
        int slen=s.length();
        boolean[] dp=new boolean[slen+1];
        dp[0]=true;//令s最前一个为true。虚构一个元素。
        for(int i=1;i<=slen;i++){
             for(int j=0;j<i;j++){
                 if(dp[j]){
                     if(wordDict.contains(s.substring(j,i))){
                         dp[i]=true;
                     }
                 }
             }
        }

        for (boolean b:dp) {
            System.out.println(b);
        }
        System.out.println("结果为：");
        return dp[slen];

    }

    public static void main(String args[]){
        String s="leetcode";
        List<String> dict= Arrays.asList("leet","code");

        WordBreak obj=new WordBreak();

        System.out.println(obj.wordBreak(s,dict));
    }
}
