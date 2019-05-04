import java.util.*;
import java.io.*;

public class IOtest {

    public static void main(String[] args) {


        Map<String, Integer> names = Calendar.getInstance().getDisplayNames(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH);
        try {
            FileOutputStream fos = new FileOutputStream("test.txt");
            Writer out = new OutputStreamWriter(fos, "UTF-16");
            out.write(names.toString());
            out.close();

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }


}
