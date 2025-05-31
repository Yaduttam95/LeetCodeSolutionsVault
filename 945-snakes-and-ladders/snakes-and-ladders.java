class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[][] map = new int[n * n + 1][2];
        int count = 1, b = 0;
        for(int i = n - 1; i >= 0; i--){
            if(b % 2 == 0){
                for(int j = 0; j < n; j++){
                    map[count++] = new int[]{i, j};
                }
                b ^= 1;
            }else{
                for(int j = n - 1; j >= 0; j--){
                    map[count++] = new int[]{i, j};
                }
                b ^= 1;
            }
        }
        int t = n * n;
        ArrayDeque<int[]> pq = new ArrayDeque<>();
        int[] d = new int[(n * n) + 1];
        boolean[] vis = new boolean[(n * n) + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[1] = 0;
        pq.offer(new int[]{1, 0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            vis[curr[0]] = false;
            for(int i = curr[0] + 1; i <= Math.min(curr[0] + 6, t); i++){
                int val = board[map[i][0]][map[i][1]];
                if(val == -1){
                    val = i;
                }
                if(d[val] > curr[1] + 1){
                    d[val] = curr[1] + 1;
                    if(!vis[val]){
                        vis[val] = true;
                        pq.offer(new int[]{val, curr[1] + 1});
                    }
                }
            }
        }
        return d[t] != Integer.MAX_VALUE ? d[t] : -1;
    }
}