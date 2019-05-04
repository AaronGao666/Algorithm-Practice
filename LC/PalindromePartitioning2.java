///*
//* 这个版本完全不行！！！
//* 使用DP规划更好！！！！
//* */
//
//
//
//
//package LeetCodePackage;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Stack;
//
//public class PalindromePartitioning2 {
//
//
//    public static boolean isPalindromeString(String s){
//        int len=s.length();
//        if(len==1) return true;
//        int halflen=len/2;
//            for(int i=0;i<halflen;i++){
//                if(s.charAt(i)!=s.charAt(len-i-1)){
//                    return false;
//                }
//                else if(i==halflen-1){
//                    return true;
//                }
//                else continue;
//            }
//            return false;
//    }//String的性能应该不如char array
//
//    public static boolean isPalindromeCharArray(char[] c){
//        int len=c.length;
//        int halflen=len/2;
//        if(len==1) return true;
//
//        for(int i=0;i<halflen;i++){
//            if(c[i]!=c[len-i-1]){
//                return false;
//            }
//            else if(i==halflen-1){
//                return true;
//            }
//            else continue;
//        }
//        return false;
//    }
//
//
//    public static void printchar(char[] c){
//        for(char i:c){
//            System.out.print(i+",");
//        }
//        System.out.println("");
//    }
//
//
//    public ArrayList<Integer> findAllPalindromeFromIndex(char[] c,int index){//index为从第几位开始算。应该可以省空间？
//        ArrayList<Integer> result=new ArrayList<>();
//        for(int i=index+1;i<c.length;i++){
//            char[] c1= Arrays.copyOfRange(c,index,i+1);
//            System.out.print("c1:");
//            printchar(c1);
//            //System.out.println("c1起始位置"+c1[0]+","+c1[c1.length-1]);
//            if(isPalindromeCharArray(c1)){
//                result.add(i);
//                System.out.println(i+"是符合要求的index！");
//            }
//        }
//        return result;
//    }
//
//    public ArrayList<ArrayList<Integer>> findAllPalindrome(char[] c){
//        int len=c.length;
//        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
//        for(int i=0;i<len-1;i++){//遍历到倒数第二个元素
//            ArrayList<Integer> tempresult=findAllPalindromeFromIndex(c, i);
//            result.add(tempresult);
//        }
//        return result;
//    }
//
//
//
//
//    public int minimunCut(String s){//主算法函数
//        char[] c=s.toCharArray();
//        ArrayList<ArrayList<Integer>> arr=findAllPalindrome(c);
//        int lenth=arr.size();
////        int[] cutCount=new int[arr.size()];
//        for(int i=0;i<lenth;i++){
//            if(arr.get(i)==null) continue;
//            for(Integer j:arr.get(i)){
//
//
//            }
//
//
//
//        }
//
//
//
//
//    }
//
//
//
//    public static void main(String args[]){
//    String s="1232112321";
//    char[] c=s.toCharArray();
//    PalindromePartitioning2 obj=new PalindromePartitioning2();
////    ArrayList<Integer> result=obj.findAllPalindromeFromIndex(c,0);
////        for(Integer i:result){
////            System.out.print(i+",");
////        }
//
//
//    ArrayList<ArrayList<Integer>> result=obj.findAllPalindrome(c);
//        System.out.println("resultsize:"+result.size());
//    for(ArrayList<Integer> arr:result){
//        System.out.print("=>");
//        for(Integer i:arr){
//            System.out.print(i+",");
//        }
//        System.out.println("");
//    }
//
//
//    }
//}
