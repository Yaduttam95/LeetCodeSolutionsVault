class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int num : nums) {
            total += num;
        }

        if(total % 2 != 0) return false;

        Map<String, Boolean> dp = new HashMap<>();

        return helper(0, 0, nums, total / 2, dp);
    }

    private boolean helper(int idx, int sum, int[] nums, int tgt, Map<String, Boolean> dp) {
        if(idx == nums.length) return sum == tgt;

        String key = idx + ", " + sum;
        if(dp.containsKey(key)) return dp.get(key);

        dp.put(key, helper(idx + 1, sum + nums[idx], nums, tgt, dp) || helper(idx + 1, sum, nums, tgt, dp));
        
        return dp.get(key);
    }
}