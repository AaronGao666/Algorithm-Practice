import java.util.*;

public class ReorderList {


    public void reorderList(ListNode head) {

        Queue<ListNode> q=new LinkedList<>();//first half
        Stack<ListNode> stk=new Stack<>();//second half


        ListNode slow=head;
        ListNode quick=head.next;
        while(quick!=null && quick.next!=null){
            q.offer(slow);
            slow=slow.next;
            quick=quick.next.next;
        }
        q.offer(slow);
        slow=slow.next;

        while(slow!=null){
            stk.push(slow);
            slow=slow.next;
        }


        ListNode first=q.poll();
        ListNode last=stk.pop();
        System.out.println("First:"+first.val);
        System.out.println("last: "+last.val);
        first.next=last;
        while(!stk.isEmpty()){

            first=q.poll();
            System.out.println("First:"+first.val);
            last.next=first;
            last=stk.pop();
            System.out.println("last: "+last.val);
            first.next=last;
        }
        last.next=null;
        if(!q.isEmpty()){
            first=q.poll();
            last.next=first;
            first.next=null;
        }

    }


    public static void main(String[] args){

        ReorderList obj=new ReorderList();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);

        head.next.next.next.next=new ListNode(5);
        obj.reorderList(head);

        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }




    }
}
