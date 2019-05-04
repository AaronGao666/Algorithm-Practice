package Google1808;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimalDistanceInArray {



    public int[] minimalDistance(int[] a, int[] b) {

        Arrays.sort(a);
        int alast=a[a.length-1];
        int afirst=a[0];
        int len=b.length;
        int[] result=new int[len];
        for(int i=0;i<len;i++){
            if(b[i]>=alast){
                result[i]=alast;
            }else if(b[i]<=afirst){
                result[i]=afirst;
            }else{
                int pos= Arrays.binarySearch(a,b[i]);
                if(pos<0){
                    if(pos==-1) result[i]=afirst;
                    result[i]=Math.abs(a[-pos-1]-b[i])<Math.abs(a[-pos-2]-b[i])?a[-pos-1]:a[-pos-2];
                }else{
                    result[i]=b[i];
                }
            }
        }

        return result;

    }


    public static void main(String[] args){

        int[] a={3,-1,7,6,5,-4,-2,7};
        Arrays.sort(a);
        for (int i: a) {
            System.out.print(i+"\t");
        }
        System.out.println(Arrays.binarySearch(a,0));



    }
}
