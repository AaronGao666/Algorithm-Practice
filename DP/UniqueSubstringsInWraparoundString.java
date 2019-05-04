public class UniqueSubstringsInWraparoundString {



    public int findSubstringInWraparoundString(String p){

        int size=p.length();
        if(size==0){
            return 0;
        }
        int[] alphabet=new int[26];//每一个代表该字母出发，最长的连续段
        alphabet[p.charAt(size-1)-'a']=1;

        /**
         * 注意！！！！这里完全可以不用两重循环！！！效率很低！！！！答题思路很正确。
         */
        for(int i=0;i<size;i++){
            for(int j=i;j<size-1;j++){
                if(p.charAt(j)==(p.charAt(j+1)-1)||(p.charAt(j)=='z'&&p.charAt(j+1)=='a')){
                    if(j==size-2){//从i一直连续到p尾端
                        for(int k=i;k<size;k++){
                            alphabet[p.charAt(k)-'a']=Math.max(alphabet[p.charAt(k)-'a'],size-k);
                        }
                    }
                }else{
                    for(int k=i;k<=j;k++){
                        alphabet[p.charAt(k)-'a']=Math.max(alphabet[p.charAt(k)-'a'],j-k+1);
                    }
                    i=j;
                    break;
                }
            }
        }

        int result=0;
        System.out.println("计算后为：");
        for(int i:alphabet){
            System.out.println(i);
            result+=i;
        }

        return result;
    }
    public static void main(String args[]){

        String p="cac";
        UniqueSubstringsInWraparoundString obj =new UniqueSubstringsInWraparoundString();
        System.out.println("结果是"+obj.findSubstringInWraparoundString(p));
    }


}
