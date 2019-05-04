package LeetCodePackage;
//错的思路
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class WordBreakII_false {

    public ArrayList<String> getoneresult(String s,String[] wordDict){
        System.out.println("调用了getoneresult");
        int beginindex=0;
        int endindex=0;
        ArrayList<String> result=new ArrayList<>();
        for(beginindex=0;beginindex<s.length();beginindex++){
            for(endindex=beginindex+1;endindex<s.length();endindex++){
                String s1=s.substring(beginindex,endindex);

                if(endindex==s.length()-1){//找到最后
                    s1=s.substring(beginindex);
                    if(Arrays.binarySearch(wordDict,s1)>=0) {//找到了
                        System.out.println("找到一个"+s1);
                        result.add(s1);
                        beginindex=endindex;
                        break;
                    }
                    else {
                        result.clear();
                        return null;
                    }
                }
                else{ //没到最后
                    if(Arrays.binarySearch(wordDict,s1)>=0){//找到了
                        System.out.println("找到一个"+s1);
                        result.add(s1);
                        beginindex=endindex;
                    }
                    else continue;
                }
            }

        }
        return result;
    }


    public ArrayList<ArrayList<String>> WordBreakII_false(String s, String[] wordDict){
        Arrays.sort(wordDict);
        ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
        ArrayList<String> arr=new ArrayList<>();
        arr=getoneresult(s,wordDict);
        if(arr==null) return null;

        result.add(arr);
        String s1=s;
        String firstword=arr.get(0);
        int nextwordindex=firstword.length();
        do{
            firstword=s1.substring(0,nextwordindex+1);
//            System.out.println("nexworldindex:"+nextwordindex);
//            System.out.println(s.substring(nextwordindex+1));
            if(Arrays.binarySearch(wordDict,firstword)>=0){

                ArrayList<String> test=getoneresult(s.substring(nextwordindex+1),wordDict);
//                System.out.println("test"+test);
                if(test!=null){
                    ArrayList<String> oneresult=new ArrayList<>();
                    oneresult.add(firstword);
                    oneresult.addAll(test);//又一个合法结果
                    result.add(oneresult);
//                    System.out.println("result"+result);
                    nextwordindex++;
                }
                else {
                    nextwordindex++;
                }
            }
            else {
                nextwordindex++;
            }
        }while(nextwordindex<s1.length());

        return result;


    }


    public static void main(String args[]){
        String s="catsanddog";
        String[] wordDict={"cat","cats","and","sand","dog"};

        WordBreakII_false obj=new WordBreakII_false();
        ArrayList<ArrayList<String>> result=obj.WordBreakII_false(s,wordDict);
        System.out.println(result);
//        System.out.println("resultsize"+result.size());
//        for (ArrayList<String> arr:result) {
//            System.out.println("结果：");
//            for (String s666:arr) {
//                System.out.print(s666+',');
//            }
//
//        }


    }


}
