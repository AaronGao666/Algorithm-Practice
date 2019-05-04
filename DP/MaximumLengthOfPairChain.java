import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximumLengthOfPairChain {


//    public int findLongestChain(int[][] pairs) {
//
//        int n=pairs.length;
//
////        quickSort(pairs);
//
//
//
//        //如果不排序，直接dp：这是一个0/1背包问题。
//
//        //@todo 卧槽做不出来！！！
//
//        boolean[][] dp=new boolean[n][n+1];//用前n个数，能不能组成n的长度。
//        for(int i=0;i<n;i++){//无论前几个，组成1总是没问题的
//            dp[i][0]=true;
//            dp[i][1]=true;
//        }
//
//
//
//
//
//
//
//
//        int[] dp=new int[n];
//
//
//
//
//    }
    public static void quickSort(int[][] pairs,int start, int end){
        if(end==start){
            return;
        }
//        System.out.println("start="+start+"，end="+end+"处理之前的pair：");
//        printPairs(pairs);
        if(end-start==1){
            if(pairs[end][0]<pairs[start][0]){
                swap(pairs[end],pairs[start]);
            }
            return;
        }
        int i=start,j=end-1;
        while(i<j){
            if(pairs[i][0]<=pairs[end][0]){
                i++;
                continue;
            }
            if(pairs[j][0]>=pairs[end][0]){
                j--;
                continue;
            }
            swap(pairs[i],pairs[j]);
        }
        if(pairs[end][0]<pairs[j][0]){
            swap(pairs[end],pairs[j]);
        }

//        System.out.println("当前i="+i+"，j="+j+"处理之后的pair：");
//        printPairs(pairs);

        quickSort(pairs,start,i-1);
        quickSort(pairs,j+1,end);

    }

    public static void swap(int[] a,int[] b){
        int t0=a[0];
        int t1=a[1];
        a[0]=b[0];
        a[1]=b[1];
        b[0]=t0;
        b[1]=t1;
    }

    public static void printPairs(int[][] pairs){
        System.out.println("result:");
        for(int[] arr:pairs){
            for(int i:arr){
                System.out.print(i+"\t\t");
            }
            System.out.println("");
        }
        System.out.println("finished");
    }

    public static void printPairs(char[][] pairs){
        System.out.println("result:");
        for(char[] arr:pairs){
            for(char i:arr){
                System.out.print(i+"\t\t");
            }
            System.out.println("");
        }
        System.out.println("finished");
    }

    public static void main(String args[]){

        int[][] pairs={
                {1,2},
                {3,4},
                {2,10},
                {10,12},
                {3,6},
                {5,10},
                {2,4},
                {7,9},
                {8,10}

        };
        printPairs(pairs);
//        quickSort(pairs,0,pairs.length-1);
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));



        printPairs(pairs);


        int[] test={1,10,8,4,2,1,9,20,15};

        Integer[] test1=new Integer[]{1,10,8,4,2,1,9,20,15};
        Comparator<Integer> c= Collections.reverseOrder();
        Arrays.sort(test1,c);
        for(int i:test1){
            System.out.println(i);
        }


        char[][] pairs1={
                {'a','b'},
                {'q','s'},
                {'c','d'},
                {'d','e'},
                {'m','q'},
                {'l','o'},
                {'t','w'},
                {'f','g'},
                {'h','k'},

        };

        printPairs(pairs1);
        Arrays.sort(pairs1, (a, b) -> (a[0] - b[0]));
        printPairs(pairs1);

//        for(int i=0;i<pairs.length;i++){
//            int j=i;
//            while(j<pairs.length){
//                if(pairs[j][0]!=pairs[i][0]){
//                    break;
//                }
//                j++;
//            }
//            if(i>j+1){
//                System.out.println(i+"j="+j);
//                quickSort(pairs,1,i,j);
//            }
//        }
//        printPairs(pairs);
    }

}
