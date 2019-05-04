public class StringCompression {


    public int[] wordsCompression(String[] s) {
        // Write your code here
        String total=s[0];
        int counts=s.length;
        int[] result=new int[counts];
        for(int i=1;i<counts;i++){

            System.out.println("当前i="+i+"，TOTAL: "+total);
            int[] next=CreateNext(s[i]);

            for(int iter:next){
                System.out.print(iter+"\t");
            }
            System.out.println("");

            int index=KMP(total,s[i],next);


//            index=total.length()-index;


            System.out.println("index："+index);
            total+=s[i].substring(index);
            System.out.println("TOTAL: "+total);
            result[i]=KMPFind(total,s[i],next);
        }

        return result;

    }

    public int[] CreateNext(String p){
        int pLen=p.length();
        int[] next = new int[pLen];
        //遍历p字符串，找出那个数组
        int j = 0, i = 1;
        while (i < pLen) {
            while (p.charAt(j) != p.charAt(i) && j != 0) {
                j = next[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                next[i] = j + 1;
                i++;
                j++;
            } else {
                next[i] = 0;
                i++;
            }

        }
        return next;
    }



    public int KMP(String s, String p, int[] next) {

        int pLen = p.length();
        int sLen = s.length();
        int i = sLen>pLen?sLen-pLen:0;
        int j = 0;

        while (i < sLen ) {

            if(s.charAt(i)==p.charAt(j)){
                i++;
                j++;
            }else if(j==0){
                i++;
            }else{
                j=next[j-1];
            }
        }

        return j;
    }

    public int KMPFind(String s, String p, int[] next) {

        int pLen = p.length();
        int sLen = s.length();
        int i = 0;
        int j = 0;
        while (i < sLen && j < pLen) {

            if(s.charAt(i)==p.charAt(j)){
                i++;
                j++;
            }else if(j==0){
                i++;
            }else{
                j=next[j-1];
            }

        }
        return i-j;
    }





    public static void main(String[] args){
        String[] s={"aaaba","abbb","aba","bbaa","baaa"};
        StringCompression obj=new StringCompression();
        int[] res=obj.wordsCompression(s);
        for(int i:res){
            System.out.print(i+"\t");
        }
    }
}
