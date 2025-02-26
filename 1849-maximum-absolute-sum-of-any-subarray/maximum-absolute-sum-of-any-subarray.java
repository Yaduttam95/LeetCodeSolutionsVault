class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int maxEnding = nums[0];
        int maxSum= nums[0];
        int minSum = nums[0];
        int minEnding = nums[0];
        for(int i=1;i<n;i++){
            maxEnding = Math.max(maxEnding+ nums[i], nums[i]);
            maxSum = Math.max(maxSum, maxEnding);
        }

        for(int i=1;i<n;i++){
            minEnding = Math.min(minEnding+ nums[i], nums[i]);
            minSum = Math.min(minEnding, minSum);
        }

        return Math.max(maxSum, Math.abs(minSum));
        
    }
}