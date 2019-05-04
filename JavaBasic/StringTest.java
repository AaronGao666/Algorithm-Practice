public class StringTest {

    public static void main(String[] args){

        String s = "abcd";
        String s1 = "abcd";
        String s2 = new String("abcd");


        System.out.println(s.equals(("abcd")));
        System.out.println(s == "abcd");
        System.out.println(s == s1);
        System.out.println(s == s2);

        System.out.println(s.hashCode());
        s = s.replace('a','M');
        System.out.println(s);
        System.out.println(s.hashCode());


    }



}
