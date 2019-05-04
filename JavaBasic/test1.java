import com.sun.xml.internal.ws.api.model.CheckedException;

public class test1 {



    public static void main(String[] args){




    }



}


class MyEx extends Exception{
    public String getR() throws Exception{
        throw new Exception();
    }
}

class MyEx1 extends RuntimeException {
    private static final long serialVersionUID = 1l;

    public MyEx1(String s) {
        super(s);
    }

    public String getLocalizedMessage() {
        return "thisis myex1";
    }
}