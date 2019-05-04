import javax.annotation.processing.SupportedSourceVersion;

public class isPanlindrome {

    public boolean isPalindrome(String s) {
        int len=s.length();
        if(len==0){
            return true;
        }
        int head=0;
        int tail=len-1;
        while(head<tail){
            char ch=s.charAt(head);
            char ct=s.charAt(tail);
            if(!isAlphanumeric(ch)){
                head++;
                continue;
            }
            if(!isAlphanumeric(ct)){
                tail--;
                continue;
            }
            if(equals(ct,ch)){
                head++;
                tail--;
            }else{
                System.out.println(ch+","+ct);
                return false;
            }
        }
        return equals(s.charAt(head),s.charAt(tail));

    }
    private boolean isAlphanumeric(char c){
        if((c>='0' && c<='9') || (c>='A' && c<='Z') || (c>='a' && c<='z')){
            return true;
        }else return false;
    }
    private boolean equals(char a, char b){

        char temp;
        if(a>b){
            temp=a;
            a=b;
            b=temp;
        }

        if(a>='A' && a<='Z' && b>='a' && b<='z'){
            return a+32==b;
        }

        return a==b;
    }

    public static void main(String[] args){
        String s="`l;`` 1o1 ??;l`";
        isPanlindrome obj =new isPanlindrome();
        System.out.println(obj.isPalindrome(s));

    }
}
