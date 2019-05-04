package algorithm;
import java.util.*;

public class MaxPointsOnAline {
    class Point{
        int x;
        int y;
        Point(){x=0;y=0;}
        Point(int a, int b){x=a;y=b;}
    }
    public Point[] pointsgeneration (int[][] arr){
        int len=arr[0].length;//获取总点数
        Point[] points=new Point[len];
        for(int i=0;i<len;i++){
            points[i]=new Point();
            points[i].x=arr[0][i];
            points[i].y=arr[1][i];
        }
        return points;
    }
    public boolean isInALine(Point a,Point b,Point c){

        if(a.x==b.x||a.x==c.x||b.x==c.x){
            if(a.x==b.x&&b.x==c.x) {
                return true;
            }
            else return false;
        }
        else if(a.y==b.y||a.y==c.y||b.y==c.y){
            if(a.y==b.y&&c.y==a.y){
                return true;
            }
            else return false;
        }
        else if((float)((c.y-b.y)/(b.y-a.y))==(float)(c.x-b.x)/(b.x-a.x)){
            return true;

        }
        else return false;
    }



    static int maxno=2;//点数计数器

    public ArrayList<ArrayList<Point>> maxPoints(Point[] points){
        ArrayList<ArrayList<Point>> result=new ArrayList<ArrayList<Point>>();
        int index1=0;
        int index2=1;
        int index3=2;

        for(index1=0;index1<points.length-2;index1++){
            for(index2=index1+1;index2<points.length-1;index2++){
                int count=2;
                ArrayList<Point> line=new ArrayList<Point>();
                line.add(points[index1]);
                line.add(points[index2]);
                for(index3=index2+1;index3<points.length;index3++){
                    if(isInALine(points[index1],points[index2],points[index3])){
                        line.add(points[index3]);
                        count++;
                    }

                }
                if (count>maxno){
                    maxno=count;
                    result.clear();
                    result.add(line);
                }
                else if(count==maxno&&count>2){
                    result.add(line);
                }
            }
        }

        return result;
    }


    public static void main(String args[]){
        int [][] arr={{2,5,1,3,2,4,5,4,6},{1,7,5,9,9,1,9,2,3}};//x坐标们和y坐标们

        MaxPointsOnAline test=new MaxPointsOnAline();
        Point[] points=test.pointsgeneration(arr);

        ArrayList<ArrayList<Point>> result=test.maxPoints(points);
        int nooflines=1;
        for(ArrayList<Point> line: result){

            System.out.println("第"+nooflines+"条线由以下点构成：");
            for (Point p:line){
                System.out.print("("+p.x+","+p.y+")");
            }
            System.out.println();
            nooflines++;
        }



    }

}
