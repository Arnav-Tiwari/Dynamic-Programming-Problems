//Leetcode Problem 790:Domino and Tromino Tiling
class Solution {
    int mod=1000000007;
    long dp[][];
    public int numTilings(int n) {
        dp=new long[n][4];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],Long.MAX_VALUE);
        return (int)CountWays(0,n,true,true);
    }
    public long CountWays(int i,int n,boolean t1,boolean t2){
        if(i==n)
            return 1;
        int state=makeState(t1,t2);
        if(dp[i][(int)state]!=Long.MAX_VALUE)
            return dp[(int)i][(int)state];
        boolean t3=i+1<n;
        boolean t4=i+1<n;
        long count=0;
        if(t1&&t2&&t3)
            count+=CountWays(i+1,n,false,true);
        if(t1&&t2&&t4)
            count+=CountWays(i+1,n,true,false);
        if(t1&&!t2&&t3&&t4)
            count+=CountWays(i+1,n,false,false);
        if(!t1&&t2&&t3&&t4)
            count+=CountWays(i+1,n,false,false);
        if(t1&&t2)
            count+=CountWays(i+1,n,true,true);
        if(t1&&t2&&t3&&t4)
            count+=CountWays(i+1,n,false,false);
        if(t1&&!t2&&t3)
            count+=CountWays(i+1,n,false,true);
        if(!t1&&t2&&t4)
            count+=CountWays(i+1,n,true,false);
        if(!t1&&!t2)
            count+=CountWays(i+1,n,true,true);
        return dp[(int)i][(int)state]=count%mod;
    }
    public int makeState(boolean t1,boolean t2){
        int state=0;
        if(t1)
            state|=1;
        if(t2)
            state|=2;
        return state;
    }
    
}
