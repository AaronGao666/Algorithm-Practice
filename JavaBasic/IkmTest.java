public class IkmTest {
    public IkmTest(){
        this(10);
    }
    public IkmTest(int data){
        this.data = data;
    }
    void display(){
        System.out.println("data = " + data);
    }
    int data;
    class Decre{
        public void decre(double data){
            data = data -1.0;
        }
    }

    public static void main(String[] args){
        int data = 0;
        IkmTest t = new IkmTest(data);
        t.display();
    }
}
