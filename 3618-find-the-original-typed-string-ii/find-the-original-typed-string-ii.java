class Solution {
    private static final int MOD = 1_000_000_007;

    public int possibleStringCount(String word, int k) {
        if (word.isEmpty()) return 0;

        // Step 1: Group consecutive characters
        List<Integer> groups = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            } else {
                groups.add(count);
                count = 1;
            }
        }
        groups.add(count); // Add the last group

        // Step 2: Total combinations (product of group lengths)
        long total = 1;
        for (int num : groups) {
            total = (total * num) % MOD;
        }

        // Step 3: If k <= group count, all are valid
        if (k <= groups.size()) return (int) total;

        // Step 4: Count invalid original strings of length < k using DP
        int[] dp = new int[k];
        dp[0] = 1;

        for (int num : groups) {
            int[] newDp = new int[k];
            long sum = 0;

            for (int s = 0; s < k; s++) {
                if (s > 0) sum = (sum + dp[s - 1]) % MOD;
                if (s > num) sum = (sum - dp[s - num - 1] + MOD) % MOD;
                newDp[s] = (int) sum;
            }

            dp = newDp;
        }

        // Step 5: Subtract invalid strings from total
        long invalid = 0;
        for (int s = groups.size(); s < k; s++) {
            invalid = (invalid + dp[s]) % MOD;
        }

        return (int) ((total - invalid + MOD) % MOD);
    }
}