package algorithm;

public class InterleavingString {



    public boolean isInterLeave(int i, int j, int m, int n, String s1, String s2, String s3){//i
        if(i==m){
            for (;j<n;j++) {
                if(s2.charAt(j)==s3.charAt(m+j)){
                    if(j==n-1){
                       return true;
                    }
                }else return false;
            }
        }
        if(j==n){
            for (;i<m;i++) {
                if(s1.charAt(i)==s3.charAt(n+i)){
                    if(i==m-1){
                        return true;
                    }
                }else return false;
            }
        }
        if(s1.charAt(i)!=s3.charAt(i+j)&&s2.charAt(j)!=s3.charAt(i+j)){
            return false;
        }
        if(s1.charAt(i)==s3.charAt(i+j)&&s2.charAt(j)!=s3.charAt(i+j)){
            return isInterLeave(i+1,j,m,n,s1,s2,s3);
        }
        if(s1.charAt(i)!=s3.charAt(i+j)&&s2.charAt(j)==s3.charAt(i+j)){
            return isInterLeave(i,j+1,m,n,s1,s2,s3);
        }

        if(s1.charAt(i)==s3.charAt(i+j)&&s2.charAt(j)==s3.charAt(i+j)){
            return (isInterLeave(i+1,j,m,n,s1,s2,s3)||isInterLeave(i,j+1,m,n,s1,s2,s3));
        }
        return false;
    }

    public boolean InterleavingString(String s1, String s2, String s3){
        int m=s1.length();
        int n=s2.length();
        int k=s3.length();
        if(k!=(m+n)) return false;
        return isInterLeave(0,0,m,n,s1,s2,s3);
    }


    public static void main(String args[]){
        String s1="aaaaa";
        String s2="aaaaa";
        String s3="aaaaaaaaaa";
        InterleavingString obj=new InterleavingString();
        System.out.println(obj.InterleavingString(s1,s2,s3));


    }

}
