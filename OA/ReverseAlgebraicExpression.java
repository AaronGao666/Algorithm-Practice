package GSOA;

import  java.util.*;
public class ReverseAlgebraicExpression {



    public String reverse(String s){

        HashSet<Character> set=new HashSet<>();
        set.add('/');
        set.add('*');
        set.add('+');
        set.add('-');
        Stack<Integer> stack=new Stack<>();
        int len=s.length();
        for(int i=1;i<len;i++){
            char c=s.charAt(i);
            char prev=s.charAt(i-1);
            if(set.contains(prev)&&c=='-'){
                continue;
            }

            if(set.contains(c)){
                stack.push(i);
            }
        }

        StringBuilder sb=new StringBuilder();
        int index=0,prevIndex=len;

        while(!stack.isEmpty()){
            index=stack.pop();
            sb.append(s.substring(index+1,prevIndex)+s.charAt(index));
            prevIndex=index;
        }
        sb.append(s.substring(0,index));


        return new String(sb);
    }


    public static void main(String[] args){

        String s="1*2+9-23";
        String s1="10.4*32.7/12";
        String s2="-12*2.4+-9.6--23.89";
        ReverseAlgebraicExpression obj =new ReverseAlgebraicExpression();

        System.out.println(obj.reverse(s2));


    }
}
