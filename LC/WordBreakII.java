package LeetCodePackage;

import java.util.ArrayList;
import java.util.Arrays;

enum Color{
    BLACK,WHITE,GRAY
}
//广度优先搜索动态树



public class WordBreakII {



    class Node{
        int depth=-1;
        int id=-1;
        int fatherID=-1;
        int nextBrotherName=-1;
        int endPointer=-1;//该单词结束的位置
        String value=null;//该单词本身
        Color color=Color.WHITE;
    }

    static int iditerator=1;
    public ArrayList<Node> WordBreakII(String s, String[] wordDict){
        Arrays.sort(wordDict);
        ArrayList<Node> arr=new ArrayList<Node>();
        int beginindex=0;
        int endindex=0;

        Node root=new Node();
        root.id=0;
        root.depth=0;//虚拟一个根节点。

        for(beginindex=0;beginindex<s.length();beginindex++ ){

            for(endindex=beginindex;endindex<s.length();endindex++){
                if(Arrays.binarySearch(wordDict,s.substring(beginindex,endindex))>=0){
                    Node n=new Node();
                    n.id=iditerator;
                    iditerator++;
                    n.value=s.substring(beginindex,endindex);
                    arr.add(n);
                }

            }

        }

        return arr;
    }

    public static void main(String args[]){
        String s="catsanddog";
        String[] wordDict={"cat","cats","and","sand","dog"};
        WordBreakII test=new WordBreakII();
        ArrayList<Node> result=test.WordBreakII(s,wordDict);

        System.out.println(result.get(0).value);
        System.out.println(result.get(1).value);
        System.out.println(result.get(2).value);
        System.out.println(result.get(3).value);
    }

}
