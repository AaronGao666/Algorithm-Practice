import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.*;

class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}

public class cloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if(node ==null){
            return null;
        }

        HashMap<Integer,UndirectedGraphNode > map =new HashMap<>();
        Set<UndirectedGraphNode> set =new HashSet<>(); //标志有没有遍历过
        Queue<UndirectedGraphNode> q=new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){//BFS to put all nodes into map
            UndirectedGraphNode curr=q.poll();
            if(!set.contains(curr)){
                map.put(curr.label,new UndirectedGraphNode(curr.label));
                set.add(curr);
            }
            for(UndirectedGraphNode n:curr.neighbors){
                if(!set.contains(n)){
                    q.offer(n);
                }
            }
        }



        q.offer(node);
        set.clear();
        UndirectedGraphNode res=map.get(node.label);
        while(!q.isEmpty()){
            UndirectedGraphNode curr=q.poll();


            System.out.println("当前节点："+curr);






            if(!set.contains(curr)){
                UndirectedGraphNode cNode=map.get(curr.label);
                set.add(curr);
                List<UndirectedGraphNode> cNeighbors=new ArrayList<>();
                for(UndirectedGraphNode n:curr.neighbors){
                    cNeighbors.add(map.get(n.label));
                }
                cNode.neighbors=cNeighbors;
            }
            for(UndirectedGraphNode n:curr.neighbors){
                if(!set.contains(n)){
                    q.offer(n);
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        UndirectedGraphNode n0=new UndirectedGraphNode(-1);

        UndirectedGraphNode n1=new UndirectedGraphNode(1);
//        UndirectedGraphNode n2=new UndirectedGraphNode(2);
        n0.neighbors.add(n1);
//        n2.neighbors.add(n2);
        System.out.println("打印原始nodes");
        System.out.println(n0);
        System.out.println(n1);
        System.out.println("打印完毕");
        cloneGraph obj=new cloneGraph();
        UndirectedGraphNode res=obj.cloneGraph(n0);
        System.out.println(res);
        System.out.println(res.neighbors.get(0));
        System.out.println(res.neighbors.get(0).label);
//        System.out.println(res.neighbors.get(0).neighbors.get(0).neighbors.get(0));

    }

}
