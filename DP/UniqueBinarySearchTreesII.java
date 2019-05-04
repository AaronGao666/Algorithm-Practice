//import java.util.List;
//
//public class UniqueBinarySearchTreesII {
//
//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode(int x) { val = x; }
//    }
//
//    List<TreeNode> res=new List<TreeNode>;
//
//    public List<TreeNode> generateTrees(int n) {
//
//        return helper(1,n);
//
//    }
//
//    public List<TreeNode> helper(int start ,int end){
//
//        if(start<end) return null;
//        if(start==end) {
//            res.add(new TreeNode(start));
//            return res;
//        }
//
//
//        for(int i=start;i<=end;i++){//take one number as root
//            List<TreeNode> leftList=helper(start,i-1);
//            List<TreeNode> rightList =helper(i+1,end);
//            for (TreeNode leftNode: leftList) {
//                for(TreeNode rightnode: rightList){
//                    TreeNode root=new TreeNode(i);
//                    root.left=leftNode;
//                    root.right=rightnode;
//                    res.add(root);
//                }
//            }
//        }
//
//    }
//
//}
