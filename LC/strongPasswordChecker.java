package algorithm;
import java.util.*;
import java.util.regex.*;
enum casetype{
    UPCASE, LOWCASE, DIGIT
}

public class strongPasswordChecker {

    static int conti3index=-1;

    static int moves=0;//更改步数计数器
    static int upcount=0;
    static int lowcount=0;
    static int digcount=0;
    static boolean finishflag=false;
    static String suggestedPwd;

    public casetype getType(char c){
        casetype ct;
        if(c<='Z'&&c>='A'){
            ct=casetype.UPCASE;
        }
        else if(c<='z'&&c>='a'){
            ct=casetype.LOWCASE;
        }
        else if(c<='9'&&c>='0'){
            ct=casetype.DIGIT;
        }
        else ct=null;
        return ct;
    }
    public casetype whichmost(){
        casetype ct;
        if (upcount>=lowcount&&upcount>=digcount)
            ct=casetype.UPCASE;
        else if(lowcount>=upcount&&lowcount>=digcount)
            ct=casetype.LOWCASE;
        else if(digcount>=upcount&&digcount>=lowcount)
            ct=casetype.DIGIT;
        else ct=null;
        return ct;
    }
    public casetype whichleast(){
        casetype ct;
        if (upcount<=lowcount&&upcount<=digcount)
            ct=casetype.UPCASE;
        else if(lowcount<=upcount&&lowcount<=digcount)
            ct=casetype.LOWCASE;
        else if(digcount<=upcount&&digcount<=lowcount)
            ct=casetype.DIGIT;
        else ct=null;
        return ct;
    }


    public int pwdChecker(String s){

        char[] c=s.toCharArray();
        lowcount=0;
        upcount=0;
        digcount=0;
        for(int i=0;i<s.length();i++){

            switch (getType(c[i])){
                case LOWCASE:lowcount++;break;
                case UPCASE:upcount++;break;
                case DIGIT:digcount++;break;
                default: break;
            }
        }

        Pattern conti3=Pattern.compile("(\\w)\\1{2,}");
        Matcher contiMatch=conti3.matcher(s);
        if(contiMatch.find()){
            String substring=contiMatch.group(0);
            conti3index=s.indexOf(substring);
        }
        else {conti3index=-1;}


        StringBuffer sb=new StringBuffer(s);


        if(s.length()>20){//如果过长，则需要减少字符
            if(conti3index!=-1){//过长且有3连字符
                sb=sb.deleteCharAt(conti3index+2);

                casetype contitype=getType(c[conti3index]);
                switch (contitype){
                    case DIGIT: digcount--;break;
                    case UPCASE:upcount--;break;
                    case LOWCASE:lowcount--;break;
                    default: break;
                }
                moves++;
            }
            else {
                switch (whichmost()){
                    case UPCASE:{
                        for(int i=0;i<s.length();i++){
                            if (getType(c[i])==casetype.UPCASE){
                                sb=sb.deleteCharAt(i);
                                moves++;
                                upcount--;
                            }
                            else continue;
                        }
                    };break;
                    case LOWCASE:{
                        for(int i=0;i<s.length();i++){
                            if (getType(c[i])==casetype.LOWCASE){
                                sb=sb.deleteCharAt(i);
                                moves++;
                                lowcount--;

                            }
                            else continue;
                        }
                    };break;
                    case DIGIT:{
                        for(int i=0;i<s.length();i++){
                            if (getType(c[i])==casetype.DIGIT){
                                sb=sb.deleteCharAt(i);
                                moves++;
                                digcount--;

                            }
                            else continue;
                        }
                    };break;
                }
            }

        }

        else if(s.length()<6){//太短
            if(conti3index!=-1){//过短且有3连字符

                switch(getType(c[conti3index])){
                    case DIGIT:{
                        sb=sb.insert(conti3index+1,'s');//固定插入一个s
                        lowcount++;
                    };break;
                    case LOWCASE:{
                        sb=sb.insert(conti3index+1,'K');
                        upcount++;
                    };break;
                    case UPCASE:{
                        sb=sb.insert(conti3index+1,'5');
                        digcount++;
                    };break;
                }
                moves++;

            }
            else {
                switch (whichleast()){
                    case UPCASE:{
                        if(s.substring(s.length()-1).equals("K")) {sb.append('L');}
                        else {sb.append('K');}
                        moves++;
                        upcount++;

                    };break;
                    case LOWCASE:{
                        if(s.substring(s.length()-1).equals("s")) {sb.append('m');}
                        else {sb.append('s');}
                        moves++;
                        lowcount++;

                    };break;
                    case DIGIT:{
                        if(s.substring(s.length()-1).equals("5")) {sb.append('8');}
                        else {sb.append('5');}
                        moves++;
                        digcount++;

                    };break;
                }
            }
        }


        else if(s.length()<=20&&s.length()>=6){//合理长度
            if(conti3index==-1&&lowcount>0&&upcount>0&&digcount>0){//合理密码
                finishflag=true;
            }
            else {
                if (conti3index != -1) {//存在3连字

                    switch (whichleast()) {
                        case DIGIT: {
                            if (c[conti3index] != '5') {
                                sb = sb.replace(conti3index + 1, conti3index + 2, "5");
                            } else {
                                sb = sb.replace(conti3index + 1, conti3index + 2, "0");
                            }
                            moves++;
                            digcount++;
                        };break;
                        case LOWCASE: {
                            if (c[conti3index] != 's') {
                                sb = sb.replace(conti3index + 1, conti3index + 2, "s");
                            } else {
                                sb = sb.replace(conti3index + 1, conti3index + 2, "m");
                            }
                            moves++;
                            lowcount++;

                        };break;
                        case UPCASE: {

                            if (c[conti3index] != 'K') {
                                sb = sb.replace(conti3index + 1, conti3index + 2, "K");
                            }//替换为一个大写字符
                            else {
                                sb = sb.replace(conti3index + 1, conti3index + 2, "V");
                            }
                            moves++;
                            upcount++;

                        };break;
                    }
                }
                else {//长度合理，并且没有3连词，但不合法（数字、大写、小写最少缺失了一项），与缺项一样，添加项
                    switch (whichleast()) {
                        case UPCASE: {
                            if (c[s.length()] == 'K') {
                                sb.append('L');
                            } else {
                                sb.append('K');
                            }
                            moves++;
                            upcount++;

                        };break;
                        case LOWCASE: {
                            if (c[s.length()] == 's') {
                                sb.append('m');
                            } else {
                                sb.append('s');
                            }
                            moves++;
                            lowcount++;

                        };break;
                        case DIGIT: {
                            if (c[s.length()] == '5') {
                                sb.append('8');
                            } else {
                                sb.append('5');
                            }
                            moves++;
                            digcount++;

                        };break;
                    }
                }

            }
        }
        if(finishflag) {
            suggestedPwd=sb.toString();
            return moves;
        }
        else return pwdChecker(sb.toString());
    }


    public static void main(String[] args){
        String s="33333333333aaaaaaaa";
        strongPasswordChecker test=new strongPasswordChecker();
        int i=test.pwdChecker(s);
        System.out.println("您的输入为："+s);
        if (i>0){
            System.out.println("输入不合法！");
            System.out.println("建议密码为："+suggestedPwd);
            System.out.println("替换完成总共用了"+i+"步");
        }
        else if(i==0)
            System.out.println("输入合法！");

    }

}
