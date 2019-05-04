public class mergeArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<m;i++){
            if(nums1[i]<=nums2[0]){
                continue;
            }

            for(int j=0;j<n;j++){
                if(nums1[i]<=nums2[j]){//j-1 should be swaped
                    int temp=nums2[j-1];
                    nums2[j-1]=nums1[i];
                    nums1[i]=temp;
                    break;
                }
            }
        }

        for(int i=0;i<n;i++){
            nums1[i+m]=nums2[i];
        }

    }


    public static void main(String[] args){

        int[] nums1={1,2,3,0,0,0};
        int m=3;
        int[] nums2={2,5,6};
        int n=3;
        mergeArray obj =new mergeArray();
        obj.merge(nums1,m,nums2,n);

        for(int i:nums1){
            System.out.print(i+"\t");
        }


    }


}
