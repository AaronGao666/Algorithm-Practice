import java.util.Stack;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {

        int M=matrix.length;
        int N = matrix[0].length;
        int[] height=new int[N+2];// add two more virtual bars.
        int maxArea=0;
        for(int i=0;i<M;i++){
            //reset the height arr
            for(int j=0;j<N;j++){
                if(matrix[i][j]=='0'){
                    height[j+1]=0;
                }else{
                    height[j+1]++;
                }
            }
            //find out the max
            Stack<Integer> stack=new Stack<>();
            for(int j=0;j<N+2;j++){
                while(!stack.isEmpty() && height[stack.peek()]>height[j]){
                    int top=stack.pop();
                    int prev=stack.peek();
                    maxArea=Math.max(maxArea, (j-prev-1)*height[top]);
                }
                stack.push(j);
            }

        }

        return maxArea;

    }

    public static void main(String[] args){
        char[][] m={
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};


        MaximalRectangle obj =new MaximalRectangle();
        System.out.println(obj.maximalRectangle(m));
    }



}
