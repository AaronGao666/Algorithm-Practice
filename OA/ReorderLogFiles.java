package AmazonOA;

import java.util.*;

public class ReorderLogFiles {


    public List<List<String>> reorder(List<List<String>> logs) {
//        PriorityQueue<List<String>> pq = new PriorityQueue<List<String>>(new Comparator<List<String>>() {
//            @Override
//            public int compare(List<String> l1, List<String> l2) {
//
//                boolean isNum1 = l1.get(1).charAt(0) <= '9' && l1.get(1).charAt(0) >= '0';
//                boolean isNum2 = l2.get(1).charAt(0) <= '9' && l2.get(1).charAt(0) >= '0';
//
//                if (isNum1 && !isNum2) return 1;
//                else if (!isNum1 && isNum2) return -1;
//                else {
//
//                    int index = 1;
//                    while (index < l1.size() && index < l2.size()) {
//
//                        if (l1.get(index).equals(l2.get(index)))
//                            index++;
//                        else return l1.get(index).compareTo(l2.get(index));
//                    }
//
//                    if (l1.size() == l2.size()) {
//                        return l1.get(0).compareTo(l2.get(0));
//                    } else {
//                        return l1.size() > l2.size() ? 1 : -1;
//                    }
//
//                }
//
//            }
//        });
//
//
//        for(List<String> log : logs){
//            pq.offer(log);
//        }
//
//        List<List<String>> result = new ArrayList<>();
//        while(!pq.isEmpty()){
//            result.add(pq.poll());
//        }



        Collections.sort(logs, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> l1, List<String> l2) {
                boolean isNum1 = l1.get(1).charAt(0) <= '9' && l1.get(1).charAt(0) >= '0';
                boolean isNum2 = l2.get(1).charAt(0) <= '9' && l2.get(1).charAt(0) >= '0';

                if (isNum1 && !isNum2) return 1;
                else if (!isNum1 && isNum2) return -1;
                else {

                    int index = 1;
                    while (index < l1.size() && index < l2.size()) {

                        if (l1.get(index).equals(l2.get(index)))
                            index++;
                        else return l1.get(index).compareTo(l2.get(index));
                    }

                    if (l1.size() == l2.size()) {
                        return l1.get(0).compareTo(l2.get(0));
                    } else {
                        return l1.size() > l2.size() ? 1 : -1;
                    }

                }
            }
        });

        return logs;

//        return result;
    }


    public static void main(String[] args) {

        List<List<String>> logs = new ArrayList<>();

        logs.add(Arrays.asList("a1", "9", "2", "3", "1"));
        logs.add(Arrays.asList("11", "act", "car"));
        logs.add(Arrays.asList("g1", "act", "car"));
        logs.add(Arrays.asList("zo4", "4", "7"));
        logs.add(Arrays.asList("ab1", "off", "key", "dog"));
        logs.add(Arrays.asList("a8", "act", "zoo"));

        ReorderLogFiles obj = new ReorderLogFiles();
        List<List<String>> result = obj.reorder(logs);

        for(List<String> res : result){
            System.out.println(res);
        }
    }


}
