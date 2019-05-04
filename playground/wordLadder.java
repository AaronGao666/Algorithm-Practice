import java.util.*;

public class wordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> currLayer = new HashSet<>();
        currLayer.add(beginWord);

        int res = bfs(currLayer, endWord, wordList, new HashSet<String>());
        if (res == 0) {
            return 0;
        } else {
            return res + 1;
        }

    }


    private int bfs(HashSet<String> currLayer, String end, List<String> wordList, HashSet<String> visited) {


        HashSet<String> nextLayer = new HashSet<>();

        for (String start : currLayer) {
            for (String s : wordList) {
                if (s.equals(start)) {
                    visited.add(s);
                } else if (!visited.contains(s) && isAdj(start, s)) {
                    nextLayer.add(s);
                    visited.add(s);
                }
            }
        }

        if (nextLayer.isEmpty()) {
            return 0;
        } else if (nextLayer.contains(end)) {
            return 1;
        }

        int temp = bfs(nextLayer, end, wordList, visited);
        if (temp == 0) {
            return 0;
        } else {
            return temp + 1;
        }

    }


    private boolean isAdj(String s, String e) {
        int i = 0;
        int len = s.length();

        if (len <= 1) {
            return true;
        }
        int j = len - 1;

        while (s.charAt(i) == e.charAt(i) && i < len) {
            i++;
        }
        while (s.charAt(j) == e.charAt(j) && j >= 0) {
            j--;
        }

        return i == j;
    }


    public static void main(String[] args) {

        wordLadder obj = new wordLadder();
        String start = "hot";
        String end = "dog";
        List<String> dict = Arrays.asList("hot", "dog");
        System.out.println(obj.ladderLength(start, end, dict));
    }
}
