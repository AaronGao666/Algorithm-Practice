public class addStrings {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        if(len1 == 0){
            return num2;
        }
        if(len2 == 0){
            return num1;
        }
        if(len1 > len2){
            return addStrings(num2, num1);// make sure that num2 is larger one.
        }
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(; index < len1; index ++ ){

            int n1 = num1.charAt(len1 - 1 - index) - '0';
            int n2 = num2.charAt(len2 - 1 - index) - '0';

            sb.append((n1 + n2 + carry) % 10);
            carry = (n1 + n2 + carry) / 10;

        }
        System.out.println(sb);
        System.out.println(carry);
        while(index < len2){
            int n2 = num2.charAt(len2 - 1 - index) - '0';
            sb.append( (n2 + carry) % 10);
            carry = (n2 + carry) /10;
            index ++;
        }
        if(carry != 0){
            sb.append(carry);
        }
        if(sb.length() == 0){
            return "0";
        }


        return new String(sb.reverse());

    }

    public static void main(String[] args){
        addStrings obj = new addStrings();
        System.out.println(obj.addStrings("9","98"));
    }


}
