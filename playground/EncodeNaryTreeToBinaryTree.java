
import java.util.*;

public class EncodeNaryTreeToBinaryTree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null) return null;
        TreeNode bRoot = new TreeNode(root.val);
        encodeHelper(bRoot, root);
        return bRoot;
    }

    private void encodeHelper(TreeNode tn, Node n) {
        TreeNode leftHead = new TreeNode(-1);
        TreeNode ptr = leftHead;
        for (Node c : n.children) {
            ptr.right = new TreeNode(c.val);
            ptr = ptr.right;
            encodeHelper(ptr, c);
        }
        tn.left = leftHead.right;

    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) return null;
        Node nRoot = new Node(root.val, new ArrayList<>());
        decodeHelper(root, nRoot);
        return nRoot;
    }

    private void decodeHelper(TreeNode tn, Node n) {
//        if(tn == null) return;
        TreeNode left = tn.left;
        while (left != null) {
            Node c = new Node(left.val, new ArrayList<>());
            n.children.add(c);
            decodeHelper(left, c);
            left = left.right;
        }
    }


    private Node createNaryTree(){


        Node root = new Node(1, new ArrayList<>());
        for(int i = 2; i < 7; i ++){
            root.children.add(new Node(i, new ArrayList<>()));
        }
        for(Node n : root.children){
            for(int i = 10; i < 15; i ++){
                n.children.add(new Node(i * n.val , new ArrayList<>()));
            }
        }
        for(Node n : root.children){
            for(Node c : n.children){
                for(int i = 100; i < 105; i ++){
                    c.children.add(new Node(i * n.val * c.val, new ArrayList<>()));
                }
            }
        }


        return root;
    }



    public static void main(String[] args){

//        EncodeNaryTreeToBinaryTree obj = new EncodeNaryTreeToBinaryTree();
//
//        Node root = obj.createNaryTree();
//
//        TreeNode bRoot = obj.encode(root);
//
//        Node newRoot = obj.decode(bRoot);

    }


}
