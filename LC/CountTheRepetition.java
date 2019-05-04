/**
 * https://leetcode.com/problems/count-the-repetitions/
 */



package algorithm;

public class CountTheRepetition {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1=s1.length();
        int len2=s2.length();
        if(len1*n1<len2*n2) return 0;

        //初始化查重
        int t1=repititionTimes(s1);
        n1=n1*t1;
        s1=s1.substring(0,len1/t1);
        int t2=repititionTimes(s2);
        n2=n2*t2;
        s2=s2.substring(0,len2/t2);
        //结束。
//        System.out.println("s1:"+s1+"，n1:"+n1+"\n"+"s2:"+s2+"，n2:"+n2);
        for(char c:s2.toCharArray()){
            if(!s1.contains(Character.toString(c))){
                return 0;
            }
        }//简单初始判断

        int N=containsNumber(s1,s2);
        if(N>0){//证明s1包含至少1个s2
            return (N%1000)*n1/n2;
        }else{//需要多个s1来拼凑s2
            int info= Ns1ContainsOnes2(s1,s2);
            if(info>1000){
                return (info/1000)*n1/n2;
            }else{
                return ((n1-1)/info)/n2;
            }
        }
    }

    public int repititionTimes(String s){
        int len=s.length();
        int div=0;
        for(int i=len;i>1;i--){
            if(len%i==0){
                div=len/i;
                for(int j=0;j<len-div;j++){
                    if(s.charAt(j+div)!=s.charAt(j)){
                        break;
                    }
                    else if(j==len-div-1){
                        return i;
                    }
                }
            }
        }
        return 1;
    }


    public int containsNumber(String s1,String s2){
        int index=0;
        int count=0;
        int tail=0;
        int len1=s1.length();
        int len2=s2.length();
        for(int i=0;i<len1;i++){
            if(s1.charAt(i)==s2.charAt(index)){
                index++;
            }
            if(index==len2) {
                tail=i;
                index = 0;
                count++;
            }
        }
        count+=tail*1000;//将tail信息也保存到count里。Count不会大于100.到时候对1000取余就行了。
        return count;//如果没有则返回0
    }

    public int Ns1ContainsOnes2(String s1,String s2){
        int len2=s2.length();
        for(int i=1;i<=len2;i++){//需要i个s1
            String temp=s1;
            for(int j=1;j<i;j++){
                temp+=s1;
            }//N个s1
            int info=containsNumber(temp,s2);
            int tail=info/1000;
            int count=info%1000;
            if(count==1){
                if(temp.substring(tail+1).contains(s2.substring(0,1))){
                    return i-1;
                }//k*N+1
                else {
                    return i*1000;
                }
            }
        }
        return 0;
    }

    public static void main(String args[]){
        String s1="dcba";
        String s2="abcd";
        int n1=18;
        int n2=2;
        CountTheRepetition obj=new CountTheRepetition();
//        obj.getMaxRepetitions(s1,n1,s2,n2);
        System.out.println(obj.getMaxRepetitions(s1,n1,s2,n2));

    }
}
