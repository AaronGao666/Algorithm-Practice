import java.util.*;

public class OktaOA {

    public String[] solution(String[] A, int Y) {

        HashMap<String, HashMap<Integer, Integer>> map = new HashMap<>();
        List<String> nameList = new ArrayList<>();
        HashMap<String, Integer> countMap = new HashMap<>();
        HashSet<Integer> timeSet = new HashSet<>();
        PriorityQueue<Integer> timepq = new PriorityQueue<>();

        for (String s : A) {
            String[] temp = s.split(" ");
            String name = temp[0];
            int timeStamp = Integer.parseInt(temp[1]);
            int mins = timeStamp / 60;
            if (map.containsKey(name)) {
                HashMap<Integer, Integer> freq = map.get(name);
                int currCount = freq.getOrDefault(mins, 0) + 1;
                if (currCount >= Y) {
                    currCount = Y;
                }
                freq.put(mins, currCount);
            } else {
                HashMap<Integer, Integer> freq = new HashMap<>();
                freq.put(mins, 1);
                map.put(name, freq);
            }

            if (!timeSet.contains(mins)) {
                timeSet.add(mins);
                timepq.offer(mins);
            }

            if (!countMap.containsKey(name)) {
                countMap.put(name, 0);
                nameList.add(name);
            }

        }


        int users = map.size();
        int timeCount = timeSet.size();
        int[] times = new int[timeCount];
        for (int i = 0; i < timeCount; i++) {
            times[i] = timepq.poll();
        }

        int[] totalReqPerMin = new int[timeCount];
        for (int i = 0; i < timeCount; i++) {
            int time = times[i];
            int totalReq = 0;
            for (String name : map.keySet()) {
                int curr = map.get(name).getOrDefault(time, 0);
                totalReq += curr;
                countMap.put(name, countMap.getOrDefault(name, 0) + curr);
            }
            totalReqPerMin[i] = totalReq;
        }

        for (String name : map.keySet()) {

            for (int i = 0; i < timeCount; i++) {
                int blockCountTest = 0;
                int totalCount = 0;
                int j = i;
                for (; j < timeCount && times[j] < times[i] + 5; j++) {
                    int time = times[j];
                    blockCountTest += map.get(name).getOrDefault(time, 0);
                    totalCount += totalReqPerMin[j];
                    if (totalCount >= 10 && blockCountTest * 2 > totalCount) {
                        if (map.get(name).containsKey(time + 1)) {
                            countMap.put(name, countMap.get(name) - map.get(name).get(time + 1));
                        }
                        if (map.get(name).containsKey(time + 2)) {
                            countMap.put(name, countMap.get(name) - map.get(name).get(time + 2));
                        }
                        break;
                    }

                }
                i = j;
            }
        }
        String[] res = new String[users];
        for (int i = 0; i < users; i++) {
            String name = nameList.get(i);
            res[i] = (name + " " + countMap.get(name));
        }
        return res;
    }

    public static void main(String[] args) {
        String[] a = {"java 0", "java 15", "java 59", "java 60", "java 120", "java 240", "python 0", "python 15", "python 45", "python 125"};

        String[] b = {"client1 0", "client1 15", "client1 30", "client1 45", "client1 60", "client1 75", "client1 90", "client1 120", "client1 180", "client1 240", "client2 0", "client2 60", "client2 120", "client2 180", "client2 240", "client2 320"};
        int y = 3;
        OktaOA obj = new OktaOA();
        String[] res = obj.solution(b, y);
        for (String s : res) {
            System.out.println(s);
        }
    }


}
