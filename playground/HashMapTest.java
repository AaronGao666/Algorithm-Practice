import java.util.*;

public class HashMapTest {





    public static void main(String[] args){
//
//        HashMap<Character,Integer> map=new HashMap<>();
//        map.put('c',1);
//        map.put('d',2);
//        map.put('e',4);
//        System.out.println(map.size());
//        map.remove('e');
//        System.out.println(map.size());


        int[] nums={2,2,2,1,1,1,1,1,3,4,4,4,4,5,6,6,6,6,6,6,7,7,7,7,7,77,9,1901,10,1,1,1,1,1,1};
        int k=4;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> q=new PriorityQueue<Integer>(k, Comparator.comparing((Integer i)-> map.get(i)));
        for(Integer key: map.keySet()){
            System.out.println(key+",="+map.get(key));
            q.offer(key);
        }
        System.out.println(q);






    }





}
