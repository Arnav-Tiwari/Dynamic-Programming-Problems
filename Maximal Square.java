//LeetCode Problem 221:Maximal Square
class Solution {
    public int maximalSquare(char [][]matrix){
        int [][]dp=new int[matrix.length][matrix[0].length];
        int maxArea=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0)
                    dp[i][j]=matrix[i][j]=='1'?1:0;
                else{
                    dp[i][j]=matrix[i][j]=='1'?dp[i-1][j]+1:0;
                }
                int minheight=dp[i][j];
                int minwidth=1;
                for(int k=j;k>=0;k--){
                    if(matrix[i][j]=='0')break;
                    minheight=Math.min(dp[i][k],minheight);
                    minwidth=Math.max(j-k+1,minwidth);
                    maxArea=Math.max(maxArea,(int)Math.pow(Math.min(minheight,minwidth),2));
                }
            }
        }
        return maxArea;
    }
}
