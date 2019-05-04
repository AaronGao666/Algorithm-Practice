package algorithm;
import sun.awt.AWTAccessor;

import  java.util.*;
public class medianOfTwoSortedArrays {



    public double findMedianSortedArrays(int[] nums1,int[]nums2){

//        System.out.println("数组1长度为："+nums1.length+"， 数组2长度为："+nums2.length);
//        System.out.println("nums1[0]="+nums1[0]+",   nums2[0]="+nums2[0]);
//        System.out.println("nums1[1]="+nums1[1]+",   nums2[1]="+nums2[1]);
        int x=(int)nums1.length/2;//按照坐标算，已经是n/2+1了。
        int y=(int)nums2.length/2;
        int[] highmedian=(nums1[x]>=nums2[y])?nums1:nums2;
        int[] lowmedian=(nums2[y]<=nums1[x])?nums2:nums1;
        x=(int) highmedian.length/2;//x表示较大中位数数组的中位数坐标
        y=(int) lowmedian.length/2;
//        System.out.println("highmedian="+highmedian[x]+",  lowmedian="+lowmedian[y]);
        int x1=0;
        int y1=0;
        for(int i=y;i<lowmedian.length;i++){
            if(lowmedian[i]>=highmedian[x]||i==lowmedian.length-1){
                y1=i;
                break;
            }

        }
        for(int i=x;i>=0;i--){
            if(highmedian[i]<=lowmedian[y]||i==0){
                x1=i;
                break;
            }
        }


        int smallerNo=y+x1;//比较小中位数还要小的两个数组内的数字的总个数
        int biggerNo=highmedian.length-x-1+lowmedian.length-y1-1;
//        System.out.println("smallerNo="+smallerNo+",    biggerNo="+biggerNo);

        if(smallerNo==0){//低中位数的数组长度已经为2或1
            int[] result=new int[highmedian.length+lowmedian.length];
            if(lowmedian.length==2){
                result[0]=lowmedian[0];
                result[1]=lowmedian[1];
                for(int i=2;i<highmedian.length+2;i++){
                    result[i]=highmedian[i-2];
                }
            }
            else if(lowmedian.length==1){
                result[0]=lowmedian[0];
                for(int i=1;i<highmedian.length+1;i++){
                    result[i]=highmedian[i-1];
                }
            }
            Arrays.sort(result);
            if(result.length%2!=0) return result[(int)(result.length/2)];
            else return (result[result.length/2-1]+result[result.length/2])/2;

        }
        if(biggerNo==0){
            int[] result=new int[highmedian.length+lowmedian.length];
            for(int i=0;i<lowmedian.length;i++){
                result[i]=lowmedian[i];
            }
            if(highmedian.length==2){
                result[lowmedian.length]=highmedian[0];
                result[lowmedian.length+1]=highmedian[1];
            }
            else if(highmedian.length==1){
                result[lowmedian.length]=highmedian[0];
            }
            Arrays.sort(result);

            if(result.length%2!=0) return result[(int)(result.length/2)];
            else return (((float)result[(result.length/2)-1]+(float) result[result.length/2])/2);

        }


        //开始修剪掉多余数值，只保留两个数组的各自中间段
        if(smallerNo>=biggerNo){

                int count=smallerNo-biggerNo;
                for(int i=x1;i>0;i--){
                    if(count>0) {
                        for (int j = y; j > 0; j--) {
                            if (highmedian[i] <= lowmedian[j]) {
                                y = j;
                                count--;
                            } else {
                                x1 =i;
                                count--;
                                break;
                            }
                        }
                    }
                    else break;
                }

        }
        else{//较大数字较多

                int count=biggerNo-smallerNo;
                for(int i=x;i<highmedian.length;i++){
                    if(count>0) {
                        for (int j = y1; j < lowmedian.length; j++) {
                            if (highmedian[i] >= lowmedian[j]) {
                                y = j;
                                count--;
                            } else {
                                x1 =i;
                                count--;
                                break;
                            }
                        }
                    }
                    else break;
                }
        }


//        System.out.println("y="+y+",   y1="+y1);
//        System.out.println("x="+x+",   x1="+x1);
        int[] highmediannew=new int[x-x1+1];
        int[] lowmediannew=new int[y1-y+1];
        for(int i=0;i<x-x1+1;i++){
            highmediannew[i]=highmedian[x1+i];
        }
        for(int i=0;i<y1-y+1;i++){
            lowmediannew[i]=lowmedian[y+i];
        }
        return findMedianSortedArrays(highmediannew,lowmediannew);


    }


    public static void main(String[] args){
        int[] a1={0,1,7,9,10,15,20};
        int[] a2={0,1,7,8,9,10,15};

        medianOfTwoSortedArrays test=new medianOfTwoSortedArrays();
        System.out.println(test.findMedianSortedArrays(a1,a2));
    }
}
