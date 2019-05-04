public class repetedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if (len <= 1) {
            return true;
        }
        int validLen = 1;
        int repeteTimes = 1;
        int index = 1;
        while (index < len) {
            System.out.println(index + ",validLen = " + validLen + ", repteTimes = " + repeteTimes);
            if (s.charAt(index) == s.charAt(index - repeteTimes * validLen )) {
                if ((index + 1) % validLen == 0 && validLen != 1) {
                    repeteTimes++;
                }
                index++;
            } else {
                index++;
                validLen = index;
                repeteTimes = 1;
            }
            if (validLen * 2 > len) {
                System.out.println(validLen);
                return false;
            }
        }
        return len % validLen == 0;
    }

    public static void main(String[] args) {

        String s = "abacababacab";
        repetedSubstringPattern obj = new repetedSubstringPattern();
        System.out.println(obj.repeatedSubstringPattern(s));
    }
}
