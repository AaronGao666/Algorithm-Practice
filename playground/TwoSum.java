import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;
public class TwoSum {


    public List<List<Integer>> twoSum(int[] arr, int target){


        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int len = arr.length;
        if(len <= 0){
            return result;
        }

        int start = 0;
        int end = len - 1;

        while(start < end){


            if(arr[start] + arr[end] < target){
                start ++;
            }else if(arr[start] + arr[end] > target){
                end --;
            }else{

                List<Integer> list = new ArrayList<>();
                list.add(arr[start]);
                list.add(arr[end]);
                result.add(list);
                start ++;
                end --;


            }

        }


        return result;

    }

    public static void main(String[] args){

        int[] arr = {1,2,5,9};
        int target = 11;
        TwoSum obj = new TwoSum();
        System.out.println(obj.twoSum(arr,target));


    }

}
