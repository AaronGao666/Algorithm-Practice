package Google1808;

public class InterestingString {



    public String check(String s){
        if( checkB(s)) return "yes";
        else return "no";
    }

    public boolean checkB(String s) {

        if(!isNumeric(s.charAt(0))){
            return false;
        }

        int len=s.length();
        int lastNum=0;
        for(int i=0;i<len;i++){
            if(!isNumeric(s.charAt(i))){
                lastNum=i-1;
                break;
            }
        }
        if(lastNum==0){
            int index=s.charAt(0)-'0'+1;
            if(index==len){
                return true;
            }else   return checkB(s.substring(index));
        }
        boolean[] res=new boolean[lastNum+1];
        for(int i=0;i<=lastNum;i++){
            int num=0;
            for(int j=0;j<=i;j++){
                num+=(s.charAt(j)-'0')*Math.pow(10,i-j);
            }
            if(num>len-i-1){
                res[i]=false;
            }else if(num==len-i-1){
                res[i]=true;
            }else{
                res[i]=checkB(s.substring(i+1));
            }
        }
        for (boolean b: res) {
            System.out.println(b);
            if(b) return true;
        }
        return false;
    }



    public boolean isNumeric(char c){
        if(c>='0'&&c<='9'){
            return true;
        }else return false;
    }

    public static void main(String[] args){
        String s="11gray6hunter";
        InterestingString obj=new InterestingString();
        System.out.println(obj.check(s));
    }
}
