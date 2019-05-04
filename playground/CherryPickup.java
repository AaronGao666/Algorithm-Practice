
import java.util.*;

public class CherryPickup {


//    int maxDown = 0;
//    HashSet<int[]> path;
//    public int cherryPickup(int[][] grid) {
//
//        int N = grid.length;
//        path = new HashSet<>();
//        HashSet<int[]> set = new HashSet<>();
//        downHelper(grid, 0, 0, set, 0);
//
//        if(path.isEmpty() && N > 1){
//            return 0;
//        }
//
//        for(int[] a : path){
//            System.out.println(a[0] + ","+a[1]);
//            grid[a[0]][a[1]] = 0;
//        }
//        grid[N-1][N-1] = 0;
//        for(int[] a:grid){
//            for(int i : a){
//                System.out.print(i + "\t");
//            }
//            System.out.println("");
//        }
//
//        int maxUp = upHelper(grid, N - 1, N - 1);
//
//        System.out.println(maxUp + ","  + maxDown);
//        return maxDown + maxUp;
//    }
//
//    private void downHelper(int[][] grid, int x, int y, HashSet<int[]> set, int before){ // x, y curr pos
//
//        if(x >= grid.length || y >= grid.length || grid[x][y] == -1 ){
//            return;
//        }
//        int result = grid[x][y] == 1? before + 1 : before;
//        int[] pos = {x, y};
//        if(x == y && x == grid.length - 1){
//
//            if(result > maxDown){
//                maxDown = result;
//                path.clear();
//                path.addAll(set);
//            }
//            return;
//        }
//        set.add(pos);
//        downHelper(grid, x + 1, y, set, result);
//        downHelper(grid, x, y + 1, set, result);
//        set.remove(pos);
//    }
//
//    private int upHelper(int[][] grid, int x, int y){
//
//        if(x< 0 || y < 0 || grid[x][y] == -1){
//            return 0;
//        }
//
//        if(grid[x][y] == 1){
//            return Math.max(upHelper(grid, x - 1, y),  upHelper(grid, x, y - 1) ) + 1;
//        }else{
//            return Math.max(upHelper(grid, x - 1, y), upHelper(grid, x, y - 1) );
//        }
//
//    }

    int max;
    int N;

    public int cherryPickup(int[][] grid) {
        N = grid.length;
        List<int[]> list  = new ArrayList<>();
        downHelper(grid, 0, 0, list, 0);

        return max;
    }

    private void downHelper(int[][] grid, int x, int y, List<int[]> list, int before) {
        if (x >= N || y >= N || grid[x][y] == -1) {
            return;
        }
        int result = grid[x][y] == 1 ? before + 1 : before;
        int[] pos = {x, y};
        list.add(pos);
        if (x == y && x == N - 1) {


//            int upsum = 0;
//            if(result == 13){
//                System.out.println("本次遍历下路径");
//                for(int[] a : list){
//                    System.out.print(a[0] + "," + a[1] + "\t");
//                }
//                System.out.print("\n result = " + result +"\n");
////
//                System.out.println(", upsum = " + upsum);
//            }

//            System.out.println(result);
            result += upHelper(grid, N -1 , N -1, list);
//            System.out.println("加上上行： result = " + result);
            if (result > max) {
                max = result;
            }

            list.remove(list.size() -1 );
            return;
        }

        downHelper(grid, x + 1, y, list, result);
        downHelper(grid, x, y + 1, list, result);
        list.remove(list.size() - 1 );

    }

//    private int upHelper(int[][] grid, int x, int y, HashSet<int[]> set) {
//        if (x < 0 || y < 0 || grid[x][y] == -1) {
//            return 0;
//        }
//        int[] pos = {x, y};
//
//        if (grid[x][y] == 1 && !set.contains(pos)) {
//            return Math.max(upHelper(grid, x - 1, y, set), upHelper(grid, x, y - 1, set)) + 1;
//        } else {
//            return Math.max(upHelper(grid, x - 1, y, set), upHelper(grid, x, y - 1, set));
//        }
//    }


    private int upHelper(int[][] grid, int x, int y, List<int[]> list) {



//        System.out.println("调用uphelper");
        if (x < 0 || y < 0 || grid[x][y] == -1) {
            return -1;
        }
        if(x == y && x ==0) {
            return 0; //肯定被拿走了
        }

        int[] pos = {x, y};
//
//        System.out.println("当前x，y 为: "+x + "," +y+ " list 为：" + list);
//        for(int[] a :set ){
//            System.out.print(a[0] + "," + a[1] + "\t");
//        }
//        System.out.println("\n contains 了吗" + set.contains(pos) + "\n");


        int val = Math.max(upHelper(grid, x - 1, y, list) , upHelper(grid, x, y - 1, list));
        if(val == -1){ //invalid
            return -1;
        }
//        System.out.println("upval : " + val + "当前位置： " + x + "," + y);
        if(grid[x][y] == 1){
            for(int[] a : list){
                if(Arrays.hashCode(a) == Arrays.hashCode(pos)){
//                    System.out.println("返回upval");
                    return val;
                }
            }
//            System.out.println("返回upval + 1 !!!");

            return val + 1;
        }

//        System.out.println("最后返回upval");

        return val;
    }

    public static void main(String[] args) {


//        int[][] grid = {
//                {1, 1, 1, 1, 0, 0, 0},
//                {0, 0, 0, 1, 0, 0, 0},
//                {0, 0, 0, 1, 0, 0, 1},
//                {1, 0, 0, 1, 0, 0, 0},
//                {0, 0, 0, 1, 0, 0, 0},
//                {0, 0, 0, 1, 0, 0, 0},
//                {0, 0, 0, 1, 1, 1, 1}};

//        int[][] grid = {{1}};
        
//        
//        int[][] grid = {
//                {1,1,1,1,1},
//                {1,1,1,1,1},
//                {-1,-1,1,1,-1},
//                {1,1,1,1,1},
//                {1,1,1,-1,1}};
        
        
        
        
//        int[][] grid = {{1,1,1,1,1},{1,1,-1,1,1},{-1,-1,1,1,1},{1,1,1,1,1},{-1,1,1,1,1}};

        
        
        int[][] grid = {{1,1,1,1,-1,-1,-1,1,0,0},{1,0,0,0,1,0,0,0,1,0},{0,0,1,1,1,1,0,1,1,1},{1,1,0,1,1,1,0,-1,1,1},{0,0,0,0,1,-1,0,0,1,-1},{1,0,1,1,1,0,0,-1,1,0},{1,1,0,1,0,0,1,0,1,-1},{1,-1,0,1,0,0,0,1,-1,1},{1,0,-1,0,-1,0,0,1,0,0},{0,0,-1,0,1,0,1,0,0,1}};
        
        for(int[] a : grid){
            for(int i : a ){
                System.out.print(i + "\t");
            }
            System.out.println("");
        }
        CherryPickup obj = new CherryPickup();
        System.out.println(obj.cherryPickup(grid));


    }
}
