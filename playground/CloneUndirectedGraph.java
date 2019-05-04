import java.util.*;
public class CloneUndirectedGraph {
    class Node{
        int val;
        List<Node> neighbors;
        public Node(int val){
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }
    /*
    1—-2–--6--7 
    |   | /
     4----3----5
     */

    public Node cloneGraph(Node n){

        HashMap<Node , Node> map = new HashMap<>();
        HashSet<Node> alreadyTraversed = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(n);
        alreadyTraversed.add(n);
        while(!q.isEmpty()){

            Node node = q.poll();
            Node cNode = new Node(node.val);
            map.put(node, cNode);
            for(Node neighbor : node.neighbors){

                if(! alreadyTraversed.contains(neighbor)){
                    alreadyTraversed.add(neighbor);
                    q.offer(neighbor);
                }
            }

        }


        alreadyTraversed.clear();
        q.offer(n);
        alreadyTraversed.add(n);
        while(!q.isEmpty()){

            Node node = q.poll();
            Node cNode = map.get(node);

            for(Node neighbor : node.neighbors){
                cNode.neighbors.add(map.get(neighbor));
                if(! alreadyTraversed.contains(neighbor)){
                    alreadyTraversed.add(neighbor);
                    q.offer(neighbor);
                }
            }

        }

        return map.get(n);

    }







}
