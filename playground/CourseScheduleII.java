import java.util.*;
public class CourseScheduleII {


    class Node{
        int val;
        int indegree;
        List<Node> nexts;
        public Node(int val){
            this.val = val;
            this.indegree = 0;
            this.nexts = new ArrayList<>();
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        HashSet<Node> rest = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        for (int[] a : prerequisites) {
            Node n0 = map.computeIfAbsent(a[0], k -> new Node(a[0]));
            Node n1 = map.computeIfAbsent(a[1], k -> new Node(a[1]));
            n0.indegree++;
            n1.nexts.add(n0);
        }

        for(int i = 0; i < numCourses; i ++){
            Node n = map.get(i);
            if(n == null){
                res.add(i);
            }else if(n.indegree == 0){
                q.offer(n);
                res.add(i);
            }else{
                rest.add(n);
            }
        }
        System.out.println(res);

        while(!q.isEmpty()){

            Node node = q.poll();

            for(Node n : node.nexts){
                if(rest.contains(n)){
                    n.indegree --;
                    if(n.indegree == 0){
                        res.add(n.val);
                        rest.remove(n);
                        q.offer(n);
                    }
                }
            }
        }
        int[] result;
        System.out.println(res);
        if(res.size() == numCourses){
            result = new int[numCourses];
            for(int i = 0; i < numCourses; i ++){
                result[i] = res.get(i);
            }

        }else{
            result = new int[0];
        }

        return result;
    }

    public static void main(String[] args){
        CourseScheduleII obj = new CourseScheduleII();
        int[][] a = {{1,0},{2,1}};
        int num = 3;
        int[] res = obj.findOrder(num,a);
        System.out.println("resArr: ");
        for(int i : res){
            System.out.print(i + "\t");
        }
    }
}
