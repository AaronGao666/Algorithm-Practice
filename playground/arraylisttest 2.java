import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.*;

public class arraylisttest {

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len < 3) return res;
        Arrays.sort(nums);
        int index = Arrays.binarySearch(nums, 0);
        if (index == 0 || index == -1 || -index > len || index == len - 1) {//全非负、全非正
            return res;
        }

        HashMap<Integer, Boolean> map=new HashMap<>();
        List<Integer> nList=new ArrayList<>();//存储负数
        List<Integer> pList=new ArrayList<>();//存储正数
        int countZeros=0;
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                countZeros++;
                continue;
            }
            if(!map.containsKey(nums[i])){
                map.put(nums[i],false);
                if(nums[i]<0){
                    nList.add(nums[i]);
                }else{
                    pList.add(nums[i]);
                }
            }else{
                map.put(nums[i],true);// at least 2 number exists.
            }
        }
        if(countZeros>=3){
            Integer[] zeros={0,0,0};
            res.add(new ArrayList<>(Arrays.asList(zeros)));
        }
        int pLen=pList.size();
        int nLen=nList.size();



        for(int i=0;i<pLen;i++){//only 1 pos nums
            int target=-pList.get(i);
            int nIndex= Collections.binarySearch(nList,target);// 在负数里找
            if(nIndex>=0){
                if(countZeros!=0){
                    Integer[] temp= {target,0,-target};
                    res.add(new ArrayList<>(Arrays.asList(temp))); //先把一个负数情况加入
                }
                nIndex++;
            }else {
                nIndex=-nIndex-1;
            }
            if(nIndex>nLen-1){
                continue;
            }else{
                for(int j=nIndex;j<nLen;j++){
                    int curr=nList.get(j);
                    if(curr*2==target&&map.get(curr)){
                        Integer[] temp={curr,curr,-target};
                        res.add(new ArrayList<>(Arrays.asList(temp)));
                        break;
                    }
                    for(int k=j+1;k<nLen;k++){
                        int curr1=nList.get(k);
                        if(curr+curr1==target){
                            Integer[] temp={curr,curr1,-target};
                            res.add(new ArrayList<>(Arrays.asList(temp)));
                            break;
                        }
                    }
                }
            }
        }
        for(int i=0;i<nLen;i++){
            int target=-nList.get(i);
            int pIndex=Collections.binarySearch(pList,target);
            if(pIndex<0){  //找不找的到，都无所谓，找出一个最大值就行
                pIndex=-pIndex-1;
            }
            for(int j=0;j<pIndex;j++){
                int curr=pList.get(j);
                if(curr*2==target&&map.get(curr)){
                    Integer[] temp={curr,curr,-target};
                    res.add(new ArrayList<>(Arrays.asList(temp)));
                    break;
                }
                for(int k=j+1;k<pLen;k++){
                    int curr1=pList.get(k);
                    if(curr+curr1==target){
                        Integer[] temp={curr,curr1,-target};
                        res.add(new ArrayList<>(Arrays.asList(temp)));
                        break;
                    }
                }

            }

        }


        System.out.println(res);
        return  res;









//
//
//
//
//
//
//
//        int[] positiveArr;
//        int[] negativeArr;
//        if (index > 0) {//0存在
//            int upzero = index;
//            int downzero = index;
//            for (int i = index; i < len; i++) {
//                if (nums[i] != 0) {
//                    upzero = i - 1;
//                    break;
//                } else {
//                    upzero = i;
//                }
//            }
//            for (int j = index; j >= 0; j--) {
//                if (nums[j] != 0) {
//                    downzero = j + 1;
//                    break;
//                } else {
//                    downzero = j;
//                }
//            }
//            if (upzero - downzero >= 2) {
//                Integer[] zeros = {0, 0, 0};
//                res.add(new ArrayList<Integer>(Arrays.asList(zeros)));
//            }
//            if (upzero == len - 1 || downzero == 0) {
//                return res;
//            }
//            positiveArr = Arrays.copyOfRange(nums, upzero + 1, len);
//            negativeArr = Arrays.copyOfRange(nums, 0, downzero);
//        } else {
//            positiveArr = Arrays.copyOfRange(nums, -index - 1, len);
//            negativeArr = Arrays.copyOfRange(nums, 0, -index - 1);
//        }
//
//        System.out.println("正数：");
//        for(int i:positiveArr){
//            System.out.print(i+"\t");
//        }
//        System.out.println("");
//        System.out.println("负数：");
//        for(int i:negativeArr){
//            System.out.print(i+"\t");
//        }
//        System.out.println("");


//
//        int pLen = positiveArr.length;
//        int nLen = negativeArr.length;
//        for (int i = 0; i < pLen; i++) {// only select one postive number.
//            if (i > 0) {
//                if (positiveArr[i] == positiveArr[i - 1]) continue;
//            }
//            int nIndex = Arrays.binarySearch(negativeArr, -positiveArr[i]);
//            if (nIndex >= 0 && index > 0) {  // only if 0 exists.
//                Integer[] temp = {-positiveArr[i], 0, positiveArr[i]};
//                res.add(new ArrayList<Integer>(Arrays.asList(temp)));
//            } else if (-nIndex < nLen && nIndex < 0) { // should select two negative numbers
//                for (int j = -nIndex - 1; j < nLen; j++) {
//                    for (int k = j + 1; k < nLen; k++) {
//                        if (negativeArr[j] + negativeArr[k] == -positiveArr[i]) {
//                            Integer[] temp = {positiveArr[i], negativeArr[j], negativeArr[k]};
//                            res.add(new ArrayList<Integer>(Arrays.asList(temp)));
//                        } else if (negativeArr[j] + negativeArr[k] > -positiveArr[i]) {// won't consider the following  negative nums.
//                            j = nLen;
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < nLen; i++) {//only select one negative number. (have 0 won't be considered here )
//            if (i > 0) {
//                if (negativeArr[i] == negativeArr[i - 1]) continue;
//            }
//            int pIndex = Arrays.binarySearch(positiveArr, -negativeArr[i]);
//            if (pIndex < -1) {
//                for (int j = 0; j < -pIndex - 1; j++) {
//                    for (int k = j + 1; k < -pIndex - 1; k++) {
//                        if (positiveArr[j] + positiveArr[k] == -negativeArr[i]) {
//                            Integer[] temp = {positiveArr[j], positiveArr[k], negativeArr[i]};
//                            res.add(new ArrayList<Integer>(Arrays.asList(temp)));
//                        } else if (positiveArr[j] + positiveArr[k] > -negativeArr[i]) {
//                            j = pLen;
//                            break;
//                        }
//                    }
//                }
//            }
//            if(pIndex>0){//可以找下面两个
//                for (int j = 0; j < pIndex; j++) {
//                    for (int k = j + 1; k < pIndex; k++) {
////                        if(k>j+1){
////                            if(positiveArr[k]==positiveArr[k-1]) continue;
////                        }
//                        if (positiveArr[j] + positiveArr[k] == -negativeArr[i]) {
//                            Integer[] temp = {positiveArr[j], positiveArr[k], negativeArr[i]};
//                            res.add(new ArrayList<Integer>(Arrays.asList(temp)));
//                        }
//                    }
//                }
//            }
//
//        }
//

//        System.out.println(res);
//        return res;

    }


    public static void main(String[] args) {

        int[] temp = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        arraylisttest obj =new arraylisttest();
        obj.threeSum(temp);


    }
}
