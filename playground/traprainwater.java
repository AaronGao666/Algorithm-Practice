public class traprainwater {


    public int trap(int[] height) {

        int len= height.length;
        if(len<3){
            return 0;
        }
        int totalArea=0;
        for(int i=0;i<len;i++){
            for(int j=len-1;j>=i+2;j--){
                int area=trapArea(height,i,j);
                if(area>0){
                    i=j-1;
                    totalArea+=area;
                    break;
                }
            }
        }

        return totalArea;
    }

    public int trapArea(int[] height, int start, int end){
        int min=height[start]<height[end]?height[start]:height[end];
        int area=0;
        for(int i=start+1;i<end;i++){
            if(height[i]>=min){
                return -1;
            }
            area+=min-height[i];
        }
        return area;
    }



    public static void main(String[] args){
        int[] test={0,1,0,2,1,0,1,3,2,1,2,1};
        traprainwater obj=new traprainwater();
        obj.trap(test);
    }


}
