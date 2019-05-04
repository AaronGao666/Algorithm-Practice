/**
 * 好像没有用到dp？？？直接强行循环？？
 */

public class SentenceScreenFitting {


    public int sentenceFitting(String[] sentence, int cols, int rows){

        int words=sentence.length;
        int index=0;
        int times=0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<=cols;){
                j+=sentence[index].length();
                if(j==cols){
                    index++;
                    break;
                }else if(j>cols){
                    break;
                }else{
                    j++;
                }
                ++index;
                if(index>=words){
                    times++;
                    index=index%words;
                }
            }
        }

        return times;

    }


    public static void main(String args[]){

        int rows=4, cols=5;
        String[] sentence={"I", "had", "apple", "pie"};
        SentenceScreenFitting obj=new SentenceScreenFitting();
        System.out.println(obj.sentenceFitting(sentence,cols,rows));




    }
}
