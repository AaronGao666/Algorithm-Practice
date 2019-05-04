import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Intervals {

    /**
     * Definition of Interval:
     * public classs Interval {
     *     int start, end;
     *     Interval(int start, int end) {
     *         this.start = start;
     *         this.end = end;
     *     }
     * }
     */

    /**
     * @param intervals:   Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {


        int len = intervals.size();

        if (len == 0) {
            intervals.add(newInterval);
            return intervals;
        }


        int start = 0;
        int end = len - 1;
        if (newInterval.start > intervals.get(end).end) {
            intervals.add(newInterval);
            return intervals;
        } else if (newInterval.end < intervals.get(0).start) {
            intervals.add(0, newInterval);
            return intervals;
        }


        int mid = (start + end) / 2;
        while (start < end - 1) {
            if (intervals.get(mid).start == newInterval.start) {
                start = mid;
                break;
            } else if (intervals.get(mid).start < newInterval.start) {
                start = mid;
                mid = (start + end) / 2;
            } else {
                end = mid;
                mid = (start + end) / 2;
            }
        }

        int startIndex = start;
        start = 0;
        end = len - 1;
        mid = (start + end) / 2;
        while (start < end - 1) {
            if (intervals.get(mid).end == newInterval.end) {
                end = mid;
                break;
            } else if (intervals.get(mid).end < newInterval.end) {
                start = mid;
                mid = (start + end) / 2;
            } else {
                end = mid;
                mid = (start + end) / 2;
            }
        }

        int endIndex = end;


//        if (intervals.get(startIndex).end < newInterval.start && intervals.get(endIndex).start > newInterval.end) {
//            intervals.add(startIndex + 1, newInterval);
//            return intervals;
//        }

        if(intervals.get(endIndex).start > newInterval.end){
            endIndex--;
        }
        if(intervals.get(startIndex).end < newInterval.start){
            startIndex++;
        }
        if(endIndex < startIndex){
            intervals.add(startIndex,newInterval);
            return intervals;
        }



        List<Interval> res = new ArrayList<>();

        for (int i = 0; i < startIndex; i++) {
            res.add(intervals.get(i));
        }
        res.add(new Interval(Math.min(newInterval.start, intervals.get(startIndex).start), Math.max(newInterval.end, intervals.get(endIndex).end)));
        for (int i = endIndex + 1; i < len; i++) {
            res.add(intervals.get(i));
        }
        return res;


//            int len=intervals.size();
//
//            if(len==0){
//                intervals.add(newInterval);
//                return intervals;
//            }
//
//
//            int index= Collections.binarySearch(intervals, newInterval, Comparator.comparing((Interval a)->(a.start)));
//
//            if(index<0){
//                index=-index-1;
//            }
//
//            if(index==len){
//                intervals.add(newInterval);
//                return intervals;
//            }
//
//
//            int end=index;
//            while(intervals.get(end).start<=newInterval.end ){
//                end++;
//                if(end>=len){
//                    end=len-1;
//                    break;
//                }
//            }
//
//            System.out.println(index+","+end);
//
//            if(end==index){
//                if(intervals.get(end).end<newInterval.start){
//                    intervals.add(end+1,newInterval);
//                    return intervals;
//                }
//                if(intervals.get(end).start>newInterval.end){
//                    intervals.add(end,newInterval);
//                    return intervals;
//                }
//            }
//
//            int min=Math.min(newInterval.start,intervals.get(index).start);
//            int max=Math.max(newInterval.end,intervals.get(end).end);
//
//            intervals.set(index,new Interval(min,max));
//            for(int i=index+1;i<=end;i++){
//                intervals.remove(i);
//            }
//            return intervals;
    }

    public static void main(String[] args) {

        Interval i1 = new Interval(1, 2);
        Interval i2 = new Interval(3, 4);

        List<Interval> list = new ArrayList<>();
        list.add(i1);
        list.add(i2);
        list.add(new Interval(6, 7));
        list.add(new Interval(8, 10));
        list.add(new Interval(16, 17));


        Interval i3 = new Interval(11, 13);

        Intervals obj = new Intervals();
        list = obj.insert(list, i3);
        for (Interval i : list) {
            System.out.println(i.start + "\t" + i.end);
        }
    }


}
