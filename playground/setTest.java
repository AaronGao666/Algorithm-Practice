import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class setTest {


    public static void main(String[] args){

        int a=1;
        int b=2;
        int c=3;
        int d=1;
        Set<Integer> set=new HashSet<>();
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);

        for(Integer i:set){
            System.out.println(i);
        }
        System.out.println(set.contains(2));

        Set<Integer> newSet=new HashSet<>(set);
        set.remove(a);
        System.out.println("orignial:");
        for(Integer i:set){
            System.out.println(i);
        }
        System.out.println("copy:");
        for(Integer i:newSet){
            System.out.println(i);
        }




    }
}
