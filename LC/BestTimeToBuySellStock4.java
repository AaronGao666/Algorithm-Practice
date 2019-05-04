package algorithm;

import javax.management.ObjectName;
import javax.print.attribute.standard.NumberUp;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class BestTimeToBuySellStock4 {


    public ArrayList<int[]> findNumberInOrder(int[] prices){
        ArrayList<int[]> result=new ArrayList<>();
        for(int i=0;i<prices.length;i++){
            int temp=0;
            int max=0;
            int maxindex=i;
            for(int j=i;j<prices.length;j++){
                if(prices[i]<prices[j]){
                    temp=prices[j]-prices[i];
                    if(max<temp){
                        max=temp;
                        int[] pair=new int[2];
                        pair[0]=i;
                        pair[1]=j;
                        result.add(pair);
                    }
                }
            }
        }
        for(int i=0;i<result.size();i++){
            for(int j=i+1;j<result.size();j++){
                if((result.get(i)[1]>=result.get(j)[1])&&(result.get(i)[0]<result.get(j)[0])){
                    if((prices[result.get(j)[1]]-prices[result.get(j)[0]])>=(prices[result.get(i)[1]]-prices[result.get(i)[0]])){
                        result.remove(i);
                        i--;
                        break;
                    }//将i节点作废
                }
            }
        }
        return result;//剩下的都是有意义的操作
    }

//    public ArrayList<int[]> getMAX(int[] prices,ArrayList<int[]> Numbers,ArrayList<ArrayList <int[]>> Arrays){
//        ArrayList<int[]> result=new ArrayList<>();
//        if(Arrays==null&&Numbers!=null){
//            int[] NumberResult=new int[Numbers.size()];
//            int max=0;
//            int maxindex=0;
//            int[] head=new int[2];
//            for(int i=0;i<Numbers.size();i++){
//                NumberResult[i]=prices[Numbers.get(i)[1]]-prices[Numbers.get(i)[0]];
//                if(max<NumberResult[i]){
//                    max=NumberResult[i];
//                    maxindex=i;
//                }
//            }
//            head[0]=max;
//            head[1]=-1;
//            result.add(head);
//            result.add(Numbers.get(maxindex));
//        }
//        if (Numbers==null&&Arrays!=null){
//            int[] ArrayResult=new int[Arrays.size()];
//            int max=0;
//            int maxindex=0;
//            int[] head=new int[2];
//            for(int i=0;i<Arrays.size();i++){
//                for (int[] m: Arrays.get(i)) {
//                    ArrayResult[i]+=prices[m[1]]-prices[m[0]];
//                }
//                if(max<ArrayResult[i]){
//                    max=ArrayResult[i];
//                    maxindex=i;
//                }
//            }
//            head[0]=max;
//            head[1]=-1;
//            result.add(head);
//            result.addAll(Arrays.get(maxindex));
//        }
//        return result;
//    }
/*
方便打印的函数
* */
    public static void printArrArrInt(ArrayList<ArrayList<int[]>> obj){//输出双重链表的值
        for (ArrayList<int[]> arr:obj ) {
            for(int[] arr1:arr){
                System.out.print("["+arr1[0]+",");
                System.out.print(arr1[1]+"]");
            }
            System.out.println("");
        }
    }
/*
这是一个C（n,k）的函数，已经调试通过。目前用不到，
* */
    public ArrayList<ArrayList<int[]>> getPosibleArrays(int Combos,ArrayList<int[]> OneTimeResult){//返回指定几次的结果串，没有就是空。这个版本是遍历计算C（N，K）的，没有排除不合理情况

        ArrayList<ArrayList<int[]>> result=new ArrayList<>();
        if(Combos>OneTimeResult.size()){
            return null;
        }

        if(Combos==1){
            for(int i=0;i<OneTimeResult.size();i++){
                ArrayList<int[]> oneresult=new ArrayList<>();
                oneresult.add(OneTimeResult.get(i));
                result.add(oneresult);
            }
            return result;//
        }
        if(Combos==OneTimeResult.size()){//n==k
            ArrayList<int[]> oneresult=new ArrayList<>();
            oneresult.addAll(OneTimeResult);
            result.add(oneresult);
            return result;
        }
        else{
            int[] temp=OneTimeResult.get(OneTimeResult.size()-1);
            ArrayList<int[]> OneTimeResultCopy=(ArrayList<int[]>) OneTimeResult.clone();//克隆一个数组用于霍霍
            OneTimeResultCopy.remove(OneTimeResultCopy.size()-1);//拿去最后一个节点
            ArrayList<ArrayList<int[]>> firsthalf=getPosibleArrays(Combos-1,OneTimeResultCopy);
            for (ArrayList<int[]> arr:firsthalf) {
                arr.add(temp);
            }
            OneTimeResult.remove(OneTimeResult.size()-1);//拿去最后一个节点
            ArrayList<ArrayList<int[]>> secondhalf=getPosibleArrays(Combos,OneTimeResult);
            result=firsthalf;
            result.addAll(secondhalf);
            return result;
        }

    }
    /*
    基于C（n,k）的函数改造的，因为有很多内容（存在逆序对的）是不合规的，不需要遍历太多遍，浪费内存和时间。
    * */
    public ArrayList<ArrayList<int[]>> getValidPosibleArrays(int Combos,ArrayList<int[]> OneTimeResult){//返回指定几次的结果串，没有就是空。这个版本是遍历计算C（N，K）的，没有排除不合理情况

        ArrayList<ArrayList<int[]>> result=new ArrayList<>();
        if(Combos>OneTimeResult.size()){
            return null;
        }

        if(Combos==1){
            for(int i=0;i<OneTimeResult.size();i++){
                ArrayList<int[]> oneresult=new ArrayList<>();
                oneresult.add(OneTimeResult.get(i));
                result.add(oneresult);
            }
            return result;//
        }
        if(Combos==OneTimeResult.size()){//n==k
            for(int i=0;i<Combos-1;i++){
                if(OneTimeResult.get(i)[1]>=OneTimeResult.get(i+1)[0]) {//只要出现一个逆序对，则判定为不合格
                    return null;
                }
            }

            ArrayList<int[]> oneresult=new ArrayList<>();
            oneresult.addAll(OneTimeResult);
            result.add(oneresult);
            return result;
        }
        else{
            int[] temp=OneTimeResult.get(OneTimeResult.size()-1);
            ArrayList<int[]> OneTimeResultCopy=(ArrayList<int[]>) OneTimeResult.clone();//克隆一个数组用于霍霍
            OneTimeResultCopy.remove(OneTimeResultCopy.size()-1);//拿去最后一个节点
            ArrayList<ArrayList<int[]>> firsthalf=getValidPosibleArrays(Combos-1,OneTimeResultCopy);
            for(int i=0;i<firsthalf.size();i++){
                if(firsthalf.get(i).get(firsthalf.get(i).size()-1)[1]<temp[0]){//合格，可以拼接。
                    firsthalf.get(i).add(temp);
                }
                else{
                    firsthalf.remove(i);//整排移除。
                    i--;
                }
            }//得到最终的firsthalf。
            OneTimeResult.remove(OneTimeResult.size()-1);//拿去最后一个节点
            ArrayList<ArrayList<int[]>> secondhalf=getValidPosibleArrays(Combos,OneTimeResult);
            result=firsthalf;
            if(secondhalf!=null){
                result.addAll(secondhalf);
                return result;
            }else{
                return result;
            }
        }
    }

    public ArrayList<int[]> findMaxValue(ArrayList<ArrayList<int[]>> ArrArrInt,ArrayList<int[]> ArrInt,int[] prices){
        ArrayList<int[]> result=new ArrayList<>();
        if(ArrArrInt==null&&ArrInt!=null){//计算单维arraylist
            int max=0;
            int maxindex=0;
            int tempvalue=0;
            for(int i=0;i<ArrInt.size();i++){
                tempvalue=prices[ArrInt.get(i)[1]]-prices[ArrInt.get(i)[0]];//计算单步所得利润
                if(max<tempvalue){
                    max=tempvalue;
                    maxindex=i;
                }
            }
            int[] head=new int[2];
            head[0]=max;
            head[1]=-1;
            result.add(head);
            result.add(ArrInt.get(maxindex));
        }
        if(ArrArrInt!=null&ArrInt==null){//计算双维arraylist
            int max=0;
            int maxindex=0;
            for(int i=0;i<ArrArrInt.size();i++){
                int tempvalue=0;
                for(int j=0;j<ArrArrInt.get(0).size();j++){//遍历每一行的结果和
                    tempvalue+=prices[ArrArrInt.get(i).get(j)[1]]-prices[ArrArrInt.get(i).get(j)[0]];  //当前这一行的值
                }
                if(max<tempvalue){
                    max=tempvalue;
                    maxindex=i;
                }
            }
            int[] head=new int[2];
            head[0]=max;
            head[1]=-1;
            result.add(head);
            result.addAll(ArrArrInt.get(maxindex));
        }

        return result;
    }


    public ArrayList<int[]> maxProfit(int k, int[] prices){
        if(k>prices.length){
            System.out.println("K is greater than N!");
        }
        if(k>=prices.length/2){
            k=prices.length-k;
        }

        ArrayList<int[]> NumberPairs=findNumberInOrder(prices);
        ArrayList<int[]> NumberPairsCP1=(ArrayList<int[]>) NumberPairs.clone();

        ArrayList<ArrayList<int[]>> result=new ArrayList<>();
        ArrayList<int[]> istepvalue=findMaxValue(null,NumberPairsCP1,prices);
        result.add(istepvalue);
        for(int i=2;i<=k;i++) {
            ArrayList<int[]> NumberPairsCP2=(ArrayList<int[]>) NumberPairs.clone();
            ArrayList<ArrayList<int[]>> iStepsResult = getValidPosibleArrays(i, NumberPairsCP2);
            if(iStepsResult==null){
                break;
            }
            ArrayList<int[]> iStepValueGreaterThan1=findMaxValue(iStepsResult,null,prices);
            result.add(iStepValueGreaterThan1);
        }
        int max=0;
        int maxid=0;
        for(int i=0;i<result.size();i++){
            int temp=result.get(i).get(0)[0];
            if(max<temp){
                max=temp;
                maxid=i;
            }
        }
        return result.get(maxid);
    }

    public static void main(String args[]){
        int[] prices={3,2,6,5,0,3,5,7,2,9,12};
        int k=4;
        BestTimeToBuySellStock4 obj=new BestTimeToBuySellStock4();
        ArrayList<int[]> result=obj.maxProfit(k,prices);
        System.out.println("最大利益为："+result.get(0)[0]);
        System.out.println("操作步骤为：");
        for(int i=1;i<result.size();i++){
            System.out.print("("+result.get(i)[0]+","+result.get(i)[1]+")--->");
        }

    }
}
