import java.util.ArrayList;
import java.util.List;

public class ReverseInteger {
    public int reverse(int x) {

        if (x==0) return 0;

        boolean isPos=x>0;
        if(!isPos){
            x=-x;
        }
        List<Integer> list=new ArrayList<>();
        for(int i=10;i>0;i--){
            int num=(int) (x%(Math.pow(10,i)));
            num=(int)(num/Math.pow(10,i-1));
            if(num!=0){
                list.add(num);
            }else if(!list.isEmpty()){
                list.add(num);
            }

        }

        int len=list.size();
        if(len==10){
            if(list.get(len-1)>2){
                return 0;
            }
        }


        int newX=0;
        for(int i=0;i<len;i++){
            newX+=Math.pow(10,i)*list.get(i);
        }

        if(!isPos){
            newX=-newX;
        }
        return newX;
    }
    public  static void main(String[] args){



    }

}
