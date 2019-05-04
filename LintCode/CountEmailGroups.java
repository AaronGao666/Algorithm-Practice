package Google1808;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountEmailGroups {


    public int countGroups(List<String> emails) {

        List<String> tempresult=new ArrayList<>();
        List<String> result=new ArrayList<>();
        for (String email: emails) {
            String temp=simplify(email);
            if(!tempresult.contains(temp)){
                tempresult.add(temp);
            }else {
                if(!result.contains(temp)){
                    result.add(temp);
                }
            }
        }
        System.out.println(tempresult);
        System.out.println(result);

        return result.size();
    }
    public static String simplify(String s){
        String res="";
        char[] chars=s.toCharArray();
        int atIndex=s.indexOf('@');
        for(int i=0;i<atIndex;i++){
            for(int j=i;j<atIndex;j++){
                if(chars[j]=='.'){
                    res+=s.substring(i,j);
                    i=j+1;
                }
                if(chars[j]=='+'){
                    if(i==j){
                        i=atIndex;
                        j=atIndex;
                    }else{
                        res+=s.substring(i,j);
                        i=atIndex;
                        j=atIndex;
                    }
                }
                if(j==atIndex-1&&chars[j]!='.'&&chars[j]!='+'){
                    res+=s.substring(i,atIndex);
                    i=atIndex;
                    j=atIndex;
                }
            }
        }
        res+=s.substring(atIndex);
        return res;
    }


    public static void main(String[] args){

        String[] arr={"-peaafstak@jiu.zh.ang.com","-*...@jiuzh+ng.com","fst*pe-+@.j.i.u.z.h.a.n.g.c.o.m","-cdtle*se@jiuzhangcom",".-**+@jiu.zhang.com","aa+fstfst+@jiu.zhang.com","cewa*++@jiuzh+ng.com","pe*secd.@jiu.zh.ang.com","tle**-+@ji+.+han+.com","-*pefstac@jiu.zh+ng.com","*ac.+.@.j.i.u.z.h.a.n.g.c.o.m","*-aa*ce@jiu.zh+ng.com","*ce**-@.j.i.u.z.h.a.n.g.c.o.m","--ac-aa@jiu.zh.ang.com",".aa*--@jiuzhangcom","*.aa.*@.j.i.u.z.h.a.n.g.c.o.m","fst*ab*wa@jiu.zhang.com","cd.**pe@jiu.zh.ang.com","*cd+.ab@jiuzhangcom","-.aktledc@jiu.zhangcom","+akdcfstce@.j.i.u.z.h.a.n.g.c.o.m","cedc-.-@jiuzhangcom","mle+-.-@jiuzhangcom","--fstaaaa@jiu.zhang.com","cd-ak.+@.j.i.u.z.h.a.n.g.c.o.m","cdce-+-@jiu.zhang.com","aape--+@jiuzh+ng.com","aasefst-wa@.j.i.u.z.h.a.n.g.c.o.m","pecefst.+@jiu.zh.ang.com","+abaaaaaa@ji+.+han+.com","*ce-aaac@ji+.+han+.com","seak*.ac@jiuzhang.com","dccdaaab*@jiu.zhang.com","++.tleaa@jiuzhangcom","akwa**aa@jiu.zhangcom","ab.cdwape@jiu.zhang.com","wamle-dc.@jiuzh+ng.com","ce*++ak@jiuzhangcom",".aamle.+@.j.i.u.z.h.a.n.g.c.o.m","*ab+-+@jiuzhang.com",".-.pe+@jiu.zhangcom",".wa.dc.@jiuzh+ng.com","*tleacpefst@jiuzhangcom","*...se@jiu.zhang.com",".abpe--@ji+.+han+.com","*wase+*@.j.i.u.z.h.a.n.g.c.o.m","peaape..@jiu.zh.ang.com","--+tle*@jiu.zh+ng.com","ab-se+-@jiuzh+ng.com","dcaadcfst-@jiu.zhang.com","mlecdtle.tle@jiu.zh.ang.com","+-**+@jiuzh+ng.com","aawa+wafst@jiu.zh.ang.com","aacdaacd.@.j.i.u.z.h.a.n.g.c.o.m","cetle***@jiu.zh.ang.com","aafsttletle-@jiu.zhangcom","-**dcmle@jiu.zh.ang.com","-cd*ac-@jiu.zhang.com","*tle.ceaa@jiuzh+ng.com",".-mle..@jiuzhangcom","aa*aacd-@ji+.+han+.com","pe-*aacd@jiuzhang.com","-cd-*+@ji+.+han+.com","tlemle+++@jiuzh+ng.com","dc-tleaa+@jiu.zh+ng.com","*mle+-*@jiu.zh.ang.com","pe*.ce.@jiu.zh.ang.com","akakce.fst@jiu.zh.ang.com","waakwa*tle@jiuzhangcom","-akaa+fst@jiu.zh.ang.com","tleac--+@.j.i.u.z.h.a.n.g.c.o.m","tle+-.+@.j.i.u.z.h.a.n.g.c.o.m","*-aawape@.j.i.u.z.h.a.n.g.c.o.m","fstcece.*@jiuzh+ng.com","mleaktlepedc@jiu.zh+ng.com","+cdwadcmle@jiuzh+ng.com","ak.+*tle@jiuzhangcom",".-aapetle@jiuzhangcom","pe-.abwa@jiu.zh.ang.com","*..--@jiu.zhangcom",".abcefst.@ji+.+han+.com","aacd-ac.@jiuzhang.com","seac+wa*@jiuzhangcom","cd.wa*ab@jiuzh+ng.com","dcmle-fstac@.j.i.u.z.h.a.n.g.c.o.m","pe*+-fst@jiuzh+ng.com","wa*se++@jiu.zhang.com","aa-pemle+@jiu.zhang.com","cdaa.ac.@jiuzhangcom","tle-mle+aa@ji+.+han+.com","cd+mledc.@jiu.zh+ng.com","se-ac.*@ji+.+han+.com","++.cdaa@jiuzhang.com","*+-*tle@jiuzhang.com","pe-+.aa@jiuzh+ng.com","..aaacaa@jiuzh+ng.com","+aawawa.@jiuzhangcom","ce..aaak@jiu.zh+ng.com",".mleacdc*@jiuzh+ng.com","*ac++aa@jiu.zh.ang.com","-tlece-cd@jiu.zhang.com","pece-*ak@jiu.zh.ang.com","*-aacd-@jiu.zh+ng.com","+.*tlepe@jiuzh+ng.com","abse*+-@jiuzhangcom","aa.*+se@ji+.+han+.com","--+cd*@ji+.+han+.com","*mlese-pe@jiu.zh.ang.com","+wape*-@jiu.zh.ang.com",".aa..fst@jiuzhangcom","wamle---@jiuzhang.com","*aadcmle*@jiuzh+ng.com","*mlecdaa-@jiu.zhangcom","+mleak.wa@jiu.zh.ang.com","*ak*-ab@jiuzhang.com","tlecd+*wa@jiuzh+ng.com","aaaafst+.@jiu.zhangcom","*mleabtlese@jiu.zhangcom","se.abtle+@.j.i.u.z.h.a.n.g.c.o.m","mletle.ac+@ji+.+han+.com","-.ab+*@jiuzhang.com","*.ac+tle@jiu.zh.ang.com","-pemleac+@.j.i.u.z.h.a.n.g.c.o.m","-ce+--@ji+.+han+.com","cdfsttle*aa@jiuzhangcom","tlewa.pewa@jiuzh+ng.com","+ce-+mle@jiuzh+ng.com","dcabwa*.@ji+.+han+.com","fstaa++mle@jiuzhangcom","aa.wa-*@ji+.+han+.com","+-mlece-@jiu.zh.ang.com","---abmle@jiu.zh.ang.com","mlewa.ab+@jiu.zhang.com","abpe+aawa@jiu.zhangcom","*+*aa.@jiuzhang.com","+*-aace@jiu.zhang.com","aa+-acfst@.j.i.u.z.h.a.n.g.c.o.m","abtle+dc*@ji+.+han+.com","ak-pemlecd@.j.i.u.z.h.a.n.g.c.o.m","--mlewa-@jiuzhangcom","pe+.secd@jiuzh+ng.com",".cddc+.@jiuzhangcom","ce--pe-@jiu.zhangcom","pedctle.+@jiu.zhang.com","fst*akdc.@jiu.zhang.com","wape-ab.@ji+.+han+.com","*aa+cdmle@jiu.zh.ang.com","+cd*+mle@jiu.zhangcom","*+.ab+@ji+.+han+.com","-seaase-@jiu.zhang.com",".ac++cd@jiu.zhang.com","+.*-aa@jiuzh+ng.com","fstce-**@jiu.zhangcom","**ce..@jiuzhangcom","mlewa+-+@jiuzhangcom","aaaa-cd*@jiuzh+ng.com","aktle-semle@jiu.zhang.com","akpe-+*@ji+.+han+.com","***++@jiuzhang.com","-+wa+.@ji+.+han+.com","*peabtleaa@ji+.+han+.com"};
        List<String> list = Arrays.asList(arr);

        CountEmailGroups obj=new CountEmailGroups();
        System.out.println(obj.countGroups(list));



    }

}
