public class BitManupulation {

    public boolean validUtf8(int[] data) {

        int len=data.length;
        for(int i=0;i<len;i++){
            int temp=data[i]&255;
            if(temp>=248){
                System.out.println("这");
                return false;
            }else{
                int step;
                temp=temp&248;
                if(temp<128) continue;  //1 byte
                else if(temp==192 || temp ==216||temp==200||temp==208){ //2 btye
                    step=i+1;
                }else if(temp==232||temp==224){
                    step=i+2;
                }else if(temp==240){
                    step=i+3;
                }else {
                    System.out.println("这儿：temp="+temp);
                    return false;
                }
                if(step>=len){
                    System.out.println("超长"+temp);
                    return false;
                }
                for(i=i+1;i<=step;i++){
                    if((data[i]&192)!=128){
                        System.out.println("后续不合法："+(data[i]));
                        return false;
                    }
                }
                i--;
            }
        }

        return true;

    }
    public static void main(String[] args){
        int[] data={228,189,160,229,165,189,13,10};
        BitManupulation obj=new BitManupulation();
        System.out.println(obj.validUtf8(data));
    }





}
