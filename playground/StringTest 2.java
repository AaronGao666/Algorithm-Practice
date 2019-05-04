public class StringTest {


    public String reverseWords(String s) {
        s=s.trim();
        String[] dict=s.split("[ ]+");
        int len=dict.length;
        String res="";
        if(len==0){
            return res;
        }

        for(int i=0;i<len;i++){
            System.out.println("dicti="+dict[i]);
        }


        for(int i=len-1;i>=1;i--){
            res+=dict[i]+" ";
        }
        res+=dict[0];
        return res;
    }
    public static void main(String[] args){

        StringTest obj=new StringTest();
        String s=" 1     2  fda4   fda5  f  6     ";
        System.out.println(obj.reverseWords(s));


    }



}
