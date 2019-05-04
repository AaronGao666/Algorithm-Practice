package AmazonOA;

import java.util.*;


class ComponentNode{
    int val;
    ArrayList<ComponentNode> components;
    public ComponentNode(int val){
        this.val = val;
        this.components = new ArrayList<>();
    }
    public ComponentNode(){
        this.components = new ArrayList<>();
    }
}


public class MaximumAverageNode {


    double max = Double.MIN_VALUE;
    ComponentNode maxNode = null;
    HashMap<ComponentNode, Integer> count;
    public ComponentNode findMaxAvg(ComponentNode root){

        count = new HashMap<>();

        helper(root);

        return maxNode;
    }

    private double helper(ComponentNode root){
        if(root == null) {
            count.put(root, 0);
            return 0.0;
        }

        if(root.components.isEmpty()){
            count.put(root, 1);
            return (double) root.val;
        }

        double sum = root.val;
        int nodes = 1;
        for(ComponentNode n : root.components){
            double avg = helper(n);
            sum += avg * count.get(n);
            nodes += count.get(n);
        }
        count.put(root, nodes);

        double res = sum/ (double) nodes;
        if(res > max){
            max = res;
            maxNode = root;
        }

        return res;
    }


    private ComponentNode GenTree(){

        ComponentNode root = new ComponentNode(200);


        ComponentNode l1 = new ComponentNode(120);
        ComponentNode l2 = new ComponentNode(180);


        root.components.add(l1);
        root.components.add(l2);
        l1.components.add(new ComponentNode(110));
        l1.components.add(new ComponentNode(20));
        l1.components.add(new ComponentNode(30));

        l2.components.add(new ComponentNode(150));
        l2.components.add(new ComponentNode(80));


        return root;


    }



    public int treeProblem(int[] fa, int[] val) {
        // Write your code here
        int N = fa.length;

        HashMap<Integer, Double> avgMap = new HashMap<>();
        HashMap<Integer, Integer> countMap = new HashMap<>();

        double max = Double.MIN_VALUE;
        int maxIndex = -1;
        for(int i = N; i >= 1; i --){
            double sum = val[i - 1];
            int count = 1;
            for(int j = 0; j < N; j ++){
                if(fa[j] == i){
                    if(avgMap.containsKey(j + 1)){
                        sum += avgMap.get(j + 1) * countMap.get(j + 1);
                        count += countMap.get(j + 1);
                    }else{
                        sum += val[j];
                        count ++;
                    }
                }
            }

            sum /= count;
            if(max < sum){
                max = sum;
                maxIndex = i;
            }else if(max == sum){
                if(maxIndex > i) maxIndex = i;
            }
            avgMap.put(i, sum);
            countMap.put(i, count);

        }

        for(int i : avgMap.keySet()){
            System.out.print("("+i + "," +avgMap.get(i) + ") \t");
        }
        System.out.println("");
        for(int i : countMap.keySet()){
            System.out.print("("+i + "," +countMap.get(i) + ") \t");
        }

        return maxIndex;

    }








    public static void main(String[] args){

        MaximumAverageNode obj = new MaximumAverageNode();
//        ComponentNode root = obj.GenTree();
//
//        ComponentNode res = obj.findMaxAvg(root);
//
//        System.out.println(res.val);


        int[] fa = {-1,1,2,2,2,3,1,1};
        int[] val= {54,92,51,69,94,92,70,94};

        System.out.println(obj.treeProblem(fa, val));



    }

}
