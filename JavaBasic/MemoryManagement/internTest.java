package MemoryManagement;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class internTest {


    public static void main(String[] args){

        String str1 = "Java";
        String s1 = new StringBuilder("cs").append(" software ").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("Ja").append("va").toString();
        System.out.println(s2.intern() == s2);
//


//        String str1 = "Java";
//        String str2 = "Java";
//
//        String str3 = new String("Java");

//        String str4 = "Ja";
//        str4 += "va";


//        System.out.println(str2  == str1);


    }


}
