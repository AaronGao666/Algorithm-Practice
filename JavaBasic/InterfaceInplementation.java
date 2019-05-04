interface test{

    int a = 6; //即使不说明，也是static final的变量。

    void printTime(); //所有的interface里的方法都是public abstract 的。不允许其他修饰
//    static void print(); //@todo jdk1.8以后可以允许static 方法，但是必须写出body。即使是{}也行
    static void print(){
        System.out.println("this is a static method in the interface");
    }
}

public class InterfaceInplementation implements test{

    @Override
    public void printTime() { //如果改成小范围会报错。必须也是public
        System.out.println("这是inplement接口的方法");
    }


    public static void main(String[] args){
        InterfaceInplementation obj = new InterfaceInplementation();
        System.out.println(obj.a);

    }

}
