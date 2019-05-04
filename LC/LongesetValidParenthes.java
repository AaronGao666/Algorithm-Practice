package algorithm;
import java.util.regex.*;

public class LongesetValidParenthes {


    public int longestvalidparenthes(String s){
//        boolean shouldcontinue=true;
        int count=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('&&s.charAt(i+1)==')'){
//                shouldcontinue=true;
                count+=2;
                i++;
                max=max>count?max:count;
//                System.out.println("max="+max);
            }
            else {
//                shouldcontinue=false;
                count=0;
            }

        }
        return max;
    }


    public static void main( String args[] ){
        String s=")))()()())))(((()))()()()))()()()))()()()()()()()())))(()()";
        System.out.println(s.length());
        LongesetValidParenthes test=new LongesetValidParenthes();
        System.out.println(test.longestvalidparenthes(s));
    }

}
