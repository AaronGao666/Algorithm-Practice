import  java.util.*;
public class PQtest {



    public static void main(String[] args){


        HashMap<String ,Integer> map=new HashMap<>();
        PriorityQueue pq=new PriorityQueue<>(Comparator.comparing((String s )-> map.get(s)).reversed().thenComparing((a,b)->(a.compareTo(b)) ) );

    }
}
