import java.math.BigDecimal;

//@todo 所有interface里的变量都是final static???
interface Account{
    BigDecimal balance = new BigDecimal(0.0);
}
class SavingAccount implements Account{
    public SavingAccount(BigDecimal init){
//        balance = init; //@todo !!!
    }
    public String toString(){
        return balance.toString();
    }
}

public class BigNumTest {
    public static void main(String[] args){
        SavingAccount obj = new SavingAccount(new BigDecimal(50.00));
        System.out.println(obj);
        BigDecimal val = new BigDecimal(20.0);
        BigDecimal val1 = new BigDecimal(21.0);
        val = val1;

    }
}
