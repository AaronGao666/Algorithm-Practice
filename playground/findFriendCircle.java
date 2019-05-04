import java.util.HashSet;

public class findFriendCircle {

    public int findCircleNum(int[][] M) {
        int N=M.length;
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=i;
        }
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(M[i][j]==1){
                    union(arr, i, j);
                    System.out.println(i+","+j+"这个arr：");
                    for(int iter:arr){
                        System.out.print(iter+"\t");
                    }
                    System.out.println("");
                }
            }
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<N;i++){
            set.add(find(arr,arr[i]));
        }
        return set.size();


    }
    public void union(int[] arr, int x, int y){
        int yAns=find(arr, y);
        int xAns=find(arr, x);
            if(yAns<xAns){
                arr[xAns]=yAns;
            }else if(xAns<yAns){
                arr[yAns]=xAns;
            }

    }
    public int find(int[] arr, int x){

        if(arr[x]==x){
            return x;
        }
        arr[x] = find(arr, arr[x]);
        return arr[x];
    }



    public static void main(String[] args){

        int[][] arr={
                {1,1,1,0,1,1,1,0,0,0},
                {1,1,0,0,0,0,0,1,0,0},
                {1,0,1,0,0,0,0,0,0,0},
                {0,0,0,1,1,0,0,0,1,0},
                {1,0,0,1,1,0,0,0,0,0},
                {1,0,0,0,0,1,0,0,0,0},
                {1,0,0,0,0,0,1,0,1,0},
                {0,1,0,0,0,0,0,1,0,1},
                {0,0,0,1,0,0,1,0,1,1},
                {0,0,0,0,0,0,0,1,1,1}};

        int[][] arr1={
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}};



        int[][] arr2={
                {1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
                {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},
                {0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},
                {0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},
                {1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},
                {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
                {0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}};



        findFriendCircle obj =new findFriendCircle();
        System.out.println(obj.findCircleNum(arr2));


    }

}
