///**
// *采用DFS
// *
// * 写不下去了。思路不行。
// */
//
//package LeetCodePackage;
//
//import java.util.ArrayList;
//
//enum COLOR{
//    WHITE,
//    BLACK,
//    GRAY
//}
//
//public class WordSearchII {
//
//    class Node{
//        int[] position=new int[2];//x,y坐标
//        boolean left=false;
//        boolean right=false;
//        boolean up=false;
//        boolean down=false;
//        COLOR color=COLOR.WHITE;
//    }
//
//
//    public void visitNode(String s,char[][] board, ArrayList<ArrayList<Node>> arr,int i){
//        Node n=arr.get()
//        int x=n.position[0];
//        int y=n.position[1];
//        char nextChar=s.charAt(i);
//        if(x==0) n.left=false;
//        if(x==board[0].length-1) n.right=false;
//        if(y==0) n.up=false;
//        if(y==board.length-1) n.down=false;
//        if(board[y][x+1]==nextChar) n.right=true;
//        if(board[y][x-1]==nextChar) n.left=true;
//        if(board[y+1][x]==nextChar) n.down=true;
//        if(board[y-1][x]==nextChar) n.up=true;
//        if(!(n.right||n.left||n.up||n.down)){//全非
//            n.color=COLOR.BLACK;
//            return;
//        }
//        if(n.up){
//            n.color=COLOR.GRAY;
//            i++;
//            visitNode(s,board,);
//        }
//    }
//
//
//
//    public void wordSearch2(char[][] board, String s){
//        ArrayList<ArrayList<Node>> arr=new ArrayList<>();
//        for(int j=0;j<board.length;j++){
//            ArrayList<Node> arr1=new ArrayList<>();
//            for(int i=0;i<board[0].length;i++){
//                Node n=new Node();
//                n.position[0]=i;
//                n.position[1]=j;
//                arr1.add(n);
//            }
//            arr.add(arr1);
//        }
//
//
//    }
//
//
////    public boolean isThere(String s, char[][] board, int[] position ){
////        int len=s.length();
////        Node n=new Node();
////        n.position=position;
////        visitNode(s.charAt(1),board,n);
////        if(n.up==true) {
////            position[1]--;
////        }
////    }
//
//    public String[] wordSearchII(String[] words, char[][] board){
//
//        for(String s:words){
//
//
//
//
//        }
//
//
//
//    }
//
//
//
//    public static void main(String args[]){
//
//    }
//}
