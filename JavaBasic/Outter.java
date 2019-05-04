public class Outter {

    private int OutterM;
    protected int OutterN;
    public int OutterX;

    class Inner{
        public int m;
        private int n;
        public int getM() {
            return m;
        }

        public void setM(int m) {
            this.m = m;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }


        private void test(){
            OutterM = 6;
        }

    }


    private void test(){
        Inner obj = new Inner();


    }

    public static void main(String[] args){

    }

}
