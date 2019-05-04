

/*
* 初始化过程是这样的：
1.首先，初始化父类中的静态成员变量和静态代码块，按照在程序中出现的顺序初始化；
2.然后，初始化子类中的静态成员变量和静态代码块，按照在程序中出现的顺序初始化；
3.其次，初始化父类的普通成员变量和代码块，在执行父类的构造方法；
4.最后，初始化子类的普通成员变量和代码块，在执行子类的构造方法；
*
* */

class C {
    C() {
        System.out.print("C");
    }
}

class A {


    A() {
        this("A");
        System.out.print("A");
    }

    A(String s) {
        System.out.print(s);
    }


    C c = new C();
}


public class ClassInitializationProcess extends A{

    ClassInitializationProcess() {
        super("B");
        System.out.print("B");
    }

    public static void main(String[] args) {
        new ClassInitializationProcess();
    }

}
