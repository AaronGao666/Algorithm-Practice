public class WordCompression_Others {

    public int[] wordsCompression(String[] s) {
        // Write your code here
        //StringBuilder sb = new StringBuilder();
        String now = s[0];
        int n = s.length;
        int[] res = new int[s.length];
        res[0] = 0;
        for(int i = 1; i < n; i ++) {
            int[] next = buildNext(s[i]);

            for(int iter:next){
                System.out.print(iter+"\t");
            }
            System.out.println("\n");



            int idx = kmp(now, s[i], next);
            int len = now.length() - idx;
            now += s[i].substring(len, s[i].length());
            res[i] = find(now, s[i], next);
        }
        return res;
    }
    int find(String a, String b, int[] next) {
        int m = a.length();
        int n = b.length();
        int i = 0, j = 0;
        while(i < m && j < n) {
            if(j < 0 || a.charAt(i) == b.charAt(j)) {
                i ++;
                j ++;
            } else {
                j = next[j];
            }
        }
        return i - j;
    }
    int kmp(String a, String b, int[] next) {
        int m = a.length();
        int n = b.length();
        int i = 0;
        if(m > n) {
            i = m - n;
        }
        int j = 0;
        while(i < m) {
            if(j == n) j = next[j];
            if(j < 0 || a.charAt(i) == b.charAt(j)) {
                j ++;
                i ++;
            } else {
                j = next[j];
            }
        }
        return m - j;
    }
    int[] buildNext(String s) {
        int[] next = new int[s.length() + 1];
        int m = s.length();
        int t = next[0] = -1;
        int j = 0;
        while(j < m) {
            if(t < 0 || s.charAt(t) == s.charAt(j)) {
                t ++;
                j ++;
                next[j] = t;
            } else {
                t = next[t];
            }
        }
        return next;
    }


    public static void main(String[] args){

        WordCompression_Others obj =new WordCompression_Others();
        String[] s={"aaaba","abbb","aba","bbaa","baaa"};
        int[] res=obj.wordsCompression(s);
        for(int i:res){
            System.out.print(i+"\t");
        }



    }
}
