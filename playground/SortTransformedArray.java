import java.util.Arrays;

public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int len = nums.length;
        if(len < 1) return new int[0];
        int[] res = new int[len];
        if(a == 0){

            if(b >= 0){
                for(int i = 0; i < len; i ++){
                    res[i] = nums[i] * b + c;
                }
            }else {
                for(int i = 0; i < len; i ++){
                    res[len - i - 1] = nums[i] * b + c;
                }
            }
            return res;
        }

        double mid = - (double)b / (double)(2 * a );


//        System.out.println(Arrays.binarySearch(nums, (int)mid));

        double minDiff = Double.MAX_VALUE;
        int midAxis = 0;
        for(int i = 0; i < len; i ++){
            double diff = Math.abs(nums[i] - mid);
            if(diff <= minDiff){
                minDiff = diff;
                midAxis = i;
            }else {
                break;
            }
        }



        System.out.println(midAxis + ";;;" + nums[midAxis]);


        int low = midAxis - 1;
        int high = midAxis + 1;
        if (a > 0) {
            res[0] = fun(nums[midAxis], a, b, c);
            int index = 1;
            while (low >= 0 && high < len) {
                if (mid - nums[low] <= nums[high] -  mid) res[index++] = fun(nums[low--], a, b, c);
                else res[index++] = fun(nums[high++], a, b, c);
            }
            while (low >= 0) {
                res[index++] = fun(nums[low--], a, b, c);
            }
            while (high < len) {
                res[index++] = fun(nums[high++], a, b, c);
            }
        } else {
            res[len - 1] = fun(nums[midAxis], a, b, c);
            int index = len - 2;
            while (low >= 0 && high < len) {
                if (mid - nums[low] <= nums[high] - mid)
                    res[index--] = fun(nums[low--], a, b, c);
                else
                    res[index--] = fun(nums[high++], a, b, c);
            }
            while (low >= 0) {
                res[index--] = fun(nums[low--], a, b, c);
            }
            while (high < len) {
                res[index--] = fun(nums[high++], a, b, c);
            }
        }


        return res;
    }
    private int fun(int x, int a, int b, int c){
        return a * x * x + b * x + c;
    }

    public static void main(String[] args){
//        int[] arr = {-99,-94,-90,-88,-84,-83,-79,-68,-58,-52,-52,-50,-47,-45,-35,-29,-5,-1,9,12,13,25,27,33,36,38,40,46,47,49,57,57,61,63,73,75,79,97,98};
//        int a = -2;
//        int b = 44;
//        int c = -56;
//        SortTransformedArray obj = new SortTransformedArray();
//        int[]  res = obj.sortTransformedArray(arr, a, b, c);
////        Arrays.sort(res);
//        for(int i : res){
//            System.out.print(i + "\t");
//        }

        String a = "1245";
        String b = "1235";

        System.out.print(a.compareTo(b) );

    }

}
