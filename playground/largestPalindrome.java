import java.util.*;

public class largestPalindrome {
    public int largestPalindrome(int n) {

        if(n == 1){
            return 9;
        }
        int[] init = new int[n];
        init[0] = 1;
        long minDivide = getNumber(init);
        Arrays.fill(init, 9);
        long maxDivide = getNumber(init);
        long currNumber = maxDivide * maxDivide;

        long firstHalf = (long) (currNumber / Math.pow(10, n));
        if(firstHalf % 10 == 0 || firstHalf % 10 > ((long) (currNumber / Math.pow(10, n - 1))) % 10 ){
            firstHalf --;
        }

        System.out.println(maxDivide + "," + minDivide + "," + currNumber + "first half = " + firstHalf);

        while (firstHalf >= minDivide) {
//            System.out.println("outer");
            currNumber = getPalindrome(firstHalf, n);
            long currDivide = maxDivide;

            while (currDivide >= minDivide) {
//                System.out.println("currNum = "+currNumber + "currDiv = " +currDivide);
                if(currNumber / currDivide > Math.pow(10, n)){
                    break;
                }
                if (currNumber % currDivide == 0) {
//                    System.out.println(currNumber +",,," +currDivide);
                    return (int) (currNumber % 1337);
                }
                currDivide--;
            }
            firstHalf --;
        }

        return -1;
    }

    private long getNumber(int[] digits) {
        int len = digits.length;
        long res = 0;
        for (int i = 0; i < digits.length; i++) {
            res *= 10;
            res += digits[i];
        }
        return res;
    }

    private long getPalindrome(long firstHalf, int n) {
        int[] nums = new int[2 * n];
        int index = n  - 1;
        while(index >= 0){
            nums[index] = (int) (firstHalf % 10);
            nums[2*n - index - 1] = nums[index];
            firstHalf /= 10;
            index --;
        }

        return getNumber(nums);
    }


    public static void main(String[] args) {
//        int n = 4;
//        largestPalindrome obj = new largestPalindrome();
//        System.out.println(obj.largestPalindrome(n));



        int[] arr = {1,3,4,5, 100};
        System.out.println(Arrays.binarySearch(arr, 2));
    }
}
