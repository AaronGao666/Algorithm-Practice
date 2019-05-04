import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class groupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String >> res=new ArrayList<>();
        List<int[]> list =new ArrayList<>();


        for(String s:strs){


            System.out.println("当前string："+s);

            int[] temp=new int[26];
            int len=s.length();
            for(int i=0;i<len;i++){
                temp[s.charAt(i)-'a']++;
            }



            if(list.isEmpty()){
                list.add(temp);
                List<String> l=new ArrayList<>();
                l.add(s);
                res.add(new ArrayList<>(l));
            }else{
                int size=list.size();
                boolean isSame=false;
                for(int i=0;i<size;i++){
                    isSame=true;
                    for(int j=0;j<26;j++){
                        if(temp[j]!=list.get(i)[j]){
                            isSame=false;
                            break;
                        }
                    }
                    if(isSame){
                        res.get(i).add(s);
                        break;
                    }

                }
                if(!isSame){
                    list.add(temp);
                    List<String> l=new ArrayList<>();
                    l.add(s);
                    res.add(new ArrayList<>(l));
                }
            }

//            for (int[] arr:  list     ) {
//                for(int i=0;i<26;i++){
//                    if(arr[i]!=0){
//                        System.out.print("第"+i+"个="+arr[i]+"\t");
//                    }
//                }
//                System.out.println("");
//            }



        }

        return res;

    }


    public static void main(String[] args){

        String[] strs={"eat","tea","tan","ate","nat","bat"};
        String[] strs1={"eat","teb","tan","ate","nat","bat"};
//        groupAnagrams obj=new groupAnagrams();
//        System.out.println(obj.groupAnagrams(strs));


        int[] arr1 = {0};
        int[] arr2 = {1};
        System.out.println(Arrays.hashCode(arr1) + " , "  + Arrays.hashCode(arr2));


    }





}
