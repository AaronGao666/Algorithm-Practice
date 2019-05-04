package algorithm;

public class FirstMissingPositive {


    public int firstMissingPositive(int[] nums){
        int len=nums.length;
        int first=nums[0]-1;
        int next=nums[0]+1;
        for(int i=1;i<len;i++){
            if(nums[i]==first){
                first=nums[i]-1;
            }else if(nums[i]==next){
                next=nums[i]+1;
            }else if((nums[i]<first && nums[i]>0)||(next<1)){//下一个为正并且比当前的小，则换，或者当前的为负，无脑换
                first=nums[i]-1;
                next=nums[i]+1;
            }
        }
        if(first>0) return first;
        else return next;
    }


    public static void main(String args[]){
        int[] nums={-1,1,2,-4,5,1,10,12,16,3,4,5,6,7};
        FirstMissingPositive obj=new FirstMissingPositive();
        System.out.println(obj.firstMissingPositive(nums));
    }
}
