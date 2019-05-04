import java.util.*;

public class HashSetTest {


    public static void main(String args[]) {


        Set<String> set = new HashSet<>();
//        Set<String> set = new LinkedHashSet<String>();
        set.add("3");
        set.add("1");
        set.add("3");
        set.add("2");
        set.add("3");
        set.add("1");
        for (Iterator<String> it = set.iterator(); it.hasNext(); ) {
            String str = (String) it.next();
            System.out.print(str + "-");
            System.out.print(str.hashCode() +"\n");
        }





    }
}
