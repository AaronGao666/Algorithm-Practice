import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class KMPalgorithm {

    public int strStr(String haystack, String needle) {

        int pLen = needle.length();
        int sLen = haystack.length();
        if(pLen == 0){
            return 0;
        }
        if(sLen == 0){
            return -1;
        }

        int[] p = new int[pLen];
        char[] pattern = needle.toCharArray();
        int j = 0;
        int i = 1;
        while(i < pLen){
            if(pattern[i] == pattern[j]){
                p[i] = j + 1;
                i ++;
                j ++;
            }else if(j == 0){
                p[i] = 0;
                i ++;
            }else{
                j = p[j - 1];
            }
        }

        for(i = 0 ; i < pLen; i ++){
            System.out.print(p[i] + "\t");
        }


        return 0;
    }



    public int KMP(String s, String p) {

        int pLen = p.length();
        int sLen = s.length();
        int[] next = new int[pLen];
        //遍历p字符串，找出那个数组
        int j = 0, i = 1;
        while (i < pLen) {
            while (p.charAt(j) != p.charAt(i) && j != 0) {
                j = next[j - 1];
            }

//            System.out.println("当前i=" + i + "，j=" + j);
            if (p.charAt(i) == p.charAt(j)) {
                next[i] = j + 1;
                i++;
                j++;
            } else {
                next[i] = 0;
                i++;
            }

        }



        for(int iter:next){
            System.out.print(iter+"\t");
        }
        System.out.println("");

        i = 0;
        j = 0;
        while (i < sLen && j < pLen) {

            if(s.charAt(i)==p.charAt(j)){
                if(j==pLen-1){
                    return i-pLen+1;
                }
                i++;
                j++;

            }else if(j==0){
                i++;
            }else{
                j=next[j-1];
            }

        }


//
//        for (int iter : next) {
//            System.out.print(iter + "\t");
//        }

        return -1;
    }


    public static void main(String[] args) {
        String s="aabaaabaaac";

        String p = "aabaaac";
        KMPalgorithm obj = new KMPalgorithm();
        obj.strStr(s,p);



    }


}
