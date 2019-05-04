package algorithm;

public class SelfCrossing {

    public boolean isSelfCrossing(int[] x){
        int len=x.length;
        if(len<4) return false;//少于4条边是不可能交叉的
        int key=0;
        for(int i=0;i<len-2;i++){
            if(i==len-3) return false;//遍历到最后都是扩张的图形

            if(x[i+2]<=x[i]){
                key=i;
                break;
            }
        }
        System.out.println(key);
        if(key>2){//这一段是用来判断两个卷的相对位置
            if(x[key]>(x[key+2]+x[key-2])){
                x[key]-=x[key-2];
            }else{
                key++;
                x[key]-=x[key-2];
            }
        }
        System.out.println(key);
        return isSelfCrossingWithCollapsing(x,key);
    }
    public boolean isSelfCrossingWithCollapsing(int[] x,int key){
        int len=x.length;
        for(int i=key;i<len-2;i++){
            if(x[i+2]>=x[i]) return true;//交叉
        }
        return false;
    }

    public static void main(String args[]){
        int[] x={1,2,10,9,4,3,2,1,10};
        SelfCrossing obj=new SelfCrossing();
        System.out.println(obj.isSelfCrossing(x));
    }
}
