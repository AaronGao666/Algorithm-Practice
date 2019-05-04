public class MinimumPathSum {

    public int minPathSum(int[][] grid) {

        int width=grid[0].length;
        int rows=grid.length;

        int[] arr=new int[width];
        arr=grid[0];
        for(int i=1;i<width;i++){
            arr[i]+=arr[i-1];
        }
        printarr(arr);
        for (int i=1;i<rows;i++) {
            arr[0]+=grid[i][0];
            for(int j=1;j<width;j++){
                arr[j]=Math.min(arr[j-1],arr[j])+grid[i][j];
            }
            printarr(arr);
        }
        return arr[width-1];

    }

    public void printarr(int[] arr){
        System.out.print("Array:[");
        for (int i :arr) {
            System.out.print(i+",");
        }
        System.out.println("]");
    }
    public static void main(String args[]){

        int[][] grid={
                {1,3,1,5,7,2,6},
                {1,5,1,4,2,3,9},
                {4,2,6,3,1,1,1},
                {1,2,3,4,5,6,7},
                {1,1,2,3,2,1,1}
        };
        MinimumPathSum obj=new MinimumPathSum();
        System.out.println(obj.minPathSum(grid));



    }
}
