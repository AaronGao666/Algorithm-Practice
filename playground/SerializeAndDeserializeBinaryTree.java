import apple.laf.JRSUIUtils;

import java.util.*;

public class SerializeAndDeserializeBinaryTree {


    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(n == null) sb.append(",");
            else{
                q.offer(n.left);
                q.offer(n.right);
                sb.append(n.val + ",");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        return new String(sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        int count = strs.length;
        if(count <= 1) return null;
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int index = 1;
        while(index < strs.length){
            TreeNode n = q.poll();

            if(strs[index].length() != 0){
                n.left = new TreeNode(Integer.parseInt(strs[index]));
                q.offer(n.left);
            }
            index ++;
            if(strs[index].length() != 0){
                n.right = new TreeNode(Integer.parseInt(strs[index]));
                q.offer(n.right);
            }
            index ++;
        }

        return root;
    }



    private TreeNode createTree(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);
        root.right.right.left.right = new TreeNode(9);

        root.right.right.left.right.left = new TreeNode(11);
        root.right.right.left.right.right = new TreeNode(12);

        return  root;

    }


    public static void main(String[] args){

        SerializeAndDeserializeBinaryTree obj = new SerializeAndDeserializeBinaryTree();
        TreeNode root = obj.createTree();
        String s = obj.serialize(root);
        System.out.println(s);
        TreeNode newRoot = obj.deserialize(s);
        System.out.println("finished");
    }
}
