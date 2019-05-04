import java.util.*;

public class NQueens {


    public List<List<String>> solveNQueens(int n) {

        List<List<Integer>> resPos = new ArrayList<>();
        positionHelper(resPos, new ArrayList<>(), n);

        List<List<String>> res = new ArrayList<>();

        for (List<Integer> list : resPos) {
            List<String> oneSolution = new ArrayList<>();
            for (int pos : list) {

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (i == pos) {
                        sb.append('Q');
                    } else sb.append('.');
                }
                oneSolution.add(new String(sb));

            }
            res.add(new ArrayList<>(oneSolution));
        }


//        for(List<String> list : res){
//
//            for(String s: list){
//                System.out.println(s);
//            }
//
//            System.out.println("--------");
//
//        }
        return res;
    }

    public void positionHelper(List<List<Integer>> resPos, List<Integer> oneSolution, int n) {
        if (oneSolution.size() == n && qualified(oneSolution)) {
            resPos.add(new ArrayList(oneSolution));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!oneSolution.contains(i) && qualified(oneSolution)) {
                oneSolution.add(i);
                positionHelper(resPos, oneSolution, n);
                oneSolution.remove(oneSolution.size() - 1);
            }
        }

    }

    private boolean qualified(List<Integer> oneSolution) { // only validate the last one who added in. and only diagonal
        int len = oneSolution.size();

        if (len <= 1) {
            return true;
        }

        for (int i = 0; i < len - 1; i++) {
            if (Math.abs(oneSolution.get(i) - oneSolution.get(len - 1)) == len - i - 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        NQueens obj = new NQueens();
        obj.solveNQueens(5);


    }
}
