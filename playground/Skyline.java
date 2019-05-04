import java.util.*;
public class Skyline {


    public List<int[]> getSkyline(int[][] buildings) {

        List<int[]> heights = new ArrayList<>();
        for(int[] b : buildings){
            heights.add(new int[] {b[0],b[2],0});//0 : start
            heights.add(new int[] {b[1],b[2],1});
        }

        Collections.sort(heights, new Comparator<int[]>(){

            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]){
                    if(a[2] == b[2]){
                        return a[2]==0? b[1] - a[1] : a[1] - b[1];
                    }else{
                        return a[2] - b[2];
                    }
                }else{
                    return a[0] - b[0];
                }
            }
        });




        for(int[] a :heights){
            System.out.println(a[0]+","+a[1]+","+a[2]);
        }





        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));
        List<int[]> res = new ArrayList<>();
        pq.offer(0);
        int prev = 0;
        for(int[] h:heights){
            if(h[2]==0){
                pq.offer(h[1]);
                if(pq.peek()!=prev){
                    res.add(new int[]{h[0],h[1]});
                    prev=pq.peek();
                }
            }else{
                pq.remove(h[1]);
                if(pq.peek()!=prev){
                    res.add(new int[]{h[0],pq.peek()});
                    prev = pq.peek();
                }

            }
        }


        return res;

    }
    public static void main(String[] args){

        int[][] buildings = {

                {2,9,10},
                {3,7,15},
                {5,12,12},
                {15,20,10},
                {19,24,8},
        };

        Skyline obj = new Skyline();
        List<int[]> res = obj.getSkyline(buildings);
        for(int[] a: res){
            System.out.println(a[0]+"，"+a[1]);
        }
    }
}
