class Solution {
    public int minimumRecolors(String s, int k) {
        int n = s.length();
        int pre[] = new int[n];
        if(s.charAt(0)=='W') pre[0] = 1;

        for(int i=1; i<n; i++){
            char col = s.charAt(i);
            if(col=='W') pre[i] = pre[i-1]+1;
            else pre[i] = pre[i-1];
        }

        int ans = Integer.MAX_VALUE;
        for(int i=k-1; i<n; i++){
            int w = pre[i]-((i-k)>=0 ? pre[i-k] : 0);
            ans = Math.min(ans,w);
        }
        return ans;
    }
}