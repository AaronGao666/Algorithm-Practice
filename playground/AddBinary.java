public class AddBinary {

    public static String addBinary(String a, String b) {

        int lenA = a.length();
        int lenB = b.length();
        if (lenA == 0) {
            return b;
        }
        if (lenB == 0) {
            return a;
        }

        if (lenA < lenB) {
            return addBinary(b, a);// make sure a is longer string
        }
        StringBuilder sb = new StringBuilder();
        boolean carry = false;
        for (int i = 1; i <= lenB; i++) {
            char ca = a.charAt(lenA - i);
            char cb = b.charAt(lenB - i);
            if (carry) {
                if (ca != cb) {
                    sb.append('0');
                } else if (ca == '1') {// two 1
                    sb.append('1');
                } else { // two 0
                    sb.append('1');
                    carry = false;
                }
            } else {
                if (ca != cb) {
                    sb.append('1');
                } else if (ca == '1') {// two 1
                    sb.append('0');
                    carry = true;
                } else { // two 0
                    sb.append('0');
                }
            }
        }

        for (int i = lenB + 1; i <= lenA; i++) {
            char ca = a.charAt(lenA - i);
            if (carry) {
                if (ca == '1') {
                    sb.append('0');
                } else {
                    sb.append('1');
                    carry = false;
                }

            } else {
                sb.append(ca);
            }

        }
        if (carry) {
            sb.append('1');
        }

//        System.out.println(sb);
        return new String(sb.reverse());
    }


    public static void main(String[] args) {

        String s1 = "110010";
        String s2 = "10111";

        System.out.println(addBinary(s1, s2));

    }
}
