package algorithm;


import java.lang.reflect.Array;
import java.util.Arrays;

public class ConstructBinaryTreeFromPreAndIn {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }



    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return helper(0,0,inorder.length-1,preorder,inorder);

    }
    public TreeNode helper(int preStart,int inStart, int inEnd, int[] preorder, int[] inorder){

        TreeNode root =new TreeNode(preorder[0]);
        int inIndex=0;
        for(int i=inStart;i<=inEnd;i++){
            if(root.val==inorder[i]){
                inIndex=i;
            }
        }

        root.left=helper(preStart+1,inStart,inIndex-1,preorder,inorder);
        root.right=helper(preStart+inIndex-inStart+1,inIndex+1,inEnd,preorder,inorder);

        return root;

    }


}
