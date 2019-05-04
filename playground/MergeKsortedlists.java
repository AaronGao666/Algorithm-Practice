import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.util.*;


public class MergeKsortedlists {

//    public ListNode mergeKLists(ListNode[] lists) {


//        ListNode res=new ListNode(-1);//dummy node
//        ListNode iter=res;
//        int size=lists.length;
//        List<ListNode> buff=new LinkedList<>();
//        for(int i=0;i<size;i++){
//            buff.add(lists[i]);
//        }
//        Collections.sort(buff, (a, b)->(a.val-b.val));
//        while(buff.size()!=0){
//            ListNode n=buff.get(0);
//            ListNode next=n.next;
//            buff.remove(0);
//            iter.next=n;
//            iter=n;
//            if(next!=null){
//                buff.add(next);
//            }
//        }
//    }
//    public void minHeapAdd(ListNode[] lists){
//
//
//    }
//    public ListNode minHeapDel(ListNode[] lists){
//
//    }

    public static void main(String[] args){


        int[] arr={1,1,2};
        ListNode[] lists=new ListNode[arr.length];
        for(int i=0;i<arr.length;i++){
            lists[i]=new ListNode(arr[i]);
        }

//        PriorityQueue<ListNode> q=new PriorityQueue(lists.length);
    }


}
