/**
*采用DFS
*
*
*/

package algorithm;

import java.util.ArrayList;

public class WordSearch2 {

    public ArrayList<String> findWords(char[][] board, String[] words) {
        ArrayList<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }




    public void dfs(char[][] board, int i, int j, TrieNode p, ArrayList<String> result){
        char c=board[i][j];
        if (c=='#'||p.next[c-'a']==null) return;
        p=p.next[c-'a'];
        if(p.word!=null){
            result.add(p.word);
            p.word=null;
        }
        board[i][j]='#';
        if(i>0) dfs(board,i-1,j,p,result);
        if(j>0) dfs(board,i,j-1,p,result);
        if (i < board.length - 1) dfs(board, i + 1, j, p, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, result);
        board[i][j] = c;
    }




    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    public static void main(String args[]){
        char[][] board={  {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}};
        String[] words={"oath","pea","eat","rain"};
        System.out.println(System.nanoTime());
        WordSearch2 obj=new WordSearch2();
        ArrayList result=obj.findWords(board,words);
        System.out.println(System.nanoTime());
        System.out.println(result);
//        for(int i=0;i<26;i++){
//            System.out.println(i+":"+root.next[4].next[0].next[19].);
//        }
    }

}
