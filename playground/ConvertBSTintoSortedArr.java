import java.util.*;
public class ConvertBSTintoSortedArr {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int value){
            this.val =value;
        }
    }

    public List<Integer> convert(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode ptr = root;


        while(!stack.isEmpty() || ptr != null){

            while(ptr != null){
                stack.push(ptr);
                ptr = ptr.left;
            }
            ptr = stack.pop();
            result.add(ptr.val);
//            if(ptr.right != null){
//                stack.push(ptr.right);
//            }
            ptr = ptr.right;
        }


        return result;
    }


    public List<Integer> rightView(TreeNode root){

        List<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode dummy = new TreeNode(-1);

        q.offer(root);
        q.offer(dummy);
        TreeNode prev = root;
        while(!q.isEmpty()){
            TreeNode ptr = q.poll();
            if(ptr == dummy ){
                result.add(prev.val);
                if(!q.isEmpty()){
                    q.offer(dummy);
                }
            }else{
                if(ptr.left != null){
                    q.offer(ptr.left);
                }
                if(ptr.right != null){
                    q.offer(ptr.right);
                }
                prev = ptr;
            }
        }

        return result;
    }








    private TreeNode geneTree(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);



        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(9);

        return root;
    }


    public static void main(String[] args){

        ConvertBSTintoSortedArr obj = new ConvertBSTintoSortedArr();
        TreeNode root = obj.geneTree();
        List<Integer> list = obj.rightView(root);
        System.out.println(list);


    }

}
