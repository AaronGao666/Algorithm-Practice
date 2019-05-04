public class KnightProbabilityInChessboard {
    double probability = 0.0;
    double onestep;
    final int[][] dirs = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {1, 2}, {2, 1}};

    public double knightProbability(int N, int K, int r, int c) {
        onestep = 1 / Math.pow(8, K);
        dfs(N, K, r, c, 0);
        return probability;
    }

    private void dfs(int N, int K, int r, int c, int steps) {

//        System.out.println("r = " + r + "c = " + c + "steps=" + steps);

        if (r >= N || r < 0 || c >= N || c < 0) {
            return;
        }
        if (steps == K) {
            probability += onestep;
            return;
        }

        for (int[] dir : dirs) {
            dfs(N, K, r + dir[0], c + dir[1], steps + 1);
        }

    }

    public static void main(String[] args) {

        int N = 8;
        int K = 30;
        int r = 6;
        int c = 4;

        KnightProbabilityInChessboard obj = new KnightProbabilityInChessboard();
        System.out.println(obj.knightProbability(N, K, r, c));


    }
}
