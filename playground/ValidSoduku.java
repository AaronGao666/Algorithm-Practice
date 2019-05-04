import java.util.*;
public class ValidSoduku {



    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> row = new HashSet<>();
        ArrayList<HashSet<Character>> boxes = new ArrayList<>();
        ArrayList<HashSet<Character>> cols = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            HashSet<Character> set = new HashSet<>();
            boxes.add(set);
        }
        for(int i = 0; i < 9; i++){
            HashSet<Character> set = new HashSet<>();
            cols.add(set);
        }

        for(int i = 0; i < 9; i++){
            row.clear();
            if(i == 3 || i == 6){
                boxes.get(0).clear();
                boxes.get(1).clear();
                boxes.get(2).clear();
            }

            for(int j = 0; j < 9; j++){

                char c = board[i][j];

                if(c == '.'){
                    continue;
                }

                System.out.println(c);
                if(row.contains(c)){
                    System.out.println("fdaf");
                    return false;
                }else{
                    row.add(c);
                }


                if(boxes.get(j/3).contains(c)){
                    System.out.println(j/3);
                    System.out.println(boxes.get(j/3));
                    System.out.println("fdafdafdasfdaf");
                    return false;
                }else{
                    boxes.get(j/3).add(c);
                }


                if(cols.get(j).contains(c)){
                    System.out.println("43214315afdafdassfas");
                    return false;
                }else{
                    cols.get(j).add(c);
                }
            }
        }

        return true;
    }
    
    public static void main(String[] args){
        char[][] board = {
                {'.','.','.','3','.','.','.','1','.'},
                {'.','.','.','.','.','7','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},

                {'.','.','.','.','.','8','2','7','.'},
                {'1','.','.','.','.','.','.','.','.'},
                {'.','.','.','5','.','.','.','.','.'},

                {'2','.','.','.','8','.','.','.','7'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}};

        ValidSoduku obj =new ValidSoduku();
        System.out.println(obj.isValidSudoku(board));

    }
    

}
