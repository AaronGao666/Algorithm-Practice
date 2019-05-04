public class PalindromicSubstrings {





    public int countSubstrings(String s) {

        int len=s.length();
        if(len<=1){
            return len;
        }
        int[][] dp=new int[len][len];
        dp[0][0]=1;
        for(int i=1;i<len;i++){
            dp[i][i]=1;
            dp[i-1][i]=s.charAt(i-1)==s.charAt(i)?2:0;
        }

        for(int i=2;i<len;i++){
            for(int j=0;j+i<len;j++){
                if(s.charAt(j)==s.charAt(j+i)&&dp[j+1][i+j-1]!=0){
                    dp[j][j+i]=Math.max(dp[j+1][i+j-1]+2,dp[j][i+j-1]);
                }else{
                    dp[j][j+i]=0;
                }
            }
        }


        for (int i=0;i<len;i++) {
            for(int j=0;j<len;j++){
                if(dp[i][j]!=1&&dp[i][j]!=0) {
                    System.out.print("i="+i+",j="+j+"dpij="+dp[i][j]+"\t");
                }
            }
            System.out.println("");
        }
        int result=0;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(dp[i][j]!=0){
                    result++;
                }
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args){
        String s1="aba";
        String s="dnncbwoneinoplypwgbwktmvkoimcooyiwirgbxlcttgteqthcvyoueyftiwgwwxvxvg";
//        System.out.println(s.length());
        PalindromicSubstrings obj= new PalindromicSubstrings();
        obj.countSubstrings(s);
    }
}
