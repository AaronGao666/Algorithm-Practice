package algorithm;

public class WordFilter {

    String[] words;
    int index=0;

    public WordFilter(String[] words){
        this.words=words;
    }

    public int f(String prefix, String suffix){
        int len=this.words.length;
        for (int i=0;i<len;i++) {
            if (this.words[i].startsWith(prefix)&&this.words[i].endsWith(suffix)){
                this.index=i;
            }
        }
        return this.index;
    }


    public static void main(String args[]){
        String[] words={"applle","fdafdasfda","ajinnxagnghoiage","fdafdafdaf","jiopangpe"};
        String prefix="a";
        String suffix="e";

        WordFilter obj=new WordFilter(words);
        int result=obj.f(prefix,suffix);
        System.out.println(result);

    }

}
