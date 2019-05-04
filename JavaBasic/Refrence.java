import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

class myDemo{
    int val;
    myDemo(int val){
        this.val = val;
    }
    myDemo(){
    }
}


public class Refrence {

    public static void main(String[] args){

        myDemo obj = new myDemo(3);
        SoftReference<myDemo> softRef = new SoftReference<>(obj); // 生成一个对象的软引用，obj有两个引用

        obj = null;//此时只剩一个软引用。jvm会在抛出outofmemory之前回收它

        WeakReference<myDemo> weakRef = new WeakReference<>(obj);
        Runtime rt = Runtime.getRuntime();
        System.gc();
        rt.runFinalization();
        System.gc();
        obj = softRef.get();
        System.out.println(obj.val);//此时会打印出来结果，表明gc没有回收软引用。

        obj = weakRef.get();
        System.out.println(obj.val);//这儿会抛出NPE

        WeakHashMap<myDemo, Integer> map = new WeakHashMap<>();//如果 弱引用key被回收，则value对象也被回收。强key则不会



    }

}
