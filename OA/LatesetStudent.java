package GSOA;

import java.lang.reflect.Array;
import java.util.*;

public class LatesetStudent {


        static String latestStudent(List<List<String>> attendanceData) {

            if(attendanceData.size()==0){
                return "";
            }



            HashMap<String, Integer> datePresentStus=new HashMap<>();
            HashMap<String, Integer> dateTotalLate=new HashMap<>();
            HashMap<String, Integer> ClassTime=new HashMap<>();
            HashMap<String, Integer> stuTime=new HashMap<>();
            for(List<String> data:attendanceData) {
                String date = data.get(0);
                int classTime=Integer.parseInt(data.get(2));
                int actuallTime=Integer.parseInt(data.get(3));
                int late=actuallTime-classTime>0?actuallTime-classTime:0;
                datePresentStus.put(date,datePresentStus.getOrDefault(date,0)+1);
                dateTotalLate.put(date,dateTotalLate.getOrDefault(date,0)+late);
                if(!ClassTime.containsKey(date)){
                    ClassTime.put(date,classTime);
                }
            }

            for(String date: datePresentStus.keySet()){

                int stus=datePresentStus.get(date);
                int aveTime=ClassTime.get(date)+dateTotalLate.get(date)/stus;
                ClassTime.put(date,aveTime);
            }

            for(List<String> data: attendanceData){
                String date = data.get(0);
                String name = data.get(1);
                int actualTime=Integer.parseInt(data.get(3));
                int late=actualTime>ClassTime.get(date)? actualTime-ClassTime.get(date):0;
                stuTime.put(name, stuTime.getOrDefault(name,0)+late);
            }


            int latest=0;
//            PriorityQueue<String > namelist=new PriorityQueue<>();
            List<String> namelist=new ArrayList<>();
            for(String name: stuTime.keySet()){

                int late=stuTime.get(name);
                if(late>latest){
                    namelist.clear();
                    namelist.add(name);
                    latest=late;
                }else if(late==latest){
                    namelist.add(name);
                }

            }
            Collections.sort(namelist);
            return namelist.get(0);



//            HashMap<String, HashMap<String, Integer>> map =new HashMap<>();
//            HashMap<String, Integer> classMap=new HashMap<>();
//            HashMap<String, Integer> stuLateness=new HashMap<>();
//
//            for(List<String> data:attendanceData){
//                String date=data.get(0);
//                String name= data.get(1);
//                HashMap<String, Integer> stuTime;
//                if(!classMap.containsKey(date)){
//                    classMap.put(date, Integer.parseInt(data.get(2)));
//                    stuTime=new HashMap<>();
//                    stuTime.put(name, Integer.parseInt(data.get(3)));
//                    map.put(date, stuTime);
//                }else{
//                    stuTime=map.get(date);
//                    stuTime.put(name, Integer.parseInt(data.get(3)));
//                }
//            }
//
//
//            for(String date: classMap.keySet() ){
//
//                HashMap<String, Integer> stuTime=map.get(date);
//                int totalLate=0;
//                int totalStus=stuTime.size();
//                for(String name: stuTime.keySet()){
//                    int lateTime=stuTime.get(name)-classMap.get(date);
//                    totalLate+= lateTime>0? lateTime:0;
//                }
//                classMap.put(date, classMap.get(date)+totalLate/totalStus);
//
//                for(String name:stuTime.keySet()){
//                    int lateTime=stuTime.get(name)-classMap.get(date);
//                    if(lateTime<0) lateTime=0;
//                    stuLateness.put(name, stuLateness.getOrDefault(name, 0)+lateTime);
//                }
//            }
//
//
//            for(String date:classMap.keySet()){
//                System.out.println(date+"，"+classMap.get(date));
//            }
//
//
//            PriorityQueue<String> namelist=new PriorityQueue<>();
//            int latest=0;
//
//            for(String name: stuLateness.keySet()){
//                int late=stuLateness.get(name);
//
//                System.out.println("name:"+name+"，late:"+late);
//                if(late>latest){
//                    namelist.clear();
//                    namelist.offer(name);
//                    latest=late;
//                }else if(late==latest){
//                    namelist.offer(name);
//                }
//            }
//
//
//            return namelist.poll();
        }



    public static void main(String[] args){

//            String[] s1={"09-01", "Arlene", "540","570"};
//            List<String> l1= Arrays.asList(s1);
//            String[] s2={"09-01","Bobby" ,"540" ,"543"};
//            List<String> l2= Arrays.asList(s2);
//            String[] s3={"09-01" ,"Caroline", "540", "530"};
//            List<String> l3= Arrays.asList(s3);
//
//            String[] s4={"09-02", "Arlene", "540", "580"};
//        List<String> l4= Arrays.asList(s4);
//            String[] s5={"09-02" ,"Bobby", "540", "580"};
//        List<String> l5= Arrays.asList(s5);
//        String[] s6={"09-02" ,"Caroline", "540", "595"};
//        List<String> l6= Arrays.asList(s6);
//        List<List<String>> list=new ArrayList<>();
//        list.add(l1);
//        list.add(l2);
//        list.add(l3);
//        list.add(l4);
//        list.add(l5);
//        list.add(l6);
//
//        System.out.println(latestStudent(list));


//        PriorityQueue<String> namelist=new PriorityQueue<>();
        List<String> namelist=new ArrayList<>();
        namelist.add("Arlene");
        namelist.add("BOB");
        namelist.add("Aa");
        namelist.add("a");





        System.out.println(namelist.get(0));



    }

}
