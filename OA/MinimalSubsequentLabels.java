package AmazonOA;

import java.util.*;

public class MinimalSubsequentLabels {


    public List<Integer> minimalPartition(List<Character> input) {

        int size = input.size();
        HashMap<Character, Integer> lastPost = new HashMap<>();
        for (int i = size - 1; i >= 0; i--) {
            if (!lastPost.containsKey(input.get(i))) {
                lastPost.put(input.get(i), i);
            }
        }


        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < size; ) {
            int end = lastPost.get(input.get(i));
            for (int j = i; j < end; j++) {
                if (lastPost.get(input.get(j)) > end) {
                    end = lastPost.get(input.get(j));
                }
            }
            i = end + 1;
            result.add(i);
        }

        for(int i = result.size() - 1; i > 0; i --){
            result.set(i, result.get(i) - result.get(i - 1));
        }

        return result;
    }


    public static void main(String[] args){

        List<Character> list = Arrays.asList('a','b','a','b','c','b','a','c','a','d','e','f','e','g','d','e','h','i','j','h','k','l','i','j');

        MinimalSubsequentLabels obj = new MinimalSubsequentLabels();
        System.out.println(obj.minimalPartition(list));


    }


}
