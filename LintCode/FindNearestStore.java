package Google1808;

import java.util.*;

public class FindNearestStore {



    public List<Integer> findNearestStore(List<Integer> stores, List<Integer> houses) {


        Collections.sort(stores);
        int len=houses.size();
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<len;i++){

            if(houses.get(i)<=stores.get(0)){
                res.add(stores.get(0));
                continue;
            }
            if(houses.get(i)>=stores.get(stores.size()-1)){
                res.add(stores.get(stores.size()-1));
                continue;
            }

            int pos=Collections.binarySearch(stores,houses.get(i));
            if(pos>=0){
                res.add(stores.get(pos));
            }else{
                res.add(Math.abs(stores.get(-pos-1)-houses.get(i))<Math.abs(stores.get(-pos-2)-houses.get(i))?stores.get(-pos-1):stores.get(-pos-2));
            }
        }
        System.out.println(res);
        return res;
    }


    public static void main(String[] args){

        Integer[] s={1,3,6};
        Integer[] h={2,4,6,7};
        List<Integer> stores=Arrays.asList(s);
        List<Integer> houses=Arrays.asList(h);
        System.out.println(stores);
        System.out.println(houses);
        FindNearestStore obj=new FindNearestStore();
        obj.findNearestStore(stores,houses);

    }
}
