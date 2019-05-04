package AmazonOA;

public class LongestPalindromeSubstr {

    public String longestPalindrome(String s) {

        int len = s.length();
        if (len <= 0) {
            return "";
        }
        char[] chars = s.toCharArray();

        int start = 0;
        int maxLen = 0;

        for(int i = 0; i < len; i ++){

            int temp = findMaxLen(chars, i, i);
            int temp2 = findMaxLen(chars, i, i + 1);
            temp = Math.max(temp, temp2);
            if(temp > maxLen){
                maxLen = temp;
                start = i - (temp - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }
    private int findMaxLen(char[] chars, int left, int right){

        while(left >= 0 && right < chars.length  && chars[left] == chars[right]){
            left --;
            right ++;
        }

        return right - left - 1;
    }



}
