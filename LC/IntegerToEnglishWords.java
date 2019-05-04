package algorithm;



public class IntegerToEnglishWords {

    private static final int Billion=1000000000;
    private static final int Million = 1000000;
    private static final int Thousand = 1000;
    public String smallNumToWords(int num){
        String[] numbers={"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String[] tens={"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String[] teens={"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        int hundred=(int)(num/100);
        int ten=(int)((num-hundred*100)/10);
        int digit=num-hundred*100-ten*10;
        StringBuffer sb=new StringBuffer();
        if(hundred>0) sb.append(numbers[hundred-1]+" Hundred");
        if(ten==1) {
            sb.append(teens[digit]);
            return sb.toString();
        }
        if(ten>1) sb.append(" "+tens[ten-1]);
        if(digit>0) sb.append(" "+numbers[digit-1]);

        return sb.toString();
    }

    public String numberToWords(int num){
        int billion=(int)num/Billion;
        int million=(int)((num-billion*Billion)/Million);
        int thousand=(int) (((num-billion*Billion-million*Million))/Thousand);
        int belowthousand=(int)((num-billion*Billion-million*Million-thousand*Thousand));

        StringBuffer sb=new StringBuffer();
        if(billion!=0) sb.append(smallNumToWords(billion)+" Billion ");
        if(million!=0) sb.append(smallNumToWords(million)+" Million ");
        if(thousand!=0) sb.append(smallNumToWords(thousand)+" Thousand ");
        if(belowthousand!=0) sb.append(smallNumToWords(belowthousand));
        return sb.toString();

    }
    public static void main(String[] args){
        IntegerToEnglishWords test= new IntegerToEnglishWords();
        System.out.println(test.numberToWords(2143673265));
    }
}
