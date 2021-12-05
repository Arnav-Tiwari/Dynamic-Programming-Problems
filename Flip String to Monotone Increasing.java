class Solution {
    int [][]dp;
    public int minFlipsMonoIncr(String s) {
        dp=new int[2][s.length()];
        for(int i=0;i<2;i++){
        Arrays.fill(dp[i],Integer.MAX_VALUE);}
        return Math.min(Flip(s,0,'0'),Flip(s,0,'1'));
    }
    public int Flip(String s,int index,char set){
        if(index>=s.length())
            return 0;
        if(dp[set-'0'][index]!=Integer.MAX_VALUE)
            return dp[set-'0'][index];
        char ch=s.charAt(index);
        int min=Integer.MAX_VALUE;
        int val=ch==set?0:1;
        if(set=='0')
            min=Math.min(Flip(s,index+1,'0'),Flip(s,index+1,'1'));
        else
            min=Flip(s,index+1,'1');
        dp[set-'0'][index]=min+val;
        return dp[set-'0'][index];
    }
}
