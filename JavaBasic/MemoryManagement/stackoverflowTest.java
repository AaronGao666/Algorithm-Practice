package MemoryManagement;


//@todo 高危操作！ 会导致系统假死
//-Xss2M
public class stackoverflowTest {

    private void dontStop(){
        while(true){

        }
    }

    public void stackLeakByThread(){
        while(true){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });

            t.start();
        }
    }



    public static void main(String[] args) throws Throwable{
        stackoverflowTest obj  = new stackoverflowTest();
        obj.stackLeakByThread();
    }
}
