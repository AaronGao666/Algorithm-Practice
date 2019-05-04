import java.util.HashSet;

public class StringTest {







    public static void main(String[] args){
        char[] chars = {'a','b',3,'c'};

//        System.out.println(new String(chars));

        String s = "abc";
        String e = "abc";

        String m = new String("abc");


        String x = "abcd".substring(0,3);


        HashSet<String> set = new HashSet<>();
        set.add(s);
        set.add(e);
        set.add(m);
        set.add(x);

        System.out.println(s.hashCode());
        System.out.println(e.hashCode());
        System.out.println(m.hashCode());

        System.out.println(x);
        System.out.println(x.hashCode());


        System.out.println(e==x);

        System.out.println(set.size());




    }

}
