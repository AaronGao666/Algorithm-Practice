package algorithm;

public class ShortestPalindrome {


    public String ShortestPanlindrome(String s){
        int len=s.length();
        boolean isOdd=(len%2==1);//奇数个
        int halflen=isOdd?len/2+1:len/2;
        int maxIndex=0;
        boolean oddFlag=true;
        for(int i=1;i<halflen;i++){
            for(int j=1;j<=i;j++){//判断奇数个
                if(s.charAt(i-j)==s.charAt(i+j)) {
                    if(j==i) {
                        maxIndex=i;
                        oddFlag=true;
                    }
                }
                else break;
            }
            for(int j=1;j<i;j++){//判断偶数个
                if(s.charAt(i-j+1)==s.charAt(i+j)){
                    if(i==j+1){
                        maxIndex=i;
                        oddFlag=false;
                    }
                }
                else break;
            }
        }
        int validNums=oddFlag?2*maxIndex+1:2*maxIndex+2;
        char[] head=new char[len-validNums];
        for(int i=0;i+validNums<len;i++){
            head[i]=s.charAt(len-i-1);
        }
        String s1=new String(head);
        return s1+s;
    }

    public static void main(String args[]){
        String s="43211234";
        ShortestPalindrome obj=new ShortestPalindrome();
        System.out.println(obj.ShortestPanlindrome(s));

    }
}
