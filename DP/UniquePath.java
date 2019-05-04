public class UniquePath {


    public int uniquePaths(int m,int n){

        int[][] result=new int[n][m];

        for(int i=0;i<m;i++){
            result[0][i]=1;
        }
        for(int i=0;i<n;i++){
            result[i][0]=1;
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                result[i][j]=result[i][j-1]+result[i-1][j];
            }
        }

        return result[n-1][m-1];

    }


    public static void main(String args[]){

        UniquePath obj =new UniquePath();

        System.out.println(obj.uniquePaths(2,3));
    }

}
