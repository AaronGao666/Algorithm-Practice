package algorithm;
/*
 */
public class WildCardMatching {

    public String removesurplus(String s){
         if(s.contains("**")){
            String s1=s.replace("**","*");
            return removesurplus(s1);
        }
        return s;
    }
    public boolean isMatch(String s,String inip){
        String p=removesurplus(inip);
        System.out.println(p);
        char[] schar=s.toCharArray();
        char[] pchar=p.toCharArray();
        boolean shouldcontinue=true;

        int indexofs=0;
        for(int i=0;i<p.length();i++){
            if(shouldcontinue){
                if(pchar[i]=='*'){
                        if(i!=p.length()-1){//*不是最后一个匹配符
                            if(pchar[i+1]=='?'){
                                shouldcontinue=true;

                            }
                            else{
                                for(int j=indexofs;j<s.length();j++){
                                    if(schar[j]==pchar[i+1]){
                                        indexofs=j;
                                        shouldcontinue=true;
                                        break;
                                    }
                                    if(j==s.length()-1&&schar[j]!=pchar[i+1]){
                                        shouldcontinue=false;
                                        return false;
                                    }
                                }
                            }


                        }
                        else return true;//*是最后一个匹配符
                }
                else if(pchar[i]=='?'){

                    if(indexofs==s.length()-1&&i==p.length()-1){//都到末尾
                        shouldcontinue=false;
                        return true;
                    }
                    else if((i==p.length()-1)!=(indexofs==s.length()-1)){
                        shouldcontinue=false;
                        return false;
                    }
                    else if(i!=p.length()-1&&indexofs!=s.length()-1){
                        shouldcontinue=true;
                        indexofs+=1;
                    }

                }
                else{
                    if(pchar[i]==schar[indexofs]){

                        if(indexofs==s.length()-1&&i==p.length()-1){//都到末尾
                            shouldcontinue=false;
                            return true;
                        }
                        else if((i==p.length()-1)!=(indexofs==s.length()-1)){
                            shouldcontinue=false;
                            return false;
                        }
                        else if(i!=p.length()-1&&indexofs!=s.length()-1){
                            shouldcontinue=true;
                            indexofs+=1;
                        }

                    }
                    else{
                        shouldcontinue=false;
                        return false;
                    }
                }




            }

        }

        return false;
    }
    public static void main(String[] args){
        String s="acdcb5a4";
        String p="acd******???a**?";
        WildCardMatching test=new WildCardMatching();
        System.out.println(test.isMatch(s,p));

    }
}
