public class StringMultiply {


    public String multiply(String num1, String num2) {

        int m=num1.length();
        int n=num2.length();

        int[] res=new int[m+n];

        for(int i=0;i<m;i++){
            char c1=num1.charAt(m-1-i);
            for(int j=0;j<n;j++){
                char c2=num2.charAt(n-1-j);
                res[i+j]+=(c2-'0')*(c1-'0');
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<m+n-1;i++){
            res[i+1]+=res[i]/10;
            res[i]=res[i]%10;
            sb.insert(0,res[i]);
        }
        sb.insert(0,res[m+n-1]);
        int index=0;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)!='0'){
                index=i;
                break;
            }
        }



        return sb.substring(index);

    }



    public static void main(String[] args){


        StringMultiply obj=new StringMultiply();
        System.out.println(obj.multiply("123","456"));


    }


}
