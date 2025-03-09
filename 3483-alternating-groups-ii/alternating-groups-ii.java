class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        boolean isTrue = true;
        int i;
        for (i = 1; i < k; i++) {
            if (colors[i] == colors[i - 1]) {
                isTrue = false;
                break;
            }
        }
        
        int cnt = isTrue?1:0;
        int prev = colors[i - 1];

        while (i < n+k-1) {
            int index = i % n;
            if (isTrue && (colors[index] != prev)) {
                cnt++;
                prev = colors[index];
                i++;
            } else {
                if(i>=n)
                    return cnt;
                isTrue = true;
                int x;
                for (x = 1; x < k && i<n; x++) {
                    if (colors[(index + x) % n] == colors[(index + x - 1) % n]) {
                        isTrue = false;
                        break;
                    }
                }
                cnt = isTrue?cnt+1:cnt;
                i += x;
                prev = colors[(i-1)%n];
            }
        }
        return cnt;
    }
}