class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int directions[][]=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int dp[][]=new int[moveTime.length][moveTime[0].length];
        for(int x[]:dp)Arrays.fill(x,Integer.MAX_VALUE);
        PriorityQueue<int[]>p=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        dp[0][0]=0;
        p.add(new int[]{0,0,0,1});
        while(!p.isEmpty()){
            int a[]=p.poll();
            int v=a[0],x=a[1],y=a[2],s=a[3];

            if(dp[x][y]==Integer.MAX_VALUE)continue;
            if(x==(moveTime.length-1)&&y==(moveTime[0].length-1))return dp[x][y];
            
            for(int d[]:directions){
                int r=x+d[0];
                int c=y+d[1];
                if(r>=0&&c>=0&&r<moveTime.length&&c<moveTime[0].length){
                   int num=Math.max(v,moveTime[r][c])+s;
                   if(num<dp[r][c]){
                    dp[r][c]=num;
                  
                    p.add(new int[]{num,r,c,(s%2)+1});
                   }
                }


            }
           
        }
 return -1;
    }
}