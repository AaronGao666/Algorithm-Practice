package GSOA;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class WorldCup {



    public static void main(String[] args){

        double d=12.9181201921312;
        BigDecimal bg = new BigDecimal(d).setScale(2, RoundingMode.DOWN);
        double d1=bg.doubleValue();
        System.out.println(d1);



    }



}
