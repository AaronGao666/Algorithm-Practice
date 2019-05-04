public class FindMedianSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        return (helper(0, 0, nums1, nums2, (len1 + len2 + 1) / 2) + helper(0, 0, nums1, nums2, (len1 + len2 + 2) / 2)) / 2.0;

    }


    private int helper(int s1, int s2, int[] nums1, int[] nums2, int k) {


        System.out.println(s1 + "," + s2 + "," + k);
        if (s1 == nums1.length) {
            return nums2[s2 + k - 1];
        }

        if (s2 == nums2.length) {
            return nums1[s1 + k - 1];
        }
        if (k == 1) {
            System.out.println("这里返回：" + s1 + "," + s2 + "," + k);
            return nums1[s1] < nums2[s2] ? nums1[s1] : nums2[s2];
        }


        if (s1 + k / 2 >= nums1.length) {
            int diff = nums1.length - s1;//nums1 还剩多少个
            if (nums1[nums1.length - 1] <= nums2[s2 + diff - 1]) {  //全部扔掉
                System.out.println("zherer");
                return nums2[s2 + k - diff - 1];
            } else {
                return helper(s1, s2 + diff, nums1, nums2, k - diff); //nums2  扔掉了diff个
            }
        }

        if (s2 + k / 2 >= nums2.length) {
            int diff = nums2.length - s2;
            if (nums2[nums2.length - 1] <= nums1[s1 + diff - 1]) {
                System.out.println("fdasfdaf");

                return nums1[s1 + k - diff - 1];
            } else {
                return helper(s1 + diff, s2, nums1, nums2, k - diff);
            }
        }


        int mid1 = nums1[s1 + k / 2 - 1];

        int mid2 = nums2[s2 + k / 2 - 1];

        System.out.println(mid1 + ", mid2 = " + mid2);
        if (mid1 < mid2) {
            return helper(s1 + k / 2, s2, nums1, nums2, k - k / 2);
        } else {
            return helper(s1, s2 + k / 2, nums1, nums2, k - k / 2);
        }


    }


    public static void main(String[] args) {

        int[] a = {1, 2};
        int[] b = {-1, 3};
        FindMedianSortedArray obj = new FindMedianSortedArray();
        System.out.println(obj.findMedianSortedArrays(a, b));

    }
}
