package algorithm;
import java.util.*;


public class WordLadder2 {
    final String WHITE="white";
    final String BLACK="black";
    final String GRAY="gray";


    public static boolean isconnected(String a, String b){
        boolean isconn=false;
        int count=0;
        char[] c1=a.toCharArray();
        char[] c2=b.toCharArray();
        for(int i=0;i<a.length();i++){
            if (c1[i]-c2[i]!=0){
                count++;
            }
        }
        if( count==1)
            isconn=true;
        else
            isconn=false;

        return isconn;

    }
    class node {//每个节点的4个属性：父节点名称，与根节点的距离，颜色
        int dis=Integer.MAX_VALUE;
        String father=null;
        String name=null;
        String color=WHITE;
        String getName(){
            return this.name;
        }
        String getFather(){
            return this.father;
        }
        String getColor(){
            return this.color;
        }
        int getDis(){
            return this.dis;
        }

    }

    public Map<String,node> initialize(String[] dict){
        String key=null;
        Map<String, node> map=new HashMap<String,node>();

        for(String s:dict){
            node n=new node();
            key=s;
            n.name=s;
            n.dis=Integer.MAX_VALUE;
            n.color=WHITE;
            map.put(key,n);
        }
        return map;
    }



    public Map<String,node> buildTree(String[] wordList,String beginWord){
        Map<String, node> dict =initialize(wordList);//将单词表初始化为node类型的词典
        Queue<node> queue=new LinkedList<node>();
        node beginnode=new node();
        beginnode.color=GRAY;
        beginnode.dis=0;
        beginnode.name=beginWord;
        dict.put(beginWord,beginnode);
        queue.offer(beginnode);
        while(queue.peek()!=null){//队列非空
            node curr=queue.poll();
            for(Map.Entry<String, node> entry : dict.entrySet()) {
                node word=entry.getValue();

                if(word.color==WHITE) {
                    if (isconnected(word.getName(),curr.getName())) {
                        queue.offer(word);
                        word.father = curr.getName();
                        word.color = GRAY;
                        curr.color = BLACK;
                        word.dis=curr.dis+1;
                    }
                }

            }
        }
        return dict;
    }

    static int minimunstep=Integer.MAX_VALUE;
    public ArrayList<ArrayList<String>> findpath(String[] wordList,String beginWord, String endWord){
        Map<String,node> BFStree=new WordLadder2().buildTree(wordList,beginWord);
        ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>> ();

        for(Map.Entry<String, node> entry : BFStree.entrySet()) {
            node n=entry.getValue();
            node pointer=n;
            ArrayList<String> solution=new ArrayList<String>();
            if(n.getColor()==GRAY && isconnected(endWord,n.getName()) && n.getDis()<=minimunstep){//表明是链条的终端并且与终结词相邻，同时为最短路径
                minimunstep=n.getDis();
                while(pointer.getFather()!=null){
                    solution.add(0,pointer.getName());
                    pointer=BFStree.get(pointer.getFather());
                }
            }
            if(solution.isEmpty())
                continue;
            else {
                solution.add(0,beginWord);
                solution.add(endWord);
                result.add(solution);
            }
        }
        return result;
    }

    public static void main(String args[]){
        String[] wordList={"hot","dot","dog","lot","log","mus","jus","aog","loa","mua","coa","hoa","fun"};
        String beginWord="hit";
        String endWord="cog";
        ArrayList<ArrayList<String>> result=new WordLadder2().findpath(wordList,beginWord,endWord);
        System.out.println(result);


    }

}
