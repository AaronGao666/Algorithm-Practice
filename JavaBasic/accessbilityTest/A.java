package accessbilityTest;
public class A {
    public void m1(){ //全球可见
        System.out.println("Am1");
    }
    protected void m2(){ //本类和子类（可以跨包）可见，包内也可见
        System.out.println("Am2");
    }
    private void m3(){//只有本类可见
        System.out.println("Am3");
    }
    void m4(){ //包内可见
        System.out.println("Am4");
    }
}

class B{
    public static void main(String[] args){
        A a = new A();
        a.m1();
        a.m2();
//        a.m3(); @todo 这里报错
        a.m4();
    }
}