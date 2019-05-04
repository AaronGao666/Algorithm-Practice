class TrieNode{
    TrieNode left;
    TrieNode right;
    boolean isEnd;
    TrieNode(){
        this.isEnd=false;
    }
}

public class FindMaxDistance {

    public int getAns(String[] s) {


        int len=s.length;

        TrieNode root= buildTrie(s,len);




        return findMaxPath(root);


    }
    public TrieNode buildTrie(String[] s, int len){
        TrieNode root=new TrieNode();
        TrieNode ptr;
        for(int i=0;i<len;i++){
            int length=s[i].length();
            ptr=root;
            for(int j=0;j<length;j++){
                if(s[i].charAt(j)=='0'){
                    if(ptr.left==null){
                        ptr.left=new TrieNode();
                    }
                    ptr=ptr.left;
                }else{
                    if(ptr.right==null){
                        ptr.right=new TrieNode();
                    }
                    ptr=ptr.right;
                }
            }
            ptr.isEnd=true;
        }

        return root;

    }
    public int findMaxPath(TrieNode root){

        if(root==null){
            return 0;
        }
        if(root.left==null){
            return findMaxPath(root.right);
        }
        if(root.right==null){
            return findMaxPath(root.left);
        }


        return getLength(root.left)+getLength(root.right);
    }

    public int getLength(TrieNode root){
        if(root==null) return 0;
        int depth1= getLength(root.left);
        int   depth2 = getLength(root.right);
        if(depth1>depth2) return depth1+1;
        else return depth2+1;
    }



    public static void main(String[] args){
        String[] s={"01","0","0101010"};
        FindMaxDistance obj=new FindMaxDistance();
        System.out.println(obj.getAns(s));

    }
}
