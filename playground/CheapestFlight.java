import java.util.*;
public class CheapestFlight {
//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
//        for(int[] flight : flights){
//            if(!map.containsKey(flight[0])) map.put(flight[0], new HashMap<>());
//            map.get(flight[0]).put(flight[1], flight[2]);
//        }
//
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
//        pq.offer(new int[]{0, src, K + 1});
//
//        while(!pq.isEmpty()){
//            int[] n = pq.poll();
//            int price = n[0];
//            int city = n[1];
//            int stops = n[2];
//            if(city == dst) return price;
//            if(stops > 0){
//                HashMap<Integer, Integer> nexts = map.get(city);
//                for(int i : nexts.keySet()){
//                    pq.offer(new int[]{price + map.get(i), i, stops - 1});
//                }
//            }
//        }
//
//
//        return -1;
//    }
//
//
//    public static void main(String[] args){
//
//    }


}
