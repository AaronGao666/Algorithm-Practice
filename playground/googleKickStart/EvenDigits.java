package googleKickStart;

public class EvenDigits {

    public int EvenDigits(int num) {


        char[] chars = (num + "").toCharArray();
        int len = chars.length;
        int[] number = new int[len];
        int firstOdd = -1;
        for (int i = 0; i < len; i++) {
            number[i] = chars[i] - '0';
            if (firstOdd == -1 && number[i] % 2 != 0) firstOdd = i;
        }

        if (firstOdd == -1) return 0;


        int lower= number[firstOdd] - 1;
        int higher = number[firstOdd] + 1;
        number[firstOdd] = lower;
        for (int i = firstOdd + 1; i < len; i++) {
            number[i] = 8;
        }
        lower = 0;
        for (int i = 0; i < len; i++) {
            lower *= 10;
            lower += number[i];
        }

        System.out.println(lower);
        int res = num - lower;
        System.out.println(res);


        System.out.println(higher);
        if(higher != 10){
            number[firstOdd] = higher;
            for (int i = firstOdd + 1; i < len; i++) {
                number[i] = 0;
            }

            higher = 0;
            for (int i = 0; i < len; i++) {
                higher *= 10;
                higher += number[i];
            }
            System.out.println(higher);
            res = Math.min(res, higher - num);
        }



        return res;
    }


    public static void main(String[] args){

//        int num = 6687431;
//        System.out.println(new EvenDigits().EvenDigits(num));

        char a = 'z';
        System.out.println((int)a);


    }


}
