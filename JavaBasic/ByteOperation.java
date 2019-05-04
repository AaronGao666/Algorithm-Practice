public class ByteOperation {


    public void add(Byte b) {
        b = b++;
    }

    public void test() {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.print(a + " ");
        add(b);
        System.out.print(b + "");
    }

    public static void main(String[] args){

        ByteOperation obj = new ByteOperation();
        obj.test();
        Byte a = 127;
        a = a ++; // 这是无效操作。a赋值给了a，然后老的a ++没有意义了。因为新的a 已经被赋值 。涉及到AutoBoxing / Unboxing 自动装包，拆包

        System.out.println(a);

    }

}
