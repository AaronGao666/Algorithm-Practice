public class countPrime {
    public int countPrimes(int n) {

        if(n<=2){
            return 0;
        }


        boolean[] nonPrime =new boolean[n+1];
        for(int i=2;i<=n;i++){

            if(!nonPrime[i]){
                for(int j=i;j*i<=n && j*i>0;j++){

                    nonPrime[j*i]=true;
                }
            }
        }
        int count=0;
        for(int i=2;i<=n;i++){
            if(!nonPrime[i]){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){

        countPrime obj=new countPrime();
        System.out.println(obj.countPrimes(499979));

    }
}
