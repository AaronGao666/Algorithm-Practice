import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        if (row <= 0) return false;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    System.out.println("这里合格："+i +"," + j);
                    boolean[][] visited = new boolean[row][col];
                    if (find(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        System.out.println("zheer");
        return false;
    }

    public boolean find(char[][] board, String word, int x, int y, int pos, boolean[][] visited) {



        System.out.println("这次调用：" + x + "," + y +"pos = "+ pos +"，visit：");
        for(boolean[] bs : visited){
            for(boolean b : bs){
                System.out.print(b + "\t");
            }
            System.out.println("");
        }

        if(pos == word.length()){
            return true;
        }

        if (x >= board.length || x < 0 || y >= board[0].length || y < 0 || visited[x][y] || word.charAt(pos) != board[x][y] ) {
            return false;
        }


        visited[x][y] = true;

        boolean flag = find(board, word, x - 1, y, pos + 1, visited) || find(board, word, x + 1, y, pos + 1, visited) || find(board, word, x, y - 1, pos + 1, visited) || find(board, word, x, y + 1, pos + 1, visited);

        visited[x][y] =false;

        return flag;
    }

    public static void main(String[] args) {

        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'E', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
        String word = "ABCESEEEFS";
        WordSearch obj = new WordSearch();
        System.out.println(obj.exist(board,word));


    }
}
