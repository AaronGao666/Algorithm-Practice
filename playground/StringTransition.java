import java.util.HashMap;
import java.util.HashSet;

public class StringTransition {


    public boolean canTransfer(String startString, String endString) {
        int len=startString.length();
        int len1=endString.length();
        if(len!=len1){
            return false;
        }

        HashMap<Character, Character> map =new HashMap<>();
        for(int i=0;i<len;i++){
            char s=startString.charAt(i);
            char e=endString.charAt(i);
            if(s==e){
                if(!map.containsKey(s)){
                    map.put(s,s);
                }
                continue;
            }
            if(!map.containsKey(s)){
                map.put(s,'0');
            }

            if(!map.containsKey(e) || map.get(e)=='0' || map.get(e)==s){
                map.put(e,s);
            }else {
                return false;
            }
        }

//        for(char c:map.keySet()){
//            System.out.println(c+"，"+map.get(c));
//        }


        //test if the loop exists, or some have same prev
        for(char c:map.keySet()){


            char fast=map.get(c);
            char slow=c;
            while(slow!='0' && fast !='0'){
                if(fast==slow){
                    System.out.println("loop return");
                    return false;
                }

                if(map.get(fast)=='0'){
                    break;
                }

                fast=map.get(map.get(fast));
                slow=map.get(slow);
            }
        }
        return true;

    }

    public static void main(String[] args){

        String s="abcdefg";
        String e="bcdefga";
        StringTransition obj=new StringTransition();
        System.out.println(obj.canTransfer(s,e));


    }
}
