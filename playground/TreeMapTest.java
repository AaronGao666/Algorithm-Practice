import java.util.*;

public class TreeMapTest {


    public static void main(String[] args){


        TreeMap<Integer, Integer> map = new TreeMap<>();



        HashMap<Integer, Integer> hmap = new HashMap<>();

        for(int i = 0; i < 20; i ++){
            map.put( (int)(Math.random()*100), (int)(Math.random()*100));
            hmap.put((int)(Math.random()*100), (int)(Math.random()*100));
        }
        for(int i : map.keySet()){
            System.out.println(i + "," + map.get(i));
        }

        System.out.println("下一个");

        for(int i : hmap.keySet()){
            System.out.println(i + "," + hmap.get(i));
        }


        List<Integer> list = new ArrayList<>(map.keySet());
        System.out.println(list);

        List<Integer> list1 = new ArrayList<>(hmap.keySet());
        System.out.println(list1);
    }


}
