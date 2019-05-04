import com.apple.eawt.AppEvent;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

abstract class node{
    private void getNode(){

    }
}


public class DecodeString {


    public String decodeString(String s) {
//        StringBuilder sb = new StringBuilder();

//        Stack<String> stk = new Stack<>();
//        Stack<Integer> countStk = new Stack<>();
//        int count = 0;
//        StringBuilder temp = new StringBuilder();
//        for(char c : s.toCharArray()){
//            if(c >= '0' && c <= '9'){
//                if(temp.length() != 0){
//                    stk.push(new String(temp));
//                    temp.delete(0, temp.length());
//                }
//                count = count * 10 + c - '0';
//            }else if(c =='['){
//                countStk.push(count);
//                count = 0;
//            }else if(c ==']'){
//                int num = countStk.pop();
//                StringBuilder t = new StringBuilder(temp);
//                for(int i = 0; i < num - 1; i ++){
//                    temp.append(new String(t));
//                }
//
//                if(stk.isEmpty() && countStk.isEmpty()){
//                    sb.append(new String(temp));
//                    temp.delete(0, temp.length());
//                }else if(!stk.isEmpty() && stk.size() == countStk.size() ){
//                    temp.insert(0, stk.pop());
//                }
//
//            }else{
//                temp.append(c);
//            }
//
//             System.out.println("当前是："+c);
//            System.out.println(sb);
//             System.out.println(count);
//             System.out.println(stk);
//             System.out.println(countStk);
//             System.out.println(temp);
//
//        }
//
//        sb.append(temp);


        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        Stack<String> stk = new Stack<>();
        int count = 0;
        for(char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {

                if(temp.length() != 0) stk.push(new String(temp));
                temp.delete(0,temp.length());
                count = count * 10 + c - '0';

            } else if (c == '[') {
               stk.push(count+"");
               count = 0;

            } else if (c == ']') {

                String info = stk.pop();
                if(Character.isDigit(info.charAt(0))){
                    String t = temp.toString();
                    int rep = Integer.parseInt(info);
                    for(int i = 1 ; i < rep; i ++){
                        temp.append(t);
                    }
                    if(!stk.isEmpty() && !Character.isDigit(stk.peek().charAt(0))){
                        temp.insert(0,stk.pop());
                    }
                    if(temp.length() != 0) stk.push(new String(temp));
                    temp.delete(0,temp.length());
                } else {
                    temp.insert(0,info);

                    if(!stk.isEmpty() && Character.isDigit(stk.peek().charAt(0))){
                        String t = temp.toString();
                        int rep = Integer.parseInt(stk.pop());
                        for(int i = 1 ;i < rep; i ++){
                            temp.append(t);
                        }

                    }



                    if(temp.length() != 0) stk.push(new String(temp));
                    temp.delete(0, temp.length());
                }



            } else {
                temp.append(c);
            }
             System.out.println("当前是："+c);
             System.out.println(count);
             System.out.println(stk);
//             System.out.println(countStk);
             System.out.println(temp);

        }

        System.out.println(stk);


//        sb.append(stk.pop());
//        if(!stk.isEmpty()){
//            sb.insert(0, stk.pop());
//        }
//        sb.append(temp);

        System.out.println(sb);
        return sb.toString();
    }


    public static void main(String[] args){

        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        String res = new DecodeString().decodeString(s);
        System.out.println(res.equals("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"));
    }

}
