import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class DecodeWays {

    int[] dp;


    public int numDecodings(String s){
        int n=s.length();
        dp=new int[n];

        switch (s.charAt(0)){
            case '0': return 0;
            case '1': {
                dp[0]=1;
                dp[1]=s.charAt(1)=='0'?1:2;
                break;
            }
            case '2': {
                dp[0]=1;
                if(s.charAt(1)>='1'&&s.charAt(1)<='6'){
                    dp[1]=2;
                }else{
                    dp[1]=1;
                }
                break;
            }
            default: {
                dp[0]=1;
                dp[1]=1;
            }
        }

        for(int i=2;i<n;i++){
            if(s.charAt(i)=='0'){
                if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'){
                    dp[i]=dp[i-2];
                }else{
                    return 0;
                }
            }else if(s.charAt(i)>='7'&&s.charAt(i)<='9'){
                if(s.charAt(i-1)=='1'){
                    dp[i]=dp[i-1]+dp[i-2];
                }else{
                    dp[i]=dp[i-1];
                }
            }else{
                if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'){
                    dp[i]=dp[i-1]+dp[i-2];
                }else{
                    dp[i]=dp[i-1];
                }
            }
        }
        return dp[n-1];
    }



    public int numDecod(String s){
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];

        return memo[0];
    }


//    public int helper(String s, int start, int end){
//
//        for(int i=end;i>=start;i--){
//            if(s.charAt(i)=='0'){
//                if(s.charAt(i-1)!='1'||s.charAt(i-1)!='2'){
//                    return -1;
//                }else{
//                    return helper(s,start,i-2)*helper(s,i+1,end);
//                }
//            }else if(s.charAt(i)>='7'&&s.charAt(i)<='9'){
//
//            }
//        }
//
//
//    }
    public static void main(String args[]){

        String s="1232141509421";
        DecodeWays obj=new DecodeWays();

        long start=System.nanoTime();

        System.out.println(obj.numDecodings(s));

        long end= System.nanoTime();
        System.out.println((end-start));

        start=System.nanoTime();
        System.out.println(obj.numDecod(s));
        end= System.nanoTime();
        System.out.println((end-start));

    }
}
