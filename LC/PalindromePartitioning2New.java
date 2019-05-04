/**
 *
 * 采用DP规划，性能更优
 *
 */
package algorithm;

public class PalindromePartitioning2New {

    public int minimunCut(String s){
        int len=s.length();
        int[] minCut=new int[len+1];
        for (int i=0;i<len+1;i++) {
            minCut[i]=i-1;//minCut[k]代表长度为k之前需要剪切多少下，所以数组长度为n+1. n+1个数字代表着长度为n的剪切数
        }

        for(int i=0;i<len;i++){
            for(int j=0;(i-j>=0)&&(i+j<len)&&(s.charAt(i-j)==s.charAt(i+j));j++){//回文为奇数
                minCut[i+j+1]=(minCut[i-j]+1)<minCut[i+j+1]?(minCut[i-j]+1):minCut[i+j+1];
            }
            for(int j=1;(i-j+1>=0)&&(i+j<len)&&(s.charAt(i-j+1)==s.charAt(i+j));j++) {//回文为偶数
                minCut[i+j+1]=(minCut[i-j+1]+1)<minCut[i+j]?(minCut[i-j+1]+1):minCut[i+j];
            }
        }
        return minCut[len];
    }


    public static void main(String args[]){
        String s="fdaadfadfda";
        PalindromePartitioning2New obj=new PalindromePartitioning2New();
        System.out.println(obj.minimunCut(s));

    }


}
