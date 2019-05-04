/**
 *错误的，思路混乱了。
 *
 */






package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class KthSmallestLexicographical {


//    public int findRightNumber(int base,int step, int inspectedNum){//返回几个步长
//        if(inspectedNum<=base) return 0;
//        if (step<=0) return 0;
//        for(int i=0;;i++){
//            if((base+step*i)<=inspectedNum&&(base+step*(i+1))>=inspectedNum){
//                return i;
//            }
//        }
//    }
    public int[] findRightPath(int len, int k){
        int step=0;//多少位数就有多少个1
        for (int i=0;i<len;i++) {
            step+=Math.pow(10,i);
        }
        int[] result=new int[len];
        for(int i=0;i<len;i++){//位数循环
            for(int j=0;j<=9;j++){//步长探测
                if((j*step<=k)&&((j+1)*step>k)){
                    result[i]=j;
                    k-=j*step;
                }
            }
            step=step/10;
        }
        return result;
    }

    public int findKthNumber(int n, int k){
//        if (n<=10){
//            return k;
//        }

        char[] digitchar=(Integer.toString(n)).toCharArray();
        int len=digitchar.length;
//        System.out.println("位数"+len);
        int[] digit=new int[len];
        for(int i=0;i<len;i++){
            digit[i]=digitchar[i]-'0';
        }
        int[] ones=new int[len];
        int oneCount=0;
        for(int i=len-1;i>=0;i--){
            oneCount+=Math.pow(10,len-1-i);
            ones[i]=oneCount;
        }
//        for(int i:ones){
//            System.out.println(i);
//        }
        //找到n在字典顺序里拍第几
        int count=(digit[0]-1)*ones[0];
        for(int i=1;i<len;i++){
//            System.out.println(count);
            count+=(digit[i])*ones[i];
            System.out.println(count);
        }
        count+=len;

//        System.out.println("最后："+count);

    return 0;
    }

    public static void main(String args[]){
        int n=123321321;
        int k=634;
        KthSmallestLexicographical obj=new KthSmallestLexicographical();
        int[] result=obj.findRightPath(Integer.toString(n).length(),k);
        for (int i: result){
            System.out.println(i);
        }


    }


}
