package AmazonOA;

import java.util.*;

public class MinimumDistance {


    public int minDistance(int numRow, int numCol, int[][] lot) {


        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        int count = 0;
        int[] dummy = {-1, -1};
        q.offer(dummy);
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            if (pos == dummy) {
                if (!q.isEmpty()) q.offer(dummy);
                count++;
            } else {
                int x = pos[0];
                int y = pos[1];
                if (lot[x][y] == 9) return count;
                lot[x][y] = 0;
                if (x > 0 && lot[x - 1][y] != 0) q.offer(new int[]{x - 1, y});
                if (y > 0 && lot[x][y - 1] != 0) q.offer(new int[]{x, y - 1});
                if (x < numRow - 1 && lot[x + 1][y] != 0) q.offer(new int[]{x + 1, y});
                if (y < numCol - 1 && lot[x][y + 1] != 0) q.offer(new int[]{x, y + 1});

            }


        }


        return -1;
    }


    public static void main(String[] args) {

//        int[][] lot = {
//                {1,1,1,1},
//                {0,1,1,1},
//                {0,1,0,1},
//                {1,1,9,1},
//                {0,0,1,1}
//        };


        int[][] lot = {
                {1, 0, 0},
                {1, 0, 0},
                {1, 9, 1}
        };

        System.out.println(new MinimumDistance().minDistance(lot.length, lot[0].length, lot));

    }


}
