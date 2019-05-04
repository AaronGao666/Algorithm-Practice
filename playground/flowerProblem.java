import java.util.HashMap;
import java.util.HashSet;

public class flowerProblem {

    public int flowerProblem(int[] flowers, int k, int m) {
        int N = flowers.length;
        int[] days = new int[N];
        for (int i = 0; i < N; i++) days[flowers[i] - 1] = i + 1;

//        for (int i : days) {
//            System.out.print(i + "\t");
//        }

        int[] setID=new int[N];

        int lasyDay=-1;
        for(int i=0;i<N;i++){
            System.out.println("第"+(i+1)+"天：");
            int d=days[i];
            int low=-1;
            int high=-1;
            for(int j=0;j<i;j++){
                if(days[j]==d-1) {
                    low=j;
                }
                if(days[j]==d+1){
                    high=j;
                }
            }

            if(high==-1&&low==-1){
                setID[i]=d;
            }else if(high!=-1&&low==-1){
                setID[i]=setID[high];
            }else if(high==-1&&low!=-1){
                setID[i]=setID[low];
            }else{
                int temp=setID[high];
                setID[i]=setID[low];
                for(int j=0;j<i;j++){
                    if(setID[j]==temp){
                        setID[j]=setID[low];
                    }
                }
            }



            for (int iter: setID) {
                System.out.print(iter+"\t");
            }
            System.out.println("");

            HashMap<Integer,Integer> map=new HashMap<>();
            for(int j=0;j<=i;j++){
                map.put(setID[j],map.getOrDefault(setID[j],0)+1);
            }


            if(map.size()>=m){
                int counter=0;
                for (int key:map.keySet()) {
                    if(map.get(key)>=k){
                        counter++;
                    }
                }
                if(counter>=m){
                    lasyDay=i;
                }
            }

        }


        return lasyDay==-1?-1:lasyDay+1;

//        for(int i=0;i<N;i++){
//
//            int d=days[i];
//            if(d==1){
//                if(setID[d]==0){
//                    setID[d-1]=d;
//                }else{
//                    setID[d-1]=setID[d];
//                }
//
//            }else if(d==N){
//                if(setID[d-2]==0){
//                    setID[d-1]=d;
//                }else{
//                    setID[d-1]=setID[d];
//                }
//            }else{
//                if(setID[d-2]==0&&setID[d]==0){
//                    setID[d-1]=d;
//                }else if(setID[d]==0){
//                    setID[d-1]=setID[d];
//                }else{
//                    setID[d-1]=setID[d-2];
//                }
//            }
//
//        }
//
//        System.out.println("\n");
//
//        for (int i : setID) {
//            System.out.print(i + "\t");
//        }
//
//
//        return 0;




//        HashSet<HashSet<Integer>> totalSet = new HashSet<>();
//
//        int lastday = -1;
//        for (int i = 0; i < N; i++) {
//            HashSet<Integer> loSet = new HashSet<>();
//            HashSet<Integer> hiSet = new HashSet<>();
//
//            for (HashSet<Integer> set : totalSet) {
//                if(set.size()==0){//@todo 也不行？？？？
//                    totalSet.remove(set);
//                }
//                if (set.contains(days[i] - 1)) {
//                    loSet = set;
//                }
//                if (set.contains(days[i] + 1)) {
//                    hiSet = set;
//                }
//            }
//            if (!hiSet.isEmpty() && !loSet.isEmpty()) {
//
//
////                for(HashSet<Integer> set:totalSet){
////                    System.out.println("set："+set);
////                    System.out.println("set.hashcode:"+set.hashCode());
////                }
//
////                System.out.println("hiset.hashcode："+hiSet.hashCode());
//                loSet.addAll(hiSet);
//                loSet.add(days[i]);
////                hiSet.clear();
//                totalSet.remove(hiSet);//@todo 为啥不能直接删除？？？？？
//
//            } else if (hiSet.isEmpty() && !loSet.isEmpty()) {
//                loSet.add(days[i]);
//            } else if (!hiSet.isEmpty() && loSet.isEmpty()) {
//                hiSet.add(days[i]);
//            } else {
//                HashSet<Integer> newSet = new HashSet<>();
//                newSet.add(days[i]);
//                totalSet.add(newSet);
//            }
//
//
//            int qualifyCounter = 0;
//            for (HashSet<Integer> set : totalSet) {
//                if (set.size() >= k) {
//                    qualifyCounter++;
//                }
//            }
//            if (qualifyCounter >= m) {
//                lastday = i + 1;
//            }
//
//            System.out.println("\n第" + (i + 1) + "天：");
//            for (HashSet<Integer> set : totalSet) {
//                System.out.println(set);
//            }
//
//        }

//        return lastday;
    }

    public static void main(String[] args) {

        int[] flowers = {3,5,10,1,7,6,4,2,8,9};
        flowerProblem obj = new flowerProblem();
        System.out.println(obj.flowerProblem(flowers, 2,2));

//
//        HashSet<HashSet<Integer>> totalSet = new HashSet<>();
//        HashSet<Integer> set = new HashSet<>();
//        set.add(100);
//        set.add(200);
//        set.add(300);
//        totalSet.add(new HashSet<>(set));
//        set.clear();
//        set.add(1000);
//        set.add(2000);
//        set.add(3000);
//        totalSet.add(new HashSet<>(set));
//
//
//        HashSet<Integer> hiSet = new HashSet<>();
//        HashSet<Integer> loSet = new HashSet<>();
//        for (HashSet<Integer> s : totalSet) {
//            if (s.contains(1000)) {
//                hiSet = s;
//            }
//            if (s.contains(100)) {
//                loSet = s;
//            }
//        }
//        loSet.addAll(hiSet);
//        totalSet.remove(hiSet);
//
//        for (HashSet<Integer> s : totalSet) {
//            System.out.println(s);
//        }


    }


}
