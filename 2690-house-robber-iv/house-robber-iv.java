class Solution {
    private boolean stealOrNot(int[] nums, int k, int m) {

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= m) {
                k--;
                i++;
            }
            if(k <= 0) {
                return true;
            }
        }
        return false;
    }
    public int minCapability(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int ans = max;
        while(min <= max) {
            int mid = (min + max)/2;

            if(stealOrNot(nums, k, mid)) {
                max = mid - 1;
                ans = mid;
            }
            else {
                min = mid + 1;
            }
        }
        return ans;

    }
}