import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplit {

    public int calculate(String s) {
        s=s.replace(" ","");
        int count=0;//count how many (
        boolean has=false;//if the s contains ()
        int len=s.length();
        List<Integer> modules=new ArrayList<>();
        List<Boolean> shouldAdd=new ArrayList<>();

        int start=0,end=0;

        while(end<len){
            char cs=s.charAt(start);
            char ce=s.charAt(end);
            if(count==0){
                if(cs=='-'||cs=='+'){
                    start++;
                    continue;
                }
                if(Character.isDigit(ce)){
                    if(end==len-1){
                        modules.add(Integer.parseInt(s.substring(start,len)));
                    }
                    end++;
                    continue;
                }else if(ce=='-'){
                    modules.add(Integer.parseInt(s.substring(start,end)));
                    start=end;
                    end++;
                    shouldAdd.add(false);
                }else if(ce=='+'){
                    modules.add(Integer.parseInt(s.substring(start,end)));
                    start=end;
                    end++;
                    shouldAdd.add(true);
                }
            }

            if(ce=='('){
                has=true;
                count++;
            }
            if(ce==')'){
                count--;
            }
            if(has&&count==0){
                modules.add(calculate(s.substring(start+1,end)));
                if(end!=len-1){
                    shouldAdd.add(s.charAt(end+1)=='+');
                }
                start=end;
                end++;
            }

        }
        int res=modules.get(0);
        for(int i=0;i<shouldAdd.size();i++){
            res+=shouldAdd.get(i)?modules.get(i+1):-modules.get(i+1);
        }
        return res;
    }


    public static void main(String[] args){
        String s="(1 +(4+ 5 +  2)-3 )+(6  +8 )   ";
        StringSplit obj=new StringSplit();
        System.out.println(obj.calculate(s));


    }
}
