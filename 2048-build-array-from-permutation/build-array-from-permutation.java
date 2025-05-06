class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;

        // Encode two values in each index:
        // new = old + (new % n) * n
        for (int i = 0; i < n; i++) {
            nums[i] += (nums[nums[i]] % n) * n;
        }

        // Extract new values
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] / n;
        }

        return nums;
    }
}