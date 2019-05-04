package AmazonOA;

import java.util.*;

class Connection {
    String node1;
    String node2;
    int cost;

    public Connection(String a, String b, int c) {
        node1 = a;
        node2 = b;
        cost = c;
    }
}


public class CityConnect {


    //Kruskal
    public List<Connection> getLowCost(List<Connection> connections) {

        PriorityQueue<Connection> pq = new PriorityQueue<Connection>(new Comparator<Connection>() {
            @Override
            public int compare(Connection c1, Connection c2) {
                if (c1.cost == c2.cost) {
                    if (c1.node1.equals(c2.node1))
                        return c1.node2.compareTo(c2.node2);
                    else
                        return c1.node1.compareTo(c2.node1);
                } else
                    return c1.cost - c2.cost;
            }
        });

        for (Connection c : connections) {
            pq.offer(c);
        }

        HashMap<String, String> parent = new HashMap<>();
        List<Connection> result = new ArrayList<>();

        HashSet<String> set = new HashSet<>();
        while (!pq.isEmpty()) {
            Connection c = pq.poll();
            set.add(c.node1);
            set.add(c.node2);
            String p1 = find(parent, c.node1);
            String p2 = find(parent, c.node2);
            if (!p1.equals(p2)) {
                parent.put(p2, p1);
                result.add(c);
            }
        }



        return result.size() == set.size() - 1 ? result : new ArrayList<>();
    }


    private String find(HashMap<String, String> parent, String node) {
        while (parent.containsKey(node) && !node.equals(parent.get(node))) {
            node = parent.get(node);
        }
        return node;
    }


    //Prim
//    public List<Connection> getLowCost_Prim(List<Connection> connections){
//
//        HashMap<String, List<Connection>> map = new HashMap<>();
//        List<Connection> result = new ArrayList<>();
//        for(Connection c : connections){
//            if(map.containsKey(c.node1)){
//                map.get(c.node1).add(c);
//            }else{
//                List<Connection> neighbours = new ArrayList<>();
//                neighbours.add(c);
//                map.put(c.node1,neighbours);
//            }
//
//            if(map.containsKey(c.node2)){
//                map.get(c.node2).add(c);
//            }else{
//                List<Connection> neighbours = new ArrayList<>();
//                neighbours.add(c);
//                map.put(c.node2,neighbours);
//            }
//        }
//
//        PriorityQueue<Connection> pq = new PriorityQueue<>(new Comparator<Connection>() {
//            @Override
//            public int compare(Connection c1, Connection c2) {
//                if (c1.cost == c2.cost) {
//                    if (c1.node1.equals(c2.node1))
//                        return c1.node2.compareTo(c2.node2);
//                    else
//                        return c1.node1.compareTo(c2.node1);
//                } else
//                    return c1.cost - c2.cost;
//            }
//        });
//
//
//
//
//
//
//
//    }



    public static void main(String[] args) {

        Connection c1 = new Connection("A", "D", 1);
        Connection c2 = new Connection("A", "B", 3);
        Connection c3 = new Connection("D", "B", 3);
        Connection c4 = new Connection("B", "C", 1);
        Connection c5 = new Connection("C", "D", 1);
        Connection c6 = new Connection("E", "D", 6);
        Connection c7 = new Connection("C", "E", 5);
        Connection c8 = new Connection("C", "F", 4);
        Connection c9 = new Connection("E", "F", 2);

//        List<Connection> Connects = Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9);

        List<Connection> Connects = Arrays.asList(c1, c9);

        CityConnect obj = new CityConnect();

        List<Connection> result = obj.getLowCost(Connects);


        for (Connection n : result) {
            System.out.println("(" + n.node1 + "," + n.node2 + ") , " + n.cost);
        }


    }


}
