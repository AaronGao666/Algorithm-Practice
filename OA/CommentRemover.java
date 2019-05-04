package GSOA;

import java.util.List;

public class CommentRemover {

//    public String[] removeComment(String[] input){
//
//        int len=input.length;
//
//        int blockCommentStart=-1;
//        int lineComment=-1;
//        int blockCommentEnd=-1;
//
//        int blockStartLine=-1;
//        int validBlockStart=-1;
//
//        for(int i=0;i<len;i++){
//
//
//            lineComment=input[i].indexOf("//");
//
//            blockCommentStart=input[i].indexOf("/*");
//
//            blockCommentEnd=input[i].indexOf("*/");
//
//
//
//            if(blockStartLine==-1){//不在一个block内
//
//                if((lineComment>0 && lineComment<blockCommentStart) || (lineComment>0 && blockCommentStart<0)){
//                    input[i]=input[i].substring(0,lineComment)+" ";
//                }
//
//                if((blockCommentStart>0&& blockCommentStart<lineComment )|| (blockCommentStart>0 && lineComment<0)){
//                    blockStartLine=i;
//                    validBlockStart=blockCommentStart;
//                    i--;
//                }
//            }else{
//
//                if(blockCommentEnd>0){
//
//                    for(int j=blockStartLine+1;j<=i;j++){
//
//                    }
//
//
//
//                }
//
//
//
//
//            }
//
//        }
//
//
//
//
//    }


}
