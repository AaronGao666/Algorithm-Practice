package algorithm;

import java.util.ArrayList;

public class TextJustification {

    public ArrayList<String> fullJustify(String[] words,int maxwidth){
        ArrayList<String> result=new ArrayList<String>();

        int beginindex=0;
        int endindex=0;
        int testlen=0;
        for(int i=0;i< words.length;i++){

                int it=beginindex;
                testlen=0;
                do{
                    testlen+=words[it].length();
                    it++;
                }while(it<=endindex);
                testlen+=endindex-beginindex;//计算测试长度

                if(testlen>maxwidth){//如果加入了当前词以后行长度过长
                    testlen-=endindex-beginindex+words[endindex].length();//获得了实际该行字符总长
                    endindex-=1;
                    i--;
                    int diff=maxwidth-testlen;
                    int num=endindex-beginindex;

                    int[] space=new int[num];
                    for(int k=0;k<num;k++){
                        space[k]=(int)diff/num;
                        if(k<diff%num)
                            space[k]++;

                    }

                    StringBuffer sb=new StringBuffer();

                    for(int m=beginindex;m<=endindex;m++){
                        sb.append(words[m]);
                        if(m!=endindex){
                            for(int j=0;j<space[m-beginindex];j++){
                                sb.append(' ');
                            }
                        }
                    }

                    result.add(sb.toString());
                    beginindex=endindex+1;
                    endindex=beginindex;
                    testlen=0;

                }
                else if(testlen==maxwidth){
                    StringBuffer sb=new StringBuffer();
                    for(int m=beginindex;m<=endindex;m++){
                        if(m!=beginindex){
                            sb.append(' ');
                        }
                        sb.append(words[m]);
                    }
                    result.add(sb.toString());
                    beginindex=endindex+1;
                    endindex=beginindex;
                    testlen=0;
                }
                else if(testlen<maxwidth){
                    if(endindex==words.length-1){//最后一行
                        testlen-=endindex-beginindex;//获得了实际该行字符总长
                        int diff=maxwidth-testlen;
                        int num=endindex-beginindex;

                        int[] space=new int[num];
                        for(int k=0;k<num;k++){
                            space[k]=(int)diff/num;
                            if(k<diff%num)
                                space[k]++;

                        }

                        StringBuffer sb=new StringBuffer();

                        for(int m=beginindex;m<=endindex;m++){
                            sb.append(words[m]);
                            if(m!=endindex){
                                for(int j=0;j<space[m-beginindex];j++){
                                    sb.append(' ');
                                }
                            }
                        }

                        result.add(sb.toString());
                    }
                    else{
                        endindex += 1;
                    }
                }



            }



        return result;
    }



    public static void main(String[] args){
        String[] words={"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do","not","know"};
        int maxWidth=16;
        TextJustification test=new TextJustification();
        ArrayList<String> arr=test.fullJustify(words,maxWidth);
        System.out.println(arr);

    }
}
