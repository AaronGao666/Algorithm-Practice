import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class RepeatedStringMatch {



    public int repeatedStringMatch(String a, String b){

        int lenA = a.length();
        int lenB = b.length();
        int[] prefix = new int[lenB  + 1];
        for(int i = 1, j = 0; i < lenB;){

            if(b.charAt(i) == b.charAt(j)) prefix[++i] = ++j;
            else if (j == 0) prefix[++i] = 0;
            else j = prefix[j];

        }

        for(int i : prefix){
            System.out.print(i + "\t");
        }
        System.out.println("");

        for(int i = 0 , j = 0; i < lenA; i += Math.max(1, j - prefix[j]), j = prefix[j]){

            while( j < lenB && a.charAt((i + j) %lenA) == b.charAt(j)){
                ++j;
            }
            if(j == lenB){
                return (i + j)/lenA +  ((i + j)%lenA != 0 ?1:0);
            }

        }

        return -1;
    }



    public static void main(String[] args){
        String a = "abcd";
        String b = "cdabcdabe";
        RepeatedStringMatch obj = new RepeatedStringMatch();
        System.out.println(obj.repeatedStringMatch(a,b));
    }
}
