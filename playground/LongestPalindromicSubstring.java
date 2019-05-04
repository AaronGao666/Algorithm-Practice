import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {

        int len = s.length();
        if (len <= 0) {
            return "";
        }
        char[] chars = s.toCharArray();

        int maxLen = 1;
        int maxIndex = 0;
        boolean odd = true;
        for (int i = 0; i < len ; i++) {

            for (int j = 1; i + j < len && i - j >= 0; j++) {
                if (chars[i + j] == chars[i - j]) {
                    if (2 * j + 1 > maxLen) {
                        maxLen = 2 * j + 1;
                        maxIndex = i;
                        odd = true;
                    }
                }else{
                    break;
                }
            }
            System.out.println(i + "," + maxLen);
            for (int j = 0; i + 1 + j < len && i - j >= 0; j++) {
                if (chars[i + 1 + j] == chars[i - j]) {
                    if (2 * j + 2 > maxLen) {
                        maxLen = 2 * j + 2;
                        maxIndex = i;
                        odd = false;
                    }
                }else{
                    break;
                }
            }

        }

        System.out.println(maxIndex + ","+maxLen + "," + odd);
        if (odd) {
            maxLen = maxLen / 2;
            return s.substring(maxIndex - maxLen, maxIndex + maxLen + 1);
        } else {
            maxLen = maxLen / 2 - 1;
            return s.substring(maxIndex - maxLen, maxIndex + maxLen + 2);
        }


    }

    public static void main(String[] args) {
        String s = "aaa";

        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        System.out.println(obj.longestPalindrome(s));


    }

}
