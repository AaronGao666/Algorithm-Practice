import  java.util.*;
public class CheepestFlight {


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for(int[] flight : flights){
            if(!map.containsKey(flight[0])){
                HashMap<Integer, Integer> price = new HashMap<>();
                price.put(flight[1],flight[2]);
                map.put(flight[0], price);
            }else{
                HashMap<Integer, Integer> price = map.get(flight[0]);
                price.put(flight[1],flight[2]);
            }
        }

        for(int i : map.keySet()){
            System.out.print(i+"-->");
            for(int j: map.get(i).keySet()){
                System.out.print(j+":"+map.get(i).get(j)+",\t");
            }
            System.out.println("");
        }



        int res = BFS(map, src, dst, K, new HashSet<>(), 0);
        if(res == Integer.MAX_VALUE){
            return -1;
        }else {
            return res;
        }
    }
    private int BFS(HashMap<Integer, HashMap<Integer, Integer>> map, int src, int dst, int K, HashSet<Integer> set, int currPrice ){

        System.out.println("BFS调用，src="+src+",K="+K+",curr="+currPrice);

        if(src == dst){
            return currPrice;
        }

        if(!map.containsKey(src) || K < 0){
            System.out.println("这");
            return Integer.MAX_VALUE;
        }
        set.add(src);

        int min = Integer.MAX_VALUE;
        if(map.get(src).containsKey(dst)){
            min = map.get(src).get(dst)+currPrice;
            set.add(dst);
        }

        for(int connectCity : map.get(src).keySet()){
            System.out.println("递归一次");
            set.add(connectCity);
            min = Math.min(min, BFS(map, connectCity, dst, K-1, set, currPrice + map.get(src).get(connectCity)));
            set.remove(connectCity);
        }

        set.remove(src);
        return min;
    }




    public static void main(String[] args){

        int n = 3;
        int[][] flight = {
                {4,1,1},
                {1,2,3},
                {0,3,2},
                {0,4,10},
                {3,1,1},
                {1,4,3}
        };
        int src=0;
        int dst = 2;
        int K =1;
        CheepestFlight obj = new CheepestFlight();
        System.out.println(obj.findCheapestPrice(n,flight,src,dst, K+1));

    }
}
