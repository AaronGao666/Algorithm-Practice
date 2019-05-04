package algorithm;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Candy {


    public int Candy(int[] ratings){
        int n=ratings.length;//n名小朋友
        int[] getNums=new int[n];//前后各留下两个空余
        if(ratings[0]<=ratings[1]) getNums[0]=1;//虚拟一个头部节点
        else getNums[0]=Integer.MAX_VALUE;
        if(ratings[n-2]>=ratings[n-1]) getNums[n-1]=1;//虚拟一个尾部节点
        else getNums[n-1]=Integer.MAX_VALUE;
        for (int i=1;i<n-1;i++){
            if((ratings[i]<=ratings[i-1])&&(ratings[i]<=ratings[i+1])){
                getNums[i]=1;//找到峰谷
            }
            if((ratings[i]>=ratings[i-1])&&(ratings[i]>=ratings[i+1])){
                getNums[i]=Integer.MAX_VALUE;//找到峰顶
            }
        }

        int head=0;
        int tail=0;
        for(int i=0;i<n;i++){
            if(getNums[i]==0){
                head=i;
                for(int j=i;j<n;j++){
                    if(getNums[j]!=0) {
                        tail = j;
                        i=tail;
                        break;
                    }
                }
                if(getNums[head-1]==1){//代表升序
                    for(int k=head;k<tail;k++){
                        getNums[k]=k-head+2;
                    }
                }else{//降序
                    for(int k=tail-1;k>=head;k--){
                        getNums[k]=tail+1-k;
                    }
                }
            }
        }

        for(int i=0;i<n;i++){//最大值maxvalue的处理
            if(getNums[i]==Integer.MAX_VALUE){
                head=i;
                for(int j=i;j<n;j++){
                    if(getNums[j]!=Integer.MAX_VALUE){
                         tail=j;
                         i=tail;
                         break;
                    }
                }
                int max=getNums[head-1]>getNums[tail]?getNums[head-1]:getNums[tail];
                for(int k=head;k<tail;k++){
                    getNums[k]=max+1;
                }
            }
        }

        int result=0;
        for (int i:getNums) {
            result+=i;
        }

        return result;

    }


    public static void main(String args[]){
        int[] c={2,3,4,5,6,6,4,2,0,10,9,2,4,1};
        Candy obj=new Candy();
        int result=obj.Candy(c);
        System.out.println(result);

    }
}
