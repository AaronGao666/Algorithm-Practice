public class kEmptySlots {


    public int kEmptySlots(int[] flowers, int k) {

        int len=flowers.length;
        int[] days=new int[len];
        for(int i=0;i<len;i++){
            days[flowers[i]-1]=i+1;
        }
        System.out.println("days：");



        int day=-1;

        for(int i:days){
            System.out.print(i+"\t");
        }
        System.out.println("");


        for(int i=0;i<len-k-1;i++){

            int max=days[i]<days[i+k+1]?days[i+k+1]:days[i];
            System.out.println("max："+max);
            boolean exists=true;
            for(int j=i+1;j<i+k+1;j++){
                if(days[j]<max){
                    exists=false;
                    break;
                }
            }
            if(exists){
                day= day==-1? max:Math.min(max,day);
            }

        }
        return day;

    }


    public static void main(String[] args){

        int[] flo={1,3,2};
        int k=1;
        kEmptySlots obj=new kEmptySlots();
       System.out.println(obj.kEmptySlots(flo,k));
    }
}
