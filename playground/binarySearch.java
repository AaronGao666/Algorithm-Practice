
import java.util.Arrays;

public class binarySearch {

    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int start = 0;
        int end = 0;
        for(int i = 0 ; i < len ; i++){
            System.out.println(i);
            int temp = Arrays.binarySearch(numbers, i+1, len, target - numbers[i]);
            if( temp >= 0){
                start = i;
                end = temp;
                break;
            }
        }

        return new int[]{start+1, end+1 };
    }

    public static void main(String[] args){

//        int[] a = {-1,0};
//        int k = -1;
//        int[] res = new binarySearch().twoSum(a,k);
//        System.out.println(res[0]+","+res[1]);
//

//        int[] arr= {1,2,3,4,5,7,9,10,13,19,20};
        int[] arr = {2,2};
        System.out.println(Arrays.binarySearch(arr, 1,2,2));

    }



}
