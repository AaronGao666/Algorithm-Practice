import java.sql.SQLSyntaxErrorException;

class Invoice{
    public static String formatId(String s){
        return s +"_Invoice";
    }
}

class SalesInvoice extends Invoice{
    public static String formatId(String s ){
        return s +"_SalesInvoice";
    }
}


class Superclass{
    Superclass(){
        this(0);
        System.out.println("1");
    }
    Superclass(int x){
        System.out.println("2" + x);
    }
}

class Subclass extends Superclass{
    Subclass(int x ){
        System.out.println("3" + x);
    }
    Subclass(int x, int y){
        this(x);
        System.out.println("4" + x + y);
    }
    public static void main(String[] args){
        new Subclass(2,3);
    }
}




class LB_1{
    public void ret(){
        System.out.println("LB_1");
    }
}
class LB_2 extends LB_1{
    public void ret(){
        System.out.println("LB_2");
    }
    public static void main(String[] args){
        LB_1 lb= new LB_2();//@todo 其实也就是意味着new 的是啥类，执行的时候就是啥类的方法。跟上面那个例子的构造器不同。
        lb.ret();
    }
}



public class InheritanceDemo {


    public static void main(String[] args){

        SalesInvoice invoice = new SalesInvoice();
        System.out.println(Invoice.formatId("1234"));



        

    }



}
