

public class LongestSubstrWithoutRep {
    public int lengthOfLongestSubstring(String s) {

        int len=s.length();
        if(len<=1){
            return len;
        }
        boolean[] dp=new boolean[len];
        for(int i=0;i<len;i++){
            dp[i]=true;
        }
        for(int dis=1;dis<len;dis++){
            for(int i=0;i+dis<len;i++){
                if(dp[i]){
                    boolean diffFlag=true;
                    for(int j=i;j<i+dis;j++){
                        if(s.charAt(i+dis)==s.charAt(j)){
                            diffFlag=false;
                            break;
                        }
                    }
                    dp[i]=diffFlag;
                }
            }
            boolean allFalse=false;
            for(int i=0;i+dis<len;i++){
                allFalse=allFalse||dp[i];
            }
            if(!allFalse){
                return dis;
            }
        }

        return len;
    }

    public static void main(String[] args){
        String s="au";
        LongestSubstrWithoutRep obj =new LongestSubstrWithoutRep();
        System.out.println(obj.lengthOfLongestSubstring(s));
    }
}
