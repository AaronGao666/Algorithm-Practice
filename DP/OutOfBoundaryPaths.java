public class OutOfBoundaryPaths {


    public int findPaths(int m, int n, int N, int i, int j) {

        if(N==0){
            return 0;
        }
        int minStepNeeded=Math.min(Math.min(i+1,m-i),Math.min(j+1,n-j));
        if(minStepNeeded>N){
            return 0;
        }
        int[][][] dp=new int[N+1][m][n];//第一个纬度代表用了n步到达该点. 0就是0步
        //init:
        dp[0][i][j]=1;


        //@todo 你这里卡住的唯一原因，就是非要硬性计算出初始点的所有可能值。其实，第二步的初始值也是依赖于周围四个点的第一步的值的！！！！！！



        for(int steps=2;steps<=N;steps++){//从第2步开始计算回归原点的方式
            if(i%2==0){//代表偶数步
                int[][] temp=new int[m][n];
                for(int i1=0;i1<m;i++){
                    for(int j1=0;j1<n;j1++){
                        int distance=(Math.abs(j1-j)+Math.abs(i1-i));

                    }
                }
            }
        }


        return 0;
    }

}
