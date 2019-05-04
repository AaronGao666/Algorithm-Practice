/**
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * 从票数第一的C++答案照搬过来的，这算法真是牛逼
 */

package algorithm;
public class MinimunWindowSubstring {


    public String minWindow(String s, String t) {
        int[] frequency=new int[128];
        for (char c:t.toCharArray()) frequency[c]++;

        int counter=t.length();
        int slen=s.length();
        int begin=0;
        int end=0;
        int d=Integer.MAX_VALUE;
        int head=0;

        while(end<slen){
//            System.out.println("begin:"+begin+",head:"+head+",end:"+end+",scharatend:"+s.charAt(end));
            if((frequency[s.charAt(end++)]--)>0) counter--;
//            System.out.println("counter:"+counter);
            while(counter==0){
                if(end-begin<d)    d=end-(head=begin);
//                System.out.println("head"+head+",d:"+d+",begin:"+begin);
                if((frequency[s.charAt(begin++)]++)==0) counter++;//在这里将window重新invalid
            }
        }
//        System.out.println("head:"+head+",d:"+d);
        return d==Integer.MAX_VALUE?"":s.substring(head,head+d);

    }


    public static void main(String args[]){
        String s="ADOBECODEBANC";
        String t="ABC";
        MinimunWindowSubstring obj=new MinimunWindowSubstring();
        System.out.println(obj.minWindow(s,t));
    }


}
