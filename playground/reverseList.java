import java.util.Stack;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


public class reverseList {

    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }

        Stack<ListNode> st=new Stack<>();
        while(head!=null){
            st.push(head);
            head=head.next;
        }
        ListNode newHead=st.pop();
        ListNode iter=newHead;
        while(!st.isEmpty()){
            iter.next=st.pop();
            iter=iter.next;
        }
        return newHead;
    }
    public static void main(String[] args){
        int[] arr={1,2,3,4,5};
        ListNode head=new ListNode(arr[0]);
        ListNode iter=head;
        for(int i=0;i<arr.length;i++){
            if(i<arr.length-1){
                iter.next=new ListNode(arr[i+1]);
            }else{
                iter.next=null;
            }
            iter=iter.next;
        }
        reverseList obj=new reverseList();
        ListNode newHead=obj.reverseList(head);

    }

}
