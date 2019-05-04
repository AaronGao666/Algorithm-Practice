class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

}

public class deleteBSTnode {



    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return root;
        }

        TreeNode ptr = null;
        TreeNode parent = root;
        while (parent != null && (parent.left != null || parent.right != null)) {
            if (parent.left != null && parent.left.val == key) {
                ptr = parent.left;
                break;
            }
            if (parent.right != null && parent.right.val == key) {
                ptr = parent.right;
                break;
            }
            if (parent.val == key) {
                break;
            } else if (parent.val > key) {
                parent = parent.left;
            } else {
                parent = parent.right;
            }
        }

        if (parent.val == key) {
            System.out.println("here");
            if (root.left != null) {
                TreeNode max = root.left;
                while (max.right != null) {
                    parent = max;
                    max = max.right;
                }
                if(parent == root){
                    max.right = root.right;
                }else{
                    parent.right = max.left;
                    max.left = root.left;
                    max.right = root.right;
                }
                return max;
            } else if (root.right != null) {
                TreeNode min = root.right;
                System.out.println("zheer");
                while (min.left != null) {
                    parent = min;
                    min = min.left;
                }

                if(parent == root){
                    System.out.println("fdasfdasfa");
                    min.left = root.left;
                }else{
                    parent.left = min.right;
                    min.right = root.right;
                    min.left = root.left;
                }
                System.out.println("min.val:" +min.val);
                return min;
            } else {
                return null;
            }
        }

        if (ptr == null) {
            return root;
        }

        TreeNode left = ptr.left;
        TreeNode right = ptr.right;

        if (left != null && right != null) {
            if (parent.left == ptr) {
                parent.left = left;
            } else {
                parent.right = left;
            }
            while (left.right != null) {
                left = left.right;
            }
            left.right = right;
        } else if (left == null) {
            if (parent.left == ptr) {
                parent.left = right;
            } else {
                parent.right = right;
            }
        } else {
            if (parent.left == ptr) {
                parent.left = left;
            } else {
                parent.right = left;
            }
        }
        return root;
    }


    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        deleteBSTnode obj = new deleteBSTnode();
        TreeNode res = obj.deleteNode(root,1);
        System.out.println(res.val);
        System.out.println(res.left);


    }
}
