package AmazonOA;

import java.util.*;
public class Restaurant {

    public List<List<Integer>> nearestRestaurant(List<List<Integer>> restaurant, int n) {
        // Write your code here
        if(restaurant.isEmpty() || n < 1 || restaurant.size() < n) return new ArrayList<>();

        // Collections.sort(restaurant, new Comparator<List<Integer>>(){
        //     @Override
        //     public int compare(List<Integer> l1, List<Integer> l2){

        //         int dis1 = l1.get(0) * l1.get(0) + l1.get(1) * l1.get(1);
        //         int dis2 = l2.get(0) * l2.get(0) + l2.get(1) * l2.get(1);
        //         if(dis2 < dis1) return 1;
        //         else return -1;
        //     }

        // });
        Collections.sort(restaurant, (a,b) -> (a.get(0) * a.get(0) + a.get(1)*a.get(1) - b.get(0) *b.get(0) - b.get(1) * b.get(1)));
        for(List<Integer> l : restaurant){
            System.out.print(l);
            System.out.println("\t");
        }


        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < n; i ++){
            result.add(restaurant.get(i));
        }

        return result;

    }

    public static void main(String[] args){

        List<List<Integer>> restaurant = new ArrayList<>();
        restaurant.add(Arrays.asList(1,1));
        restaurant.add(Arrays.asList(1,2));
        restaurant.add(Arrays.asList(1,3));
        restaurant.add(Arrays.asList(1,4));
        restaurant.add(Arrays.asList(1,5));
        restaurant.add(Arrays.asList(2,2));
        restaurant.add(Arrays.asList(2,3));
        restaurant.add(Arrays.asList(2,4));
        restaurant.add(Arrays.asList(2,5));
        restaurant.add(Arrays.asList(3,3));
        restaurant.add(Arrays.asList(3,4));
        restaurant.add(Arrays.asList(3,5));

        int n = 7;
        Restaurant obj = new Restaurant();

        obj.nearestRestaurant(restaurant, n);
    }
}
