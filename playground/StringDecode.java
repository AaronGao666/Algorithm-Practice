import java.util.*;
public class StringDecode {

    public String decodeString(String s) {

        int len = s.length();
//        if(len == 0){
//            return "";
//        }


        // StringBuilder res = new StringBuilder();
        Stack<Integer> stk = new Stack<>();
        Stack<String> stk2 = new Stack<>();


        String tempStr;
        int strStart = 0;
        int num = 0;
        for(int i=0;i<len;i++){

            char c = s.charAt(i);
            if(c>='0' && c<='9'){
                num = num*10 + c-'0';
            }else if(c == '['){
                stk.push(num);
                num = 0;
            }else if(c == ']'){


                int count = stk.pop();
                String str = stk2.pop();
                StringBuilder temp = new StringBuilder();

                for(int j = 0; j < count; j++){
                    temp.append(str);
                }
                if(stk2.isEmpty()){
                    stk2.push(new String(temp));
                }else{
                    stk2.push(stk2.pop()+temp);
                }

            }else{

                System.out.println(i);
                if(i > 0 && !isData(s.charAt(i-1))){
                    strStart = i;
                }
                if(i < len-1 && !isData(s.charAt(i+1))){
                    tempStr=s.substring(strStart,i+1);
                    strStart=0;
                }

            }

        }

        if(stk2.isEmpty()){
            return s;
        }
        if(strStart!=0){
            return stk2.pop()+s.substring(strStart);
        }
        return stk2.pop();
    }

    private boolean isData(char c){

        if(c >= '0' && c <='9'){
            return false;
        }else if(c == '[' || c == ']'){
            return false;
        }

        return true;
    }



    public static void main(String[] args){

        StringDecode obj =new StringDecode();
        System.out.println(obj.decodeString("3[a]2[b4[F]c]"));

    }

}
