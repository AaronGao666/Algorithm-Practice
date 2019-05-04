import java.util.ArrayList;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {

        int len=s.length();
        if(len==0){
            return null;
        }
        int[] counts=new int[26];

        for(int i=0;i<len;i++){
            counts[s.charAt(i)-'a']++;
        }


        ArrayList<Character> list=new ArrayList<>();
        for(int i=0;i<len;){
            char ci=s.charAt(i);

            if(counts[ci-'a']==0){
                i++;
                continue;
            }

            if(counts[ci-'a']==1){
                list.add(ci);
                counts[ci-'a']=0;
                i++;
                continue;
            }

            for(int j=i+1;j<len;j++){
                char cj=s.charAt(j);
                if(cj==ci){
                    i=j;
                    counts[cj-'a']--;
                    break;
                }else if(cj>ci){
                    if(counts[cj-'a']==1){
                        list.add(ci);
                        counts[ci-'a']=0;
                        list.add(cj);
                        counts[cj-'a']=0;
                        i=j+1;
                        break;
                    }else{
                        counts[cj-'a']--;
                    }
                }else{
                    System.out.println(i+","+counts[ci-'a']);

                    counts[ci-'a']--;
                    i=j;
                    break;
                }
            }
        }
        String res="";
        for(char c:list){
            res+=c;
        }

        return res;


    }


    public static void main(String[] args){
        String s="cbacdcbc";
        RemoveDuplicateLetters obj=new RemoveDuplicateLetters();
       System.out.println( obj.removeDuplicateLetters(s));
    }
}
