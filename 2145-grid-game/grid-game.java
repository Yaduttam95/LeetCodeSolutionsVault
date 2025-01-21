class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] topPrefix = new long[n]; 
        long[] bottomSuffix = new long[n]; 

        for (int j = 0; j < n; j++) {
            topPrefix[j] = grid[0][j] + (j > 0 ? topPrefix[j - 1] : 0);
        }

        for (int j = n - 1; j >= 0; j--) {
            bottomSuffix[j] = grid[1][j] + (j < n - 1 ? bottomSuffix[j + 1] : 0);
        }

        long minPointsForSecond = Long.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            long pointsTop = j + 1 < n ? topPrefix[n - 1] - topPrefix[j] : 0;
            long pointsBottom = j > 0 ? bottomSuffix[0] - bottomSuffix[j] : 0;

            long pointsForSecond = Math.max(pointsTop, pointsBottom);

            minPointsForSecond = Math.min(minPointsForSecond, pointsForSecond);
        }

        return minPointsForSecond;
    }
}