/**
 * 状态表示选择错了！！！！这个题其实本质上就是一个可重复利用数字（对应本题的special的元素），然后取最大解的问题。
 */





import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingOffers {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {


        int offerTypes=special.size();
        int itemsTypes=price.size();
        int maxNoNeeds=0;
        for(int i:needs){
            maxNoNeeds=maxNoNeeds<=i?i:maxNoNeeds;
        }

        int[][] dp=new int[offerTypes][maxNoNeeds+1];//前i种offer，买了几个第i个offer，的最优价格

        for(int i=0;i<itemsTypes;i++){
            dp[0][0]+=price.get(i)*needs.get(i);
        }
        //初始化第一列。
        for(int i=1;i<=maxNoNeeds;i++){
            int currPrice=0;
            int[] currContainer= new int[itemsTypes];
            currPrice+=(special.get(0).get(itemsTypes))*i;//拿到i个第0个套餐以后的价格
            for(int item=0;item<itemsTypes;item++){
                currContainer[item]=special.get(0).get(item)*i;
            }
            for(int j=0;j<itemsTypes;j++){
                if(currContainer[j]>needs.get(j)){
                    currPrice=-1;//不合格的购买套餐
                    break;
                }else{
                    currPrice+=(needs.get(j)-currContainer[j])*price.get(j);
                }
            }
            dp[0][i]=currPrice;
        }
        //第一列初始化结束。

//        for (int i: dp[0]) {
//            System.out.println(i);
//        }
//
//        System.out.println("finished！");


        for(int i=1;i<offerTypes;i++) {//从第2个（i=1）套餐开始遍历
            for (int j = 0; j <= maxNoNeeds; j++) {//购买j个i套餐
                int currPrice = 0;
                int[] currContainer = new int[itemsTypes];
                currPrice += special.get(i).get(itemsTypes);//拿到j个这个套餐的初始价格
                for (int k = 0; k < itemsTypes; k++) {

                }
            }
        }

        return -1;
    }
    public static void main(String args[]){

        List<Integer> price =Arrays.asList(2,3,4);
        List<List<Integer>> special=new ArrayList<>();
        List<Integer> s1=Arrays.asList(1,1,0,4);
        List<Integer> s2=Arrays.asList(2,2,1,9);
        special.add(s1);
        special.add(s2);
        List<Integer> needs=Arrays.asList(1,2,1);
        ShoppingOffers obj= new ShoppingOffers();
        obj.shoppingOffers(price,special,needs);


    }
}
