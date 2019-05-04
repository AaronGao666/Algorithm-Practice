import java.util.HashSet;

public class CompareVerison {


    public int compareVersion(String version1, String version2) {

        String[] v1s = version1.split("[.]");
        String[] v2s = version2.split("[.]");
        int len1 = v1s.length;
        int len2 = v2s.length;
        int index = 0;

        while(index < len1 && index < len2){
            int v1 = Integer.parseInt(v1s[index]);

            int v2 = Integer.parseInt(v2s[index]);
            if(v1 == v2){
                index++;
            }else if(v1 > v2){
                return 1;
            }else{
                return -1;
            }
        }

        if(len1 == len2){
            return 0;
        }else if(len1 > len2){
            while(index < len1){
                if(Integer.parseInt(v1s[index]) == 0){
                    index++;
                }else{
                    return 1;
                }
            }

        }else{
            while(index < len2){
                if(Integer.parseInt(v2s[index]) == 0){
                    index++;
                }else{
                    return -1;
                }
            }
        }

        return 0;

    }

    public static void main(String[] args){

        CompareVerison obj = new CompareVerison();
        System.out.println(obj.compareVersion("0.1","1.1"));


        HashSet<Character>[] sets = new HashSet[2];
        for (HashSet set: sets) {
            set = new HashSet<>();
        }


    }
}
