import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.lang.reflect.Array;
import java.util.*;

 class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }


public class MergeIntervals {


    public static void main(String[] args){

        List<Interval> intervals=new ArrayList<>();

        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));

        Collections.sort(intervals, Comparator.comparing((Interval a)->a.start).thenComparing((Interval a)->a.end));
        int len=intervals.size();
        for(int i=1;i<len;i++){
            if(intervals.get(i).start<=intervals.get(i-1).end){
                intervals.get(i-1).end=intervals.get(i).end;
                intervals.remove(i);

            }
        }
        System.out.println(intervals);
    }

}
