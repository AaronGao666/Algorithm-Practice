import java.util.*;


public class PriorityQueueTest {

    public int[][] reconstructQueue(int[][] people) {
        LinkedList<int[]> list = new LinkedList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] a) -> (a[0])).reversed().thenComparing((int[] a) -> (a[1])));
        for(int[] person: people){
            pq.add(person);
        }
        while(!pq.isEmpty()){
            int[] person = pq.poll();
            if(list.size()>person[1]) {
                list.add(person[1], person);
            }else{
                list.add(person);
            }
        }

        int len = list.size();
        int[][] result = new int[len][2];
        for(int i = 0; i < len ; i++){
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args){
//        LinkedList<Integer> list = new LinkedList();
//        list.add(1);
//        list.add(2);
//        System.out.println(list.get(2));



        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        pq.offer(1);
        pq.offer(2);
        pq.offer(3);
        pq.offer(2);
        pq.offer(3);
        pq.offer(1);
        System.out.println(pq);
        pq.remove();
        System.out.println(pq);
//        pq.remove(10);
//        System.out.println(pq);
    }

}
