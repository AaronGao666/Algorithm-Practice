import java.util.*;
public class StringBuilderTest {

    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb=new StringBuilder();
        char[] chars=S.toCharArray();
        int n=chars.length;
        StringBuilder curr=new StringBuilder(K);
        for(int i=n-1;i>=0;i--){
            char currChar=S.charAt(i);
            if(currChar=='-'){
                continue;
            }else if(currChar>='a'){
                currChar=(char) (currChar-32);
            }
            curr.insert(0,currChar);
            if(curr.length()==K){
                if(sb.length()!=0){
                    sb.insert(0,"-");
                }
                sb.insert(0,curr);
                curr.delete(0,K);
            }
        }
        if(curr.length()!=0){
            if(sb.length()!=0){
                sb.insert(0,"-");
            }
            sb.insert(0,curr);
        }
        return new String(sb);
    }




    public static void main(String[] args){
//        String s="--------EyRfCyHxyUJzhygiazYpjuDFdHvrnDwoQKQEsccLDiwhpmjueADIzqIvExbDDFnEGovAxYeszbzuTekRuWUPXRPbVKJuDQzIzzTj";
//        StringBuilderTest obj=new StringBuilderTest();
//        obj.licenseKeyFormatting(s,16);
////
//        String s="fdasfdasfdasfas";
//        StringBuilder sb= new StringBuilder(s);
//        sb.deleteCharAt(3);



        String[] dirs = "/..".split("/");


//        for(String s:dirs){
//            System.out.println(s);
//        }
//        List<String> res = new ArrayList<>();
//        for(String dir:dirs){
//
//            if(dir.equals("..")){
//                if(){
//                    res.remove(res.size()-1);
//                }
//
//            }else if(dir.length() > 0 && !dir.equals(".")){
//                res.add(dir);
//            }
//
//        }


//        System.out.println(res);

//        System.out.println(sb+s);

    }
}
