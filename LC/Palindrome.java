package algorithm;
import java.util.*;
import java.util.regex.*;


public class Palindrome {
    public char[] initialize(String n){
        char[] c=n.toCharArray();
        if (n.length()>18){
            return null;
        }
        else {
            Pattern pattern = Pattern.compile("[0-9]*");
            if (pattern.matcher(n).matches()){
                return c;
            }
            else return null;
        }
    }

    public String nearestPalindromic(String n){
        char[] c =new Palindrome().initialize(n);
        if (c!=null) {

            int central;
            if(c.length%2==0){//偶数
                central=c.length/2-1;
                c[central+1]=c[central];
                for(int offset=1;central-offset>=0;offset++){
                    c[central+1+offset]=c[central-offset];
                }

            }
            else {//奇数
                central=(int) c.length/2;
                for(int offset=1;central-offset>=0;offset++){
                    c[central+offset]=c[central-offset];
                }
            }
            String s=new String(c);
            return s;

        }
        else {
            System.out.println("输入不合法！请输入18位以内纯数字");
            return null;
        }


    }


    public static void main(String[] args){
        String s="4321789571";
        System.out.println("输入数据长度："+s.length());
        String result=new Palindrome().nearestPalindromic(s);

        System.out.println(result);
    }

}


