package algorithm;

public class ReachPoints {
//    public int fibonacci(int n){
//        if(n==0){
//            return 0;
//        }
//        if(n==1||n==2){
//            return 1;
//        }
//        else return fibonacci(n-1)+fibonacci(n-2);
//    }

    static boolean xequal=false;
    static boolean yequal=false;


    public boolean reachingPoint(int sx,int sy, int tx, int ty) {

        if(tx==ty){
            if((tx==sx&&ty==sy)||(tx==sx&&sy==0)||(ty==sy&&sx==0)) return true;
            else return false;
        }
        else {
            if(tx>ty){

                if(tx==sx){
                    xequal=true;
                }
                tx=tx-ty;

                if(tx==sx){
                    xequal=true;
                }
//                System.out.println("减完以后tx："+tx);
                if(yequal) return true;
                else return reachingPoint(sx,sy,tx,ty);
            }
            else if(tx<ty){

                if(ty==sy){
                    yequal=true;
                }
                ty=ty-tx;

                if(ty==sy){
                    yequal=true;
                }
//                System.out.println("减完以后ty："+ty);
                if(xequal) return true;
                else return reachingPoint(sx,sy,tx,ty);
            }

        }
        System.out.println("无法判断");
        return false;
    }
    public static void main(String[] args){
        ReachPoints test=new ReachPoints();

        System.out.println(test.reachingPoint(2,0,2,2));
    }


}
