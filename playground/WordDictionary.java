public class WordDictionary {


    class TrieNode {
        char c;
        TrieNode[] nexts;
        boolean isEnd;

        TrieNode(char c) {
            this.c = c;
            this.nexts = new TrieNode[26];
            this.isEnd = false;
        }

    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        this.root = new TrieNode('\0');
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {

        TrieNode ptr = this.root;
        for (char c : word.toCharArray()) {

            if(ptr.nexts[c - 'a'] == null) {
                ptr.nexts[c - 'a'] = new TrieNode(c);
            }
            ptr = ptr.nexts[c - 'a'];
        }
        ptr.isEnd = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {

        char[] wordChars = word.toCharArray();
        return match(wordChars, 0, this.root);

    }


    public boolean match(char[] chars, int index, TrieNode root) {
        char c = chars[index];

        if (index == chars.length - 1) {
            if (c == '.') {
                for (TrieNode n : root.nexts) {
                    if (n != null && n.isEnd) {
                        return true;
                    }
                }
//                System.out.println("zher");
                return false;
            } else {
                if (root.nexts[c - 'a'] != null && root.nexts[c - 'a'].isEnd) {
                    return true;
                } else {
                    return false;
                }
            }
        }


        if (c == '.') {
            for (TrieNode n : root.nexts) {
                if (n != null) {
                    if (match(chars, index + 1, n)) return true;
                }
            }
        } else {
            if (root.nexts[c - 'a'] != null) {
                return match(chars, index + 1, root.nexts[c - 'a']);
            } else {
                return false;
            }
        }

        return false;
    }



    public static void main(String[] args){

        WordDictionary obj = new WordDictionary();
        obj.addWord("a");
        obj.addWord("ab");
        System.out.println(obj.search("a"));


    }

}
