package Google1808;


public class WordsCompression {



    public int[] wordsCompression(String[] s) {

        int len=s.length;
        int[] result=new int[len];
        if(len==0){
            return null;
        }
        String currStr=s[0];
        for(int i=1;i<len;i++){
            int currLen=currStr.length();
            int sLen=s[i].length();
            int max,start=0;
            if(currLen>=sLen){
                max=sLen;
                start=currLen-sLen;
            }else{
                max=currLen;
            }

            for(int j=start;j<max;j++){
                for(int k=j;k<max;k++){
                    if(s[i].charAt(k-start)!=currStr.charAt(k)){
                        break;
                    }else if(k==max-1){

                    }
                }
            }

//            for(int j=min;j>0;j--){
//                String sub=s[i].substring(0,j);
//                String currSub=currStr.substring(currLen-j);
//                if(currSub.equals(sub)){
//                    int index=currStr.indexOf(s[i]);
//                    result[i]=index==-1?(currLen-j):index;
//                    currStr+=s[i].substring(j);
//                    break;
//                }else if(j==1){
//                    currStr+=s[i];
//                    int index=currStr.indexOf(s[i]);
//                    result[i]=index==-1?currLen:index;
//                }

//            }

        }
        return result;
    }

    public static void main(String[] args){
        String[] s={"a","b","a","a","cacb"};
        WordsCompression obj=new WordsCompression();
        obj.wordsCompression(s);

    }

}
