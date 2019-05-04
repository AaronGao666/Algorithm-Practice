package MemoryManagement;
//-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
import java.util.*;
public class mm {


    public static void main(String[] args){
        List<mm> list = new ArrayList<>();
        while(true){
            list.add(new mm());
        }
    }


}
