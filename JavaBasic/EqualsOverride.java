public class EqualsOverride {
    private int val;
    EqualsOverride(int val){
        this.val = val;
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof EqualsOverride){
            return this.equals(obj);
        }else{
            return false;
        }
    }


    public static void main(String[] args){
        EqualsOverride obj = new EqualsOverride(1);
        EqualsOverride obj2 = new EqualsOverride(11);
        System.out.println(obj.equals(obj2));
    }
}
