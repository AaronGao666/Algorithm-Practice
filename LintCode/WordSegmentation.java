package Google1808;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;

public class WordSegmentation {


    public String[] wordSegmentation(String s, int k) {

        ArrayList<String> list=new ArrayList<>();
        int len=s.length();
        for(int i=0;i<len;){
            if(i+k>=len-1){
                list.add(s.substring(i));
                break;
            }
            if(s.charAt(i+k)==' '){
                list.add(s.substring(i,i+k));
                i=i+k+1;
            }else{
                for(int j=i+k;j>i;j--){
                    if(s.charAt(j)==' '){
                        list.add(s.substring(i,j));
                        i=j+1;
                    }
                }

            }
        }
        int resultSize= list.size();
        String[] arr=new String[resultSize];
        for(int i=0;i<resultSize;i++){
            arr[i]= list.get(i);
        }
        return arr;

    }
    public static void main(String[] args){

        String s="aaaa bbb cccc ddd ee ff ggggg";
        int k=8;
        WordSegmentation obj=new WordSegmentation();
        obj.wordSegmentation(s,k);

    }

}
