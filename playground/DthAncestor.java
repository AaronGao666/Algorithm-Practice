import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Node{
    int val;
    Node parent;
    List<Node> children;
    Node(int val){
        this.val=val;
        this.children=new ArrayList<>();
    }
}


public class DthAncestor {

    public List<Integer> findDthAncestor(List<Integer> tree, int D){


        Node root=new Node(0);
        int len=tree.size();
        Node[] list=new Node[len];
        for(int i=0;i<len;i++){


            if(list[i]==null){
                list[i]=new Node(i);
            }

            int p=tree.get(i);

            if(p==-1){
                root=list[i];
                continue;
            }

            if(list[p]!=null){
                list[i].parent=list[p];
                list[p].children.add(list[i]);
            }else{
                list[i].parent=new Node(p);
                list[p]=list[i].parent;
                list[p].children.add(list[i]);
            }
        }


//        for(int i=0;i<len;i++){
//        System.out.println("第"+i);
//            for(Node n:list[i].children){
//                System.out.println(n.val);
//            }
//        }




        Integer[] res=new Integer[len];
//        for(int i=0;i<len;i++){
//            res[i]=-2;
//        }
        List<Node> stack=new ArrayList<>();
        traverseTree(root,res,stack,D);
        List<Integer> result=Arrays.asList(res);
        return result;
    }

    private void  traverseTree(Node root, Integer[] result, List<Node> stack, int D){



        if(root==null){
            return;
        }



        if(stack.size()<D){
//            if(result[root.val]==-2){
                result[root.val]=-1;
//            }

        }else{
//            if(result[root.val]==-2){
                result[root.val]=stack.get(stack.size()-D).val;
//            }
        }
        stack.add(root);
        for(Node n:root.children){
            traverseTree(n,result,stack,D);
        }

        stack.remove(stack.size()-1);
    }


    public static void main(String[] args){
        Integer[] ints ={3,5,5,5,1,-1};
        List<Integer> list=Arrays.asList(ints);
        DthAncestor obj=new DthAncestor();
        System.out.println(obj.findDthAncestor(list,2));

    }


}
