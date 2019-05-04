package AmazonOA;

import java.util.HashSet;

public class numberOfSubstringWithExactlyKDistinctChar {


    //k 长度的有k -1 个distinct
    public int k_1Distinct(String s, int k) {


        if (s.length() < k) return 0;
        char[] S = s.toCharArray();
        int[] count = new int[26];
        int charCount = 0;

        int result = 0;
        for (int i = 0; i < k; i++) {
            if (count[S[i] - 'a'] == 0) charCount++;
            count[S[i] - 'a']++;
        }
        if (charCount == k - 1) result++;
        for (int i = k; i < S.length; i++) {
            count[S[i - k] - 'a']--;
            if (count[S[i - k] - 'a'] == 0) charCount--;
            if (count[S[i] - 'a'] == 0) charCount++;
            count[S[i] - 'a']++;
            if (charCount == k - 1) result++;
        }


        return result;

    }







    //K 长度有k 个distinct
    public int K_distinct(String s, int k) {

        if (s.length() < k) return 0;
        char[] S = s.toCharArray();
        int[] count = new int[26];
        int charCount = 0;

        int result = 0;
        for (int i = 0; i < k; i++) {
            if (count[S[i] - 'a'] == 0) charCount++;
            count[S[i] - 'a']++;
        }
        if (charCount == k) result++;
        for (int i = k; i < S.length; i++) {
            count[S[i - k] - 'a']--;
            if (count[S[i - k] - 'a'] == 0) charCount--;
            if (count[S[i] - 'a'] == 0) charCount++;
            count[S[i] - 'a']++;
            if (charCount == k) result++;
        }


        return result;

    }
    //相同substring 算一个的
    public int K_distinct_Nodup(String s, int k) {

        if (s.length() < k) return 0;
        char[] S = s.toCharArray();
        int[] count = new int[256];
        int charCount = 0;

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < k; i++) {
            if (count[S[i]] == 0) charCount++;
            count[S[i]]++;
        }
        if (charCount == k) {
            set.add(s.substring(0, k));
        }
        for (int i = k; i < S.length; i++) {

            System.out.println(i);

            count[S[i - k] ]--;
            if (count[S[i - k] ] == 0) charCount--;
            if (count[S[i] ] == 0) charCount++;
            count[S[i] ]++;
            if (charCount == k) {
                set.add(s.substring(i-k + 1,i + 1));
            }


//            for(int j = 0; j < 256; j ++){
//                if(count[j] != 0) System.out.print("("+ (char)j + ","+ count[j]+") \t");
//            }
//            System.out.println("\n charcount= " + charCount );

        }

        System.out.println(set);

        return set.size();

    }




    //不限长度的k  0 <= k <= 26
    public int countNumber(String s, int k) {

        if (s.length() < k) return 0;
        char[] S = s.toCharArray();

        int result = 0;

        for (int i = 0; i < S.length; i++) {
            int[] count = new int[26];
            int charCount = 0;
            for (int j = i; j < S.length; j++) {
                if(count[S[j] - 'a'] == 0) charCount ++;
                count[S[j] - 'a']++;
                if(charCount == k) result ++;
            }
        }


        return result;
    }


    public static void main(String[] args) {
        String s = "abcba";
        int k = 2;
//        System.out.println(new numberOfSubstringWithExactlyKDistinctChar().countNumber(s, k));

        numberOfSubstringWithExactlyKDistinctChar obj = new numberOfSubstringWithExactlyKDistinctChar();
        System.out.println(obj.K_distinct_Nodup(s, k));
    }


}

