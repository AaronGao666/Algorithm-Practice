//class Account<T>{
//    private T accountType;
//    public void add(T newType){
//        accountType = newType;
//    }
//    public T get(){
//        return accountType;
//    }
//}


class Foo{
    native int bar(String s );
    static {
        System.loadLibrary("foo_bar");
    }
}