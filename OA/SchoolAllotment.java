package GSOA;

import java.util.*;

public class SchoolAllotment {


    public int[] allocateStu(int[] schoolSeats, int[] stuScores, int[][] stuPrefer){


        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->(stuScores[b]-stuScores[a]));

        int stus=stuScores.length;
        int schools=schoolSeats.length;
        int haveNoSchoolToGo=stus;
        int haveAvaliableSeats=0;

        for(int i=0;i<stus;i++){
            pq.offer(i);
        }

        int preferLen=stuPrefer[0].length;
        while(!pq.isEmpty()){

            int stu=pq.poll();

            for(int i=0;i<preferLen;i++){

                int school=stuPrefer[stu][i];
                if(schoolSeats[i]>0){
                    schoolSeats[i]--;
                    haveNoSchoolToGo--;
                    break;
                }
            }

        }

        for(int i=0;i<schools;i++){
            haveAvaliableSeats+=schoolSeats[i];
        }

        int[] res={haveAvaliableSeats,haveNoSchoolToGo};
        return  res;
    }


    public static void main(String[] args){


        int[] schoolSeats={1,3,1,2};
        int[] stuScore={990,780,830,860,920};
        int[][] stuPrefer={
                {3,2,1},
                {3,0,0},
                {2,0,1},
                {0,1,3},
                {0,2,3},
        };
        SchoolAllotment obj=new SchoolAllotment();

        int[] res=obj.allocateStu(schoolSeats,stuScore,stuPrefer);
        for(int i:res){
            System.out.println(i);
        }


    }


}
