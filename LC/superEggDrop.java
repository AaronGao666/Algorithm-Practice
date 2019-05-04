/**
 * Not sure it's right or not
 * https://leetcode.com/problems/super-egg-drop/description/
 */
package algorithm;

public class superEggDrop {
    public int superEggDrop(int K, int N){

        int power = (int) (Math.log(N)/Math.log(2));
        int remains = 0;
        if( power-K >= 1 ){
            remains = (int)(N/Math.pow(2,K-1));//用掉k-1个鸡蛋以后，还剩下一个，此时确定的最低楼层
            return remains-1+K-1;
        }
        else return power+1;
    }

    public static void main(String args[]){
        int K = 1;
        int N = 2;

        superEggDrop obj = new superEggDrop();
        int result = obj.superEggDrop(K,N);
        System.out.println(result);

    }

}
