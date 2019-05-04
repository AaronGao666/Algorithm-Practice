import java.sql.SQLSyntaxErrorException;
import java.util.*;
public class checkInclusion {


    public boolean checkInclusion(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 > len2){
            return false;
        }

        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < len1; i++){
            char c = s1.charAt(i);
            freq.put(c, freq.getOrDefault(c,0) + 1);
        }

        for(char c : freq.keySet()){
            System.out.print(c +","+freq.get(c)+ "\t");
        }
        System.out.println("");


        for(int i = 0; i <= len2 - len1; i ++){
            char c = s2.charAt(i);
            System.out.println(c);
            if(!freq.containsKey(c)){
                continue;
            }
            HashMap<Character, Integer> temp = new HashMap<>(freq);


//            for(char cs : freq.keySet()){
//                System.out.print(cs +","+freq.get(cs)+  "\t");
//            }
//            System.out.println("");




            boolean needValid = true;
            for(int j = i; j < len1 + i; j ++){
                char cj = s2.charAt(j);
                if(!temp.containsKey(cj)){
                    i = j;
                    needValid = false;
                    break;
                }
                temp.put(cj,temp.get(cj) - 1);
            }



            if(needValid){

                for(char t : temp.keySet()){
                    if(temp.get(t) != 0){
                        needValid = false;
                        break;
                    }
                }

                if(needValid) return true;
            }
            System.out.println("zheer");
        }


        return false;

    }

    public static void main(String[] args){


//        String s1 = "ab";
//        String s2 = "eidbaooo";
//        checkInclusion obj = new checkInclusion();
//        System.out.println(obj.checkInclusion(s1, s2));


        Integer[] nums = {1,2,3,45,5,132,15,1231,90};
        String[] strs = new String[nums.length];
        for(int i =0;i < nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });




        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });


        for(String s : strs){
            System.out.println(s);
        }

    }
}
