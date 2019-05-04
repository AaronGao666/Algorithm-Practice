package GSOA;

import java.util.HashSet;

public class PairsThatSumToK {




    public int countPairs(int[] arr, int k){

        HashSet<Integer> traversed=new HashSet<>();
        int counts=0;
        for(int i:arr){
            if(!traversed.contains(i)){
                if(traversed.contains(k-i)){
                    counts++;
                }
                traversed.add(i);
            }
        }
        return counts;

    }


    public static void main(String[] args){

        int[] arr={1,2,2,2,2,4,5,1,6,1,67,91,102,43,2,56,18,29,30,27,28,3};
        int k=30;
        PairsThatSumToK obj=new PairsThatSumToK();
        System.out.println(obj.countPairs(arr,k));


    }
}
