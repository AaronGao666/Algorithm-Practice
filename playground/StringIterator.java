public class StringIterator {


    StringBuilder sb;
    int index;
    int N;
    public StringIterator(String compressedString) {
        sb = new StringBuilder();
        char[] chars = compressedString.toCharArray();
        int len = chars.length;

        for(int i = 0; i < len; ){
            if(chars[i] < '0' || chars[i] > '9'){
                int j = i + 1;
                int count = 0;
                while(j < len && chars[j] >= '0' && chars[j] <= '9'){
                    count = count * 10;
                    count += chars[j] - '0';
                    j ++;
                }
                for(int c = 0; c < count; c ++){
                    sb.append(chars[i]);
                }
                i = j;
            }
        }
        N = sb.length();
        index = 0;
    }

    public char next() {

        char res = index < N ? sb.charAt(index) : ' ';
        index ++;
        return res;
    }

    public boolean hasNext() {
        return index < N;
    }


    public static void main(String[] args){

        String s = "L1e2t1C1o1d1e1";
        StringIterator obj = new StringIterator(s);
        while(obj.hasNext()){
            System.out.println(obj.next());
        }

    }

}
