import java.util.ArrayList;
import java.util.List;

public class removeComment {
    public List<String> removeComments(String[] source) {

        List<String > res=new ArrayList<>();
        boolean isIgnored=false;
        String legacy=null;
        for(String s:source){

            int indexStar=s.indexOf("/*");
            int indexStarEnd=s.indexOf("*/");
            int indexDouble=s.indexOf("//");


//            System.out.println("/*:"+indexStar+"\t\t//:"+indexDouble+"\t\t*/:"+indexStarEnd+"\t\tignore?"+isIgnored);


            if(isIgnored ){
                if(indexStarEnd>=0){
                    if(indexStarEnd!=s.length()){
                        String temp;
                        if(legacy!=null &&  !legacy.isEmpty()){
                            temp=legacy+s.substring(indexStarEnd, s.length());
                        }else{
                            temp=s.substring(indexStarEnd, s.length());
                        }
                        if(temp.length()!=0){
                            res.add(temp);
                        }
                    }
                    isIgnored=false;
                }
                continue;
            }
            if(indexDouble==0 ) continue;
            if(indexDouble >0 && (indexStar> indexDouble || indexStar<0)){
                res.add(s.substring(0,indexDouble));
                continue;
            }
            if((indexStar>=0 && indexDouble > indexStar )|| (indexStar>=0 && indexDouble<0)){

                if(indexStarEnd<0){
                    isIgnored=true;
                    legacy=s.substring(0,indexStar);
                }else{

                    String temp=s.substring(0,indexStar)+s.substring(indexStarEnd+2);
                    if(!temp.isEmpty()){
                        res.add(temp);
                    }

                }

                continue;
            }


            res.add(s);

        }

        return res;

    }


    public static void main(String[] args){

        String[] source ={"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        removeComment obj=new removeComment();
        System.out.println( obj.removeComments(source));



    }
}
