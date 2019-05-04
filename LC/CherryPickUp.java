package algorithm;

enum color{
    GRAY,WHITE,BLACK
}

public class CherryPickUp {

    public  int  cherryPickup(int[][] grid){
        class node {
            int colum;//代表处在第几行
            int row;//代表处在第几列
            int precolum;
            int prerow;
            int staus;
            boolean leftok=false;
            boolean rightok=false;
            boolean upok=false;
            boolean downok=false;
            color thiscolor=color.WHITE;
        }
        int N=grid.length;
        node[][] nodegrid=new node[N][N];

        for (int i = 0; i < N; i++) {//行遍历
            for (int j = 0; j < N; j++) {//列遍历
                nodegrid[i][j]=new node();
                nodegrid[i][j].colum=i;
                nodegrid[i][j].row=j;
                nodegrid[i][j].staus=grid[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("("+nodegrid[i][j].colum+","+nodegrid[i][j].row+"):");
                System.out.println("状态为："+nodegrid[i][j].staus);
            }
        }

        return 1;

    }
    public static void main(String[] args){
        int[][] grid={{1,1,0,0,0,0,-1},{-1,-1,0,0,0,1,0},{-1,1,0,0,0,1,0},{-1,1,0,1,0,-1,0},{1,-1,0,0,-1,1,0},{-1,-1,0,-1,0,1,0},{-1,0,0,0,0,1,0}};
        CherryPickUp test=new CherryPickUp();
        test.cherryPickup(grid);
    }
}
