/**
 * 用dp做会更快。现在这个递归太慢了
 *
 */


public class OnesAndZeros {



    public int findMaxForm(String[] strs, int m,int n){
        return helper(strs,strs.length-1,m,n);
    }


    public int helper(String[] strs, int end, int m,int n){
        int count0=0,count1=0;
        boolean valid=false;
        String s=strs[end];
        int len=s.length();
        for(int i=0;i<len;i++){
            if (s.charAt(i) == '0') {
                count0++;
            } else {
                count1++;
            }
        }
        if(count0<=m&&count1<=n){
            valid=true;
        }

        if(end==0){
            if(valid){
                return 1;
            }else return 0;
        }

        if(valid){
            return Math.max(helper(strs,end-1,m,n),helper(strs,end-1,m-count0,n-count1)+1);
        }else{
            return helper(strs,end-1,m,n);
        }

    }


    public static void main(String args[]){
        String[] strs={"11","11","0","0","10","1","1","0","11","1","0","111","11111000","0","11","000","1","1","0","00","1","101","001","000","0","00","0011","0","10000"};
        OnesAndZeros obj=new OnesAndZeros();
        System.out.println(System.currentTimeMillis());
        System.out.println(obj.findMaxForm(strs,90,66));
        System.out.println(System.currentTimeMillis());
    }
}
