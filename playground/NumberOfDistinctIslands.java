import java.util.*;
public class NumberOfDistinctIslands {

    List<int[]> list;
    int row;
    int col;
    int[][] grid;
    public int numDistinctIslands(int[][] grid) {
        list = new ArrayList<>();
        row = grid.length;
        col = grid[0].length;
        this.grid = grid;
        for(int i = 0 ; i < row; i++){
            for(int j = 0; j < col; j ++){
                if(grid[i][j] == 1){
                    traverse(i, j);
                    boolean isSame = false;
                    for(int[] p : list){

                        isSame = isSame(p[0], p[1], i, j);
                        System.out.println("检查了: ("+ i + "," + j + "), (" + p[0] + "," + p[1] + ")" + isSame);
                        traverse(p[0], p[1]);
                        traverse(i, j);
                        if(isSame)
                            break;
                    }
                    if(!isSame){
                        list.add(new int[]{i, j});
                    }
                }
            }
        }

        for(int[] p : list){
            System.out.println(p[0] + "," + p[1]);
        }





        return list.size();
    }


    private void traverse(int x, int y){
        if(x < 0|| x >= row || y < 0 || y >= col || grid[x][y] % 2 == 0){
            return;
        }
        grid[x][y] = 2;
        traverse(x - 1, y);
        traverse(x + 1, y);
        traverse(x, y - 1);
        traverse(x, y + 1);
    }

    private boolean isSame(int x1, int y1 , int x2, int y2){


        System.out.println("当前检查: ("+ x1 + "," + y1 + "), (" + x2 + "," + y2 + ")" );
        for(int[] arr : grid){
            for(int i : arr){
                System.out.print(i + "\t");
            }
            System.out.println("");
        }

        boolean out1 = x1 < 0 || y1 < 0 || x1 >= row || y1 >= col;
        boolean out2 = x2 < 0 || y2 < 0 || x2 >= row || y2 >= col;

        if(out1 && out2){
            return true;
        }else if(out1){
            return grid[x2][y2] == 0;
        }else if(out2){
            return grid[x1][y1] == 0;
        }else{

            if(grid[x1][y1] == 2 ^ grid[x2][y2] == 2){//一个是2 一个不是
                return false;
            }else if(grid[x1][y1] == 2 && grid[x2][y2] == 2){//俩都是2
                grid[x1][y1] = 3;
                grid[x2][y2] = 3;
                return isSame(x1 - 1, y1, x2 - 1, y2) && isSame(x1 + 1, y1, x2 + 1, y2) && isSame(x1, y1 - 1, x2, y2 - 1) && isSame(x1, y1 + 1, x2, y2 + 1);
            }else { //俩都不是2
                return true;
            }


        }

    }

    public static void main(String[] args){


        int[][] grid = {{0,1,1}, {1, 0 ,0 }, {1, 0 ,1}};
        NumberOfDistinctIslands obj = new NumberOfDistinctIslands();
        System.out.println(obj.numDistinctIslands(grid));


    }
}
