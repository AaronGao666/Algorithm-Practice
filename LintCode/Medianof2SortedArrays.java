import java.util.Arrays;
public class Medianof2SortedArrays {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1=nums1.length;
        int len2=nums2.length;

        return findMedHelper(nums1,0,len1-1,nums2,0,len2-1);

    }

    public double findMedHelper(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2){

        int len1=e1-s1+1;
        int len2=e2-s2+1;


        boolean isEven1=len1%2==0;//偶数
        boolean isEven2=len2%2==0;

        if(len1==0){
            return isEven2?(nums2[len2/2]+nums2[len2/2-1])/2:nums2[len2/2];
        }
        if(len2==0){
            return isEven1?(nums1[len1/2]+nums1[len1/2-1])/2:nums1[len1/2];
        }

        int med1=isEven1?(nums1[len1/2]+nums1[len1/2-1])/2:nums1[len1/2];
        int med2=isEven2?(nums2[len2/2]+nums2[len2/2-1])/2:nums2[len2/2];


        if(len1==1){
            int index=Arrays.binarySearch(nums2,s2,e2,nums1[s1]);
            if(index>=0){
                if(index==len2/2){
                    return nums1[s1];
                }


            }



//            if(nums1[s1]>=nums2[e2]){
//                return findMedHelper(nums1,s1,s1-1,nums2,s2+1,e2);
//            }else if(nums1[s1]<=nums2[s2]){
//                return findMedHelper(nums1,s1,s1-1,nums2,s2,e2-1);
//            }


        }

        if(len2==1){



        }

        if(med1==med2){
            return med1;
        }else if(med1>med2){
            return findMedHelper(nums1,s1,e1-len1/2,nums2,s2+len2/2,e2);
        }else{
            return findMedHelper(nums1,s1+len1/2,e1,nums2,s2,e2-len2/2);
        }


    }



    public static void main(String[] args){
        int[] arr={1,3};
        System.out.println(Arrays.binarySearch(arr,2));
    }
}
