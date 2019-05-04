import java.util.*;


class UFNode{// 仅供UF使用

    String name;
    double quotient;
    public UFNode(String name, double quotient){
        this.name=name;
        this.quotient=quotient;
    }
}




public class EvaluateDivision {

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        HashMap<String, List<String>> pairs=new HashMap<>();
        HashMap<String, List<Double>> valuePairs=new HashMap<>();
        int len=values.length;
        //build the dictionnary
        for(int i=0;i<len ;i++){
            String[] s=equations[i];
            double value=values[i];

            if(!pairs.containsKey(s[0])){
                pairs.put(s[0],new ArrayList<String>());
            }
            if(!pairs.containsKey(s[1])){
                pairs.put(s[1],new ArrayList<String>());
            }
            if(!valuePairs.containsKey(s[0])){
                valuePairs.put(s[0],new ArrayList<Double>());
            }
            if(!valuePairs.containsKey(s[1])){
                valuePairs.put(s[1],new ArrayList<Double>());
            }

            pairs.get(s[0]).add(s[1]);
            valuePairs.get(s[0]).add(value);
            pairs.get(s[1]).add(s[0]);
            valuePairs.get(s[1]).add(1/value);
        }

//        System.out.println("准备输出：");
//
//        for(String s:pairs.keySet()){
//            System.out.println(s);
//            System.out.println(pairs.get(s));
//            System.out.println(valuePairs.get(s));
//        }
//        System.out.println("输出完毕：");
//


        len=queries.length;
        double[] res=new double[len];
        for(int i=0;i<len;i++){

            String[] s=queries[i];

            res[i]=dfs(pairs, valuePairs, s[0], s[1], new HashSet<String>(), 1.0);
            if(res[i]==0.0){
                res[i]=-1.0;
            }

        }

        return res;
    }

    public double dfs(HashMap<String, List<String>> pairs,
                      HashMap<String, List<Double>> valuePairs,
                      String start, String end,
                      HashSet<String> set,
                      double value){

        if(set.contains(start) || !pairs.containsKey(start)){
            return 0.0;
        }
        if(start.equals(end)){
            return value;
        }
        set.add(start);

        List<String> nexts=pairs.get(start);
        List<Double> nextValues=valuePairs.get(start);
        int len=nexts.size();
        double temp=0.0;
        for(int i=0;i<len;i++){
            String next=nexts.get(i);
            double nextval = nextValues.get(i);
                temp= dfs(pairs, valuePairs, next, end, set, value * nextval);
                if(temp!=0.0){
                    break;
                }
        }
        set.remove(start);
        return temp;
    }






    //solution 2： union find

    public double[] calcEquationWithUF(String[][] equations, double[] values, String[][] queries) {


        HashMap<String, UFNode> map=new HashMap<>();

        int len=values.length;
        for(int i=0;i<len;i++){

            String n=equations[i][0];
            String m=equations[i][1];
            double val=values[i];

            UFNode N=find(n,map);
            UFNode M=find(m,map);

            if(!M.name.equals(N.name)){
                map.put(M.name,new UFNode(N.name,N.quotient/M.quotient*val));
            }
        }


        for(String s:map.keySet()){
            System.out.println(s+"，"+map.get(s).name+"，"+map.get(s).quotient);
        }



//        find("c",map);


        len=queries.length;
        double[] res=new double[len];
        for(int i=0;i<len;i++){
            String n=queries[i][0];
            String m=queries[i][1];
            System.out.println("第"+i+"个：");
            if(map.containsKey(n) && map.containsKey(m)){

                System.out.println("n="+n+"，m="+m);
                UFNode N=find(n,map);
                System.out.println(N.name+"，Q="+N.quotient);
                UFNode M=find(m,map);
                System.out.println(M.name+"，Q="+M.quotient);
                if(N.name.equals(M.name)){
                    res[i]=M.quotient/N.quotient;
                }else {
                    res[i] = -1.0;
                }

            }else{
                res[i]=-1.0;
            }


        }

        return res;
    }



    private UFNode find(String s, HashMap<String, UFNode> map){


        UFNode res;
        if(!map.containsKey(s)){
            res=new UFNode(s,1.0);
            map.put(s,res);
            return res;
        }

//        System.out.println("当前S="+s);
        UFNode temp=map.get(s);
        UFNode next=map.get(temp.name);
        double quote=temp.quotient;
//        System.out.println(quote);
        while (!temp.name.equals(next.name)){
            temp=map.get(temp.name);
            quote*=temp.quotient;
//            System.out.println(quote);
            next=map.get(temp.name);
        }


        res=new UFNode(temp.name,quote);
        map.put(s,res);
        return res;

    }









        public static void main(String[] args){

        EvaluateDivision obj=new EvaluateDivision();
        String[][] equations={
                {"a","b"},{"b","c"}
        };
        double[] values={2.0,3.0};
        String[][] queries={
                {"a","c"},
                {"b","c"},{"a","e"},{"a","a"},{"x","x"}
        };



//        String[][] equations={
//                {"a","b"},{"e","f"},{"b","e"}
//        };
//        double[] values={3.4,1.4,2.3};
//        String[][] queries={
//                {"b","a"},
//                {"a","f"},{"f","f"},{"e","e"},{"c","c"},{"a","c"},{"f","e"}
//        };

//        String[][] equations={
//                {"x1","x2"},{"x2","x3"},{"x1","x4"},{"x2","x5"}
//        };
//        double[] values={3.0,0.5,3.4,5.6};
//        String[][] queries={
//                {"x2","x4"},
//                {"x1","x5"},
//                {"x1","x3"},
//                {"x5","x5"},{"x5","x1"},{"x3","x4"},{"x4","x3"},{"x6","x6"},{"x0","x0"}
//        };



        double[] res=obj.calcEquationWithUF(equations,values,queries);
        for(double d:res){
            System.out.print(d+"\t");
        }

    }
}
