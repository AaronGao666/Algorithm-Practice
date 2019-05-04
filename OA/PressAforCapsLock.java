package GSOA;

public class PressAforCapsLock {



    public String capsLock(String s){

        int len=s.length();
        StringBuilder sb=new StringBuilder();
        int diff='a'-'A';
        boolean capsOn=false;
        for(int i=0;i<len;i++){

            char c=s.charAt(i);
            if(c=='a'||c=='A'){
                capsOn=!capsOn;
                continue;
            }
            if(capsOn){
                if(c<='z'&&c>'a'){
                    c-=diff;
                }
                sb.append(c);
            }else{
                sb.append(c);
            }
        }

        return new String(sb);
    }

    public static void main(String[] args){


        String s="My keyboard is broken!";
        String s1="Baa, Baa! said the sheep";
        PressAforCapsLock obj=new PressAforCapsLock();
        System.out.println(obj.capsLock(s1));


    }
}
