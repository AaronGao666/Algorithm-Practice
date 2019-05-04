import java.util.*;

public class CourseSchedule {
    class Node {
        int val;
        int indegree;
        List<Node> nexts;

        public Node(int val) {
            this.val = val;
            this.indegree = 0;
            this.nexts = new ArrayList<>();
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, Node> map = new HashMap<>();
        HashSet<Node> rest = new HashSet<>();
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing((Node n) -> n.indegree));
        for (int[] a : prerequisites) {

            Node n0 = map.computeIfAbsent(a[0], k -> new Node(a[0]));
            Node n1 = map.computeIfAbsent(a[1], k -> new Node(a[1]));
            n0.indegree++;
            n1.nexts.add(n0);
        }

        for (Node n : map.values()) {
            if (n.indegree == 0) {
                q.offer(n);
            } else {
                rest.add(n);
            }
        }

        while (!q.isEmpty()) {
            Node n = q.poll();
            for (Node next : n.nexts) {
                next.indegree--;
                if (next.indegree == 0) {
                    q.offer(next);
                    rest.remove(next);
                }
            }
        }
        return rest.isEmpty();
    }


    public static void main(String[] args) {
        int[][] a = {{1, 0}, {2, 1}};
        CourseSchedule obj = new CourseSchedule();
        System.out.println(obj.canFinish(3, a));
    }
}
