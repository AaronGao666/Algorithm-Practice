import  java.util.*;
public class Killprocess {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        List<Integer> res = new ArrayList<>();
        int size = pid.size();
        HashMap<Integer, Integer> pMap = new HashMap<>();
        for(int i = 0; i < size; i ++){
            pMap.put(pid.get(i), ppid.get(i));
        }


        for (int i : pMap.keySet()) {
            System.out.println(i + "->" + pMap.get(i));
        }

        for(int i = 0; i < size; i ++){
            if(find(pMap, kill, pid.get(i))){
                res.add(pid.get(i));
            }
        }

        return res;
    }
    private boolean find(HashMap<Integer, Integer> pMap, int kill, int curr){

        if(curr == kill){
            return true;
        }

        while(curr != 0 ){
            curr = pMap.get(curr);
            if(curr == kill){
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args){
        Integer[] p = {1,3, 10,5};
        Integer[] q = {3,0,5,3};
        List<Integer> pid = Arrays.asList( p);
        List<Integer> ppid = Arrays.asList( q);
        int kill= 5 ;

        System.out.println(new Killprocess().killProcess(pid,ppid,kill));

    }
}
