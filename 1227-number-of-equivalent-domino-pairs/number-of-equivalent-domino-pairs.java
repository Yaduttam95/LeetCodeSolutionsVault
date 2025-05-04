class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        
        int count=0;
        int max=10;

        int grid[][]=new int[max+1][max+1];

        for(int g[]:dominoes){
           int i=g[0];
           int j=g[1];
           if(g[1]<g[0]){
              j=g[0];     
              i=g[1];
           }

          grid[i][j]++;
        }


        for(int g[]:grid){
         
         for(int n:g){
            if(n>1){
                count+=((n)*(n-1))/2;
            }
         }

        }



return count;
    }
}