public class StudentAttendanceRecordII {

    int mod = (int)Math.pow(10,9) + 7;
    public int checkRecord(int n) {

        if(n == 1) return 3;
        int minP = (n-2)/3 + ((n-2)%3 == 0? 0 : 1);
        int maxP = n;
        int res = 0;
        System.out.println(minP + "," + maxP);
        for(int p = minP; p <= maxP; p ++){
            //have p + 1 spaces.

            int l = n - p;
            int minLL = l > p + 1 ? l - p - 1 : 0;
            int maxLL = l/2;
            long temp = 0;
            System.out.println("\n p="+p+", minLL=" +minLL +", maxLL=" + maxLL + ", l=" + l + "") ;


            long cMax= 0;
            for(int LL = minLL; LL <= maxLL; LL ++){



                long c1 = combine(p + 1, LL);
                long c2 = combine(p + 1 - LL, l - 2 * LL);
                System.out.println("c1(" + (p + 1) + " ," + LL + ")= "+c1+"  , c2("+ (p+1-LL) + " ," + (l - 2*LL) + ")=" + c2);

                long c3= c1*c2;
                cMax = Math.max(c3, cMax);

                long c = (c1*c2) % mod;
//                System.out.println("两者乘=" +c);

                temp += c;
                temp %= mod;

            }
//            if(cMax > mod) System.out.println("cMax = " + cMax);

            res += (temp * (p + 1) ) % mod;
            res %= mod;
        }


        return res;

    }

    private long combine(int n , int k){
        if(k == 0) return 1;
        if(n == k){
            return 1;
        }
        long res = 1;
        for(int i = n - k + 1; i <=n; i ++){
            res *= i;
        }
        for(int i = 1; i <= k; i ++){
            res /= i;
        }
        return (res % mod);
    }



    public static void main(String[] args){
        StudentAttendanceRecordII obj = new StudentAttendanceRecordII();
//        System.out.println(obj.mod);
        System.out.println(obj.checkRecord(38));



//        System.out.println(obj.combine(4,1));


    }
}
