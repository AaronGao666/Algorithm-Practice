package algorithm;
import java.util.*;
import java.math.*;
/*
尚未完成。。觉得无意义？？
 */
public class SplitArrayWithSameAverage {


    public float intArrayAverage(int[] a){
        float result=0;
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
        }
        result=sum/a.length;
        return result;
    }

    public int ClosestIndex(int[] a,float ave){
        float distance=Float.MAX_VALUE;
        int key=0;
        for(int i=0;i<a.length;i++){
            float temp=Math.abs(((float) a[i]-ave));
            if (temp<distance){
                distance=temp;
                key=i;
            }
        }
        return key;
    }


    public boolean SplitArrayWithSameAverage(int[] a, ArrayList<Integer> b,ArrayList<Integer> c){
        Arrays.sort(a);
        float ave=intArrayAverage(a);
        int closestkey=ClosestIndex(a,ave);




        return false;
    }



    public static void main(String[] args){

        int arraysize=(int) (Math.random()*29)+1;
        System.out.println("数组大小为："+arraysize);
        int[] randomdigitarray=new int[arraysize];
        int sum=0;
        for(int i=0;i<randomdigitarray.length;i++){
            randomdigitarray[i]=(int) (Math.random()*10000);
//            System.out.println("内容为"+i);
            sum+=randomdigitarray[i];
        }

        Arrays.sort(randomdigitarray);
//        for(int i:randomdigitarray){
//            System.out.println("内容为"+i);
//        }
        System.out.println(sum);

        for(int k=1;k<=arraysize/2;k++){
            if ((sum*k)%arraysize==0)
                System.out.println(k);
        }

    }
}
