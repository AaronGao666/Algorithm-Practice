public class coinChange {
    public int coinChange(int[] coins, int amount) {

        return helper(coins, 0, amount, 0);

    }
    private int helper(int[] coins, int pos, int amount, int count){

        System.out.println(pos + "," + amount + "," + count);


        if(amount == 0){
            return count;
        }
        if(amount < 0){
            return -1;
        }

        int min = Integer.MAX_VALUE;
        for(int i = pos; i < coins.length; i ++){
            int temp = helper(coins, pos, amount - coins[i], count + 1);
            if(temp != -1){
                min = Math.min(min, temp);
            }else{
                break;
            }
        }

        return min;
    }
    public static void main(String[] args){
        int[] coins = {1,2,5};
        int amount = 11;
        coinChange obj = new coinChange();
        System.out.println(obj.coinChange(coins,amount));


    }
}
