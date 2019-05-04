package algorithm;
import java.util.ArrayList;

public class CreatMaximumNumber {
    static int mindex=0;
    static int nindex=0;
    static int rindex=0;
    public int[] createMaxwithoutkickout(int[] m, int[] n){//一个不需要减去数字的排序函数
        int[] result=new int[m.length+n.length];
        if(m.length==0) {result=n; return result;}
        if(n.length==0) {result=m;return result;}
        while(mindex<m.length){
            while(nindex<n.length){
                if(m[mindex]<n[nindex]){
                    result[rindex]=n[nindex];
                    nindex++;
                    rindex++;
                }else{
                    result[rindex]=m[mindex];
                    mindex++;
                    rindex++;
                }
            }
        }
        return result;
    }

    public String checkBigNumber(int[] m,int[] n,int NeedToBeKickOut){
        ArrayList<Integer>[] mset=new ArrayList[10];//这两个是存储m和n的各个数据位置的链表数组
        ArrayList<Integer>[] nset=new ArrayList[10];//
        for(int i=0;i<10;i++){
            mset[i]=new ArrayList<Integer>();
            nset[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<m.length;i++){
            switch(m[i]){
                case 0:{mset[0].add(i);continue;}
                case 1:{mset[1].add(i);continue;}
                case 2:{mset[2].add(i);continue;}
                case 3:{mset[3].add(i);continue;}
                case 4:{mset[4].add(i);continue;}
                case 5:{mset[5].add(i);continue;}
                case 6:{mset[6].add(i);continue;}
                case 7:{mset[7].add(i);continue;}
                case 8:{mset[8].add(i);continue;}
                case 9:{mset[9].add(i);continue;}
            }
        }
        for(int i=0;i<n.length;i++){
            switch(n[i]){
                case 0:{nset[0].add(i);continue;}
                case 1:{nset[1].add(i);continue;}
                case 2:{nset[2].add(i);continue;}
                case 3:{nset[3].add(i);continue;}
                case 4:{nset[4].add(i);continue;}
                case 5:{nset[5].add(i);continue;}
                case 6:{nset[6].add(i);continue;}
                case 7:{nset[7].add(i);continue;}
                case 8:{nset[8].add(i);continue;}
                case 9:{nset[9].add(i);continue;}
            }
        }

        for(int i=9;i>=0;i--){
            boolean mcontinueflag=false;
            boolean ncontinueflag=false;

            if((!mset[i].isEmpty())&&mset[i].get(0)<=NeedToBeKickOut) mcontinueflag=true;
            if((!nset[i].isEmpty())&&nset[i].get(0)<=NeedToBeKickOut) ncontinueflag=true;
            
            if(!mcontinueflag&&!ncontinueflag) continue;//两个数据都不合格，需要减数字
            else if(mcontinueflag&&ncontinueflag){//俩都合格
                int moffset=mset[i].get(0);
                int[] mnew = new int[m.length-moffset-1];

                for(int index=0;index<m.length-moffset-1;index++){
                    mnew[index]=m[index+moffset+1];
                }
                int mntbko=NeedToBeKickOut-mset[i].get(0);
                int noffset=nset[i].get(0);
                int[] nnew = new int[n.length-noffset-1];
                for(int index=0;index<n.length-noffset-1;index++){
                    nnew[index]=n[index+noffset+1];
                }
                int nntbko=NeedToBeKickOut-mset[i].get(0);
                String ms=checkBigNumber(mnew,n,mntbko);//返回mset中的数据作为合格数据，找出第二位的大数
                String ns=checkBigNumber(m,nnew,nntbko);

                if(nnew[Character.getNumericValue(ns.charAt(1))]<mnew[Character.getNumericValue(ms.charAt(1))]){
                        String s="m"+mset[i].get(0);//虽然下一位有可能剔除够，但是这里无需考虑
                        return s;
                }else {//这里不考虑相等的情况？？@todo
                        String s="n"+nset[i].get(0);
                        return s;
                }
            }
            else if(mcontinueflag){//单独m数字合格
                if(mset[i].get(0)==NeedToBeKickOut){
                    String s="m"+mset[i].get(0)+"!";//表示作为这个数字以后已经能够剔除多余的数字了
                    return s;
                }
                else{
                    String s="m"+mset[i].get(0);//减去的数字不够
                    return s;
                }
            }
            else if(ncontinueflag){//
                if(nset[i].get(0)==NeedToBeKickOut){
                    String s="n"+nset[i].get(0)+"!";//表示作为这个数字以后已经能够剔除多余的数字了
                    return s;
                }
                else{
                    String s="n"+nset[i].get(0);
                    return s;
                }
            }
        }
        String wrong="WRONG!";
        return wrong;
    }
    ArrayList<String> resultarr=new ArrayList<>();
    int GlobalMoffset=0;
    int GlobalNoffset=0;
    public ArrayList<String> CreateMaximumNumber(int[] m, int[] n,int NeedToBeKickOut){//算法函数
        if(NeedToBeKickOut==0){
            int[] restresult=createMaxwithoutkickout(m,n);
            for (int k:restresult) {
                resultarr.add(k+"");
            }
            return resultarr;
        }//如果不需要剔除任何数字，则执行上述函数

        for(int i=0;i<m.length+n.length-NeedToBeKickOut;i++) {
           String s = checkBigNumber(m,n,NeedToBeKickOut);
           if(s.length()==3){//代表已经剔除够了
               if(s.charAt(0)=='m'){
                   int offset=Character.getNumericValue(s.charAt(1));
                   char[] c=s.toCharArray();
                   c[1]= (char) (c[1]+GlobalMoffset);
                   String s1=new String(c);
                   resultarr.add(s1);
                   int[] mnew=new int[m.length-offset-1];//删除该元素以后成立一个新数组
                   System.arraycopy(m,offset+1,mnew,0,m.length-offset-1);
                   int[] restresult=createMaxwithoutkickout(mnew,n);
                   for(int k:restresult){
                       resultarr.add(k+"");
                   }
                   return resultarr;
               }else{
                   int offset=Character.getNumericValue(s.charAt(1));
                   char[] c=s.toCharArray();
                   c[1]= (char) (c[1]+GlobalNoffset);
                   String s1=new String(c);
                   resultarr.add(s1);
                   int[] nnew=new int[n.length-offset-1];//删除该元素以后成立一个新数组
                   System.arraycopy(n,offset+1,nnew,0,n.length-offset-1);
                   int[] restresult=createMaxwithoutkickout(nnew,n);
                   for(int k:restresult){
                       resultarr.add(k+"");
                   }
                   return resultarr;
               }
           }else{//没有剔除够，继续
               int offset=Character.getNumericValue(s.charAt(1));
               NeedToBeKickOut=NeedToBeKickOut-offset;
               if(s.charAt(0)=='m') {
                   char[] c=s.toCharArray();
                   c[1]= (char) (c[1]+GlobalMoffset);
                   String s1=new String(c);
                   resultarr.add(s1);
                   GlobalMoffset+=offset+1;
                   int[] mnew = new int[m.length - offset - 1];//删除该元素以后成立一个新数组
                   System.arraycopy(m, offset + 1, mnew, 0, m.length - offset - 1);
                   return CreateMaximumNumber(mnew,n,NeedToBeKickOut);
               }else{
                   char[] c=s.toCharArray();
                   c[1]= (char) (c[1]+GlobalNoffset);
                   String s1=new String(c);
                   resultarr.add(s1);
                   GlobalNoffset+=offset+1;
                   int[] nnew = new int[n.length - offset - 1];//删除该元素以后成立一个新数组
                   System.arraycopy(n, offset + 1, nnew, 0, n.length - offset - 1);
                   return CreateMaximumNumber(m,nnew,NeedToBeKickOut);
               }
           }
       }
//函数报错会到这里
        ArrayList<String> wrong=new ArrayList<>();
        return wrong;
    }

    public static void main(String args[]){

        int[] m={0,4,4,7,9,7};
        int[] n={6,1,5,9,1,8};
        int k=6;
        CreatMaximumNumber obj= new CreatMaximumNumber();
        ArrayList<String> result=obj.CreateMaximumNumber(m,n,m.length+n.length-k);
        int[] finalresult=new int[result.size()];
        for(int i=0;i<result.size();i++){
            if(result.get(i).charAt(0)=='m'){//mx
                int mkey=result.get(i).charAt(1)-'0';
                finalresult[i]=m[mkey];
            }else if(result.get(i).charAt(0)=='n'){//nx
                int nkey=result.get(i).charAt(1)-'0';
                finalresult[i]=n[nkey];
            }else{
                finalresult[i]=result.get(i).charAt(0)-'0';
            }
        }
        System.out.println("最终结果是：");
        for (int key:finalresult) {
            System.out.print(key+",");
        }

    }
}
