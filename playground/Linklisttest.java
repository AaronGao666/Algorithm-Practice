public class Linklisttest {


    public ListNode reverseBetween(ListNode head, int m, int n) {

        int counter =1;
        ListNode nodeM=head;
        ListNode nodePreM=null;
        while(++counter<=m){
            nodePreM=nodeM;
            nodeM=nodeM.next;
        }

        ListNode iter1=nodeM;
        ListNode iter2=nodeM.next;
        while(counter++<=n){
            ListNode temp=iter1;
            iter1=iter2.next;
            iter2.next=temp;

            temp=iter1;
            iter1=iter2;
            iter2=temp;
        }
        if(nodePreM==null){
            head=iter1;
        }else{
            nodePreM.next=iter1;
        }
        nodeM.next=iter2;
        return head;
    }
    public static void main(String[] args){

        ListNode[] list=new ListNode[6];
        list[0]=new ListNode(0);
        for(int i=1;i<=5;i++){
            list[i]=new ListNode(i);
            list[i-1].next=list[i];
        }

        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        n1.next=n2;


        Linklisttest obj=new Linklisttest();
        ListNode res=obj.reverseBetween(list[1],2,4);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }

    }
}
