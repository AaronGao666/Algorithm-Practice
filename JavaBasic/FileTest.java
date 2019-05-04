import java.io.*;

public class FileTest {

    public static void main(String[] args){
        File file = new File("/Users/aaron/IdeaProjects/JavaBasic/src/test.txt");

        System.out.println(file.exists());

        File backup = new File("test.txt.bak");
        backup.delete();
        file.renameTo(backup);
    }
}
