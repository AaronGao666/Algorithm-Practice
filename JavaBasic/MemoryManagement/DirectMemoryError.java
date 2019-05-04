package MemoryManagement;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class DirectMemoryError {

    private static final int _1MB = 1024*1024;

    public static void main(String[] args) throws Exception{
        Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);

        System.out.println(unsafe);

        while(true){
            unsafe.allocateMemory(_1MB);
        }

    }


}
