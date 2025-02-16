class Solution {
    public int[] constructDistancedSequence(int n) {
        int len = n * 2 - 1;
        int[] result = new int[len];
        boolean[] used = new boolean[n + 1];

        backtrack(0, result, used, n);
        return result;
    }

    public boolean backtrack(int pos, int[] result, boolean[] used, int n) {
        while (pos < result.length && result[pos] != 0) { // Skip filled positions
            pos++;
        }
        
        if (pos == result.length) {
            return true;
        }

        for (int i = n; i >= 1; i--) { 
            if (used[i]) continue;
            
            int secondPos = (i == 1) ? pos : pos + i;
            if (secondPos < result.length && result[secondPos] == 0) {
                result[pos] = i;
                if (i != 1) result[secondPos] = i;
                used[i] = true;

                if (backtrack(pos + 1, result, used, n)) {
                    return true;
                }

                result[pos] = 0;
                if (i != 1) result[secondPos] = 0;
                used[i] = false;
            }
        }

        return false;
    }
}