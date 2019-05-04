public class CountingBits {


    public static int[] countBits(int num){

        int[] result =new int[num];
        result[0]=0;
        result[1]=1;
        for(int i=0;i<num;i++){
            if(i%2==0){
                result[i]=result[i/2];
            }else{
                result[i]=result[i-1]+1;
            }

        }
        return result;
    }


    public static void main(String args[]){

        int[] arr=countBits(20);
        for (int i:arr) {
            System.out.print(i+",");
        }


    }

}
